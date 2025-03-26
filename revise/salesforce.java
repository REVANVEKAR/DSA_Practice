package revise;

import java.util.Scanner;

public class salesforce {



    public static void main(String[] args) {

        String[] weekdays = new String[7];
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i< weekdays.length ; i++){
//            weekdays[i] = sc.next();
        }

        for (String x : weekdays){
//            System.out.println(x);
        }

        int[] arr = {1,2,3,4,5,6,7,8,9};

        max(arr);

    }


    public static void max(int[] arr){
        int max = Integer.MIN_VALUE;

        for (int i =0; i< arr.length; i++){
            if (arr[i] > max){
                max = arr[i];
            }
        }

        System.out.println(max);
    }

}
