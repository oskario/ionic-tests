import spray.revolver.RevolverPlugin._

name := """activator-akka-spray"""

version := "1.0"

scalaVersion := "2.11.4"

resolvers += "spray repo" at "http://repo.spray.io"

resolvers += "spray nightlies" at "http://nightlies.spray.io"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % "2.3.8",
  "com.typesafe.akka" %% "akka-slf4j" % "2.3.8",
  "ch.qos.logback" % "logback-classic" % "1.1.2",
  "io.spray" %% "spray-can" % "1.3.1",
  "io.spray" %% "spray-routing" % "1.3.1",
  "io.spray" %% "spray-json" % "1.3.1",
  "net.sourceforge.tess4j" % "tess4j" % "1.3.0",
  "com.typesafe.akka" %% "akka-testkit" % "2.3.8" % "test",
  "org.specs2" %% "specs2" % "2.4.15" % "test",
  "io.spray" %% "spray-testkit" % "1.3.1" % "test",
  "com.novocode" % "junit-interface" % "0.11" % "test->default"
)

scalacOptions ++= Seq(
  "-unchecked",
  "-deprecation",
  "-Xlint",
  "-Ywarn-dead-code",
  "-language:_",
  "-target:jvm-1.7",
  "-encoding", "UTF-8"
)

testOptions += Tests.Argument(TestFrameworks.JUnit, "-v")

Revolver.settings
