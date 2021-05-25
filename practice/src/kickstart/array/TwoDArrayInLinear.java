package kickstart.array;

import java.util.*;

public class TwoDArrayInLinear {


    public static boolean check2DinLinear(Integer[] arr,Integer[][] _2d){

        Queue<Integer> list = new LinkedList<>(Arrays.asList(arr)) ;
        Map<Integer,Integer[]> map = new HashMap<>();

        for(Integer[] _1d:_2d){
            map.put(_1d[0],_1d);
        }

        while (list.peek()!=null){
            if(map.containsKey(list.peek())){
                Integer[] a = map.get(list.peek());

                if(a.length==1){
                    list.poll();
                }else {
                    for(Integer i:a){
                        if(i!=list.poll())
                        {
                            return false;
                        }
                    }
                }
            }
        }

    return false;

    }




    public static void main(String[] args){

        int[] arr ={1,2,1,3,3,3,3};

    }



}
