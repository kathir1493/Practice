package kickstart.array;

import java.util.HashMap;

public class GreatestDistinctSubarray {

    public static int LengthOfLongestSubstringTwoDistinct(String s)
    {
        if(s.length() < 1) return 0;
        HashMap<Character,Integer> index = new HashMap<>();
        int lo = 0;
        int i = 0;
        int maxLength = 0;
        while(i < s.length()) {
            if(index.size() <= 2) {
                char c = s.charAt(i);
                index.put(c, i);
                i++;
            }
            if(index.size() > 2) {
                int leftMost = s.length();
                for(int val : index.values()) {
                    leftMost = Math.min(leftMost,val);
                }
                char c = s.charAt(leftMost);
                index.remove(c);
                lo = leftMost+1;
            }
            maxLength = Math.max(maxLength, i-lo);
        }
        return maxLength;
    }

    public static void main(String[] args){

        int[] arr ={1,2,1,3,3,3,3};

        System.out.println(LengthOfLongestSubstringTwoDistinct(arr));
    }


    public static int LengthOfLongestSubstringTwoDistinct(int[] s){

        if(s.length<1) return 0;

        HashMap<Integer,Integer> window = new HashMap<>();

        int maxLength = 0;
        int leftMost = 0;
        int i = 0;
        int low = 0;

        while (i<s.length){

            if (window.size()<=2){
                window.put(s[i],i);
                i++;
            }

            if(window.size()>2){
                leftMost = s.length;
                for(Integer left : window.values()){
                    leftMost = Math.min(left,leftMost);
                }
                int leftMostValue = s[leftMost];
                window.remove(leftMostValue);
                low = leftMost+1;
            }

            maxLength = Math.max(maxLength,i-low);


        }

        return maxLength;

    }





}
