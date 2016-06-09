package mx.krieger.internals.gallery.utils

import java.security.MessageDigest
import java.util.Date

object Indexes {
  private val random = new scala.util.Random()

  private def md5(s: String) = {
    MessageDigest.getInstance("MD5").digest(s.getBytes)
  }

  def generateIndex(fact: String): String = {
    val date = new Date().getTime.toString
    val hashName = md5(fact)
    val extra = Math.abs(random.nextInt())

    date.toString + hashName.slice(3, 8) + extra
  }

}
