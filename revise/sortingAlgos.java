package revise;

public class sortingAlgos {

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

    public static void quickSort(int[] arr, int si, int ei){
        if (si>=ei){
            return;
            // base case when both pointers are pointing to the same element

        }

        int pivotElement = arr[si];
        quickSort(arr, si, pivotElement-1);
        quickSort(arr, pivotElement+1, ei);


    }

    public static int partition(int[] arr,int si, int ei ){
        int pivotNumber = arr[si];
        int smallNumberCount = 0;
        for(int i = 0; i< arr.length; i++){
            if (arr[i] <pivotNumber){
                smallNumberCount++;
            }
        }

        // now we need to swap pivot number to the position of smallNumberCount
        int temp = arr[si + smallNumberCount];
        arr[si+smallNumberCount] = arr[si];
        arr[si] = temp;

        int i = si;
        int j = ei;
        // moving small numbers to left and bigger numbers to right

        while(i>j){
            if (arr[i]<pivotNumber){
                i++;
            }else if (arr[j]>= pivotNumber){
                j--;
            }else{
                // if both condition fails that means the left has a bigger number and the
                // right has a smaller number
                // in which case its best to swap so that the smaller array we use calling
                // recursion gets the accurate array without missing pieces
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }

        return si + smallNumberCount;

    }

    public static void mergeSort(int[] arr){
        if (arr.length <= 1){
            return;
        }

        int n = arr.length;

        int[] firstHalf = new int[n/2];
        int[] secondHalf = new int[n - firstHalf.length];

        for (int i = 0; i< n/2 ; i++){
            firstHalf[i] = arr[i];
        }

        for (int i = n/2 ; i< n ; i++){
            secondHalf[i-n/2] = arr[i];
        }

        mergeSort(firstHalf);
        mergeSort(secondHalf);

        merge(firstHalf, secondHalf, arr);

    }

    public static void merge(int[] fh, int[] sh, int[] arr) {
        int i = 0; // for fh
        int j = 0; // for sh
        int k = 0; // for main array

        while(i < sh.length && j < sh.length){
            if (fh[i]<=sh[j]){
                arr[k] = fh[i];
                i++;
                k++;
            }else{
                arr[k] = sh[j];
                j++;
                k++;
            }
        }

        if (i< fh.length){
            while (i< fh.length){
                arr[k] = fh[i];
                i++;
                k++;
            }
        }

        if (j< sh.length){
            while (j< sh.length){
                arr[k] = sh[j];
                j++;
                k++;
            }
        }

    }

    public static void main(String[] args) {
        int[] arr = {4,3,7,1,2};
//        int[] newArr = selectionn(arr);
//        int[] bubArr = bubbleSort(arr);
        int[] insertionSort = insertionSort(arr);
        for (int i = 0; i<arr.length;i++){
            System.out.println(insertionSort[i]);
        }
    }
}
