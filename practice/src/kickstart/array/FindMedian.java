package kickstart.array;

import java.util.*;

public class FindMedian {

    public static void main(String[] args) {

        PriorityQueue<Integer> priorityQueue =  new PriorityQueue<>((a,b) -> Integer.compare(b,a));

        Deque<Integer>  pq =  new LinkedList<>();

        int arr[] = {6,4,3,1,2,5};

        for(int a :arr){

            priorityQueue.offer(a);
            System.out.println(priorityQueue);

        }


    }


}
