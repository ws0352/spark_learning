
package spark_learning

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.col

class Library {
  def someLibraryMethod(): Boolean = true

  //建立spark会话
  val spark = SparkSession.builder()
    .appName("Hello Spark SQL")
    .config("spark.master", "local")
    .getOrCreate()
  //将RDDS转换为DataFrames
  import spark.implicits._
  //通过导入json创建DataFrames
  var df = spark.read.json("./src/main/resources/source.json")
  //输出表信息
  df.show()
  //输出表结构
  df.printSchema()
  //表操作
  df.select("name").show()//查看某一列
  //查看和过滤操作
  df.select(col("name"), col("ref_height") + 1.00).show()
  df.filter(col("ref_height") > 15.00).show()
  df.select($"name", $"ref_height" + 1.00).show()
  //查看和过滤操作的第二种写法
  df.filter($"ref_height" > 15.00).show()
  df.groupBy("ref_height").count().show()
  //建立局部临时视图
  df.createOrReplaceTempView("tree")
  var sqlDF = spark.sql("SElECT Species FROM tree")
  sqlDF.show()
  //建立全局临时视图
  df.createGlobalTempView("tree")
  spark.sql("SELECT * FROM global_temp.tree").show()
  spark.newSession().sql("SELECT * FROM global_temp.tree").show()
  //为样例类创建编码器
  val caseClassDS = Seq(Tree("Saries SS", 16.01F)).toDS()
  caseClassDS.show()
  //大多数常用类型的编码器被隐式转换自动的提供
  val primitiveDS = Seq(1, 2, 3).toDS()
  primitiveDS.map(_ + 1).collect()
//  通过提供一个类，DataFrames可以被转换为DataSet
  val path = "./src/main/resources/tree.json"
  val treeDS = spark.read.json(path).as[Tree]
  treeDS.show()
}
