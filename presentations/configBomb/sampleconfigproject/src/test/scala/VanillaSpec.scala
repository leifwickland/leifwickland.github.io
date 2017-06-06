import org.scalatest._

class VanillaSpec extends FlatSpec with Matchers {
  "VanillaConfig" should "load" in {
    VanillaConfig.load shouldBe VanillaConfig("super53kr3tk3y", 15000, 12345)
  }
}
