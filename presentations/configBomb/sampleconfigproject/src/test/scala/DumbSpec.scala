import org.scalatest._
import java.net.URL
import java.nio.file.Paths

class DumbSpec extends FlatSpec with Matchers {
  "DumbConfig" should "awesomeClient" in {
    DumbConfig.awesomeClient shouldBe AwesomeClient(
      "super53kr3tk3y",
      15000,
      new URL("http://best.api/ever"),
      Paths.get("/write/it/here")
    )
  }
}
