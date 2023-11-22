package revise;

import javax.print.DocFlavor;
import java.util.*;

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

    //121
    public int maxProfit(int[] prices){
        int minbuy = prices[0];
        int maxProf = 0;
        for (int price : prices){
            minbuy = Math.min(minbuy, price);
            // keep updating min buy
            maxProf = Math.max(maxProf,price-minbuy );
            // update maxProf too by comparing and updating the max of the
            // current max and current price - the minbuy amount
        }
        return maxProf;
    }

    public void sortColors(int[] nums) {
//        int count0 = 0;
//        int count1 = 0;
//        int count2 = 0;
//        for (int i = 0; i< nums.length ; i++){
//            if (nums[i] == 0){
//                count0++;
//            }else if (nums[i]==1){
//                count1++;
//            }else{
//                count2++;
//            }
//        }
//        int index = 0;
//        while (count0!= 0){
//            nums[index] = 0 ;
//            count0--;
//            index++;
//        }
//        while (count1!= 0){
//            nums[index] = 1 ;
//            count1--;
//            index++;
//        }
//        while (count2!= 0){
//            nums[index] = 2 ;
//            count2--;
//            index++;
//        } // accepted but not the most efficient code


        // googled and found out about the dutch national flag algo
        // revise !!!!1

    }

    public int maxSubArray(int[] nums) {
//        int max = Integer.MIN_VALUE;
//
//        for (int i = 0; i< nums.length ; i++){
//            int sum = 0;
//            for (int j = i ; j < nums.length ; j++){
//                sum += nums[j];
//                max = Math.max(sum,max);
//            }
//        }
//        return max; // correct solution but TLE
        int sum = 0;
        int maxi = nums[0];
        for (int i = 0; i <nums.length ; i++) {
            sum = sum + nums[i];
            maxi = Math.max(maxi,sum);
            if (sum <0 ){
                sum = 0;
            }
        }
        return maxi; // kadane's algo fuckkkkk I could've solved this
    }

    public int[] rearrangeArray(int[] nums) {
//        int[] nums2 = new int[nums.length];
//
//        int index = 0;
//        for (int i = 0; i< nums.length ; i++){
//            if (nums[i]>=0){
//                nums2[index] = nums[i];
//                index++;
//            }
//        }
//        for (int i = 0; i<nums.length ; i++){
//            if (nums[i]<0){
//                nums2[index] = nums[i];
//                index++;
//            }
//        }
//        int positive = 0;
//        int negative = nums.length/2;
//        for (int i = 0; i< nums.length ; i++){
//            if (i%2==0){
//                nums[i] = nums2[positive];
//                positive++;
//            }else{
//                nums[i] = nums2[negative];
//                negative++;
//            }
//        }
//        return nums; // Im so dumbbbbb I couldve done the second part directly
        // iterating through the array twice + even if i didnt optimise I could have
        // just done all that in one array
        // lets optimize
        int[] res = new int[nums.length];
        int pos = 0;
        int neg = 1;

        for (int num : nums){
            if (num > 0 ){
                res[pos] = num;
                pos += 2;
            }else{
                res[neg] = num;
                neg += 2;
            }
        }
        return res;

    }

    public void setZeroes(int[][] matrix) {
//        int[] row = new int[matrix.length];
//        int[] col = new int[matrix[0].length];
//
//        for (int i =0 ; i<matrix.length;i++){
//            for (int j = 0; j< matrix.length ; j++){
//                if (matrix[i][j] == 0){
//                    row[i] = 1;
//                    col[j] = 1;
//                }
//            }
//        }
//        for (int i =0 ; i<matrix.length; i++){
//            for (int j =0 ; j<matrix[0].length; j++){
//                if (row[i]==1 || col[j] == 1){
//                    matrix[i][j] = 0;
//                }
//            }
//        }// not the most ideal solution lets see the one with o(1) space
    }

    public int longestConsecutive(int[] nums) {

        if (nums.length == 0){
            return 0;
        }

        int longest = 1;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i< nums.length ; i++){
            set.add(nums[i]);
        }

        for (int no : set){
            if (!set.contains(no-1)){ // to check if no is the starting point of
                // the sequence
                int count = 1;
                int x = no; // we need to collect x as we further need it to
                // use it in a while loop
                while (set.contains(x+1)){
                    count++;
                    x += 1;
                }
                longest = Math.max(count,longest);
            }
        }

        return longest;
    }


    public void nextPermutation(int[] nums) {

        int index1 = -1; //{2,1,5,4,3,0,0} reference
        int index2 = -1;

        for (int i = nums.length-2;i>=0 ; i--) {
            if (nums[i] < nums[i + 1]) {
                index1 = i;
                break;
            }
        }

        if (index1==-1){
            reverse(nums , 0);
        }
        else{
            for (int i = nums.length-1; i>=0 ; i--){
                if (nums[i] > nums[index1]){
                    index2 = i;
                    break;
                }
            }

            swap(nums,index1,index2);
            reverse(nums,index1+1);
        }



    }

    void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    void reverse(int[] nums,int start){
        int i=start;
        int j=nums.length-1;
        while(i<j){
            swap(nums,i,j);
            i++;
            j--;
        }
    }

    //48 rotate image
//    public void rotate(int[][] matrix) {
//        int k =0;
//        int[] arr = new int[matrix.length * matrix[0].length];
//
//
//        for (int i = 0; i < matrix.length ; i++){
//            for (int j = 0; j< matrix[0].length ; j++){
//                arr[k] = matrix[i][j];
//                k++;
//            }
//        }
//        k=0;
//        for (int j = matrix[0].length-1; j>=0 ; j--){
//            for (int i = 0; i < matrix.length ; i++){
//                matrix[i][j] = arr[k];
//                k++;
//            }
//        }// ok so a better approach is to find the transpose of the matrix
//        // and then swap the columns . ( yep should revise math again ;( )
//    }

    // 48 rotate matrix alternate approach
    public void rotate(int[][] matrix){
        for (int i = 0 ; i < matrix.length ; i++){
            for (int j = i; j < matrix[0].length ; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }// found transpose
        // now switching the columns

        for (int i = 0; i< matrix.length ; i++){
            int start = 0;
            int end = matrix[i].length-1;
            while (end>start){
                matrix[i][start] = matrix[i][start] + matrix[i][end];
                // image the row is 1, 2, 3
                // so this line will make it 4, 2, 3
                matrix[i][end] =  matrix[i][start] - matrix[i][end];
                // this line will make it 4, 2, (4-3) == 4, 2, 1
                matrix[i][start] = matrix[i][start] - matrix[i][end];
                // this line will make it 3, 2, 1
                start++;
                end--;
            }
        }
    }

    // 54 spiral matrix
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        // right intuition right code but could have optimised/wrote the code better
        int n = matrix.length;
        int m = matrix[0].length;

        int rmin = 0;
        int cmin = 0;
        int rmax = n-1;
        int cmax = m-1;
        int counter = 1;

        while(counter<=n*m){ // geez what a good base case when
            // we create a simulation to walk in spiral the counter should not exceed
            // max number of nodes

            // top boundary
            for (int col = cmin ; col<=cmax && counter<= n*m ; col++){
                list.add(matrix[rmin][col]);
                counter++;
            }
            rmin++;

            // right boundary
            for (int row = rmin; row <= rmax && counter<=n*m; row++){
                list.add(matrix[row][cmax]);
                counter++;
            }
            cmax--;

            //bottom boundary
            for(int col = cmax;col>=cmin && counter<=n*m;col--){
                list.add(matrix[rmax][col]);
                counter++;
            }
            rmax--;


            //left boundary
            for(int row = rmax;row>=rmin && counter<=n*m;row--){
                list.add(matrix[row][cmin]);
                counter++;
            }
            cmin++;

        }


        return list;
    }

    //560 subarray sum equals K
    public int subarraySum(int[] nums, int k) {
//        int count = 0;
//
//        for (int i =0; i< nums.length ; i++){
//            int sum = 0;
//            for (int j = i ; j< nums.length ; j++){
//                sum += nums[j];
//                if (sum == k){
//                    count++;
//                }
//            }
//        }
//        return count;
//         will work but worst solution
//         fucking o(n^2) TC
//
//         optimal approach
        int n = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        int prefSum = 0, count = 0;

        map.put(0,1);
        for (int i = 0; i<n ; i++){
            prefSum += nums[i];

            int remove = prefSum - k;
            // use getOrDefault to get either the value of the key or
            // the default value
            count += map.getOrDefault(remove,0);

            map.put(prefSum, map.getOrDefault(prefSum,0)+1);
            // ok this line is important
            // so what we are doing is updating the prefix sum ka map if its already present then get its
            // present value or use getOrDefault function to get 0 then add 1 to it


        }
        return count;

    }

//    118. pascal's triangle
    public List<List<Integer>> generate(int numRoms){
        List<List<Integer>> list = new ArrayList<>();

        // for handling row 1 which is 0c0 = 1
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list.add(list1);
        if (numRoms == 1){
            return list;
        }

        for (int i = 1; i< numRoms ; i++){
            List<Integer> temp = new ArrayList<>();

            temp.add(1);
            for (int j = 1 ; j < i ; j++){
                temp.add(list.get(i-1).get(j-1) + list.get(i-1).get(j));
            }

            temp.add(1);
            list.add(temp);
        }
        return list;
    }

    public List<Integer> majorityElement(int[] nums) {
//        int n = nums.length;
//        List<Integer> list = new ArrayList<>();
//        HashMap<Integer,Integer> map = new HashMap<>();
//
//        for (int i = 0; i < nums.length; i++ ){
//            if (!map.containsKey(nums[i])){
//                map.put(nums[i] , 1);
//            }else{
//                map.put(nums[i], map.get(nums[i])+1);
//            }
//        }
//
//        for (int value : map.keySet()){
//            if (map.get(value) > n/3){
//                list.add(value);
//            }
//        }
//        return list;
        // good approach but not optimal
        // use boyers voting algo

        int n = nums.length;

        int el1 = Integer.MIN_VALUE;
        int el2 = Integer.MIN_VALUE;

        int count1 = 0, count2 = 0;

        for (int i = 0; i< n ; i++){
            if (count1 == 0 && nums[i] != el2){
                count1++;
                el1 = nums[i];
            }
            else if (count2 == 0 && nums[i] != el1){
                count2++;
                el2 = nums[i];
            }
            else if (nums[i] == el1){
                count1++;
            }
            else if (nums[i] == el2){
                count2++;
            }
            else{
                count1--;
                count2--;
            }
        }

        List<Integer> list = new ArrayList<>();

        count1 = 0; count2 = 0;

        for (int i = 0; i < n; i++){
            if (nums[i] == el1){
                count1++;
            }
            if (nums[i] == el2){
                count2++;
            }
        }

        int mini = (int)(n/3) + 1;
        if (count1 >= mini){
            list.add(el1);
        }
        if (count2 >= mini){
            list.add(el2);
        }

        return list;
    }

    //15 3sum
    public List<List<Integer>> threeSum(int[] nums){
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        for(int i=0;i<nums.length-2;i++){
            if(i==0 || (i>0 && nums[i]!=nums[i-1])){
                int lo=i+1,hi=nums.length-1,sum=0-nums[i];
                while(lo<hi){
                    if(nums[lo]+nums[hi] == sum){
                        res.add(Arrays.asList(nums[i],nums[lo],nums[hi]));
                        while(lo<hi && nums[lo]==nums[lo+1])  lo++;
                        while(lo<hi && nums[hi] == nums[hi-1]) hi--;
                        lo++;
                        hi--;
                    }
                    else if(nums[lo]+nums[hi]<sum){ lo++; }
                    else{ hi--; }
                }
            }
        }
        return res;
    }


    // 18 4sum
//    public List<List<Integer>> fourSum(int[] nums, int target){
//
//    }


    public static void main(String[] args) {

//        int[] a  = {1,0,2,3};
//        int n = missingNumber(a);
//        System.out.println(4%7);



    }
}
