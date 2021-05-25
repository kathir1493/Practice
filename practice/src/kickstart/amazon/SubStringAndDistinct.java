package kickstart.amazon;

import java.util.Arrays;

public class SubStringAndDistinct {



    public static void findSubStringAndDistinct(String str){

        int[] count = new int[26];
        int distinctChar = 0;

        int res = 0;

        int n = str.length();

        for (int i = 0; i < n; i++)
        {
            distinctChar = 0;

            Arrays.fill(count, 0);

            for (int j=i; j<n; j++)
            {
                if (count[str.charAt(j) - 'a'] == 0)
                    distinctChar++;

                count[str.charAt(j) - 'a']++;

                if (distinctChar == 1)
                    res++;
            }
        }


        System.out.println("count : " + Arrays.toString(count));
        //System.out.println("charOccurence : " + Arrays.toString(charOccurence));


    }





    public static void main(String[] args){
        findSubStringAndDistinct("aabc");

    }


}
