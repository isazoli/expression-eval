import org.scalatest.prop.TableDrivenPropertyChecks._
import org.scalatest.{Matchers, PropSpec}

import scala.math.{cos, sin}

class ArithParserTest extends PropSpec with Matchers {

  property("parsing and evaluating should work for valid cases") {
    val combinator = new ArithParser with SmartAST {}
    forEvery(ArithParserTest.validCasesWithExpectedResult) {
      (expression: String, expectedValue: Double) =>
        val value = combinator.parseAll(combinator.expr, expression)
        value.successful shouldBe true
        value.get.eval shouldBe expectedValue
    }
  }

  property("parsing should fail for invalid cases") {
    val combinator = new ArithParser with SmartAST {}
    forEvery(ArithParserTest.inValidCases) {
      expression: String =>
        val value = combinator.parseAll(combinator.expr, expression)
        value.successful shouldBe false
    }
  }

  property("expressions with RAND should work properly") {
    val combinator = new ArithParser with SmartAST {}
    val result = combinator.parseAll(
      combinator.expr,
      "sin(30) + RAND + cos(20)"
    )
    result.successful shouldBe true
    // as we know that the RAND generator generates integer between 1 and 100
    // we can do a tricky assertion
    val pivot = sin(30) + cos(20)
    result.get.eval shouldBe <=(pivot + 100)
    result.get.eval shouldBe >=(pivot + 1)
  }

}

object ArithParserTest {

  private val validCasesWithExpectedResult = Table(
    "expression" -> "expectedValue",
    List(
      "3 + 2 + 4" -> (3 + 2 + 4).toDouble,
      //TODO: add support for plus sing operations
      //"+2" -> 2D,
      "-2" -> -2D,
      "sin(30) + cos(20)" -> (sin(30) + cos(20)),
      "sin(sin(30) + cos(20))" -> sin(sin(30) + cos(20)),
      "3 + sin(sin(30) + cos(20))" -> (3 + sin(sin(30) + cos(20)))
    ): _*
  )

  private val inValidCases = Table(
    "expression",
    List(
      "sin(30",
      "3 + +",
      "3+"
    ): _*
  )

}
