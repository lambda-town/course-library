import sbtghpackages.TokenSource.Environment

ThisBuild / scalaVersion := "2.12.10"
ThisBuild / version := "0.1.2"
ThisBuild / organization := "lambda"
ThisBuild / organizationName := "Lambdacademy"

ThisBuild / githubUser := sys.env.getOrElse("GITHUB_USER", "REPLACE_ME")
ThisBuild / githubOwner := "lambdacademy-dev"
ThisBuild / githubTokenSource := Some(Environment("GITHUB_TOKEN"))
ThisBuild / githubRepository := "course-library"

ThisBuild / resolvers ++= Seq("course-dsl").map(Resolver.githubPackagesRepo("lambdacademy-dev", _))

lazy val root = (project in file("."))
  .settings(
    name := "course-library",
    libraryDependencies ++= Seq(
      "lambda" %% "course-dsl" % "0.2.3",
      "org.scalatest" %% "scalatest" % "3.0.8" % Test
    ),
    scalacOptions ~= { _.filterNot(Set("-Xlint:missing-interpolator")) }
  )

