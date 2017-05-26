name := """smakweb-play"""
organization := "nl.vanbijleveld"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

val PhantomVersion = "2.1.3"

scalaVersion := "2.11.11"



libraryDependencies += "com.typesafe.play" %% "play-slick" % "2.0.2"
libraryDependencies += "com.typesafe.play" %% "play-slick-evolutions" % "2.0.2"
libraryDependencies += "com.h2database" % "h2" % "1.4.177"

libraryDependencies += specs2 % Test
libraryDependencies += filters


libraryDependencies += filters
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "2.0.0" % Test



//libraryDependencies ++= Seq(
//  "com.typesafe.slick" %% "slick" % "3.0.0",
//  "org.slf4j" % "slf4j-nop" % "1.6.4"
//)

//libraryDependencies ++= Seq(
//  "com.outworkers" %% "phantom-dsl" % PhantomVersion
//)

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "nl.vanbijleveld.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "nl.vanbijleveld.binders._"
