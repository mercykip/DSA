public class RecursiveBinarySearch {

    public static int binaryRecursive(int [] arr, int l, int r, int x){
        if(r >= l){
            int mid=l+(r-l)/2;

            if(arr[mid] == x){
                return mid;
            }

            if (arr[mid] > x){
                return binaryRecursive(arr,l,mid-1,x);
            }
            return binaryRecursive(arr,mid+1,r,x);


        }
        return  -1;

    }

    public static void main(String[] args) {
//        int[] arr = {3, 4 , 62, 1 , 5 , 8 , 14};
        int arr[] = { 2, 3, 4, 10, 40 };
        int x = 4;
       int y= binaryRecursive(arr,0,arr.length-1,x);
        System.out.println(y);
//        int arr[] = { 2, 3, 4, 10, 40 };
//        int n = arr.length;
//        int x = 10;
//        int result = binaryRecursive(arr, 0, n - 1, x);
//        if (result == -1)
//            System.out.println(
//                    "Element is not present in array");
//        else
//            System.out.println(
//                    "Element is present at index " + result);

    }
}
