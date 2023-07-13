public class Jump {
    public static boolean canJump(int[] nums) {
        int finalValue=0;
        for(int i=0; i < nums.length; i++){
            if(finalValue<i){
                return false;
            }
            finalValue=Math.max(finalValue,i+nums[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        int [] arr={2,3,1,1,4};
        canJump(arr);
    }
}
