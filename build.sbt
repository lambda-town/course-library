import org.apache.commons.io.FileUtils

ThisBuild / scalaVersion := "2.12.10"
ThisBuild / version := "0.1.9-SNAPSHOT"
ThisBuild / organization := "lambda"
ThisBuild / organizationName := "Lambdacademy"

githubOwner := "lambdacademy-dev"
resolvers += Resolver.githubPackages("lambdacademy-dev")
githubRepository := "course-library"

lazy val root = (project in file("."))
  .settings(
    name := "course-library",
    libraryDependencies ++= Seq(
      "lambda" %% "course-dsl" % "0.2.8",
      "org.scalatest" %% "scalatest" % "3.1.2" % Test
    ),
    scalacOptions ~= { _.filterNot(Set("-Xlint:missing-interpolator")) },
    compile in Compile := (compile in Compile).dependsOn(bundleExamples).value,
    githubTokenSource :=  TokenSource.GitConfig("github.token") || TokenSource.Environment("GITHUB_TOKEN")
  )

lazy val scalaCodeExamples = (project in file("scala-code-examples"))
  .settings(
    libraryDependencies ++= Seq(
      "lambda" %% "scala-utils" % "0.2.3",
      "org.scalatest" %% "scalatest" % "3.1.2" % Test
    ),
    githubTokenSource :=  TokenSource.GitConfig("github.token") || TokenSource.Environment("GITHUB_TOKEN")
  )

lazy val bundleExamples = TaskKey[Unit]("bundleExamples", "Copies examples in the resources folder")

ThisBuild / bundleExamples := {

  val log = streams.value.log
  val resources = resourceDirectory.in(root).in(Compile).value

  val examplesFolders = List(
    scalaSource.in(scalaCodeExamples).in(Compile).value / "lambda"
  )
  FileUtils.deleteQuietly(resources / "examples")
  examplesFolders.foreach(f => {
    FileUtils.copyDirectory(f, resources)
    log.info(s"Copied $f to $resources")
  })
}
