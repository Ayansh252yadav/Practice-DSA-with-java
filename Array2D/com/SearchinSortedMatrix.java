package Array2D.com;

import java.util.Arrays;
import java.util.Collections;

public class SearchinSortedMatrix {
    //brute force
    public static boolean SearchSorted(int mat[][],int target){
     for(int i=0;i<mat.length;i++){
         for(int j=0;j<mat[0].length;j++){
             if(mat[i][j]==target){
                 return true;
             }
         }
     }
     return false;
    }
    //optimized approach
    public static boolean search(int mat[][],int target){
        int row=0;
        int col=mat[0].length-1;
        while(row< mat.length && col>=0){
            if(mat[row][col]==target){
                return true;
            }else if(target<mat[row][col]){
                col--;
            }else{
                row++;
            }
        }
        return false;
    }
    public static void sortedMatrix( int mat[][]) {
        // code here
        int m=mat.length;
        int n=mat[0].length;
        int temp[]=new int[m*n];
        int index=0;
   for(int i=0;i<mat.length;i++){
       for(int j=0;j<mat[0].length;j++){
           temp[index]=mat[i][j];
           index++;
       }
   }
   index=0;
   Arrays.sort(temp);
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat.length;j++){
                mat[i][j]=temp[index];
                index++;
            }
        }
        System.out.println(Arrays.toString(temp));
    }
    public static void main(String[] args) {
//        int arr[][]={{1,2,3,4},
//                {5,6,7,8},
//                {9,10,11,12},
//                {13,14,15,16}};
//        System.out.println(SearchSorted(arr,13));
//        System.out.println(search(arr,0));
   int arr[][]=     {{10,20,30,40},
           {15,25,35,45},
           {27,29,37,48},
           {32,33,39,50}};
        sortedMatrix(arr);
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}
