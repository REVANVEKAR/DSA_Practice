package revise;

import java.util.HashMap;
import java.util.Map;

public class strings {

    //    1021. Remove Outermost Parentheses
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int cnt = 0;

        for (char c : s.toCharArray()){
            if (c == '('){
                if (cnt > 0){
                    sb.append(c);
                }
                cnt++;
            }else{
                cnt--;
                if (cnt > 0){
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }
    // ok now the explanation
    // we use a cnt variable to see if theres smthg opened
    // like if its 1 then we know we have an opened bracket which
    // isnt closed . prety cool


    //    151. Reverse Words in a String
    public String reverseWords(String s) {
//        String[] words = s.trim().split(" ");
//
//        StringBuilder sb = new StringBuilder();
//
//        for (int i = words.length - 1 ; i >= 0 ; i--){
//            sb.append(" ").append(words[i]);
//        }
//
//        return sb.toString().substring(1);
        // this should workkk!!!!!
        // but not working
        // ok worked i missed a regex expression \\s+

        int n = s.length();
        String ans = new String();
        int i = 0;
        while (i<n){
            while (i<n && s.charAt(i) == ' '){
                i++;
            }
            if (i >= n){
                break;
            }
            int j = i+1;
            while (j<n && s.charAt(j) != ' '){
                j++;
            }
            String sub = s.substring(i,j);
            if (ans.length()==0){
                ans = sub;
            }else{
                ans = sub + " " + ans;
            }
            i = j;

        }
        return ans;

    } // simple iterative code skip spaces if a character is found
    // start j and then get a substring from i-j then if its the first
    // thing being added then add without space orelse add with space
    // iterate from last and all set


    //1903. Largest Odd Number in String
    public String largestOddNumber(String num) {
        for (int i = num.length() - 1; i >= 0; i--) {
            if (Character.getNumericValue(num.charAt(i)) % 2 == 1) {
                return num.substring(0, i + 1);
            }
        }
        return "";
    }

    //    14. Longest Common Prefix
    public String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];
        for (int i = 1; i< strs.length; i++){
            while (strs[i].indexOf(prefix) != 0){
                prefix = prefix.substring(prefix.length()-1);
            }
        }
        return prefix;
    }

//    205. Isomorphic Strings
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()){
            return false;
        }

        Map<Character,Character> map = new HashMap<>();
        for (int i = 0; i< s.length(); i++){
            char letter1 = s.charAt(i);
            char letter2 = t.charAt(i);
            if (map.containsKey(letter1)){
                if (map.get(letter1) != letter2){
                    return false;
                }
            }else {
                if (map.containsValue(letter2)){ // this line cuz no two characters may
                    // map to the same character
                    return false;
                }
                map.put(letter1, letter2);
            }
        }
        return true;
    }

//    796. Rotate String
    public boolean rotateString(String s, String goal) {
        if(s == null || goal == null) {
            //throw exception on A and B both being null?
            return false;
        }
        if(s.length() != goal.length()) {
            return false;
        }
        if(s.length() == 0) {
            return true;
        }
        for(int i = 0; i < s.length(); i++) {
            if(rotateString(s, goal, i)) {
                return true;
            }
        }
        return false;

    }
    private boolean rotateString(String A, String B, int rotation) {
        for(int i = 0; i < A.length(); i++) {
            if(A.charAt(i) != B.charAt((i+rotation)%B.length())) {
                return false;
            }
        }
        return true;
    }

    //242. Valid Anagram
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()){
            return false;
        }
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i =0; i< s.length(); i++){
            if (map.containsKey(s.charAt(i))){
                map.put(s.charAt(i) , map.get(s.charAt(i)) + 1);
            }else{
                map.put(s.charAt(i), 1);
            }
        }

        for (int i = 0; i< s.length() ; i++){
            if (map.containsKey(t.charAt(i))){
                map.put(t.charAt(i) , map.get(t.charAt(i)) - 1);
            }else{
                return false;
            }
        }
        int sum = 0;
        for (int num : map.values()){
            sum += num;
        }

        return sum <= 0;

    }



    public static void main(String[] args) {

    }


}
