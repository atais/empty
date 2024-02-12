ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.11.8"

lazy val root = (project in file("."))
  .aggregate(
    `shapeless-empty`,
    `macro-empty`,
    `macro-empty-use`,
    `base-empty`
  )

lazy val `base-empty` = project in file("base-empty")

lazy val `macro-empty` = (project in file("macro-empty"))
  .settings(
    libraryDependencies += "org.scala-lang" % "scala-reflect" % "2.11.8"
  )
  .dependsOn(`base-empty`)

lazy val `macro-empty-use` = (project in file("macro-empty-use"))
  .settings(
  )
  .dependsOn(`macro-empty`)

lazy val `shapeless-empty` = (project in file("shapeless-empty"))
  .settings(
    libraryDependencies += "com.chuusai" %% "shapeless" % "2.3.2"
  )
  .dependsOn(`base-empty`)
