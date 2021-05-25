package kickstart.array;

import java.util.LinkedList;
import java.util.List;

public class LargestDistinctSubArray {


    private static int largestSubArray(int[] arr) {

        int maxValue = Integer.MIN_VALUE;
        List<Integer> bucket = new LinkedList<>();


        if(arr.length <2){
            return arr.length;
        }

        int prevSum = arr[1] - arr[0] ;
        int prev = arr[1];

        bucket.add(arr[0]);
        bucket.add(arr[1]);


        for (int i =2;i<arr.length;i++) {
            if ((arr[i] - prev != 1 && arr[i] - prev != -1) || (arr[i] - prev != prevSum && (prevSum == -1 || prevSum == 1))) {
                maxValue = Math.max(bucket.size(), maxValue);
                bucket.clear();
            }
            bucket.add(arr[i]);
            prevSum = arr[i] - prev;
            prev = arr[i];

        }

        maxValue = Math.max(bucket.size() ,maxValue);


        return maxValue;

    }

    public static void main(String[] args)
    {
        int a[] = { -5, -6, -7, -8, 3, 4, -9, -10, -11 };


        System.out.println(largestSubArray(a));

    }
}
