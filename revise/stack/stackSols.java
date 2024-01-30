package revise.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.PropertyResourceBundle;
import java.util.Stack;

public class stackSols {

    public boolean isValid(String s) {

//        char fb = '\0';
//        if(s.length()>0){
//            fb = s.charAt(0);
//        }
//        if(fb == ')' || fb == '}' || fb == ']'){
//            return false;
//        }
//        Stack<Character> b = new Stack<>();
//        int n = s.length();
//        for (int i = 0; i < n ; i++){
//            char pushChar = s.charAt(i);
//            if (pushChar == '(' || pushChar == '{' || pushChar == '['){
//                b.push(pushChar);
//                continue;
//            }else if(b.isEmpty()){
//                return false;
//            }else if (pushChar == ')' || pushChar == '}' || pushChar == ']'){
//                char popChar = b.pop();
//                switch (pushChar){
//                    case ')': if (popChar == '('){
//                        continue;
//                    }else {
//                        return false;
//                    }
//                    case '}': if (popChar == '{'){
//                        continue;
//                    }else {
//                        return false;
//                    }
//                    case ']': if (popChar == '['){
//                        continue;
//                    }else {
//                        return false;
//                    }
//                }
//            }
//
//        }
//        return b.isEmpty(); // works da

        Stack<Character> st=new Stack<Character>();
        for(int i=0;i<s.length();i++){

            if(s.charAt(i)=='(' || s.charAt(i)=='{' || s.charAt(i)=='['){
                st.push(s.charAt(i));
            }
            else if(st.empty()){
                return false;
            }
            // Check for the close brackets pair on the top and pop them
            else if (st.peek() == '{' && s.charAt(i) == '}' ) {
                st.pop();
            } else if (st.peek() == '(' && s.charAt(i) == ')' ) {
                st.pop();
            } else if (st.peek() == '[' && s.charAt(i) == ']' ) {
                st.pop();
            }else{
                return false;
            }
        }
        return st.isEmpty(); //better clean code
    }

//    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
//
//    }

    public int[] asteroidCollision(int[] asteroids) {
//        Stack<Integer> st = new Stack<>();
//
//        for (int val : asteroids){
//            if (st.isEmpty() || val>0){
//                st.push(val);
//            }
//            else {
//                while (true){
//                    int peek = st.peek();
//                    if (peek<0){
//                        st.push(val);
//                        break;
//                    }else if (peek == -val){
//                        st.pop();
//                        break;
//                    }else if (peek > -val){
//                        break;
//                    }else{
//                        st.pop();
//                        if (st.isEmpty()){
//                            st.push(val);
//                            break;
//                        }
//                    }
//                }
//            }
//        }
//        int i = st.size();
//        int ans[] = new int[i];
//        while(!st.isEmpty()) {
//            if(i > 0)
//                ans[i-1] = st.pop();
//            i--;
//        }
//        return ans;

        Stack<Integer> st = new Stack<>();
        for(int val : asteroids){
            if(st.isEmpty() || val > 0){
                st.push(val);
            }else{
                while(!st.isEmpty() && st.peek() > 0 &&  Math.abs(st.peek()) < Math.abs(val)){
                    st.pop();
                }
                if(!st.isEmpty() &&  (-st.peek() == val || st.peek() == -val)) {
                    st.pop();
                }
                else if(st.isEmpty() || (!st.isEmpty() && st.peek() < 0 && val < 0)) {
                    st.push(val);
                }
            }
        }
        int[] res = new int[st.size()];
        int j = st.size() -1;
        while(!st.isEmpty()){
            res[j--] = st.pop();
        }
        return res;
    }

//    1004. Max Consecutive Ones III
    public int longestOnes(int[] nums, int k) {

        int n = nums.length;

        int i = 0;
        int j = 1;

        while (j < n){

        }

    }


    public static void main(String[] args) {
        stackSols os = new stackSols();
        System.out.println(os.isValid("{}()"));
    }

}
