import java.util.List;
import java.util.ArrayList;

public class QuickSort {
    public static List<Integer> sort(List<Integer> list) {

        if (list.size() < 2)
            return list;

         int pivot = list.get(list.size()/2);
         List<Integer> smaller = new ArrayList<>();
         List<Integer> larger = new ArrayList<>();

         for(Integer num: list) {
             if (num < pivot) 
                 smaller.add(num);
             else if (num > pivot) 
                 larger.add(num);
          }

          List<Integer> result = new ArrayList<>();
          result.addAll(sort(smaller));
          result.add(pivot);
          result.addAll(sort(larger));
          return result;
    }


    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(4);
        arr.add(8);
        arr.add(2);
        arr.add(1);
        arr.add(3);
        arr.add(5);
        arr.add(6);
        arr.add(7);

        System.out.println("The sorted list is: " + sort(arr));
    }
}
