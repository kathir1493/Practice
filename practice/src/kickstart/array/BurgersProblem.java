package kickstart.array;

public class BurgersProblem {

    public static  int[] numOfBurgers(int tom, int cheese) {
        int[] list=new int[2];

        if(tom-(2*cheese)>=0 && (tom-(2*cheese))%2==0){
            int jumbo=(tom-(2*cheese))/2;
            int small=cheese-jumbo;
            if(small<0){
                return list;
            }
            list[0]= jumbo;
            list[1]= small;
        }else {
            list[0]= -1;
            list[1]= -1;
        }
        return list;
    }

    public static void main(String[] args){
        for(int i :numOfBurgers(40,15)){
            System.out.println(i);
        }
    }
}
