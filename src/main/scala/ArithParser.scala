import scala.util.parsing.combinator.JavaTokenParsers

trait ArithParser extends JavaTokenParsers {
  this: ArithAST =>
  def expr: Parser[T] = chainl1(
    term,
    "+" ^^^ Add | "-" ^^^ Sub
  )

  def term = chainl1(
    factor,
    "*" ^^^ Mul | "/" ^^^ Div
  )

  def factor =
    floatingPointNumber ^^ Number | "(" ~> expr <~ ")"
}