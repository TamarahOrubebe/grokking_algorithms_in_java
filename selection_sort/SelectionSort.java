import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class SelectionSort {

    public static List<Integer> sort(List<Integer> arr) {
       List<Integer> copiedArr = new ArrayList<>(arr);
       List<Integer> resultArr = new ArrayList<>();

       for(int i = 0; i < arr.size(); i++) {
           int smallestIdx = getSmallestIdx(copiedArr);
           resultArr.add(copiedArr.get(smallestIdx));
           copiedArr.remove(smallestIdx);
       }
       return resultArr;
    }

    public static int getSmallestIdx(List<Integer> arr) {
        int smallest = Integer.MAX_VALUE;
        int smallestIdx = 0;
        for(int i = 0; i < arr.size(); i++) {
            if (arr.get(i) < smallest) {
                smallest = arr.get(i);
                smallestIdx = i;
            }

        }
        return smallestIdx;
    }


    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(3);
        list.add(6);
        list.add(2);
        list.add(10);
        System.out.println(sort(list));
    }
}

