package kickstart.string;


public class Hashing {

    public static int maxConsequtiveSequence(String input){
        if(input.length() <= 1) return input.length();

        int lengthHere=1, maxLength=1;

        for(int i=1; i< input.length(); i++){
            if('a' == input.charAt(i) || !Character.isLetter(input.charAt(i))){
                lengthHere=1;
                continue;
            }
            if(isConsequtive(input.charAt(i-1), input.charAt(i))){
                lengthHere++;
                maxLength=Math.max(maxLength, lengthHere);
            } else{
                lengthHere=1;
            }
        }

        return maxLength;
    }

    private static boolean isConsequtive(char x, char y){
        return y-x == 1;
    }


    public static void main(String[] args) {


        System.out.println(maxConsequtiveSequence("abceabcdefgac"));

    }
}


