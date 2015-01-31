import play.PlayImport._
import play.PlayScala
import sbt.Keys._
import sbt._

object BackendBuild extends Build {

  val appVersion = "0.1.0-SNAPSHOT"

  lazy val common = Project(
    id = "common",
    base = file("common"),
    settings = Seq(
      name := "Common classes",
      scalaVersion := "2.11.4",
      version := appVersion,
      libraryDependencies ++= Seq(
      )
    )
  )

  lazy val recognizer = Project(
    id = "recognizer",
    base = file("recognizer"),
    settings = Seq(
      name := "Image recognizer",
      scalaVersion := "2.11.4",
      version := appVersion,
      libraryDependencies ++= Seq(
        openCv,
        logback,
        scalaTest % "test"
      )
    ),
    aggregate = Seq(
      common
    )
  ).dependsOn(common)

  lazy val rest = Project(
    id = "rest",
    base = file("rest"),
    settings = Seq(
      name := "Rest API",
      scalaVersion := "2.11.4",
      version := appVersion,
      libraryDependencies ++= Seq(
        jdbc,
        anorm,
        cache,
        ws
      )
    ),
    aggregate = Seq(
      common
    )
  ).enablePlugins(PlayScala)

  lazy val openCv = "nu.pattern" % "opencv" % "2.4.9-7"
  lazy val logback = "ch.qos.logback" % "logback-classic" % "1.1.2"
  lazy val scalaTest = "org.scalatest" %% "scalatest" % "2.1.6"
}