package revise;

public class patterns {

    public static void pattern_1(int n ){
        int i , j;
        for (i = 0; i< n ; i++){
            for (j = 0; j<n ; j++){
                System.out.print("*");
            }
            System.out.println("");
        }
    }

    public static void pattern_2(int n){
        int i ,j ;
        for (i = 0; i < n;i++){
            for (j = 0; j<=i;j++){
                System.out.print("*");
            }
            System.out.println("");
        }
    }
    public static void pattern_3(int n){
        int i ,j ;

        for (i = 0; i < n;i++){
            int noToBePrinted = 0 ;
            for (j = 0; j<=i;j++){
                noToBePrinted += 1;
                System.out.print(noToBePrinted);
            }
            System.out.println("");
        }
    }

    public static void pattern_4(int n){
        int i ,j ;
        int noToBePrinted = 0 ;
        for (i = 0; i < n;i++){
            noToBePrinted += 1;
            for (j = 0; j<=i;j++){
                System.out.print(noToBePrinted);
            }
            System.out.println("");
        }
    }

    public static void pattern_5(int n ){
        int i , j;
        for (i = 0; i< n ; i++){
            for (j = n; j>i ; j--){
                System.out.print("*");
            }
            System.out.println("");
        }
    }


    static void printTriangle(int n) {
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n-i; j++){
                System.out.print(" ");
            }
            for(int j=1; j<=2*i-1; j++){
                System.out.print("*");
            }
                System.out.println();
        }
    }

    static void printTriangleInverse(int n){
        for (int i = 1 ; i<=n ; i++ ){
            for (int j = 0 ; j < i ; j++){
                System.out.print(" ");
            }
            for (int j = 0 ; j<2*n-(2*i+1) ; j++){
                System.out.print("*");
            }
            for (int j = 0 ; j < i ; j++){
                System.out.print(" ");
            }

            System.out.println();
        }
    }

    static void pattern_10(int n){
        for (int i = 1; i<=2*n-1 ; i++){
            int stars = i;
            if (i>n){
                stars = 2*n - i;
            }
            for (int j = 1; j<=stars ; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void pattern_11(int n){
        int start = 1;
        for (int i = 0; i <= n ; i++){
            if (i%2 == 0){
                start = 0;
            }else{
                start = 1;
            }
            for (int j = 0; j <i ; j++){
                System.out.print(start);
                start = 1 -start;
            }
            System.out.println();
        }
    }

    static void pattern_12(int n){

        for (int i = 0; i< n ; i++){
            int start = 0;
            for (int j= 0; j<=i ; j++){
                start += 1;
                System.out.print(start);

            }
            for (int j = 0; j< 2*n - (2*(i+1)); j++){
                System.out.print(" ");
            }
            for (int j= 0; j<=i ; j++){
                System.out.print(start);
                start -= 1;
            }
            System.out.println();
        }
    }

    public static void pattern_13(int n){
        int start = 1;
        for(int i = 0; i< n ; i++){
            for (int j = 0; j <=i ; j++){
                System.out.print(start);
                start += 1;
            }
            System.out.println();
        }
    }

    public static void pattern_14(int n) {

        for (int i = 0; i< n ; i++){

            for (char ch = 'A'; ch <= 'A' + i ; ch++){
                System.out.print(ch);
            }
            System.out.println();
        }
    }

    public static void pattern_15(int n ){
        for (int i = 0; i< n ; i++){

            for (char ch = 'A'; ch <= 'A'+ (n-i-1) ; ch++){
                System.out.print(ch);
            }
            System.out.println();
        }
    }

    public static void pattern_16(int n){
        for (int i = 0 ; i< n ; i++){
            int a = 'A' + i;
            for (int j = 0 ; j<=i ; j++){
                char ch =(char) a;
                System.out.print(ch);
            }
            System.out.println();
        }
    }

    public static void pattern_17(int n){
        for (int i = 0 ; i< n ; i++){
            for (int j = 0 ; j< n - i -1; j++) {
                System.out.print(" ");
            }
            char ch = 'A';
            int breakpoint = (2*i + 1)/2;
            for (int j = 1 ; j <= 2*i + 1 ; j++){
                System.out.print(ch);
                if (j <= breakpoint ){
                    ch++;
                }else{
                    ch--;
                }
            }
            System.out.println();
        }
    }

//    public static void pattern_18(int n){
//        for (int i = 0; i< n ; i++){
//            for (int j = 0 ; j<= i ; j++){
//
//            }
//        }
//    }

    public static void pattern_19(int n){

        // upside
        int inis = 0;
        for (int i = 0; i< n ; i++){
            for (int j= 1; j<=n-i;j++){
                System.out.print("*");
            }

            for (int j = 0 ; j< inis; j++){
                System.out.print(" ");
            }
            for (int j= 1; j<=n-i;j++){
                System.out.print("*");
            }
            inis += 2;
            System.out.println();
        }

        inis = 2*n-2;
        for (int i = 1; i<= n ; i++){
            for (int j= 1; j<=i;j++){
                System.out.print("*");
            }

            for (int j = 0 ; j< inis; j++){
                System.out.print(" ");
            }
            for (int j= 1; j<=i;j++){
                System.out.print("*");
            }
            inis -= 2;
            System.out.println();
        }
    }

    public static void pattern_20(int n){
        int spaces = 2*n -2;
        for (int i = 1; i<=2*n-1 ; i++){
//            stars
            int stars = i;

            if (i>n){
                stars = 2*n -i;
            }
            for (int j = 1; j<=stars;j++){
                System.out.print("*");
            }
//            spaces
            for (int j = 1; j<=spaces; j++){
                System.out.print(" ");
            }
            for (int j = 1; j<=stars;j++){
                System.out.print("*");
            }
            System.out.println();
            if (i<n){
                spaces -= 2;
            }else{
                spaces += 2;
            }
        }
    }

    public static void pattern_21(int n){
        for (int i = 0; i< n;i++){
            for (int j = 0; j< n ; j++){
                if (i == 0 || j==0 || i == n-1 || j == n-1 ){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }

            }
            System.out.println();
        }
    }

    public static void pattern_22(int n){
        for (int i = 0; i < 2*n -1 ; i++){
            for (int j = 0; j<2*n -1 ; j++){
                int top = i;
                int left = j;
                int right = (2*n - 2) - j;
                int down = (2*n - 2) -i;
                System.out.print(n - (Math.min(Math.min(top,down),Math.min(left,right))));
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
//        System.out.println("hello");
//        pattern_1(3);
//        pattern_2(5);
//        pattern_3(4);
//        pattern_4(4);
//        pattern_5(5);
//        printTriangleInverse(6);
//        pattern_10(5);
//        pattern_11(5);
//        pattern_12(4);
//        pattern_13(3);
//        pattern_14(5);
//        pattern_15(5);
//        pattern_17(5);
//        pattern_18(5);
//        pattern_21(3);
        pattern_22(4);
    }

}
