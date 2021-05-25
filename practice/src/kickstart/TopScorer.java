package kickstart;

import java.util.*;

public class TopScorer {

   static Map<String, Deque<Integer>> scoreBoard = new HashMap<>();
    static Map<String, Integer> maxMarks = new HashMap<>();
    static int topScore = 0;

    static void addMark(String studentName,int mark){

        if(scoreBoard.containsKey(studentName)){
            Deque<Integer> marks = scoreBoard.get(studentName);

            if(marks.size()<3){
                marks.add(mark);

            }else {
                int lowest= Integer.MAX_VALUE;
                int scores= 0;


                scores = scores - lowest +mark;
                marks.remove(lowest);
                marks.add(mark);


                topScore = Math.max(scores/3,topScore);
                maxMarks.put(studentName,topScore);

            }
        }else {

            Deque<Integer> marks = new LinkedList<>();
            marks.add(mark);
            scoreBoard.put(studentName,marks);
            maxMarks.put(studentName,mark);

        }
    }


    static List<String>  getTopScorer(){
        List<String> topScorer  = new ArrayList<>();
        for(Map.Entry<String,Integer> entry : maxMarks.entrySet()){
            if(entry.getValue().equals(topScore)){
                topScorer.add(entry.getKey());
            }
        }

        return topScorer;
    }


    public static void main(String[] args){


        addMark("S1",60);
        addMark("S1",70);
        addMark("S1",80);
        addMark("S1",90);

        addMark("S2",90);
        addMark("S2",90);
        addMark("S2",90);


        System.out.println(getTopScorer());






    }


}
