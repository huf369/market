name := """play-java-market"""
organization := "com.example"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.12.2"

libraryDependencies += guice

libraryDependencies += javaJdbc

libraryDependencies ++= Seq(
  "org.mybatis" % "mybatis" % "3.4.5",
  "org.mybatis" % "mybatis-guice" % "3.9",
  "org.mybatis.caches" % "mybatis-ehcache" % "1.1.0",
  "com.google.inject.extensions" % "guice-multibindings" % "4.1.0",
  "org.apache.ibatis" % "ibatis-core" % "3.0"
)