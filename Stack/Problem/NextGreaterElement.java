package Stack.Problem;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {
    public static int [] nextGreaterElement(int arr[]){
        int n=arr.length;
        Stack<Integer>s=new Stack<>();
        int []nextGreater=new int[n];
        for(int i=n-1;i>=0;i--){
            while(!s.isEmpty() && s.peek()<=arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nextGreater[i]=-1;
            }else{
               nextGreater[i]=s.peek();
            }
            s.push(arr[i]);
        }
        return nextGreater;
    }

    public static void main(String[] args) {
        int []arr={6,8,0,1,3};
        System.out.println(Arrays.toString(nextGreaterElement(arr)));
    }
}
