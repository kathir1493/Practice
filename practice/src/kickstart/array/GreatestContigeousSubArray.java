package kickstart.array;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class GreatestContigeousSubArray {

    static  List<Integer>  findSubarray(int a[], int k, int n) {

        // Data-structure to store all
        // the sub-arrays of size K
        TreeMap<Integer,List<Integer> > vec= new TreeMap<>();

        // Iterate to find all the sub-arrays
        for (int i = 0; i < n - k + 1; i++) {
            List<Integer>  temp = new ArrayList<>();
            int sum=0;
            // Store the sub-array elements in the array
            for (int j = i; j < i + k; j++) {
                temp.add(a[j]);
                sum+=a[i];
            }

            // Push the vector in the container
            vec.put(sum,temp);
        }


        // The last sub-array in the sorted order
        // will be the answer
        return vec.lastEntry().getValue();
    }

    // Driver code
    public static void main(String[] args)
    {
        int a[] = { 1, 4, 3, 2, 5 };
        int k = 4;


        System.out.println(findSubarray(a, k,a.length));

    }


}
