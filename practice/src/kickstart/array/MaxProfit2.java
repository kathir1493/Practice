package kickstart.array;

public class MaxProfit2 {

    public static int maxProfit(int[] prices){
        int totalProfit=0;

        for(int i = 1;i<prices.length ;i++){

            if(prices[i] > prices[i-1] ){
                totalProfit +=  prices[i]-prices[i-1];
            }

        }


        return totalProfit;
    }


    public static void main (String[] args)
    {
        int arr[] = {7,1,5,3,6,4};

        System.out.println(maxProfit(arr));

    }
}
