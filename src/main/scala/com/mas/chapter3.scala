package com.mas

import scala.collection.mutable.ArrayBuffer

/**
  * Created by mssora on 2018/2/14.
  */
object chapter3 extends App {
  // 快学scala 第三章数组相关操作 练习题

  // 1.编写一段代码,将a设置为一个n个随机整数的数组, 要求随机数介于0(包含)和n(不包含)之间
  // 使用ArrayBuffer
  def genArray2(n: Int): Array[Int] = {
    val arrBuf = new ArrayBuffer[Int]()
    for (_ <- 0 until n) {
      arrBuf += scala.util.Random.nextInt(n)
    }
    arrBuf.toArray
  }

  // yield 的返回类型与for的右边类型元素的类型相关, 如果不加toArray 返回类型是IndexSeq[Int]
  def genArray(n: Int): Array[Int] = {
    for (_ <- (0 until n).toArray) yield scala.util.Random.nextInt(n)
  }

  val a = genArray(10)
  //  a.foreach(println)

  // 2.编写一个循环,将整数数组中相邻的元素置换,例如,Array(1,2,3,4,5)经过置换后变成Array(2,1,4,3,5)
  val arr = Array(1, 2, 3, 4, 5)
  // 此处需要判断元素个数  2为step
  for (i <- 0 until(if (arr.length % 2 == 0) arr.length else arr.length - 1, 2)) {
    val temp: Int = arr(i)
    arr(i) = arr(i + 1)
    arr(i + 1) = temp
  }
  arr.foreach(println)

  // 3.重复前一个练习, 不过这次生成一个新的值交换过的数组. 用for/yield
  val arr2 = Array(1, 2, 3, 4, 5, 6)
  val newArr = for (i <- arr2.indices) yield {
    // 如果下标是最后一个 判断数组个数
    if (i == arr2.length - 1) {
      if (arr2.length % 2 == 0)
        arr2(i - 1)
      else
        arr2(i)
    } else {
      // 偶数下标位取后一个元素,奇数下标位取前一个元素
      if (i % 2 == 0)
        arr2(i + 1)
      else
        arr2(i - 1)
    }
  }
  newArr.foreach(println)

  // 4.给定一个整数数组, 产出一个新的数组, 包含原数组中的所有正值,以原有顺序排序,之后的元素是所有零或者负值,以原有顺序排序
  val arr3 = Array(1, 2, 3, 5, 5, 3, 2, -1, 0, 3, -2, -3, -2)
  val arr4 = arr3.filter(_ > 0) ++ arr3.filter(_ <= 0)
  arr4.foreach(println)

  // 5.如何计算Array[Double]的平均值?
  val arr5 = Array[Double](1.0, 2.3, 3.9, 8.6)
  println(arr5.sum / arr5.length)

  // 6.如何重新组织Array[Int]的元素将它们反序排列?对于ArrayBuffer[Int]你又会如何做呢?
  val arr6 = Array(1, 2, 3, 4, 5)
  println(arr6.reverse.toBuffer)
  val arrBuf = new ArrayBuffer[Int]()
  arrBuf.appendAll(arr6)
  println(arrBuf.reverse)

  // 7.编写一段代码, 产出数组中的所有值, 去掉重复项
  arr.distinct

  // 8.重新编写3.4节结尾的实例. 收集负值元素的下标,反序 ,去掉最后一个下标,然后对每一个下标调用 a.remove(i).比较这样做和3.4
  // 节中另外两种方法的效率


  // 9.创建一个由java.util.TimeZone.getAvailableIDs返回的时区集合,判断条件是他们是否在美洲.去掉"America/" 并排序
  val timeZoneArray: Array[String] = java.util.TimeZone.getAvailableIDs
    .filter(_.startsWith("America/")).map(_.replace("America/", "")).sortWith(_ < _)
  timeZoneArray.foreach(println)

  // 10.引入java.awt.datatransfer._并构建一个类型为SystemFlavorMap的对象:
  import java.awt.datatransfer._
  // 隐式转换在scala 2.12.0过时了,新的转换使用方法显式转换
  //  import scala.collection.JavaConversions.asScalaBuffer
  import scala.collection.JavaConverters.asScalaBuffer
  import scala.collection.mutable.Buffer

  val flavors = SystemFlavorMap.getDefaultFlavorMap.asInstanceOf[SystemFlavorMap]
  // 然后以DataFlavor.imageFlavor为参数调用getNativesForFlavor方法,以scala缓冲保存值.(....)
  val buffer: Buffer[String] = asScalaBuffer(flavors.getNativesForFlavor(DataFlavor.imageFlavor))
  //  val buffer: Buffer[String]= flavors.getNativesForFlavor(DataFlavor.imageFlavor) 隐式转换会自动转换类型
  println(buffer)
}
