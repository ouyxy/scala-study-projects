package pers.ouyxy.scala.basis

import pers.ouyxy.scala.basis.utils.MyUtils

import scala.collection.mutable.ArrayBuffer

object TwoTuples {
    def main(args: Array[String]): Unit = {

        val myUtils = new MyUtils
        val arrBuf = ArrayBuffer.empty[(String, String, Int, Int, Long)]
        arrBuf += (("MIAI", "michat", 1, 1, 360000000L))
        arrBuf += (("MIAI", "nosense", 1, 1, 3600000L))
        arrBuf += (("S12 SoundBox", "michat", 1, 1, 3600000L))
        arrBuf += (("S12 SoundBox", "todofeature", 1, 1, 3600000L))
        arrBuf += (("common", "michat", 1, 1, 3600000L))
        arrBuf += (("common", "nosense", 1, 1,  3600000L))

        val tarMap: Map[(String, String), (Int, Int, Long)] = arrBuf.filter(e => (e._1 == "MIAI" || e._1 == "S12 SoundBox"))
            .map(e => (e._1, e._2) -> (e._3, e._4, e._5)).toMap
        val commonMap: Map[(String, String), (Int, Int, Long)] = arrBuf.filter(e => e._1 == "common")
            .map(e => (e._1, e._2) -> (e._3, e._4, e._5)).toMap

        val deviceList = List("MIAI", "S12 SoundBox")
        val styleList = List("michat", "nosense", "todofeature")

        val dsList = myUtils.combination(deviceList, styleList)
        val dsMap: Map[(String, String), (Int, Int, Long)] = (for (e <- dsList) yield tarMap.get(e) match {
            case Some(value) => e -> value
            case None => e -> (0, 0, 0L)
        }).toMap


        val dsMapNew = scala.collection.mutable.Map[(String, String), (Int, Int, Long, String)]()

        for (e <- styleList; d <- deviceList) {
            commonMap.get(("common", e)) match {
                case Some(c) => {
                    val o = dsMap.get((d, e)).get
                    val n = (o._1 + c._1, o._2 + c._2,o._3 + c._3)
                    val timeStr = if(n._2 > 0) myUtils.millis2Str(n._3 / n._2) else ""
                    dsMapNew += ((d, e) -> (n._1, n._2, n._3, timeStr))

                }
                case None => {
                    val n = dsMap.get((d, e)).get
                    val timeStr = if(n._2 > 0) myUtils.millis2Str(n._3 / n._2) else ""
                    dsMapNew += ((d, e) -> (n._1, n._2, n._3, timeStr))
                }
            }
        }

        for(e <- dsList){
            println(e + dsMapNew.get(e).get.toString())
        }
    }

}
