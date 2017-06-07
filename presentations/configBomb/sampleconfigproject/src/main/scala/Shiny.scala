import java.util.Properties
import scala.concurrent.duration._
import java.net.URL
import java.nio.file.{Path, Paths}

case class ShinyConfig(
  apiKey: String,
  timeout: FiniteDuration,
  readFrom: URL,
  writeTo: Path
)

object ShinyConfig{
  def load(): ShinyConfig = {
    implicit val pathConfigReader = pureconfig.ConfigReader.fromStringTry[Path]{s=>
      println("path from string: " + s)
      scala.util.Try(Paths.get(s))
    }
    pureconfig.loadConfigOrThrow[ShinyConfig]
  }
}
