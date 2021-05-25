package kickstart.array;

public class ArrangeNegative {

    public static void RearrangePosNeg(int arr[])
    {
        int i=0;
        int j=arr.length-1;

        while(true)
        {
            if(i>=j){
                return;
            }

            if(arr[i]>0)
            {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j--;
            }
            i++;
        }
    }

    // Driver Code
    public static void main (String[] args)
    {
        int arr[] = {-12, 11, -13, -5, 6, -7, 5, -3, -6};

        RearrangePosNeg(arr);

        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+" ");
    }

}
