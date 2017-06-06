import org.scalatest._
class DumbSpec extends FlatSpec with Matchers {
  "DumbConfig" should "awesomeClient" in {
    DumbConfig.awesomeClient shouldBe AwesomeClient("super53kr3tk3y", 15000, 12345)
  }
}
