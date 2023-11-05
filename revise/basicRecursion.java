package revise;

import java.util.Locale;
import java.util.Scanner;

public class basicRecursion {

//7. Reverse Integer
//    public static int reverse(int x) {
//        int n = x;
//        int reverse = 0;
//        while(n != 0){
//            int r = n % 10;
//            reverse = reverse * 10 + r;
//            n = n/10;
//        }
//
////        return x>0? reverse : -(reverse);
//        return reverse;
//    }
    // solution will fail as system allow us to store a 64 bit number

    public static int reverse(int x){
        StringBuilder s = new StringBuilder();
        s.append(x);
        s.reverse();
        if (s.length()>= 10){
            int num1 = Integer.parseInt(s.substring(0,5));
            int num2 = Integer.parseInt(s.substring(5,10));
            if (num1 >21474 || num2> 83647 ){
                return 0;
            }
        }
        int num = Integer.parseInt(s.toString());
        return x<0? -num:num;
    }
    // so the logic was to use stringbuidler as they have told that the system
    // cant hold a 64 bit long integer

    // check reverse
    public boolean isPalindrome(int x) {
        int num = x;
        int reverse = 0;
        while(num!=0){
            int count = num%10;
            reverse = reverse*10 + count;
            num /= 10;
        }
        if (reverse == x){
            return x >= 0;
        }
        else{
            return false;
        }

    } // solution accepted

    public static boolean ArmStrong_Num(int n){
        int num = n;
        int sum = 0;
        int power =0;
        while(num!=0){
            num = num/10;
            power++;
        }
        num = n;

        while (num!=0){
            int digit = num%10;
            num=num/10;
            sum += Math.pow(digit,power);
        }
        return sum==n;
    } // this solution is not the most optimised
    // try to find the best solution

    // palindrome using recursiom
    public boolean isPalindrome(String s) {
        String a = s.toLowerCase();
        String newString =helper_isPalindrome(a);
        return isPalindrome(newString,0,newString.length()-1);
    }
    public static boolean isPalindrome(String s,int si, int ei){
        if (si>ei){
            return true;
        }
        if (s.charAt(si)!=s.charAt(ei)){
            return false;
        }

        return isPalindrome(s,si+1,ei-1);
    }

    public static String helper_isPalindrome(String s){
        String newString = "";
        for (int i = 0; i<s.length();i++){
            if (!Character.isLetterOrDigit(s.charAt(i))){

            }else {
                newString += s.charAt(i);
            }
        }
        return newString;
    }

    //509. fibonacci Number
    public static int fib(int n){
        if (n<2){
            return n;
        }
        return (fib(n-1) + fib(n-2));
    }

    public static int fib_dp(int n){
        //
        int[] arr = new int[n+1]; //number starts from 0 so we need one more extra cell
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i< n ; i++){
            arr[n] = arr[n-1]+arr[n-2];
        }
        return arr[n];
    }

    public static int fact(int n){
        if (n == 0|| n == 1){
            return n;
        }
        return n*fact(n-1);
    }

    // check for prime optimised
    public static boolean isPrime(int n){
        for (int i = 2; i <Math.sqrt(n); i++){
            if (n%i==0){
                return false;
            }
        }
        return true;
    }

    //1838 frequency of the most frequent element
//    public int maxFrequency(int[] nums, int k) {
//
//
//    }







    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        Boolean x = ArmStrong_Num(sc.nextInt());
//        System.out.println(x);
        System.out.println(fact(sc.nextInt()));


    }

}
