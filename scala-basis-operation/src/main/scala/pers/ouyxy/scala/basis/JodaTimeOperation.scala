package pers.ouyxy.scala.basis

import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat

object JodaTimeOperation {
    def main(args: Array[String]): Unit = { //初始化时间
        // 字符串转DateTime
        val dateTime1: DateTime = DateTime.parse("20180919", DateTimeFormat.forPattern("yyyyMMdd"))
        println(dateTime1)
        // 输出当前时间
        println(DateTime.now())
        // 输出明天的当前时间点
        println(DateTime.now().plusDays(1))
        // 输出两个月后的当前时间点
        println(DateTime.now().plusMonths(2))
        // 获取DateTime的年月日时分秒和星期
        println("当前时间的年: " + DateTime.now().getYear)
        println("当前时间的月: " + DateTime.now().getMonthOfYear)
        println("当前时间的日: " + DateTime.now().getDayOfMonth)
        println("当前时间的时: " + DateTime.now().getHourOfDay)
        println("当前时间的分: " + DateTime.now().getMinuteOfHour)
        println("当前时间的秒: " + DateTime.now().getSecondOfMinute)
        println("当前时间的星期: " + DateTime.now().getDayOfWeek)
        // Datetime转字符串
        val dateTime = new DateTime
        val s1 = dateTime.toString("yyyy/MM/dd hh:mm:ss.SSSa")
        val s2 = dateTime.toString("yyyy-MM-dd HH:mm:ss")
        val s3 = dateTime.toString("EEEE dd MMMM, yyyy HH:mm:ssa")
        val s4 = dateTime.toString("yyyy/MM/dd HH:mm ZZZZ")
        val s5 = dateTime.toString("yyyy/MM/dd HH:mm Z")
        println(s1)
        println(s2)
        println(s3)
        println(s4)
        println(s5)
        println("---------------------------")
        val today: DateTime = DateTime.parse("20180919", DateTimeFormat.forPattern("yyyyMMdd"))
        val tomorrow = today.plusDays(1)
        val yesterday = today.minusDays(1)
        println(today.toString("yyyyMMdd"))
        println(tomorrow.toString("yyyyMMdd"))
        println(yesterday.toString("yyyyMMdd"))
        val weekList = (for (i <- 0 to 6) yield today.minusDays(i)).toList.map(_.toString("yyyyMMdd"))
        println(weekList.mkString(","))
    }
}
