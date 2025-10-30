package reviision.ArrayII.com;

import java.util.Arrays;
import java.util.Stack;

public class RotateAnArray {

    public static void main(String[] args) {
        int arr[]={1,2,3,4,5,6,7};
        int d=3;
        Stack<Integer>st=new Stack<>();
        int temp[]=new int[arr.length];
        temp[0]=arr[0];
        for (int i = 1; i < arr.length ; i++) {
            temp[i ] = arr[i-1];
        }
        System.out.println(Arrays.toString(temp));
        for (int i = 0; i < arr.length ; i++) {
            st.push(arr[i]);
        }
        for(int i=d;i>=0;i--){
            temp[i]=st.pop();
        }
       temp[d+1]=arr[arr.length-1];
        int k=0;
        for(int i=d;i<temp.length;i++){
            if(i<temp.length) {
                temp[i] = arr[k];
                k++;
            }else{
                break;
            }
        }

        System.out.println(Arrays.toString(temp));
        System.out.println(st);
        int arr1[] = {1, 2, 3, 4, 5, 6, 7};
        int d1= 3;

        int temp1[] = new int[arr1.length];

        for (int i = 0; i < arr1.length - d1; i++) {
            temp1[i] = arr1[i + d1];
        }

        for (int i = 0; i < d1; i++) {
            temp1[arr1.length - d1 + i] = arr1[i];
        }

        System.out.println(Arrays.toString(temp1));
    }
    }

