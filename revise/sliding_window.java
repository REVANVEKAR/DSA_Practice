package revise;

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
    }


    public static void main(String[] args) {

    }
}
