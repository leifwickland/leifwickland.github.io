import org.scalatest._
import java.net.URL
import java.nio.file.Paths

class VanillaSpec extends FlatSpec with Matchers {
  "VanillaConfig" should "load" in {
    VanillaConfig.load shouldBe VanillaConfig(
      "super53kr3tk3y",
      15000,
      new URL("http://best.api/ever"),
      Paths.get("/write/it/here")
    )
  }
}
