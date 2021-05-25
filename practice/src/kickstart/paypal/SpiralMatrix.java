package kickstart.paypal;

public class SpiralMatrix {

    public  void printSpiral(int[][] arr) {

        int[][] visitedNode = new int[arr.length][arr.length];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                visitedNode[i][j] = 0;
            }


        }

    }
}

