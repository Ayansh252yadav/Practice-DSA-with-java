package OnlinePlatform;

import java.util.ArrayList;
import java.util.Collections;

public class NextGreaterElement3_556 {
    public static ArrayList<ArrayList<Integer>> backtrack(ArrayList<Integer>arr,int start,ArrayList<ArrayList<Integer>>result){
        if(arr.size()==start){
            ArrayList<Integer> currentPermutation = new ArrayList<>();
            for (int num : arr) {
                currentPermutation.add(num);
            }
            result.add(currentPermutation);
            return result;
        }
        int temp;
        for(int i=start;i<arr.size();i++){
            temp=arr.get(i);
            arr.set(i,arr.get(start));
            arr.set(start,temp);
            backtrack(arr,start+1,result);
            temp=arr.get(i);
            arr.set(i,arr.get(start));
           arr.set(start,temp);
        }
        return result;
    }
    public static int nextGreaterElement(int n) {
        int temp=n;
        int rev=0;
        ArrayList<Integer>arr=new ArrayList<>();
        while(n!=0) {
            int rem = n % 10;
            arr.add(rem);
            n /= 10;
        }
       ArrayList<ArrayList<Integer>>arr1=new ArrayList<>();
        arr1= backtrack(arr,0,new ArrayList<>());
        Collections.sort(arr1, (a, b) -> a.get(0) - b.get(0));
        System.out.println(arr1);
        int j = 0;
        long max = Long.MAX_VALUE;

        for (int i = 0; i < arr1.size(); i++) {

            j = 0;
            rev = 0;

            // skip leading zero
            if (arr1.get(i).get(0) == 0) continue;

            while (j < arr1.get(i).size()) {
                rev = rev * 10 + arr1.get(i).get(j);
                j++;
            }

            if (rev > temp && rev < max) {
                max = rev;
            }
        }

        if (max <= Integer.MAX_VALUE) {
            return (int) max;
        }

        return -1;
    }

    public static void main(String[] args) {
        int n=21;
        System.out.println(nextGreaterElement(n));
    }
}

