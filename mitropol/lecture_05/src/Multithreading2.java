import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Multithreading2 {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>(Arrays.asList(1, 5, 3, 4, 2));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(10, 50, 30, 40, 20));

        List<Integer> result = new ArrayList<>();

        Thread t1 = new Thread(() -> {
           Integer max1 = Collections.max(list1, Integer::compare);
            result.add(max1);
        });
        Thread t2 = new Thread(() -> {
          Integer max2 = Collections.max(list2, Integer::compare);
            result.add(max2);
        });

        t1.start();
        t2.start();

        System.out.println(result);

    }
}