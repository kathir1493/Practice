package kickstart.array;

import java.util.*;

public class Maxweight {

    public static int lastStoneWeight(List<Integer> weights) {
        // Write your code here

        Queue<Integer> weightedQueue = new PriorityQueue<>(Collections.reverseOrder());
        weightedQueue.addAll(weights);

        int maxWeight;

        while (weightedQueue.size()>1){

            int first = weightedQueue.poll();
            int second = weightedQueue.poll();

            if(first!=second) {
                maxWeight = Math.abs(first - second);
                weightedQueue.offer(maxWeight);
            }

        }

        return weightedQueue.size()==1?weightedQueue.poll():0;
    }

    public static void main(String[] args){

        List<Integer> list = new ArrayList<>();


        Scanner obj= new Scanner(System.in);

        int n = obj.nextInt();


        for (int i=0;i<n;i++){
            list.add(obj.nextInt());
        }

        System.out.println(lastStoneWeight(list));

    }

}
