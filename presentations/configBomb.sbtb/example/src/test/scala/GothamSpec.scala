import org.scalatest._
import pureconfig._
import com.typesafe.config.ConfigFactory.parseString

class GothamSpec extends FlatSpec with Matchers {
  "field mapping" should "be individually configurable" in {
    case class GothamConf(
      bruceWayne: String,
      joker: String
    )

    val overrides = Map("bruceWayne" -> "bat-man")
    implicit val hint = ProductHint[GothamConf](
      ConfigFieldMapping(overrides.withDefault(
        ConfigFieldMapping(CamelCase, KebabCase)
      )))

    val batExp = "hero"
    val jokExp = "zero"
    val conf = s"""bat-man: $batExp
                  |joker: $jokExp""".stripMargin
    val g = loadConfigOrThrow[GothamConf](parseString(conf))
    g.bruceWayne shouldBe batExp
    g.joker shouldBe jokExp
  }
}
