package kickstart.array;

public class BreakChain {

    static int breakChain(int[] arr){

        if(arr.length<4){
            return 0;
        }

        int min = Integer.MAX_VALUE;

        for(int i = 0 ;i< arr.length - 4 ;i++) {
            min = Math.min(min, findMin(arr, i));
        }

        return min;
    }

    private static int findMin(int[] arr ,int start) {

        int n1 = arr[start] + arr[start+2];
        int n2 = arr[start] + arr[start+3];
        int n3 = arr[start+1] + arr[start+3];

        if(n1<n2 && n1<n3){
            return n1;
        }else if(n2<n1 && n2<n3){
            return n2;
        }
        return n3;
    }


    public static void main(String[] args) {
        int arr[] = {6,3,5,4,7,9};

        System.out.print(breakChain(arr));
    }

}
