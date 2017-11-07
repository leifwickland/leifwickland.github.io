lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.example",
      scalaVersion := "2.12.2",
      version      := "0.1.0-SNAPSHOT"
    )),
    name := "sampleconfigproject",
    libraryDependencies ++= Seq(
      "com.github.pureconfig" %% "pureconfig"         % "0.8.0",
      "eu.timepit"            %% "refined"            % "0.8.4",
      "eu.timepit"            %% "refined-pureconfig" % "0.8.4", // optional, JVM-only
      "org.scalatest"         %% "scalatest"          % "3.0.1" % "test"
    )
  )
