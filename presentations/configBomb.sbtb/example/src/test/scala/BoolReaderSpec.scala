import org.scalatest._
import pureconfig._
import com.typesafe.config.ConfigFactory.parseString

class BoolReaderSpec extends FlatSpec with Matchers {
  "boolean" should "be overridable" in {
    implicit val b00lReader =
      ConfigReader.fromStringOpt[Boolean] {
        case "lit" | "yaaas" => Some(true)
        case "basic" | "0" => Some(false)
        case _ => None
      }
    case class Bools(a: Boolean, b: Boolean, c:Boolean)
    val conf = s"""a: lit 
                  |b: yaaas
                  |c: basic""".stripMargin
    val g = loadConfigOrThrow[Bools](parseString(conf))
    g.a shouldBe true
    g.b shouldBe true
    g.c shouldBe false
  }
}
