import org.scalatest.{FlatSpec, Matchers}

class RandomGeneratorTest extends FlatSpec with Matchers {

  "valid random number" should "be generated" in {
    RandomGenerator.generate() shouldNot be(Double.NaN)
  }

  "different random numbers" should "be generated" in {
    val firstRandom = RandomGenerator.generate()
    firstRandom shouldNot be(Double.NaN)
    val secondRandom = RandomGenerator.generate()
    secondRandom shouldNot be(Double.NaN)
    secondRandom shouldNot be(firstRandom)
  }

}
