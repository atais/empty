ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.11.8"

lazy val root = (project in file("."))
  .aggregate(
    `shapeless-empty`,
    `macro-empty`,
    `base-empty`
  )

lazy val `base-empty` = project in file("base-empty")

lazy val `macro-empty` = (project in file("macro-empty"))
  .settings(
  )
  .dependsOn(`base-empty`)

lazy val `shapeless-empty` = (project in file("shapeless-empty"))
  .settings(
    libraryDependencies += "com.chuusai" %% "shapeless" % "2.3.2"
  )
  .dependsOn(`base-empty`)
