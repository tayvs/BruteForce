package main.scala


class StringIterator(len: Int, chars: Seq[Char]) extends Iterable[String] {
  
  override def iterator: Iterator[String] = new Iterator[String] {
    
    override val length : Long = math.pow(chars.length, len).toLong
    var position: Long = 0L
    
    val buf = new Array[Int](len)
    
    def inc(arr: Array[Int], i: Int = 0): Unit = {
      if (arr(i) == (chars.size - 1)) {
        arr(i) = 0
        inc(arr, i + 1)
      }
      else arr(i) += 1
    }
    
    override def hasNext: Boolean = {
      !buf.forall(_ == (chars.size - 1))
    }
    
    override def next: String = {
      if (position % 1000000 == 0) {
        println("buffer is " + buf.mkString(" "))
        println("Str " + buf.map(chars(_)).mkString(""))
        val perCent = position / length * 100
        println(s"calculate $perCent %")
      }
      
      val str = buf.map(chars(_)).mkString("")
      
      inc(buf)
      position += 1L
      str
    }
  }
}
