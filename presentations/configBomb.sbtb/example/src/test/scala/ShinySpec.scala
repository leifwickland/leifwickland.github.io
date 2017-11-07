import org.scalatest._
import scala.concurrent.duration._
import java.net.URL
import java.nio.file.Paths

class ShinySpec extends FlatSpec with Matchers {
  "ShinyConfig" should "load" in {
    ShinyConfig.load shouldBe ShinyConfig(
      "super53kr3tk3y",
      15.seconds,
      new URL("http://best.api/ever"),
      Paths.get("/write/it/here")
    )
  }
}
