package revise;

public class patterns {
    public static void main(String[] args) {
//        System.out.println("hello");
//        pattern_1(3);
//        pattern_2(5);
//        pattern_3(4);
//        pattern_4(4);
//        pattern_5(5);
        printTriangleInverse(6);
    }






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
            for (int j = n-i ; j<=1 ; j--){
                System.out.print(" ");
            }
            for (int j = 2*i-1 ; j>= 1 ; j--){
                System.out.print("*");
            }

            System.out.println();
        }
    }


}
