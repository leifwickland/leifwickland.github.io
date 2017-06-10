import java.util.Properties
import java.net.URL
import java.nio.file.Paths

object DumbConfig{
  def awesomeClient = {
    val prop = new Properties
    val stream = getClass.getClassLoader
      .getResourceAsStream("vanilla.properties")
    prop.load(stream)
    AwesomeClient(
      prop.getProperty("api-key"),
      prop.getProperty("timeout").toLong,
      new URL(prop.getProperty("read-from")),
      Paths.get(prop.getProperty("write-to"))
    )
  }
}
