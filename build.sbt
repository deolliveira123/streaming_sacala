ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.11"

lazy val root = (project in file("."))
  .settings(
    name := "stream"
  )

val sparkDependencies = Seq(

  "org.apache.spark" %% "spark-sql" % "3.2.0",
  "org.apache.spark" %% "spark-core" % "3.2.0"
)

val testDependencies = Seq(

  "org.scalatest" %% "scalatest" % "3.2.0"
)

libraryDependencies ++= sparkDependencies ++ testDependencies
