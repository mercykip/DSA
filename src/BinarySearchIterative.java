public class BinarySearchIterative {
//O(log N)
    public static int binarySearchIterative(int[] arr, int x) {
        int l = 0;
        int r = arr.length-1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (arr[mid] == x) {
                return mid;
            }

            if ( x > arr[mid] ) {
                l = mid + 1;

            } else {
                r = mid - 1;

            }

        }
        //element was not found
        return -1;

    }

    public static void main(String[] args) {
        int[] arr = {3, 4, 62, 1, 5, 8, 4};
        int x = 8;
        int result = binarySearchIterative(arr, x);
        System.out.println(result);
    }
}
