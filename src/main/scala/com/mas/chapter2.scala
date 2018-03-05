package com.mas

import scala.annotation.tailrec

/**
  * Created by mssora on 2018/2/14.
  */
object chapter2 extends App {
  // 快学scala 第二章 控制结构和函数 练习

  // 1.如果一个数字为正数,则它的signum为1;如果是负数则为-1;如果是0则为0.编写一个函数来计算这个值
  def signum(num: Int): Int = if (num > 0) 1 else if (num == 0) 0 else -1

  println(signum(1))

  // 2.一个空的块表达式{}的值是什么?类型是什么
  /**
    * scala> val a= {}
    * a: Unit = ()
    */
  //值为() 类型为Unit

  // 3.指出在scala中何种情况下下列赋值语句 x = y = 1 是合法的?(提示:给x找一个合适的类型定义)
  // 因为赋值语句的值为Unit 所以当x: Unit = () 时x = y = 1是合法的
  var x = ()
  var y = 1
  x = y = 1

  // 4.针对下列循环编写一个scala版本:
  // for(int i = 10 ; i>=0; i--) System.out.println(i);
  for (i <- (0 to 10).reverse) println(i)

  // 5.编写一个过程countdown(n: Int),打印从n到0的数字
  def countdown(n: Int): Unit = {
    for (i <- if (n > 0) 0 to n else n to 0) println(i)
  }

  // 6.编写一个for循环,计算字符串中所有字母的unicode代码的乘积.举例来说,"Hello"中所有字符的乘积为9415087488L
  val str = "Hello"
  var sum = 1L
  for (c <- str) {
    sum *= c.toLong
  }
  println(sum)

  // 7.同样是解决前一个问题,不使用循环(提示:在StringOps中查找函数)
  println(str.map(_.toLong).product)

  // 8.编写一个函数product(s : String),计算前面练习中提到的乘积
  def product(s: String): Long = s.map(_.toLong).product

  // 9.把前面一个练习的函数改成递归函数
  def product2(s: String, index: Int = 0): Long = {
    if (index == s.length - 1)
      s(index).toLong
    else
      s(index).toLong * product2(s, index + 1)
  }

  println(product2(str, 0))

  // 10.编写函数计算x的n次方,其中n是整数,使用如下的递归定义,公式略 这题目看不懂..
  def fun(x: Double, n: Int): BigDecimal = {
    if (n == 0) {
      1
    } else if (n < 0) {
      1 / fun(x, -1 * n)
    } else if (n % 2 == 0) {
      fun(x, n / 2) * fun(x, n / 2)
    } else {
      x * fun(x, n - 1)
    }
  }

  println(fun(323.0, 3))


}
