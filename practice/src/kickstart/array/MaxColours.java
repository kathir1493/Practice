package kickstart.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MaxColours {

    public static int getMaxColors(List<Integer> prices, int money) {
        // Write your code here

        System.out.println(prices);

        for(int i=0;i<prices.size();i++){
            money = money- prices.get(i);

            if(money==0){
                return i+1;
            }
            else if(money<0){
                return i;
            }
        }

        return 0;
    }



    public static void main(String[] args){

        List<Integer> list = new ArrayList<>();


        Scanner obj= new Scanner(System.in);

        int n = obj.nextInt();


        for (int i=0;i<n;i++){
            list.add(obj.nextInt());
        }

        System.out.println(getMaxColors(list,obj.nextInt()));

    }

}
