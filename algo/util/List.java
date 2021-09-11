package algo.util;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class List {

    //to get an almost sorted array I'll just swap 100 numbers in the sorted array
    public static int[] getAlmostOrder (){
        int[] almostOrder = IntStream.rangeClosed(1, 10000).toArray();
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            int randomNumber = 1 + random.nextInt(10000);//first number to swap
            int randomNumber2 = 1 + random.nextInt(10000);//second number to swap
            almostOrder[randomNumber] = randomNumber2;
            almostOrder[randomNumber2] = randomNumber;
        }
        return almostOrder;
    }

    /**
     * @return the inOrder
     */
    public static int[] getInOrder() {
        return IntStream.rangeClosed(1, 10000).toArray();
    }
    /**
     * @return the randomOrder
     */
    public static int[] getRandomOrder() {
        int[] ordered = IntStream.rangeClosed(1, 10000).toArray();
        java.util.List<Integer> list = Arrays.stream(ordered).boxed().collect(Collectors.toList());
        Collections.shuffle(list);
        int[] unordered = list.stream().mapToInt(i -> i).toArray();
        return unordered;
    }
    /**
     * @return the reverseOrder
     */
    public static int[] getReverseOrder() {
        int[] ordered = IntStream.rangeClosed(1, 10000).toArray();
        java.util.List<Integer> list = Arrays.stream(ordered).boxed().collect(Collectors.toList());
        Collections.reverse(list);
        int[] reverseOrder = list.stream().mapToInt(i -> i).toArray();
        return reverseOrder;
    }
}
