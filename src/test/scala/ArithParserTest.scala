import org.scalatest.{FunSpec, Matchers}

class ParserCombinatorTest extends FunSpec with Matchers {

  describe("parser combinator should parse") {
    val combinator = new ArithParser with SmartAST {}
//    it("+2") {
//      combinator.parseAll(
//        combinator.expr, "+2"
//      ).get shouldBe 4D
//    }
//    it("-2") {
//      combinator.parseAll(
//        combinator.expr, "-2"
//      ).get.eval shouldBe -2D
//    }
    it("3 + 2") {
      combinator.parseAll(
        combinator.expr, "3 + 2"
      ).get.eval shouldBe 5D
    }
    it("3 + 2 + 4") {
      combinator.parseAll(
        combinator.expr, "3 + 2 + 4"
      ).get.eval shouldBe 9D
    }
  }

}
