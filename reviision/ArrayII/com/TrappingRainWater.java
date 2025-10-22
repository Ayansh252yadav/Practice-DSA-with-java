package reviision.ArrayII.com;

public class TrappingRainWater {
    public static void rainwater(int arr[]){
        int leftMax[]=new int[arr.length];
        leftMax[0]=arr[0];
        int rightMax[]=new int[arr.length];
        rightMax[arr.length-1]=arr[arr.length-1];
        int water_level=Integer.MAX_VALUE;
     //left max boundry

        for(int i=1;i<arr.length;i++){
            leftMax[i]=Math.max(arr[i],leftMax[i-1]);
        }
        //right max boundry
        for(int i=arr.length-2;i>=0;i--){
            rightMax[i]=Math.max(arr[i],rightMax[i+1]);
        }
        int trapped_water=0;
        for(int i=0;i<arr.length;i++)
        {
          trapped_water+=Math.min(leftMax[i],rightMax[i])-arr[i];
        }
        System.out.println(trapped_water);

    }

    public static void main(String[] args) {
       int height[]={0,1,0,2,1,0,1,3,2,1,2,1};
       rainwater(height);
    }
}
