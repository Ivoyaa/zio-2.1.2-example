ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.10"

lazy val zioVersion = "2.1.2" // The HappyPathSpec gets stuck on 2.1.X but works as expected on 2.0.X
lazy val scalaTestVersion = "3.1.0"

lazy val root = (project in file("."))
  .settings(
    name := "zio-2.1.2-example",
    libraryDependencies ++= Seq(
      "dev.zio" %% "zio" % zioVersion,
      "dev.zio" %% "zio-test" % zioVersion % Test,
      "org.scalatest" %% "scalatest" % scalaTestVersion % Test,
    )
  )
