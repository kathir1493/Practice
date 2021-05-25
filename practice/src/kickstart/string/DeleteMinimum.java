package kickstart.string;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class DeleteMinimum {


    static int minCharsToDelete(String str) {
        HashMap<Character, Integer> frequencies = new HashMap<>();

        PriorityQueue<Integer> pq =
                new PriorityQueue<>((x, y) ->
                        Integer.compare(y, x));

        int minCount = 0;

        for (int i = 0; i < str.length(); i++) {
            if (frequencies.containsKey(str.charAt(i))) {
                frequencies.put(str.charAt(i),
                        frequencies.get(str.charAt(i)) + 1);
            } else {
                frequencies.put(str.charAt(i), 1);
            }
        }

        for (Map.Entry<Character,Integer> it : frequencies.entrySet()) {
            pq.add(it.getValue());
        }

        while (!pq.isEmpty()) {
            int top = pq.poll();
            if (pq.isEmpty()) {
                return minCount;
            }

            if (top == pq.peek()) {
                if (top > 1) {
                    pq.add(top - 1);
                }
                minCount++;
            }
        }

        return minCount;
    }

    // Driver Code
    public static void main(String[] args) {
        String str = "";

        System.out.print(minCharsToDelete(
                str));
    }
}


