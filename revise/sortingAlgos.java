package revise;

public class sortingAlgos {
    public static void main(String[] args) {
        int[] arr = {4,3,7,1,2};
//        int[] newArr = selectionn(arr);
//        int[] bubArr = bubbleSort(arr);
        int[] insertionSort = insertionSort(arr);
        for (int i = 0; i<arr.length;i++){
            System.out.println(insertionSort[i]);
        }
    }

    public static int[] selectionn(int arr[]){

        for (int i = 0; i< arr.length ; i++){
            int minIndex = findMinElement(arr,i,arr.length-1);
            swap(arr,i,minIndex);
        }
        return arr;
    }

    public static int findMinElement(int[] arr, int start , int end){
        int min = start;
        for (int i = start ; i<=end ; i++){
            if (arr[i] < arr[min]){
                min = i;
            }
        }
        return min;
    }

    public static void swap(int[] arr, int first, int last){
        int temp = arr[first];
        arr[first] = arr[last];
        arr[last] = temp;
    }

    public static int[] bubbleSort(int arr[]){

        for (int i = 0 ; i< arr.length-1 ;i++ ){
            int min = i;
            for (int j = i+1; j< arr.length ; j++){
                if (arr[j] < arr[min]){
                    min = j;
                }
            }
            swap(arr,i,min);
        }
        return arr;
    }

    public static int[] insertionSort(int[] arr){
        for (int i = 0; i< arr.length-1 ; i++){
            for (int j = i+1 ; j>0 ; j--){
                if (arr[j] < arr[j-1]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }else{
                    break;
                }
            }
        }
        return arr;
    }
}
