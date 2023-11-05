package revise;

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





    public static void main(String[] args) {

//        int[] a  = {1,0,2,3};
//        int n = missingNumber(a);
        System.out.println(4%7);
    }
}
