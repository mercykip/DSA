//import java.util.List;
//
//public class RotateArray {
//    public void rotate(int[] nums, int k) {
//        List<Integer> rotated = new ArrayList<>();
//        if(k <= 0){
//            return ;
//        }
//
//        for(int i=nums.length-k; i<nums.length; i++ ){
//            if(k > 0){
//                rotated.add(nums[i]);
//                k--;
//            }
//        }
//
//        for(int j =0; j<nums.length-k; j++){
//            rotated.add(nums[j]);
//
//        }
//        for (int i = 0; i < nums.length; i++) {
//            nums[i] = rotated.get(i);
//        }
//
//    }
//}
