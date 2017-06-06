import java.util.Properties

object DumbConfig{
  def awesomeClient = {
    val prop = new Properties
    val stream = getClass.getClassLoader.getResourceAsStream("vanilla.properties")
    prop.load(stream)
    AwesomeClient(
      prop.getProperty("api-key"),
      prop.getProperty("timeout").toLong,
      prop.getProperty("port").toInt
    )
  }
}
