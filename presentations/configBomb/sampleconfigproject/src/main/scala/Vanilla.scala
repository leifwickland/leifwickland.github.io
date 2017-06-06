import java.util.Properties

object VanillaConfig{
  def load(): VanillaConfig = {
    val prop = new Properties
    val stream = this.getClass.getClassLoader
      .getResourceAsStream("vanilla.properties")
    prop.load(stream)
    VanillaConfig(
      apiKey = prop.getProperty("api-key"),
      timeout = prop.getProperty("timeout").toLong,
      port = prop.getProperty("port").toInt
    )
  }
}
case class VanillaConfig(
  apiKey: String,
  timeout: Long,
  port: Int
)
