import org.scalatest._
import scala.concurrent.duration._

import eu.timepit.refined.refineMV
import eu.timepit.refined.api.Refined
import eu.timepit.refined.auto._
import eu.timepit.refined.numeric._
import eu.timepit.refined.string._
import eu.timepit.refined.collection._
import eu.timepit.refined.pureconfig._

class RefinedSpec extends FlatSpec with Matchers {
  "RefinedConfig" should "load" in {
    val config = RefinedConfig.load 
    config.apiKey.value shouldBe "super53kr3tk3y"
    config.timeout.value shouldBe 15.seconds
    config.port.value shouldBe 12345
  }
}
