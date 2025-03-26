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

//    public int maxScore(int[] cardPoints, int k) {
//
//    }

    public int numberOfSubstrings(String s) {
        if(s.length()>3){
            if (s.length()==3 && s.contains("a") && s.contains("b") && s.contains("c")){
                return 1;
            }
            return 0;
        }

        int start = 0;
        int end = 2;
        int count = 0;
        while (end<s.length()){
            String temp = s.substring(start+end+1);
            while (start<=end && end-start>=3-1 && temp.contains("a") && temp.contains("b") && temp.contains("c")){
                count += 1+s.length()-(end+1);
                start++;
                temp = s.substring(start,end+1);
            }
            end++;
        }
        return count;
    }

//    public int numberOfSubstrings(String s) {
//        char[] c = s.toCharArray();
//        int[] map = new int[3];
//        int k = 0;
//        int count = 0;
//        int left = 0;
//        for(int i = 0; i < c.length; i++){
//            map[c[i] - 'a']++;
//            if(map[c[i] - 'a'] == 1){
//                k++;
//            }
//            while(k == 3){
//                map[c[left] - 'a']--;
//                if(map[c[left]-'a'] == 0){
//                    k--;
//                }
//                left++;
//            }
//            count += left;
//        }
//        return count;
//    }
    //a solution to the a b c problem that I could never think of :(


//    public int numberOfSubstrings(String s) {
//        return helper(s, 3) - helper(s, 2);
//    }
//
//    int helper(String s, int limit) {
//        int N = s.length();
//        Map<Character, Integer> map = new HashMap<>();
//
//        int count = 0;
//        int l = 0;
//        for (int r = 0; r < N; r++) {
//            char c = s.charAt(r);
//            map.put(c, r);
//
//            while (l <= r && map.size() > limit) {
//                char lc = s.charAt(l);
//
//                if (map.get(lc) == l) {
//                    map.remove(lc);
//                }
//
//                l++;
//            }
//
//            count += r - l + 1;
//        }
//
//        return count;
//    }

    // a solution i should have thought of

    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;;

        int leftSum = 0;

        for (int i = 0 ; i < k ; i++){
            leftSum += cardPoints[i];
        }

        int max = leftSum;
        int rightSum = 0;

        for (int i = 0; i< k; i++){
            leftSum -= cardPoints[k - 1 - i];
            rightSum += cardPoints[n - 1 - i];
            max = Math.max(max, leftSum+rightSum);
        }

        return max;

    }

//    public int numSubarrayProductLessThanK(int[] nums, int k) {
//
//    }



    public static void main(String[] args) {
        sliding_window obj = new sliding_window();
        int s = obj.characterReplacement("AABABBA",1);
        System.out.println(s);
    }
}
