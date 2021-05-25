package kickstart.microsoft;

import java.util.Deque;
import java.util.LinkedList;

public class Frogs {



    public static int solution(int[] blocks) {

        Deque<Integer> window = new LinkedList<>();

        if(blocks.length == 0){
            return 0;
        }

        window.add(blocks[0]);

        int largest = blocks[0];
        int maxDistance = Integer.MIN_VALUE;

        for (int i = 1 ;i<blocks.length;i++){
            if (window.peekLast() >= blocks[i]) {
                largest = Math.max(blocks[i], largest);
            }else {
                while (window.peek() != largest){
                    window.poll();
                }
                maxDistance = Math.max(maxDistance, window.size());
            }
            window.add(blocks[i]);
        }

        return  Math.max(maxDistance, window.size());
    }


    public static int solution1(int[] blocks) {

        int start =0 ;
        int end=1;

        if(blocks.length == 0){
            return 0;
        }

        int indexOfLargest = 0;
        int maxDistance = Integer.MIN_VALUE;

        while (end < blocks.length-1){
            if (blocks[end] >= blocks[end+1] ) {
                if(blocks[end+1] > blocks[indexOfLargest]){
                    indexOfLargest = end+1;
                }
            }else {
                start = indexOfLargest;
                maxDistance = Math.max(maxDistance, end-start+1);
            }
            end++;
        }

        return  Math.max(maxDistance, end-start+1);
    }



    public static void main (String[] args)
    {


       // int arr[] = {1,5,5,5,5,5,5};

       //int arr[] = {5,4,3,2,1};

      //  int arr[] = {2,6,8,5};

       int arr[] = {2,1};

        System.out.println(solution1(arr));


    }
}
