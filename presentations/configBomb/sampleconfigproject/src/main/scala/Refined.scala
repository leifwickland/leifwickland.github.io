import java.util.Properties
import scala.concurrent.duration._
import eu.timepit.refined.W
import eu.timepit.refined.api.Refined
import eu.timepit.refined.auto._
import eu.timepit.refined.numeric._
import eu.timepit.refined.string._
import eu.timepit.refined.collection._
import eu.timepit.refined.pureconfig._
import RefinedConfig._

case class RefinedConfig(
  apiKey: String Refined NonEmpty,
  timeout: FiniteDuration Refined Positive,
  port: Int Refined PortNumber
)

object RefinedConfig{
  type PortNumber = 
    Interval.Closed[W.`1`.T, W.`65535`.T]
  implicit val FiniteDurationNumeric: scala.math.Numeric[FiniteDuration] = new scala.math.Numeric[FiniteDuration] {
    def fromInt(x: Int): FiniteDuration = x.nanos
    def minus(x: FiniteDuration,y: FiniteDuration): FiniteDuration = x-y
    def negate(x: FiniteDuration): FiniteDuration = x * -1
    def plus(x: FiniteDuration,y: FiniteDuration): FiniteDuration = x+y
    def times(x: FiniteDuration,y: FiniteDuration): FiniteDuration = x*y
    def toDouble(x: FiniteDuration): Double = x.length.toDouble
    def toFloat(x: FiniteDuration): Float = x.length.toFloat
    def toInt(x: FiniteDuration): Int = x.length.toInt
    def toLong(x: FiniteDuration): Long = x.length
    def compare(a: FiniteDuration, b: FiniteDuration): Int = FiniteDuration.FiniteDurationIsOrdered.compare(a,b)
  }
  def load(): RefinedConfig = {
    pureconfig.loadConfigOrThrow[RefinedConfig]
  }
}
