package kickstart.paypal;


public class RotateRight {

    public static void rotate(int[] a, int k) {

        k=k%a.length;
        int temp;

        for(int i = 0; i < a.length; i++)
        {
            if(i<k)
            {
                temp = a[a.length + i - k];
                a[a.length + i - k] = a[i] ;
            }
            else
            {
                temp = a[i - k];
                a[i - k] = a[i] ;
            }
            a[i] = temp;
            System.out.print("i = " + i + " ");

        }
    }

    public static void main (String[] args)
    {
        int arr[] = {1,2,3,4,5,6,7};

        args[0].chars().distinct().count();

      rotate(arr,3);

    }
}
