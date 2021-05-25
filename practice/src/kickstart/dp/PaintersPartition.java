package kickstart.dp;

import java.util.ArrayList;
import java.util.Arrays;

// A DP based Java program for
// painter's partition problem




class PaintersPartition
{
    private static int MOD = 10000003;

    private static  int numberOfPaintersRequired(ArrayList<Integer> boards, long timeUnits) {
        int numberOfPainters = 1;
        long timeUnitsTakenByThePainter = 0;

        for(int i = 0; i < boards.size(); i++) {
            timeUnitsTakenByThePainter += (long)boards.get(i);
            if(timeUnitsTakenByThePainter > timeUnits) {
                numberOfPainters++;
                timeUnitsTakenByThePainter = boards.get(i);
            }
        }
        return numberOfPainters;
    }

    private static  long sumOfBoards(ArrayList<Integer> boards) {
        long sum = 0;
        for(Integer board : boards) {
            sum += (long)board;
        }
        return sum;
    }

    private static  long maxOfBoards(ArrayList<Integer> boards) {
        Integer maxi = Integer.MIN_VALUE;
        for(Integer board : boards) {
            maxi = Math.max(maxi, board);
        }
        return (long)maxi;
    }

    public static int paint(int A, int B, ArrayList<Integer> C) {

        int paintersWeHave = A;


        ArrayList<Integer> boards = new ArrayList<>(C);

        long lowestTimeUnits = maxOfBoards(boards);
        long highestTimeUnits = sumOfBoards(boards);
        long ansTimeUnits = 0;


        while(lowestTimeUnits <= highestTimeUnits) {
            long midTimeUnits = lowestTimeUnits + (highestTimeUnits - lowestTimeUnits) / 2L;

            System.out.println("Lowest :" + lowestTimeUnits + " highest :" + highestTimeUnits + " mid:"+midTimeUnits);


            if(numberOfPaintersRequired(boards, midTimeUnits) <= paintersWeHave) {
                ansTimeUnits = midTimeUnits;
                highestTimeUnits = midTimeUnits - 1;
            } else {
                lowestTimeUnits = midTimeUnits + 1;
            }

        }

        return (int)(((ansTimeUnits % MOD) * (B % MOD)) % MOD);
    }

    // Driver code
    public static void main(String args[])
    {
        Integer arr[] = { 10, 20, 60, 50, 30, 40 };

        // Calculate size of array.
        int n = 3;

        System.out.println(paint( n, 1 ,new ArrayList<>(Arrays.asList(arr))));
    }
}

// This code is contributed by Sahil_Bansall
