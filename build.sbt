ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.11.8"

lazy val root = (project in file("."))
  .settings(
    name := "empty",
    libraryDependencies += "com.chuusai" %% "shapeless" % "2.3.2"
  )
