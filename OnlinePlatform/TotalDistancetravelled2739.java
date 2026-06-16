package OnlinePlatform;

import java.util.ArrayList;

public class TotalDistancetravelled2739 {
    public static int distanceTraveled(int mainTank, int additionalTank) {
    if(mainTank<5){
        return mainTank*10;
    }
        ArrayList<Integer>oil=new ArrayList<>();
    while (mainTank!=0){
        if(mainTank/5>=1 && additionalTank>=1){
            oil.add(5);
            mainTank=mainTank-5+1;
            additionalTank--;
        }else{
            oil.add(mainTank);
            break;
        }
    }
    int distance=0;
        for (Integer o : oil) {
            distance += o * 10;
        }
        System.out.println(oil);
    return distance;
    }

    public static void main(String[] args) {
        int mainTank = 5, additionalTank = 1;
        System.out.println(distanceTraveled(mainTank,additionalTank));
    }
}
