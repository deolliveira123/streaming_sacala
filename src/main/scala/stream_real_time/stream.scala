package stream_real_time

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types.{StringType, StructType}
object stream {

  def main(args: Array[String]): Unit = {

    val spark = SparkSession.builder()
      .appName("Stream")
      .master("local[*]")
      .getOrCreate()

    val schema_my = new StructType()
      .add("name", StringType, true)
      .add("points", StringType, true)

    val df = spark.readStream
      .option("header", true)
      .schema(schema_my)
      .csv("/home/andre/IdeaProjects/stream/src/main/scala/resources")

    df.writeStream
      .format("console")
      .outputMode("append")
      .start()
      .awaitTermination()

  }

}
