import java.util.Properties
import java.net.URL
import java.nio.file.{Path, Paths}

case class VanillaConfig(
  apiKey: String,
  timeout: Long,
  url: URL,
  path: Path
)

object VanillaConfig {
  def load(): VanillaConfig = {
    val prop = new Properties
    val stream = this.getClass.getClassLoader
      .getResourceAsStream("vanilla.properties")
    prop.load(stream)
    VanillaConfig(
      prop.getProperty("api-key"),
      prop.getProperty("timeout").toLong,
      new URL(prop.getProperty("read-from")),
      Paths.get(prop.getProperty("write-to"))
    )
  }
}
