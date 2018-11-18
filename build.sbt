import com.typesafe.sbt.SbtAspectj._
import com.typesafe.sbt.SbtAspectj.AspectjKeys

val kamonVersion = "0.5.1"

lazy val root = (project in file("."))
  .settings(
    organization := "com.github.kzmkae.sample.kamon.akka",
    name := "sample-kamon-akka",
    version := "1.0",
    scalaVersion := "2.11.12",
    libraryDependencies ++= Seq(
      "com.typesafe.akka" %% "akka-actor" % "2.5.18",
      "io.kamon" %% "kamon-core" % kamonVersion,
      "io.kamon" %% "kamon-akka" % kamonVersion,
      "io.kamon" %% "kamon-log-reporter" % kamonVersion
    ),
    aspectjSettings,
    javaOptions in run <++= AspectjKeys.weaverOptions in Aspectj,
    fork in run := true
  )
