import java.util.ArrayList;
import java.util.*;

public class SumOfRunningArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        List<Integer> mergedArray = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            mergedArray.add(nums1[i]);
        }
        for (int i = 0; i < n; i++) {
            mergedArray.add(nums2[i]);
        }
        Collections.sort(mergedArray);
        for (int i = 0; i < mergedArray.size(); i++) {
            nums1[i] = mergedArray.get(i);
        }
    }
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (i >= 0 && j >= 0) {
            if (nums1[i] >= nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }

        // If there are any remaining elements in nums2, copy them to nums1
        while (j >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }
    public static void main(String[] args) {
//        System.arraycopy(source_arr, sourcePos, dest_arr,destPos, len);
        int[] arr1={1,2,3};
        int[] arr={4,5,6};

        for(int i=0; i< arr1.length; i++){

            System.out.println("Item :: "+arr1[i]);

        }

    }
}
