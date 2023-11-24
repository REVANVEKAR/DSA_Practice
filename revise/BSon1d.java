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


    public static void main(String[] args) {

    }
}
