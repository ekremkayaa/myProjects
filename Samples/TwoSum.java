import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {

        int[] numbers = new int[] {-2, 3, 7, 4, 8};
        int target = 20;
        int[] result = getTwoSum(numbers, target);
        System.out.println(result[0] + " " + result[1]);
    }

    public static int[] getTwoSum(int[] numbers, int target){
        Map<Integer, Integer> visitedNumber = new HashMap<>();
        for(int i = 0; i<numbers.length; i++){
            int delta = target - numbers[i];
            if(visitedNumber.containsKey(delta))
                return new int[] {i, visitedNumber.get(delta)};

            visitedNumber.put(numbers[i], i);
        }
        return new int[] {-1, -1};
    }
}
