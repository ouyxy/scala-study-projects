package pers.ouyxy.scala.basis.utils

class MyUtils {

    def combination[T](A: List[T], B: List[T]): List[(T, T)] = (for (a <- A; b <- B) yield (a, b))

    def millis2Str(millis: Long): String = {
        val s = millis / 1000
        val days = s / (3600 * 24)
        val hours = ((s % (3600 * 24)) * 1.0 / 3600).formatted("%.2f")
        if (days > 0) s"${days}天${hours}小时" else s"${hours}小时"
    }
}
