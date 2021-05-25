package kickstart.paypal;


//[4,5,7,11,9,13,8,12] - 20


public class SumOfPair {
/*
    public  static void findSumOfPair(int[] arr,int sum){

        Map<Integer,Integer> mySet = new HashMap();

        for(int i=0;i<arr.length;i++){
            mySet.put(arr[i],i);
        }

        for(int num:mySet.keySet()){
            if(mySet.get(num)!=-1 && mySet.containsKey(sum-num)){
                System.out.println(num+","+(sum-num));
                mySet.put(sum-num,-1);
            }
        }
    }

    public static void main(String[] args){
        String inputString ="abdecdrtyuiop";

        StringBuffer buffer = new StringBuffer();
        int maxLength = 0;

        String maxString=null,temp =null;

        for(char c:inputString.toCharArray()){

            if(buffer.lastIndexOf(c)){
                temp = buffer.toString();
                String[] arr = buffer.toString().split(c+"");
                buffer = new StringBuffer(arr[1]); //

            }else{
                buffer.append(c);
            }
            if(temp.length()>maxLength){
                maxString =    temp;
                maxLength = temp.length();
            }
        }

        System.out.println(maxString);
    }*/

}
