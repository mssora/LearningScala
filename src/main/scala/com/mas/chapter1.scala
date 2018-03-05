package com.mas

/**
  * Created by mssora on 2018/2/13.
  */
object chapter1 extends App {
  // 快学scala 第一章 基础 练习题
  // 1.在REPL中3的可用方法
  /*
  scala> 3.
  !=   +   <<   >=    abs         compareTo     getClass     isNaN           isValidChar    isWhole     round        to               toDegrees     toInt           toShort   underlying
    %    -   <=   >>    byteValue   doubleValue   intValue     isNegInfinity   isValidInt     longValue   self         toBinaryString   toDouble      toLong          unary_+   until
    &    /   ==   >>>   ceil        floatValue    isInfinite   isPosInfinity   isValidLong    max         shortValue   toByte           toFloat       toOctalString   unary_-   |
    *    <   >    ^     compare     floor         isInfinity   isValidByte     isValidShort   min         signum       toChar           toHexString   toRadians       unary_~
  */

  // 2.在REPL中计算3的平方根,然后对该值再平方,得到的结果与3相差多少
  /**
  scala> sqrt(3)
  res0: Double = 1.7320508075688772

  scala> pow(res0, 2)
  res1: Double = 2.9999999999999996
  */

  // 3.res变量是val还是var? =>val
  /**
  scala> res1=1.0
  <console>:15: error: reassignment to val
         res1=1.0

   */

  // 4."crazy" * 3结果是什么,如何在scaladoc中找到这个操作?
  /**
  scala> "crazy" * 3
  res0: String = crazycrazycrazy

   */
  "" * 3
  // 定义在scala.collection.immutable.StringLike.*,实际上使用时string会隐式转换为scala.collection.immutable.StringOps
  /** The `String` type in Scala has methods that come either from the underlying
    *  Java String (see the documentation corresponding to your Java version, for
    *  example [[http://docs.oracle.com/javase/8/docs/api/java/lang/String.html]]) or
    *  are added implicitly through [[scala.collection.immutable.StringOps]].
    */

  // 5. 10 max 2 的含义是什么?max定义在哪个类中?
  10 max 2
  // 返回10 和 2 中大的数,定义在scala.runtime.RichInt中

  // 6.用BigInt计算2 的 1024次方
  BigInt(1) << 1024
  // 左移1位 = *2

  // 7.为了在使用probablePrime(100, Random)获取随机随机素数时不在probablePrime和Random前面不使用任何限定符,你需要引入什么?
  import scala.math.BigInt._
  import scala.util.Random
  probablePrime(100, Random)

  // 8. 创建随机文件的方法之一是生成一个随机的bigint, 然后将它转换成三十六进制,输出类似"dwhaghefwagrege"的字符串,查阅scaladoc
  // 找到在scala实现该逻辑的办法
  val value = BigInt.apply(12345, Random)
  println(value.toString(36))

  //9. 在scala中怎么获取字符串的首尾字符?
  val str1 = "Hello world!"
  println(str1(0))
  println(str1.last)

  //10. take,drop,takeRight,dropRight这些字符串函数是用来做什么的?和substring相比,他们的优缺点有哪些?

  // take(n) 取前n个字符
  println(str1.take(1))
  // drop(n) 去掉前n个字符
  println(str1.drop(1))
  // takeRight(n) 取后n个字符
  println(str1.takeRight(1))
  // dropRight(n) 去掉后n个字符
  println(str1.dropRight(1))

  /**
    * @see [[https://stackoverflow.com/questions/31711837/drop-dropright-take-takeright-vs-substring]]
    * scala里面的方法提供了边界验证,substring没有边界验证,参数错误时会抛出异常
    */
}
