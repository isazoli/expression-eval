import scala.io.StdIn

object Console extends App {

  private val arithParser = new ArithParser with SmartAST {}

  do {
    val parseResult = arithParser.parseAll(arithParser.expr, StdIn.readLine())
    System.out.println(s"Validation result = ${if (parseResult.successful) "valid" else "invalid"}")
    if (parseResult.successful) {
      System.out.println(s"Calculated value = ${parseResult.get.eval}")
    }
  } while (true)

}
