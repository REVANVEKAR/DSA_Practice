package revise.stack;

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




    public static void main(String[] args) {
        stackSols os = new stackSols();
        System.out.println(os.isValid("{}()"));
    }

}
