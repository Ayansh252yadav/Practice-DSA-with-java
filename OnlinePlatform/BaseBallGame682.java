package OnlinePlatform;

import java.util.ArrayDeque;

public class BaseBallGame682 {
    public static int calPoints(String[] operations) {
        ArrayDeque<Integer> s=new ArrayDeque<>();
        for (String operation : operations) {
            if (operation.equals("C")) {
                s.pop();
            }
            else if (operation.equals("D")) {
               s.push(s.peek()*2);
            } else if (operation.equals("+")) {
                int first = s.pop();
                int second = s.peek();
                s.push(first);
                s.push(first + second);
            }  else {
                s.push(Integer.parseInt(operation));
            }
        }
        int sum=0;
        for(int t:s){
            sum+=t;
        }
        return sum;
    }

    public static void main(String[] args) {
        String []ops={"5","-2","4","C","D","9","+","+"};
        System.out.println(calPoints(ops));
    }
}
