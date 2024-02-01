package revise;

import java.util.HashMap;
import java.util.HashSet;

public class sliding_window {

    //    1004. Max Consecutive Ones III
    public int longestOnes(int[] nums, int k) {
        int start = 0;
        int end = 0;
        int zeroes = 0;

        while (end < nums.length){
            if (nums[end]== 0){
                zeroes++;
            }
            end++;
            if (zeroes>k){
                if (nums[start] == 0){
                    zeroes--;
                }
                start++;
            }
        }
        return end-start;
    }

    //    3. Longest Substring Without Repeating Characters
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int[] charArr = new int[128];
        int max = 0;
        int start = 0;
        for (int end = 0; end < n; end++){
            char current = s.charAt(end);
            start = Math.max(start, charArr[current]);
            max = Math.max(max, end - start + 1);
            charArr[current] = end+1;
        }
        return max;
    } // the old trick !!!! create a array


    public int characterReplacement(String s, int k) {

        int n = s.length();
        int[] arr = new int[26];

        int max = 0;
        int left = 0;
        int res = 0;

        for (int right = 0; right<n ; right++){
            arr[s.charAt(right) -'A']++;

            max = Math.max(max, arr[s.charAt(right) -'A']);

            if (right - left + 1 - max > k){
                arr[s.charAt(left)-'A']--;
                left++;
            }
            res = Math.max(res, right-left+1);
        }
        return res;
    }


    public int numberOfSubarrays(int[] nums, int k) {
        return countKOddWindow(nums, k);
    }

    static int countKOddWindow(int []arr, int k){
        int n = arr.length;
        HashMap<Integer, Integer> mp = new HashMap<>();
        int sum = 0;
        int ans = 0;
        int si = 0;
        for(int cur = 0; cur<n; cur++){
            if(arr[cur] % 2 != 0){
                sum++;
            }
            if(sum == k){
                ans++;
            }
            int req = sum - k;
            if(mp.containsKey(req)){
                ans += mp.get(req);
            }
            mp.put(sum, mp.getOrDefault(sum, 0)+1);
        }
        return ans;
    }


    public static void main(String[] args) {
        sliding_window obj = new sliding_window();
        int s = obj.characterReplacement("AABABBA",1);
        System.out.println(s);
    }
}
