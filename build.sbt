ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.11.8"

lazy val root = (project in file("."))
  .aggregate(
    `empty-shapeless`,
    `empty-macro`,
    `empty-base`,
    `empty-tests`
  )

lazy val `empty-base` = project in file("empty-base")

lazy val `empty-macro` = (project in file("empty-macro"))
  .settings(
    libraryDependencies += "org.scala-lang" % "scala-reflect" % "2.11.8"
  )
  .dependsOn(`empty-base`)

lazy val `empty-tests` = (project in file("empty-tests"))
  .settings(
    scalacOptions ++= Seq(
      "-Ymacro-debug-lite"
    )
  )
  .dependsOn(
    `empty-macro`,
    `empty-shapeless`
  )

lazy val `empty-shapeless` = (project in file("empty-shapeless"))
  .settings(
    libraryDependencies += "com.chuusai" %% "shapeless" % "2.3.2"
  )
  .dependsOn(`empty-base`)
