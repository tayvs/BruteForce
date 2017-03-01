package main.scala

import java.security.MessageDigest

object TestBrute {
  val md: MessageDigest = MessageDigest.getInstance("SHA-512")
  val chars = ('a' to 'z') ++ ('A' to 'Z') ++ ('0' to '9') ++ Seq('_', '.', '@', '-', '!')
  
  def bruteHash(hash: String, login: String, pass: String) = {
    val iterator = new StringIterator(pass.length, chars).par
    iterator
      .find { pass =>
        System.err.println(s"$pass started")
        val input = pass + login
        val calcHash = md.digest(input.getBytes).map(byteToString).mkString
        System.err.println(s"$pass finished")
        calcHash == hash
      }.get
  }
  
  def bruteHash(hash: Array[Byte], login: String, pass: String) = {
    val iterator = new StringIterator(pass.length, chars).par
    iterator
      .find { pass =>
        System.err.println(s"$pass started")
        val input = pass + login
        val calcHash = md.digest(input.getBytes)
        System.err.println(s"$pass finished")
        calcHash == hash
      }.get
  }
  
  def byteToString(b: Byte): String = {
    val ch = "0123456789abcdef"
    val n1 = b & 0x0f
    val n2 = b >> 4 & 0x0f
    
    new String(Array[Char](ch(n1), ch(n2)))
  }
  
  
}