package revise;

public class bitOperators {

    public static void main(String[] args) {

    }

    public static boolean powerOfTwo(int n){
        return n > 0 && (n & (n-1)) == 0; // basically calling the and operator
        // like only one bit will have 1 and rest will be 0's and n-1 will be opposite
        // per se. therefore if its a power of two then the & of n and n-1 should be 0
        // and power of any number cant be 0 or negative hence the check
    }



}
