package revise;

import java.util.HashMap;
import java.util.Map;

public class arrays {

    public static int missingNumber(int[] nums) {
        int sum  = 0;

        for(int i = 0; i< nums.length ; i++){
            sum += nums[i];
        }
        System.out.println(sum);

        int totalSum = ((nums.length)*(nums.length + 1))/2;
        System.out.println(totalSum);

        return totalSum-sum;

    }

    public void moveZeroes(int[] nums) {
        int i = 0;

        for(int num : nums){
            if (num!=0){
                nums[i] = num;
                i++;
            }
        }
        // very creative solution just keep a count of how many zeroes
        // we encountered and just replace zeroes with nums one by one
        // while increasing the count then in the next while loop
        // we just replace the remaining elements with zero till the counter
        // reaches the last index of the array
        while(i <= nums.length-1){
            nums[i] = 0;
            i++;
        }
    }

    public void rotate(int[] nums, int k) {
//        int n = nums.length;
//        if (n==k || k==0 ){
//            return;
//        }
//        for (int i = 0; i< k ; i++){
//            int last = nums[n-1];
//            for (int j = n-2 ; j >= 0 ; j--){
//                nums[j+1] = nums[j];
//            }
//            nums[0] = last;
//        } // TLE
        // so what we are doing here is storing the last element in a varaible
        // and then rotating the array 1 element at a time k times and then
        // using the stored variable to make the first element as the initial last
        // element

        int n = nums.length;

        if(n==k || k==0){
            return ;
        }

        int[] nums2 = new int[n];
        int i = 0;
        for(int a : nums){
            nums2[i++] = a;
        }

        for(i = 0; i< n ; i++){
            nums[(i+k)%n] = nums2[i]; // this line is very important
            // (i+k)%n returns the index of the number in rotated state
            // so this is the most efficient way of rotating an array
        }

    }

    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int max = 0;
        for (int i = 0; i< nums.length ; i++){
            if (nums[i]== 1){
                count++;
            }else{
                max = Math.max(count,max);
                count = 0;
            }
        }
        max = Math.max(count,max);
        return max;

    }


//    public int singleNumber(int[] nums) {
//        HashMap<Integer,Integer> map = new HashMap<>();
//        for (int i = 0; i< nums.length ; i++){
//            if (!map.containsKey(nums[i])){
//                map.put(nums[i] ,1);
//            }else {
//                map.put(nums[i], map.get(nums[i])+1);
//            }
//        }
//        int ans = 0;
//        for (Map.Entry<Integer, Integer> x : map.entrySet()){
//            if (x.getValue() == 1){
//                ans = x.getKey();
//            }
//        }
//        return ans;
//    } // solution accepted but runtime is slow

    public int singleNumber(int[] nums){

        int ans = 0;
        for (int i =0 ; i< nums.length ; i++){
            ans ^= nums[i];
        }
        return ans;

    }// yesterdays bitwise logic xor of same number is 0
    // + also the order doesnt matter so we can use xor operation
    // great solution

    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j = 1; j< nums.length ; j++){
            if (nums[i] != nums[j]){
                i++;
                nums[i] = nums[j];
            }
        }
        return i+1;
    }

    public boolean check(int[] nums) {

        int count = 0;
        for (int i =0; i<nums.length; i++){
            if (nums[i] > nums[(i+1) %nums.length] ){
                count++;
            }
        }
        if (count>1){
            return false;
        }

        return true;
        // explanation
        // so what we are doing here is iterating through the array and
        // checking for the number of rotations
        // using the same logic we used yesterday for rotating array
        // here we are using i+1%length because that will make the comparisons work
        // in a circular way

        // and if there are more than one rotation in the array ( count >1 )
        // then we can confidently say that the array isnt sorted

    }


    public static void main(String[] args) {

//        int[] a  = {1,0,2,3};
//        int n = missingNumber(a);
        System.out.println(4%7);
    }
}
