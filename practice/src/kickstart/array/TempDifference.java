package kickstart.array;

public class TempDifference {


    public static String solution(int[] arr) {

        int size = arr.length/4;

        int[] tempDiff = new int[4];

        String[] seasons = {"WINTER","SPRING","SUMMER","AUTUMN"};

        int temp[] = new int[size];
        int j =0,k=0;

        for(int i=0;i<arr.length;i++){

            temp[j] = arr[i];
            j++;

            if( (i+1) % size == 0 ){
                j=0;
                tempDiff[k] = findMaxDiff(temp);
                k++;
            }
        }


        int maxAmplitude = Integer.MIN_VALUE, maxAmpltitudeSeason = 0;

        for (int i =0 ;i<4 ; i++) {

            if(maxAmplitude < tempDiff[i]){
                maxAmplitude = tempDiff[i];
                maxAmpltitudeSeason = i;
            }
        }

        return seasons[maxAmpltitudeSeason];
    }


    public static int findMaxDiff(int[] arr){

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int a:arr){
            min = Math.min(min,a);
            max = Math.max(max,a);
        }

        return Math.abs(max - min);
    }


    public static void main(String[] args){

        int[] spring = {-3,-14,-5,7,8,9,8,3};

        int[] winter = {-3,-14,-5,-2,8,9,8,3};

        int[] summer = {-3,-14,-5,7,8,42,8,3};

        int[] AUTUMN = {-3,-14,-5,7,8,42,8,50};


        System.out.println(solution(AUTUMN));

    }
}
