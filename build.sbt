name := "scalajs-playwright"

organization := "com.github.danhodges"

version := "0.1"

scalaVersion := "2.13.3"

lazy val root = project
  .in(file("."))
  .enablePlugins(ScalaJSPlugin, ScalaJSBundlerPlugin)
  .settings(
    scalaVersion := "2.13.3",
    licenses += ("Apache-2.0", url("https://www.apache.org/licenses/LICENSE-2.0.html")),
    bintrayRepository := "maven",
    scalaJSLinkerConfig ~= { _.withModuleKind(ModuleKind.CommonJSModule) },
    libraryDependencies ++= Seq("org.scala-js"      %%% "scalajs-dom" % "1.0.0"),
    npmDependencies in Compile ++= Seq("playwright" -> "1.4.0"),
    name := "root",
    bintrayReleaseOnPublish := !isSnapshot.value
  )
