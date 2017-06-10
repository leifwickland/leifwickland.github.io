import java.util.Properties
import scala.concurrent.duration._
import eu.timepit.refined.refineV
import eu.timepit.refined.W
import eu.timepit.refined.api.Refined
import eu.timepit.refined.auto._
import eu.timepit.refined.numeric._
import eu.timepit.refined.string._
import eu.timepit.refined.collection._
import eu.timepit.refined.pureconfig._
import eu.timepit.refined.api.Validate
import shapeless.Witness
import java.net.URL
import java.net.ServerSocket
import java.nio.file.{Paths,Path}
import RefinedConfig._

case class RefinedConfig(
  apiKey: String Refined NonEmpty,
  timeout: FiniteDuration Refined Positive,
  readFrom: URL,
  writeTo: Path
)

object RefinedConfig{
  type NonReserveredPort = Int Refined
    Interval.Closed[W.`1024`.T, W.`65535`.T]

  type ApiKey = String Refined
    MatchesRegex[W.`"[a-zA-Z0-9]{36}"`.T]

  final case class OpenPort()

  implicit val openPortValidate:
    Validate.Plain[Int, OpenPort] =
        Validate.fromPartial(
              new ServerSocket(_).close(),
                  "OpenPort", OpenPort())

    type AvailPort = Int Refined OpenPort

  final case class WritableDir()

  implicit val writableDirValidate:
    Validate.Plain[Path, WritableDir] =
    Validate.fromPredicate(
      p => p.toFile.canWrite && 
        p.toFile.isDirectory,
      p => s"$p is not a writable dir.",
      WritableDir())

  type WritableDirectory = Path Refined WritableDir

  //println("/Users/lwickland/:" + refineV[WritableDir](Paths.get("/Users/lwickland/")))
  //println("/:" + refineV[WritableDir](Paths.get("/")))

  /// Technically a FiniteDuration is not a number, so I'm going to fake it.
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
