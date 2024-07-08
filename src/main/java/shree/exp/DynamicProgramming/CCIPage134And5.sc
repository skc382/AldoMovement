object TripleStep{

  def f(n:Int):Int = {
    if(n==1 || n==2 || n==3) return n

    return f(n-1) + f(n-2) + f(n-3)
  }

  def fMemo(n:Int, acc:Array[Int]):Int = {
    if(n==1 || n==2 || n==3) return n

    if(acc(n) == 0) {
      acc(n) = fMemo(n-1, acc) + fMemo(n-2, acc) + fMemo(n-3, acc)
    }

    return acc(n)
  }

  def ftextBook(n:Int):Int = {
    if(n < 0) return 0
    if(n == 0) return 1;

    return ftextBook(n-1) + ftextBook(n-2) + ftextBook(n-3)
  }
}

val r = TripleStep.f(6)
val rTextBook = TripleStep.ftextBook(6)
val rMemo = TripleStep.fMemo(6, Array.fill(10)(0))