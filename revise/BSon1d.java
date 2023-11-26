package revise;

public class BSon1d {

//    35. Search Insert Position
    public int searchInsert(int[] nums, int target) {
        int si = 0;
        int ei = nums.length-1;
        while (si<=ei){ // made a small mistake here
            int mid = si + (ei-si)/2;
            if (target == nums[mid]){
                return mid;
            }
            else if (target<nums[mid]){
                ei = mid-1; // here too
            }else{
                si = mid+1; // and here silly ones ( ok maybe cuz I'm sleepy )
            }
        }
        return si; // ok basic but still the logic here is if mid isnt found
        // it comes out of while loop without exiting at return mid line
        // then we just return the start index where it will be inserted after exiting
        // the loop
    }


//    34. Find First and Last Position of Element in Sorted Array

    // ok the approach is think of it as two pointers find first and last occurences using
    // two binary search instead of a two pointer/for loop
    // in this we use first BS to keep looking left after finding the first
    // occurrence of target and more to keep looking right after finding the first
    // occurrence of target

    public int[] searchRange(int[] nums, int target) {
        int ans[] = {-1, -1};
        ans[0] = first(nums, target);
        ans[1] = last(nums, target);
        return ans;
    }

    private int first(int[] arr, int x) {
        int lo = 0, hi = arr.length - 1;
        int ans = -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] >= x) {
                if (arr[mid] == x)
                    ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return ans;
    }

    private int last(int[] arr, int x) {
        int lo = 0, hi = arr.length - 1;
        int ans = -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] <= x) {
                if (arr[mid] == x)
                    ans = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return ans;
    }

    public int singleNonDuplicate(int[] nums) {
        int si =0, ei = nums.length-1;

        while (si<ei){
            int mid = si + (ei-si)/2;
            if (mid%2==1){ // this case if mid falls in odd index we know that the pair
                // the single element
                mid--; // this because we know numbers should ideally make even-odd index pairs
                // and if its in odd index we know it must be in the right side of mid
                // therefore mid-- and then compare with mid+1
            }
            if (nums[mid] != nums[mid+1]){
                ei = mid; // straightforward
            }else{
                si= mid + 2; // why do mid + 1 when we know its a pair
                // and if si == ei after this we exit the while loop and return this
            }
        }
        return nums[si];
    }

//    153. Find Minimum in Rotated Sorted Array
    public int findMin(int[] nums) {
        int si = 0, ei= nums.length-1;
        while (si<ei){
            int mid = si + (ei-si)/2;
            if (nums[mid]<nums[ei]){ // ok I gotta admit this was a cool solution
                // this comparison is saying when the array is sorted and rotated
                // if ei is lesser than the middle index value how in the world will
                // the subarray from mid to left have the smallest number ( like mid itself is bigger
                // and the array is sorted and rotated ) therefore move ei
                ei = mid;
            }else{
                si = mid + 1; // this is again classic in BinSea
            }
        }
        return nums[si]; // just return start after exiting
    }

    public int findPeakElement(int[] nums) {

        int n = nums.length;

        if (n == 1)return 0;
        // if only one element just return that as the peak element
        if (nums[0] > nums[1])return 0; // first element is peak
        if (nums[n-1]>nums[n-2])return n-1; // last element is peak

        int si=1,ei= nums.length-2; // corner cases irsliye karte he kyunki out of bounds
        // jayega 0 - n-1 kiya toh


        while (si<=ei){
            int mid = si + (ei-si)/2;
            if (nums[mid-1] < nums[mid] && nums[mid] > nums[mid+1] ){
                return mid; // increasing and strictly decreasing therefore answer
            }
            if (nums[mid] > nums[mid-1]){
                si = mid + 1; // the approach is if mid > mid -1 then we should
                // search in the right part
            }else {
                ei = mid -1;// else look for in the left side
            }
        }
        return -1; // karna padta he saheb
    }


    public static void main(String[] args) {

    }
}
