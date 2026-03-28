package OnlinePlatform;

import java.util.ArrayList;
import java.util.Arrays;

public class MinimumNumberOfOperationToMoveBall1769{
    public static int[] minOperations(String boxes) {
        ArrayList<Integer>help=new ArrayList<>();
        for(int i=0;i<boxes.length();i++){
            if(boxes.charAt(i)=='1'){
                help.add(i);
            }
        }
        int []answer=new int[boxes.length()];
        int count=0;
        int k=0;
        for(int i=0;i<boxes.length();i++){
            for(int j=0;j<help.size();j++){
             count+=Math.abs(i-help.get(j));
            }
            answer[k]=count;
            count=0;
            k++;
        }
        return answer;
    }

    public static void main(String[] args) {
        String boxes = "001011";
        System.out.println(Arrays.toString(minOperations(boxes)));
    }
}
