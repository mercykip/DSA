import java.util.ArrayList;
import java.util.Arrays;

public class MergeSort {
    static int[] mergeSortArray(int[] arr, int low, int high){
        if(low >= high) return null;
        int pivot=low+((high-low)/2);
        mergeSortArray(arr,low,pivot);//left
        mergeSortArray(arr,pivot+1,high);//right
        merge(arr, low, high,pivot);
        return arr;
    }

    static void merge(int[] arr, int low, int high, int pivot){
        int left=low;
        int right=pivot+1;
        ArrayList<Integer> result= new ArrayList<>();

        while(left<=pivot && right <=high){
            if(arr[left]<arr[right]){
                result.add(arr[left]);
                left++;
            }else{
                result.add(arr[right]);
                right++;
            }
        }
         while (left<=pivot){
             result.add(arr[left]);
             left++;
         }

        while ( right <=high){
            result.add(arr[right]);
            right++;
        }
        for(int i=low; i<=high; i++){
            System.out.println(result.get(i-low));
            arr[i]=result.get(i-low);
        }
//        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] arr={3,16,8,1,7};
        mergeSortArray(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));

    }


}
