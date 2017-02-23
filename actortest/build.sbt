name := "hello"

version := "1.0"

scalaVersion := "2.10.2"

libraryDependencies ++= Seq(
  "org.postgresql" % "postgresql" % "9.3-1100-jdbc4",
  "com.typesafe.slick" %% "slick" % "2.1.0",
  "org.slf4j" % "slf4j-nop" % "1.6.4",
  "com.typesafe.akka" % "akka-actor_2.10" % "2.2-M1"
)