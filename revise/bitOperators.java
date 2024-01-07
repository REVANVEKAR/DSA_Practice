package revise;

import java.util.ArrayList;
import java.util.List;

public class bitOperators {

    public static void main(String[] args) {

    }

    public static boolean powerOfTwo(int n){
        return n > 0 && (n & (n-1)) == 0; // basically calling the and operator
        // like only one bit will have 1 and rest will be 0's and n-1 will be opposite
        // per se. therefore if its a power of two then the & of n and n-1 should be 0
        // and power of any number cant be 0 or negative hence the check
    }


    public List<List<Integer>> subsets(int[] nums) {

        // so the idea is to check for all 2^n-1 types
        // for ex if given nums are 1 2 3 then we will have 8 different subsets
        // "" 1 2 3 12 13 23 123 respectively
        // we use and operator with i and
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;

        for (int i = 0; i < Math.pow(2,n) ;i++){
            List<Integer> subset = new ArrayList();
            for (int j = 0; j< n ; j++){
                if ((i & (1<<j))!=0){
                    subset.add(nums[j]);
                }
            }
            ans.add(subset);
        }
        return ans;
    }


}
