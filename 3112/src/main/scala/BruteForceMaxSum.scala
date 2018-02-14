class BruteForceMaxSum {
    def findBruteMaxSum(list: List[Int]): Int ={
        var BEST_MAX_SUM = 0
				print("Initial Array:"+list.toString)
				for (e <- list) {
          var max_sum = 0
						for (f <- list){
								if(e+f > max_sum){
										max_sum = e+f
										if(max_sum > BEST_MAX_SUM){
											BEST_MAX_SUM = max_sum
										}
								}
						}
				}
      return BEST_MAX_SUM
		}
}
object BruteRunner extends App{
  val summer = new BruteForceMaxSum()
  val listToCheck: List[Int] = List(4,-5,2,7,-5,-4,4,-9,3,-5,2,1)
  summer.findBruteMaxSum(listToCheck)
}