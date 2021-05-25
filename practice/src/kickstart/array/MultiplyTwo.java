package kickstart.array;

import java.util.*;

public class MultiplyTwo {

    public static void multiplyTwoNum(int arr[], int givenNumber) {

        Set<Integer> hm = new HashSet<>();

        for (int value : arr) {
            if (givenNumber % value == 0 && hm.contains(givenNumber / value)) {
                System.out.println(givenNumber / value + " and " + value);
            }
            hm.add(value);
        }
    }
    public static void main(String[] args) {
        int arr[] = {2, 4, 1, 6, 5, 20, -1};
        int givenNumber = 20;
        multiplyTwoNum(arr,givenNumber);
    }
}
