name := "avro4s-example"

version := "0.1"


scalaVersion := "2.12.13"
val sparkVersion = "2.4.5"

libraryDependencies += "org.apache.spark" %% "spark-avro" % sparkVersion
libraryDependencies += "com.sksamuel.avro4s" %% "avro4s-core" % "4.0.4"
libraryDependencies += "org.apache.spark" %% "spark-sql" % "2.4.5"
