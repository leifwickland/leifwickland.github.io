import java.net.URL
import java.nio.file.Path

// So much awesomeness...
case class AwesomeClient(
  apiKey: String, 
  timeout: Long,
  readFrom: URL,
  writeTo: Path)
