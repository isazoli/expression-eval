trait ArithAST { // Interface for AST subtypes
type T

  def Add: (T, T) => T // Abstract
  def Sub: (T, T) => T // semantic
  def Mul: (T, T) => T // actions
  def Div: (T, T) => T // to build
  def Number: String => T // AST nodes.
}

trait SimpleAST extends ArithAST {
  type T = Expr

  sealed abstract class Expr

  case class Add(a: T, b: T) extends T

  case class Sub(a: T, b: T) extends T

  case class Mul(a: T, b: T) extends T

  case class Div(a: T, b: T) extends T

  case class Number(e: String) extends T

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

}
