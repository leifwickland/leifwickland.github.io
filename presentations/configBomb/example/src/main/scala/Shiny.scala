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
    pureconfig.loadConfigOrThrow[ShinyConfig]
  }
}


case class ShinierConfig(
  apiKey: String,
  timeout: FiniteDuration = 30.seconds,
  readFrom: URL,
  writeTo: Path = Paths.get("/dev/null")
)
