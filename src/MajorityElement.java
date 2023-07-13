import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MajorityElement {

    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums .length; i++){
            System.out.println("Get :: "+map.get(nums[i]));
            map.put(nums[i], map.containsKey(nums[i]) ? map.get(nums[i]) + 1 : 1);
        }
        int max = 0;
        int result = -1;
        Set<Map.Entry<Integer,Integer>> set = map.entrySet();
        System.out.println("Set :: "+set);
        for(Map.Entry<Integer,Integer> entry : set){
            if(entry.getValue() > max){
                result = entry.getKey();
                max = entry.getValue();
            }
        }
        return result;
    }
    public static int majorityElement1(int[] nums) {
        Arrays.sort(nums);
        System.out.println("nums "+ nums[nums.length / 2]);
        return nums[nums.length / 2];
    }

    public static void main(String[] args) {
        HashMap<String,Integer> map =new HashMap<>();
        map.put("1",1);
        map.put("2",2);
        map.put("3",3);


//        Set<Map.Entry<String,Integer>> set = map.entrySet();
//        System.out.println(set);
        int [] arr={4,4,4,1,1,1,1};
         Arrays.sort(arr);
        System.out.println(Arrays.stream(arr));
        majorityElement(arr);
        majorityElement1(arr);
    }
}
