package OnlinePlatform;

import java.util.Stack;

public class MaximiumRectangle85 {
    public void nsl(int []nsl,int []nums){
        Stack<Integer> stack=new Stack<>();
      for(int i=0;i<nums.length;i++){
          while(!stack.isEmpty()&&nums[stack.peek()]>=nums[i]){
               stack.pop();
          }
          if(stack.isEmpty()){
              nsl[i]=-1;
          }else{
              nsl[i]=stack.peek();
          }
          stack.push(i);
      }
    }
    public void nsr(int []nsr,int []nums){
        Stack<Integer> stack=new Stack<>();
        for(int i=nums.length-1;i>=0;i--){
        while(!stack.isEmpty()&&nums[stack.peek()]>=nums[i]){
        stack.pop();
        }
        if(stack.isEmpty()){
            nsr[i]=nums.length;
        }
        else{
            nsr[i]=stack.peek();
        }
        stack.push(i);
        }
    }


    public int maximalRectangle(char[][] matrix) {
        int maxArea=0;
      int []height=new int[matrix[0].length];
      for(int i=0;i<matrix.length;i++){
          for(int j=0;j<matrix[0].length;j++) {
              if (matrix[i][j] == '1') {
                 height[j]++;
              }else{
                  height[j]=0;
              }
          }
         int []nsl=new int[matrix[0].length];
          nsl(nsl,height);
          int []nsr=new int[matrix[0].length];
          nsr(nsr,height);
          for(int k=0;k<height.length;k++){
              int hght=height[k];
              int width=nsr[k]-nsl[k]-1;
              int currArea=hght*width;
              maxArea=Math.max(maxArea,currArea);
          }
      }
      return maxArea;
    }
}
