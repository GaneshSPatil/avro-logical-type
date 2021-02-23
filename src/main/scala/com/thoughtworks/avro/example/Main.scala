package com.thoughtworks.avro.example

import com.thoughtworks.avro.example.types.StringWithLengthLogicalTypeFactory
import org.apache.avro.{LogicalTypes, Schema}
import org.apache.spark.sql.avro.SchemaConverters
import org.apache.spark.sql.types.StructType

import scala.collection.immutable.HashMap
import scala.io.Source


object Main {
  def main(args: Array[String]): Unit = {
    LogicalTypes.register("string-with-length", new StringWithLengthLogicalTypeFactory)

    HashMap(
//      "schemas/primitive.avro" -> "data/custom-logical.json",
//      "schemas/logical.avro" -> "data/custom-logical.json",
//      "schemas/nested.avro" -> "data/custom-logical.json",
      "schemas/custom-logical.avro" -> "data/custom-logical.json",
    ).foreach(x => processAvro(x._1, x._2))
  }

  def processAvro(schemaFilename: String, dataFilename: String): Unit = {
    val avroString: String = Source.fromResource(schemaFilename).getLines().mkString
    val schemaObj: Schema = new Schema.Parser().parse(avroString)

    println(schemaObj.getField("string_with_length_name"))
    val structType = SchemaConverters.toSqlType(schemaObj).dataType.asInstanceOf[StructType]

    println("-----------------------------------------------------")
    println(s"Avro Schema: \n $schemaObj")
    println(s"\nStruct Type: \n $structType")
  }
}
