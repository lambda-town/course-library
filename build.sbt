import org.apache.commons.io.FileUtils
import sbtghpackages.TokenSource.Environment

ThisBuild / scalaVersion := "2.12.10"
ThisBuild / version := "0.1.3"
ThisBuild / organization := "lambda"
ThisBuild / organizationName := "Lambdacademy"

ThisBuild / githubUser := sys.env.getOrElse("GITHUB_USER", "REPLACE_ME")
ThisBuild / githubOwner := "lambdacademy-dev"
ThisBuild / githubTokenSource := Some(Environment("GITHUB_TOKEN"))
ThisBuild / githubRepository := "course-library"

ThisBuild / resolvers ++= Seq("course-dsl", "scala-runner").map(Resolver.githubPackagesRepo("lambdacademy-dev", _))

lazy val root = (project in file("."))
  .settings(
    name := "course-library",
    libraryDependencies ++= Seq(
      "lambda" %% "course-dsl" % "0.2.7",
      "org.scalatest" %% "scalatest" % "3.0.8" % Test
    ),
    scalacOptions ~= { _.filterNot(Set("-Xlint:missing-interpolator")) },
    compile in Compile := (compile in Compile).dependsOn(bundleExamples).value
  )

lazy val scalaCodeExamples = (project in file("scala-code-examples"))
  .settings(
    libraryDependencies ++= Seq(
      "lambda" %% "scala-utils" % "0.2.2",
      "org.scalatest" %% "scalatest" % "3.0.8" % Test
    )
  )

lazy val bundleExamples = TaskKey[Unit]("bundleExamples", "Copies examples in the resources folder")

ThisBuild / bundleExamples := {

  val log = streams.value.log
  val dest = resourceDirectory.in(root).in(Compile).value

  val examplesFolders = List(
    scalaSource.in(scalaCodeExamples).in(Compile).value / "lambda"
  )
  FileUtils.deleteQuietly(dest)
  examplesFolders.foreach(f => {
    FileUtils.copyDirectory(f, dest)
    log.info(s"Copied $f to $dest")
  })
}
