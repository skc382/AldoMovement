import scala.collection.mutable.ArrayBuffer

def sort(arr: ArrayBuffer[Int]): Unit = {
  var helper: ArrayBuffer[Int] = ArrayBuffer.fill(arr.length)(0)
  msort(arr, helper, 0, arr.length-1)
}

def msort(arr: ArrayBuffer[Int], helper: ArrayBuffer[Int],
          l:Int, h: Int): Unit = {
  if(l < h) {
    var mid = (l + h) / 2

    msort(arr, helper, l, mid)
    msort(arr, helper, mid+1, h)

    merge(arr, helper,  l, mid, h)
  }

}

def merge(arr: ArrayBuffer[Int], helper: ArrayBuffer[Int], l:Int, m:Int, h: Int): Unit = {
  var low = l
  var mid = m
  var high = h

  for(h <- low to high) {
    helper(h) = arr(h)
  }

  var helperLeft = low
  var helperRight = mid + 1
  var current = low
  while(helperLeft <= mid && helperRight <= high) {
    if(helper(helperLeft) <= helper(helperRight)) {
      arr(current) = helper(helperLeft)
      helperLeft += 1
    } else {
      arr(current) = helper(helperRight)
      helperRight += 1
    }
    current += 1
  }

  var remaining = mid - helperLeft
  while (helperLeft < remaining) {
    helperLeft += 1
    current += 1
    arr(current) = helper(helperLeft)
  }
}

var input: ArrayBuffer[Int] = ArrayBuffer[Int](12,43,54,1)
sort(input)

println(input)