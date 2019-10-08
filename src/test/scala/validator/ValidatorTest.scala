package validator

import dsl._
import org.scalatest.{FlatSpec, Matchers}
import validator.ValidatorTest._

/**
  * Expression Valid
  * 3 + 2 + 4 T
  * +2 T
  * −2 T
  * sin(30) + cos(20) T
  * sin(sin(30) + cos(20)) T
  * 3 + sin(sin(30) + cos(20)) T
  * sin(30 F
  * 3 + + F0
  * 3+ F
  */
class ValidatorTest extends FlatSpec with Matchers {

  "all valid cases" should "pass" in {
    validCases.foreach { testCase => validate(testCase) shouldBe true }
  }

  "all invalid cases" should "fail" in {
    invalidCases.foreach { testCase => validate(testCase) shouldBe false }
  }

}

object ValidatorTest {

  private val validCases = List(
    // 3 + 2 + 4
    List(
      SimpleValue(3),
      Plus,
      SimpleValue(2),
      Plus,
      SimpleValue(4)
    ),
    // +2
    List(
      Plus,
      SimpleValue(2)
    ),
    // -2
    List(
      Minus,
      SimpleValue(2)
    ),
    // sin(30) + cos(20)
    List(
      Sin,
      SimpleValue(30),
      Plus,
      Cos,
      SimpleValue(20)
    ),
    // sin(sin(30) + cos(20))
    List(
      Sin,
      Sin,
      SimpleValue(30),
      Plus,
      Cos,
      SimpleValue(20)
    ),
    // 3 + sin(sin(30) + cos(20))
    List(
      SimpleValue(3),
      Plus,
      Sin,
      Sin,
      SimpleValue(30),
      Plus,
      Cos,
      SimpleValue(20)
    )
  )

  private val invalidCases = List(
    List(
      Sin,
      SimpleValue(30)
    ),
    List(
      SimpleValue(3),
      Plus,
      Plus
    ),
    List(
      SimpleValue(3),
      Plus
    )
  )

}