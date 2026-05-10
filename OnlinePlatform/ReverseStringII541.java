package OnlinePlatform;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ReverseStringII541 {
    public static void partition(ArrayList<String>arr,int k,StringBuilder sb){
        int i=0;
        int len=2*k;
        StringBuilder temp= new StringBuilder();
        while(i < len && i < sb.length()) {
            temp.append(sb.charAt(i));
            i++;
        }
        sb.delete(0,i);
        arr.add(temp.toString());
    }
    public static String reverseStr(String s, int k) {
        ArrayList<String>arr=new ArrayList<>();
        StringBuilder sb=new StringBuilder(s);
        while(!sb.isEmpty()) {
            partition(arr, k, sb);
        }
        String ans="";
        for(int i=0;i<arr.size();i++){
                String first = new StringBuilder(arr.get(i).substring(0, k)).reverse().toString();
               ans += first + arr.get(i).substring(k);
        }
        return ans;
    }
    public int helpUtil(int []nums,int el){
        int j=0;
        int start=0;
        while(j<nums.length-1){
            if(nums[j]==el){
             start=j;
             break;
            }
            j++;
        }
        j=nums.length-1;
        int end=0;
        while(j>=0){
            if(nums[j]==el){
                end=j;
                break;
            }
            j--;
        }
        return nums.length-(start+end);
    }
    public int findShortestSubArray(int[] nums) {
        ArrayList<Integer>arr=new ArrayList<>();
        Map<Integer,Integer> mp=new HashMap<>();
        int count=0;
        for(int e:nums) {
            if (mp.containsKey(e)) {
                mp.put(e, mp.get(e) + 1);
            } else {
                mp.put(e, 1);
            }
             count=Math.max(0,mp.getOrDefault(e,0));
        }
        int temp=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
          int t=mp.get(nums[i]);
          if(t>=count){
              arr.add(nums[i]);
          }
        }
        int  max=0;
       for(int i=0;i<arr.size();i++){
           max=Math.min(max,helpUtil(nums,arr.get(i)));
       }
       return max;
    }
    public static void main(String[] args) {
        System.out.println(reverseStr("abcdefg",2));
    }
}
