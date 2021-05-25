package kickstart.paypal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Tazapay {


    public static void main(String[] args){



        List<Program> list = new ArrayList<>();

        //Pre processing here whenever starts comes increasing bandwidth (having positive value)
        //whenever ends decreasing bandwidth (having negative value)

        list.add(new Program(900,3));
        list.add(new Program(930,-3));
        list.add(new Program(930,5));
        list.add(new Program(1000,-5));
        list.add(new Program(1100,4));
        list.add(new Program(1200,-4));

        //900 - 3    3
        //930 - 5    8
        //1000 - -3  5
        //1100 - 4   9
        //1200 - -4  5
        //1250 - -5  4

        Collections.sort(list);

        int maxBandwidth=0;


        int bandwidth=0;

        for(Program program:list){
            bandwidth += program.bandWidth;
            maxBandwidth = Math.max(bandwidth,maxBandwidth);
        }

        System.out.println(maxBandwidth);
    }

}


class Program implements Comparable<Program> {

    long time;
    int bandWidth;

    public Program(long startTime,int bandWidth) {
        this.time = startTime;
        this.bandWidth = bandWidth;
    }

    @Override
    public int compareTo(Program o) {

        if(this.time>o.time){
            return 1;
        }else if(this.time==o.time){
            if(this.bandWidth>o.bandWidth)
                return -1;
            else
                return 1;
        }
        return -1;
    }
}