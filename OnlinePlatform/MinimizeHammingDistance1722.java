package OnlinePlatform;

public class MinimizeHammingDistance1722 {
    public static void swap(int []source,int a,int b){
      int temp=source[a];
      source[a]=source[b];
      source[b]=temp;
    }
    public static int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {

    for(int i=0;i<allowedSwaps.length;i++){
        for(int j=0;j<allowedSwaps[0].length-1;j++){
          int a=allowedSwaps[i][j];
          int b=allowedSwaps[i][j+1];
          swap(source,a,b);
          break;
        }
    }
    int minDis=0;
    for(int i=0;i<source.length;i++){
        if(source[i]!=target[i]){
            minDis++;
        }
    }
    return minDis;
    }

    public static void main(String[] args) {
        int []source={1,2,3,4};
        int []target={1,3,2,4};
        int [][]allowedSwap={};
        System.out.println(minimumHammingDistance(source,target,allowedSwap));
    }
}
