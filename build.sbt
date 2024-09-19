version := "1.0"
name := "scala-with-kafka"
scalaVersion := "2.13.13"

// Dependencies
libraryDependencies ++= Seq(
  "com.typesafe.play" %% "play-json" % "2.10.5",
  "org.apache.kafka" % "kafka-clients" % "3.8.0",
  "com.typesafe.scala-logging" %% "scala-logging" % "3.9.5",
  "ch.qos.logback" % "logback-classic" % "1.5.6",
  "com.typesafe" % "config" % "1.4.3"
)

// sbt-assembly configuration
assembly / assemblyMergeStrategy := {
  case PathList("META-INF", xs @ _*) => MergeStrategy.discard // Handle META-INF conflicts
  case PathList("application.conf") => MergeStrategy.concat     // For multiple `application.conf` files
  case x => MergeStrategy.first                                // Default merge strategy
}

// Define the main class to be included in the fat JAR
// Ensure that you specify your actual main class here
mainClass in assembly := Some("KafkaScalaProducer")

