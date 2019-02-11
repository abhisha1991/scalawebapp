name := """PlayStarter"""
organization := "com.microsoft"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.12"

libraryDependencies += guice
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "3.1.2" % Test
libraryDependencies += "ml.combust.mleap" %% "mleap-spark" % "0.13.0"
libraryDependencies += "ml.combust.mleap" %% "mleap-spark-extension" % "0.13.0"
libraryDependencies += "commons-io" % "commons-io" % "2.6"
libraryDependencies += "org.json4s" %% "json4s-jackson" % "3.3.0"
libraryDependencies += "com.typesafe.play" %% "play-json" % "2.6.9"

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "com.microsoft.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "com.microsoft.binders._"
