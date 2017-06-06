import org.scalatest._
import scala.concurrent.duration._

class ShinySpec extends FlatSpec with Matchers {
  "ShinyConfig" should "load" in {
    ShinyConfig.load shouldBe ShinyConfig("super53kr3tk3y", 15.seconds, 12345)
  }
}
