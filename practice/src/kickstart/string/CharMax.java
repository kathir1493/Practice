package kickstart.string;

public class CharMax {


    public static void main(String args[]){

        String S ="";


        if(S == null || S.trim().isEmpty()){
            //return 0 ;
        }

        char prev = S.charAt(0);
        char curr;
        int maxValue = Integer.MIN_VALUE;

        for(int i = 1;i<S.length();i++){

            curr = S.charAt(i);
            maxValue = Math.max(maxValue, Integer.parseInt(prev+""+curr));
            prev = curr;
        }

       // return maxValue;

    }

}
