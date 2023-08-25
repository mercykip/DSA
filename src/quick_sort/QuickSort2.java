package quick_sort;

public class QuickSort2 {
    public int[] sortArray(int[] num) {
        quickSort(num, 0, num.length-1);
        return num;
    }

    public void quickSort(int[] nums, int left, int right) {
        int pl = left;
        int pr = right;
        int pivot = nums[(pl + pr) / 2];

        do {
            while (nums[pl] < pivot) pl++;
            while (nums[pr] > pivot) pr--;
            if (pl <= pr) {
                // swap
                int temp = nums[pl];
                nums[pl] = nums[pr];
                nums[pr] = temp;
                pl++; pr--;
            }
        } while (pl <= pr);
        // recursive
        if (left < pr) quickSort(nums, left, pr);
        if (pl < right) quickSort(nums, pl, right);
    }
}
