import java.util.Properties
import scala.concurrent.duration._

case class ShinyConfig(
  apiKey: String,
  timeout: FiniteDuration,
  port: Int
)

object ShinyConfig{
  def load(): ShinyConfig = {
    pureconfig.loadConfigOrThrow[ShinyConfig]
  }
}
