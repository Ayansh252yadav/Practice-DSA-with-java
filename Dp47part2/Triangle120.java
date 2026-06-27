package Dp47part2;

import java.util.List;

public class Triangle120 {
    public int helper(List<List<Integer>> triangle,int row,int col){
     if(row==triangle.size()-1){
         return triangle.get(row).get(col);
     }
     int left=helper(triangle,row+1,col);
     int right=helper(triangle ,row+1,col+1);
     return triangle.get(row).get(col)+Math.min(left,right);
    }
    public int minimumTotal(List<List<Integer>> triangle) {
    return helper(triangle,0,0);
    }

    public static void main(String[] args) {
        int [][]triangle={{2},{3,4},{6,5,7},{4,1,8,3}};
        Triangle120 tr=new Triangle120();
//        System.out.println(tr.minimumTotal());
    }
}
