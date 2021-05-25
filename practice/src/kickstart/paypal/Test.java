package kickstart.paypal;

public class Test {
    //aabccccccccaaaA ==> a2b1c8a3A1

   // aa bbcc


   public static String getCompressedString(String input){

        StringBuilder compressedString = new StringBuilder();

        int count =1;
        char[] charArray = input.toCharArray();
        char prevChar=charArray[0];


        for(int i =1;i<input.length();i++){

            if(charArray[i]!=prevChar){
                compressedString.append(prevChar);
                compressedString.append(count);
                prevChar = charArray[i];
                count=1;
            }else {
                count++;
            }
        }
       compressedString.append(prevChar);
       compressedString.append(count);

        return compressedString.toString();
    }

    public static void main(String[] args){

       System.out.println( getCompressedString("aabccccccccaaaA"));
    }

}
