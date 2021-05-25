package kickstart.array;

import java.util.*;

public class MinimumDistanceBetweenTwoAdjecent {


    public static int solution(int arr[]){

        if(arr.length < 2){
            return -2;
        }

        Arrays.sort(arr);

        int minDistance = Integer.MAX_VALUE;

        for(int i = 1;i<arr.length;i++){
            minDistance = Math.min(Math.abs(arr[i] - arr[i-1]),minDistance);
        }

        return minDistance > 100000000? -1 : minDistance;

    }


    public static void closestNumbers(List<Integer> numbers) {

        Map<Integer, Map<Integer,Integer>> diffList = new HashMap<>();
        int min = Integer.MAX_VALUE;

        Collections.sort(numbers);

        int prev = numbers.get(0) , diff;

        for(int i=1 ;i<numbers.size();i++){

            diff = numbers.get(i) - prev;

            if(diff <= min){

                if(diffList.containsKey(diff))
                {
                    diffList.get(diff).put(prev, numbers.get(i));
                }else{
                    Map<Integer,Integer> map = new LinkedHashMap<>();
                    map.put(prev, numbers.get(i));
                    diffList.put(diff,map);
                }

                min = diff;
            }

            prev = numbers.get(i);

        }

        for(Map.Entry<Integer,Integer> entry : diffList.get(min).entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

    }



    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(2);
        list.add(1);
        list.add(3);

        closestNumbers(list);

    }
}
