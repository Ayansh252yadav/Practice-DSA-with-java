package OnlinePlatform;

import java.util.Arrays;

public class MinimumIntialEnergy1665 {
    public static int minimumEffort(int[][] tasks) {
        int currentEnergy=0;
        int ans=0;
        Arrays.sort(tasks, (a, b) ->
                (b[1] - b[0]) - (a[1] - a[0]));
        for(int a[]:tasks){
                if(currentEnergy<a[1]){
                    int t=a[1]-currentEnergy;
                    currentEnergy+=t;
                    ans+=t;
                }
                    currentEnergy-=a[0];
        }
        return ans;
    }

    public static void main(String[] args) {
        int [][]tasks = {{1,3},{2,4},{10,11},{10,12},{8,9}};
        System.out.println(minimumEffort(tasks));
    }
}
