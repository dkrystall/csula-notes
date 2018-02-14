/**
  * lab
  * Created by davidkrystall on 2/9/18.
  *
  *
  * (c) ontometrics 2015, All Rights Reserved
  */
object MaxSub extends App{
  val summer = new Maximum()
  val listToCheck: List[Int] = List(4,-5,2,7,-5,-4,4,-9,3,-5,2,1)
  println(summer.findBruteMaxSum(listToCheck))
}

class Maximum {
  def findBruteMaxSum(list: List[Int]): Int ={
    var BEST_MAX_SUM = 0
    println("Initial List: "+list.toString)
    var index = 0
    for (e <- list) {
      var max_sum = 0
      if(e > max_sum){
        max_sum = e
      }
      for (f <- list.splitAt(index)._2){
        if(max_sum+f > max_sum){
          max_sum += f
          if(max_sum > BEST_MAX_SUM){
            BEST_MAX_SUM = max_sum
          }
        } else {
          max_sum = 0
        }
      }
      index+=1
    }
    return BEST_MAX_SUM
  }
}

