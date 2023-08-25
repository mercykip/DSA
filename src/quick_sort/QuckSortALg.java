package quick_sort;

public class QuckSortALg {
    public static int[] sortArray(int[] num) {

        quickSortArray(num, 0, num.length-1);
        return num;
    }

    public static void quickSortArray(int[] num, int low, int high){
        if(low >= high) return;// base case

        int pivot=partition(num, low, high);
        //pivot is already sorted
        quickSortArray(num,low,pivot-1);
        quickSortArray(num,pivot+1,high);
    }

    public static int partition(int[] arr, int low, int high){
        int i = (low - 1); // Initialize i to one position before the first element
        int pivot = arr[high];


        for (int j = low; j <= high - 1; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j); // Swap the element at i and j
            }
        }

        swap(arr, i + 1, high); // Swap the pivot with the element at i + 1
        return i + 1; // Return the new index of the pivot
    }

    public static void swap(int [] arr, int i, int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public static void main(String[] args)
    {
        int[] arr = { 10, 7, 8, 9, 1, 5 };
        int N = arr.length;

        // Function call
        sortArray(arr);
        System.out.println("Sorted array:");
        System.out.println(arr);

    }

}
