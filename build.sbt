name := """layered-dip-hands-on"""

lazy val commonSettings = Seq(
  scalaVersion := "2.11.7"
)

lazy val projects = Project(
  id = "layered-dip-example",
  base = file("layeredDIPExample")
).enablePlugins(PlayScala)
  .settings(commonSettings)
  .settings(
    scalaSource in Compile := baseDirectory.value / "src" / "main" / "scala",
    scalaSource in Test := baseDirectory.value / "src" / "test" / "scala",
    resourceDirectory in Compile := baseDirectory.value / "src" / "main" / "resources",
    resourceDirectory in Test := baseDirectory.value / "src" / "test" / "resources"
  )
  .dependsOn(
    infrastructure % "test->test;compile->compile",
    ui % "test->test;compile->compile",
    application % "test->test;compile->compile",
    domain % "test->test;compile->compile"
  )
  .aggregate(
    infrastructure,
    domain,
    application,
    ui
  )

lazy val infrastructure = Project(
  id = "infrastructure",
  base = file("layeredDIPExample/infrastructure")
).settings(commonSettings)
  .dependsOn(
    ui % "test->test;compile->compile",
    application % "test->test;compile->compile",
    domain % "test->test;compile->compile"
  )

lazy val ui = Project(
  id = "ui",
  base = file("layeredDIPExample/ui")
).settings(commonSettings)
  .dependsOn(
    application % "test->test;compile->compile",
    domain % "test->test;compile->compile"
  )

lazy val application = Project(
  id = "application",
  base = file("layeredDIPExample/application")
).settings(commonSettings)
  .dependsOn(
    domain % "test->test;compile->compile"
  )

lazy val domain = Project(
  id = "domain",
  base = file("layeredDIPExample/domain")
).settings(commonSettings)