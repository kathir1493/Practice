package kickstart.string;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Anagram {

    public static List<Integer> getMinimumDifference(List<String> a, List<String> b) {

        List<Integer> valueList = new ArrayList<>();

        for(int i= 0;i<a.size();i++){
            int[] charArr = new int [26];

            int count=0;
            String str1 = a.get(i);
            String str2 = b.get(i);

            if(str1.length()!=str2.length()){
                valueList.add(-1);
                continue;

            }

            for(char c:str1.toCharArray()){
                charArr[c-'a']++;
            }
            for(char c:str2.toCharArray()){
                charArr[c-'a']--;
            }

            for(int val:charArr){
                if(val!=0){
                    count+=Math.abs(val);
                }
            }

            valueList.add(count/2);
        }

        return valueList;
    }

    public static void main(String[] args){

        List<String> list = new ArrayList<>();

        List<String> list2 = new ArrayList<>();

        Scanner obj= new Scanner(System.in);

        int n = obj.nextInt();
        obj.nextLine();

        for (int i=0;i<n;i++){
            list.add(obj.nextLine());
        }
        for (int i=0;i<n;i++){
            list2.add(obj.nextLine());
        }

        System.out.println(getMinimumDifference(list,list2));
    }
}
