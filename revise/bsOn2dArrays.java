package revise;

import jdk.management.jfr.FlightRecorderMXBean;

import java.util.Enumeration;

public class bsOn2dArrays {


    //74. Search a 2D Matrix
    public static boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        for (int i = 0; i < n ; i++){
            if (matrix[i][0] <= target && target <= matrix[i][m-1]){
                return binarySearch(matrix[i] , target);
            }
        }
        return false;
    }

    public static boolean binarySearch(int[] arrayFromMatrix, int target){
        int n = arrayFromMatrix.length;
        int low = 0;
        int high = n-1;

        while (low<=high){
            int mid = low + (high - low )/2;
            if (arrayFromMatrix[mid] == target){
                return true;
            }else if (target > arrayFromMatrix[mid]){
                low = mid + 1;
            }else{
                high = mid -1;
            }

        }
        return false;
    } // this was simple as fuckkkkkk but how to actually do it in logn??
    // remember a trick we used in a question while solving arrays ?
    // the modulo operator to stay inside in a rotated array!!

    // optimal approach
    public static boolean searchMatrix2(int[][] matrix, int target){
        int n = matrix.length;
        int m = matrix[0].length;

        int low = 0;
        int high = n * m - 1; // basically we will be flattening the 2d array into
        // 1d array without actually doing so

        while (low<= high){
            int mid = low + (high - low ) / 2;
            int row = mid/m, col = mid % m;
            // the modulo operator !!!!! for ex if there are 4 rows and we are in the
            // second row second column in a 1D array is index 5 right ?
            // when we do 4%5 we get 1 meaning second column hence the modulo operator
            if (matrix[row][col] == target){
                return true;
            }else if (matrix[row][col] < target){
                low = mid + 1;
            }else{
                high= mid -1;
            }

        }

        return false;
    }

    //1283. Find the Smallest Divisor Given a Threshold
//    public int smallestDivisor(int[] nums, int threshold) {
//        int n = nums.length;
//
//        int maxi = Integer.MIN_VALUE;
//
//        for (int i = 0; i < n; i++){
//            maxi = Math.max(maxi, nums[i]);
//        }
//
//        for (int d = 1; d <= maxi ; d++){
//            int sum = 0;
//            for (int i = 0; i < n; i++){
//                sum += Math.ceil((double) (nums[i]) / (double) (d));
//            }
//            if (sum <= threshold){
//                return d;
//            }
//        }
//        return -1;
//    } // brute force

    public int smallestDivisor(int[] nums, int threshold){
        int n = nums.length;

        if (n > threshold){
            return -1;
        }

        int maxi = Integer.MIN_VALUE;

        for (int i = 0 ; i < n ; i++){
            maxi = Math.max(maxi , nums[i]);
        }

        int low = 1, high = maxi;

        while (low <= high){
            int mid = low + ( high - low )/2;
            if (sumByD(nums,mid) <= threshold){
                high = mid -1;
            }else{
                low = mid + 1;
            }
        }

        return low;

    }

    public int sumByD(int[] nums , int div){
        int n = nums.length;
        int sum = 0;

        for (int i = 0; i < n ; i++){
            sum += Math.ceil((double) (nums[i]) / (double) (div));
        }
        return sum;
    }





    public static void main(String[] args) {

        int[] nums = {1,2,5,9};
        int threshold = 6;

        bsOn2dArrays hi = new bsOn2dArrays();
        int ans = hi.smallestDivisor(nums,6);
        System.out.println(ans);
    }
}
