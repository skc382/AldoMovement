import scala.annotation.tailrec

  //@tailrec
  def fib(a:Int):Int = {

    if(a==0) return 0
    if(a==1) return 1

    println("called fib"+ a)
    fib(a-1) + fib(a-2)
  }

  // Bottom up approach
  def outer(input:Int):Int = {
    var arr = Array.tabulate(100)(a => 0)
    arr(0) = 0
    arr(1) = 1

    def dynamicFib(j:Int):Int = {

      if(j==0) return arr(0)
      if(j==1) return arr(1)

      if(arr(j) != 0) return arr(j)
      println("called dyFib"+ j)
      arr(j) = dynamicFib(j-1) + dynamicFib(j-2)
      return arr(j)
    }

    return dynamicFib(input)
  }


  def memoization(i:Int, accumalator:Array[Int]):Int = {
    if(i == 0 || i == 1) return i

    if(accumalator(i) == 0) {
//      println("called asTailRec"+ i)
      accumalator(i) = memoization(i-1, accumalator) +
        memoization(i-2,accumalator)
    }

    return accumalator(i)
  }

val arr3 = Array.tabulate(100)(a => 0)

val result = fib(10)
val reault0 = memoization(20,arr3)
val result2 = outer(6)

