
/**
 * maxSubArray
 * Created by davidkrystall on 2/12/18.
 */
public class Lab03_davidkrystall {
    public static void main(String[]args){
        int[] input = {3, 4,-7, 10, -11, 4, -5, 9, 11, 12, -13, 14, 2};
        int length = input.length;
        System.out.println(brute(input));
        System.out.println("The max sum with divide and conq is: "+divide(input, 0, length-1)+". and took "+RecurseCounter.counter+" cycles.");
    }
    public static void add(){
        int x = 5;
        float y = 3.5;
        System.out.println(x+y);
    }

    private static String brute(int[] nums){
        int max = 0, start = 0, end = 0, counter = 0;
        System.out.println("size of array:"+nums.length);
        for(int i = 0; i <= nums.length; i++){
            int currentSum = 0;
            for ( int j = i; j < nums.length; j++ ) {
                currentSum+= nums[j];

                if ( currentSum > max ) {
                    max = currentSum;
                    start = i;
                    end = j;
                }
                counter++;
            }
            counter++;
        }
        return "Bruteforce Max subarray for ["+printArray(nums)+"] is: "+max+". and took "+counter+" cycles.";
    }
    private static int crossSum(int[] nums, int left, int mid, int right){
        int sum = 0, leftSum =0;
        for(int i = mid; i >= left; i--){
            sum = sum + nums[i];
            if(sum>leftSum) leftSum = sum;
        }
        int rightSum = 0; sum = 0;
        for(int i = mid+1; i <= right; i++){
            sum = sum+nums[i];
            if(sum > rightSum) rightSum = sum;
        }
        RecurseCounter.counter += 1;
        return leftSum + rightSum;
    }

    private static int divide(int[] nums, int left, int right) {
        RecurseCounter.counter += 1;
        if(left == right) {return nums[1];}
        int mid = (left+right)/2;
        return Integer.max(Integer.max(divide(nums, left, mid), divide(nums, mid+1, right)),crossSum(nums, left, mid, right));



    }

    private static String printArray(int[] nums){
        StringBuilder builder = new StringBuilder();
        for (Integer num: nums){
            if(num.equals(nums[nums.length-1])) {
                builder.append(num);
            } else {
                builder.append(num + ", ");
            }
        }
        return builder.toString();
    }
}
class RecurseCounter {
    public static int counter = 0;
}

