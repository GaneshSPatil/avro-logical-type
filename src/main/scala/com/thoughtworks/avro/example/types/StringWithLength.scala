package com.thoughtworks.avro.example.types

import org.apache.avro.LogicalTypes.LogicalTypeFactory
import org.apache.avro.{LogicalType, Schema}

class StringWithLength(str: String, len: Int) extends LogicalType("string-with-length") {
  override def validate(schema: Schema): Unit = {
    super.validate(schema)
  }
}

class StringWithLengthLogicalTypeFactory extends LogicalTypeFactory {
  override def fromSchema(schema: Schema): LogicalType = {
    return new StringWithLength("", 2)
  }
}
