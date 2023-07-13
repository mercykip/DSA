import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class RandomItem {
    HashMap<Integer,Integer> map=new HashMap<>();
    Random random;
    List<Integer> list;
    public RandomItem() {
        map = new HashMap<>();
        random = new Random();
        list = new ArrayList<>();
    }

    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }
        map.put(val,list.size());
        list.add(val);
        return true;

    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
//        Retrieves the index associated with a specific value val from a map called map.
        int index = map.get(val);
//        Checks if the retrieved index is less than the last index of the list. This
//        condition ensures that the element being removed is not already the last element in the list.
        if (index < list.size() - 1) {
//            Retrieves the last element from the list and assigns it to the variable last.
//            This element will be used to replace the element being removed.
            int last = list.get(list.size() - 1);
//             Updates the map by associating the last element with the index value obtained in step 1.
//             This effectively swaps the positions of the element being removed and the last element.
            map.put(last, index);
//            Updates the list by replacing the element at the index obtained
//            in step 1 with the last element. This completes the swapping process.
            list.set(index, last);
        }
//        Removes the mapping associated with the value val from the map.
//        Since the element is being removed from the list, its mapping in
//        the map is no longer needed.
        map.remove(val);
//        Removes the last element from the list. At this point, the desired
//        element has been swapped with the last element, so removing the last
//        element effectively removes the desired element from the list.
        list.remove(list.size() - 1);
        return true;

    }

    public int getRandom() {
//        Generates a random integer between 0 (inclusive)
//        and the size of the list (exclusive) using the nextInt() method
//        of the random object. This index represents the position of the
//        randomly selected element in the list.
        int index = random.nextInt(list.size());
//        Retrieves the element at the randomly generated index from the list
//        using the get() method. This element is then returned as the result of the function.
        return list.get(index);

    }
}
