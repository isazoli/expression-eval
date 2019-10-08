import scala.math.{cos, sin, tan}

trait ArithAST { // Interface for AST subtypes
type T

  def Add: (T, T) => T

  def Sub: (T, T) => T

  def Mul: (T, T) => T

  def Div: (T, T) => T

  def Number: String => T

  def Sin: T => T

  def Cos: T => T

  def Tan: T => T
}

trait SimpleAST extends ArithAST {
  type T = Expr

  sealed abstract class Expr

  case class Add(a: T, b: T) extends T

  case class Sub(a: T, b: T) extends T

  case class Mul(a: T, b: T) extends T

  case class Div(a: T, b: T) extends T

  case class Number(e: String) extends T

  case class Sin(a: T) extends T

  case class Cos(a: T) extends T

  case class Tan(a: T) extends T

}

trait SmartAST extends ArithAST {
  type T = Expr[Double]

  sealed abstract class Expr[+T] {
    def eval: T
  }

  case class Add(a: T, b: T) extends T {
    def eval = a.eval + b.eval
  }

  case class Sub(a: T, b: T) extends T {
    def eval = a.eval - b.eval
  }

  case class Mul(a: T, b: T) extends T {
    def eval = a.eval * b.eval
  }

  case class Div(a: T, b: T) extends T {
    def eval = a.eval / b.eval
  }

  case class Number(e: String) extends T {
    def eval = e.toDouble
  }

  case class Sin(a: T) extends T {
    def eval: Double = sin(a.eval)
  }

  case class Cos(a: T) extends T {
    def eval: Double = cos(a.eval)
  }

  case class Tan(a: T) extends T {
    def eval: Double = tan(a.eval)
  }

}
