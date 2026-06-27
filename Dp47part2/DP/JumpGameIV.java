package Dp47part2.DP;

public class JumpGameIV {
    static int count=0;
    public static void  dfs(int []arr,int i,int j){
        if(i>=arr.length || i<0 || j>arr.length){
            return;
        }
        if(arr[i]==arr[j] && i!=j){
            count++;
        }

        dfs(arr,i+1,j);
        dfs(arr,i-1,j);
    }
    public static int minJumps(int[] arr) {
        dfs(arr,0,0);
        return count;
    }

    public static void main(String[] args) {
        int []arr = {100,-23,-23,404,100,23,23,23,3,404};
        minJumps(arr);
    }
}
