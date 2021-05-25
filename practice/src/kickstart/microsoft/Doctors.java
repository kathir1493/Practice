package kickstart.microsoft;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Doctors {

    public static  int solution(int[][] arr) {

        Map<Integer,Integer> ids = new HashMap<>();
        Set<Integer> visitedDoctors = new HashSet<>();

        int count =0;

        for(int i=0;i< arr.length ;i++){
            for(int j=0;j< arr[i].length ;j++) {
                if(!ids.containsKey(arr[i][j])){
                    ids.put(arr[i][j] , i);
                }else if(ids.get(arr[i][j])!=i && !visitedDoctors.contains(arr[i][j])){
                    count++;
                    visitedDoctors.add(arr[i][j]);
                }
            }

            }

        return count;
    }





    public static void main (String[] args)
    {
        //int arr[][] = {{1,2,2},{3,1,4}};

        //int arr[][] = {{1,1,5,2,3},{4,5,6,4,3},{9,4,4,1,5}};

        int arr[][] = {{4,3},{5,5},{6,2}};


        System.out.println(solution(arr));


    }
}
