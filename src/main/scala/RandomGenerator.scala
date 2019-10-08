import com.softwaremill.sttp._

object RandomGenerator {

  private val RANDOM_GENERATOR_URI = uri"https://www.random.org/integers/?num=1&min=1&max=100&col=1&base=10&format=plain&rnd=new"

  def generate(): Double = {
    val request = sttp.get(RANDOM_GENERATOR_URI)
    implicit val backend: SttpBackend[Id, Nothing] = HttpURLConnectionBackend()
    val response = request.send()
    if (response.isSuccess) response.unsafeBody.toDouble else Double.NaN
  }

}
