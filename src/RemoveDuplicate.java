public class RemoveDuplicate {
    public static int removeDuplicates(int[] nums) {
        int j=0;
        for(int i=0; i< nums.length; i++){

            if(j == 0 || j == 1 || nums[j-2] != nums[i]){
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }

    public static void main(String[] args) {
        int arr []={1,1,1,2,2,3};
        removeDuplicates(arr);
    }
}
