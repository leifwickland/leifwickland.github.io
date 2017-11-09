import org.scalatest._
import pureconfig._
import com.typesafe.config.ConfigFactory.parseString

class GothamSpec extends FlatSpec with Matchers {
  "field mapping" should "be individually configurable" in {
    case class GothamConf(bruceWayne: String)

    implicit val hint = ProductHint[GothamConf](
      ConfigFieldMapping(Map(
        "bruceWayne" -> "bat-man" 
      ).withDefault(
        ConfigFieldMapping(CamelCase, KebabCase)))
    )

    val exp = "justice"
    val conf = s"bat-man: $exp"
    val g = loadConfigOrThrow[GothamConf](parseString(conf))
    g.bruceWayne shouldBe exp
  }
}
