package Array2D.com;

import java.util.ArrayList;

public class SpiralMatrix {
    public static void spiral(int Mat[][]){
        int n=Mat.length;
        int m=Mat[0].length;
        int stRow=0;
        int enRow=n-1;
        int stCol=0;
        int enCol=m-1;
        while (stRow<=enRow && stCol<=enCol){
            // top of matrix
            for(int top=stCol;top<=enCol;top++){
                System.out.print(Mat[stRow][top]+" ");
            }
            //right of the Matrix
            for(int right=stRow+1;right<=enRow;right++){
                System.out.print(Mat[right][enCol]+" ");
            }
            //bottom of the matrix
            for(int bottom=enCol-1;bottom>=stCol;bottom--){
                if(stRow==enRow){
                    break;
                }
                System.out.print(Mat[enRow][bottom]+" ");
            }
            //left of the matrix
            for(int left=enRow-1;left>=stRow+1;left--){
                if(stCol==enCol){
                    break;
                }
                System.out.print(Mat[left][stCol]+" ");
            }
            stRow++;
            enRow--;
            stCol++;
            enCol--;
        }
    }

    public static void main(String[] args) {
        int Matrix[][]= {{3, 3, 4,},
                {1 ,2, 3},
                {4 ,5 ,6},
                {7 ,8, 9}};
//        ArrayList<Integer>arr=new ArrayList<>();
        spiral(Matrix);

    }
}


//    Given a matrix with n rows and m columns. Your task is to find the kth element which is obtained
//    while traversing the matrix spirally. You need to complete the method findK which takes four arguments
//    the first argument is the matrix A and the next two arguments will be n and m denoting the size of
//    the matrix A and then the forth argument is an integer k.
//    The function will return the kth element obtained while traversing the matrix spirally.
//Input:
//n = 4, m = 4, k = 10
//A[][] = {{1  2  3  4},
//        {5  6  7  8},
//        {9  10 11 12},
//        {13 14 15 16}}
//Output:13
//Explanation:
//The spiral order of matrix will look like 1->2->3->4->8->12->16->15->14->13->9->5->6->7->11->10.
// So the 10th element in this order is 13
class Solution1 {
    public static int  spiral(int Mat[][],int n,int m,int k){
        // int n=Mat.length;
        // int m=Mat[0].length;
        int stRow=0;
        int enRow=n-1;
        int stCol=0;
        int enCol=m-1;
        int arr[]=new int[m*n];
        int i=0;
        while (stRow<=enRow && stCol<=enCol){
            // top of matrix
            for(int top=stCol;top<=enCol;top++){
                arr[i]=Mat[stRow][top];
                i++;
            }
            //right of the Matrix
            for(int right=stRow+1;right<=enRow;right++){
                arr[i]=Mat[right][enCol];
                i++;
            }
            //bottom of the matrix
            for(int bottom=enCol-1;bottom>=stCol;bottom--){
                if(stRow==enRow){
                    break;
                }
                arr[i]=Mat[enRow][bottom];
                i++;
            }
            //left of the matrix
            for(int left=enRow-1;left>=stRow+1;left--){
                if(stCol==enCol){
                    break;
                }
                arr[i]=Mat[left][stCol];
                i++;
            }
            stRow++;
            enRow--;
            stCol++;
            enCol--;
        }
        return arr[k-1];
    }

    int findK(int a[][], int n, int m, int k) {
        // Your code goes here
        return spiral(a,n,m,k);
    }
}

//You are given a rectangular matrix mat[][] of size n x m, and your task is to return an array while traversing the matrix in spiral form.
//
//Examples:
//
//Input: mat[][] = [[1, 2, 3, 4], [5, 6, 7, 8], [9, 10, 11, 12], [13, 14, 15, 16]]
//Output: [1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10]
//Explanation:
class Solution2{
    public static ArrayList<Integer>  spiral(int Mat[][]){
        int n=Mat.length;
        int m=Mat[0].length;
        int stRow=0;
        int enRow=n-1;
        int stCol=0;
        int enCol=m-1;
        ArrayList<Integer>arr=new ArrayList<>();

        while (stRow<=enRow && stCol<=enCol){
            // top of matrix
            for(int top=stCol;top<=enCol;top++){
                arr.add(Mat[stRow][top]);

            }
            //right of the Matrix
            for(int right=stRow+1;right<=enRow;right++){
                arr.add(Mat[right][enCol]);

            }
            //bottom of the matrix
            for(int bottom=enCol-1;bottom>=stCol;bottom--){
                if(stRow==enRow){
                    break;
                }
                arr.add(Mat[enRow][bottom]);

            }
            //left of the matrix
            for(int left=enRow-1;left>=stRow+1;left--){
                if(stCol==enCol){
                    break;
                }
                arr.add(Mat[left][stCol]);

            }
            stRow++;
            enRow--;
            stCol++;
            enCol--;
        }
        return arr;
    }

    public ArrayList<Integer> spirallyTraverse(int[][] mat) {
        // code here
        return spiral(mat);
    }
}

//Given a matrix of size N x M. You have to find the Kth element which will obtain while traversing the matrix
// spirally starting from the top-left corner of the matrix.
//
//        Example 1:
//
//Input:
//N = 3, M = 3, K = 4
//A[] = {{1, 2, 3},
//        {4, 5, 6},
//        {7, 8, 9}}
//Output:
//        6
//Explanation: Spiral traversal of matrix:
//        {1, 2, 3, 6, 9, 8, 7, 4, 5}. Fourth element
//is 6.
// User function Template for Java

class Solution3{
    public static int  spiral(int Mat[][],int k){
        int n=Mat.length;
        int m=Mat[0].length;
        int stRow=0;
        int enRow=n-1;
        int stCol=0;
        int enCol=m-1;
        int arr[]=new int[m*n];
        int i=0;
        while (stRow<=enRow && stCol<=enCol){
            // top of matrix
            for(int top=stCol;top<=enCol;top++){
                arr[i]=Mat[stRow][top];
                i++;
            }
            //right of the Matrix
            for(int right=stRow+1;right<=enRow;right++){
                arr[i]=Mat[right][enCol];
                i++;
            }
            //bottom of the matrix
            for(int bottom=enCol-1;bottom>=stCol;bottom--){
                if(stRow==enRow){
                    break;
                }
                arr[i]=Mat[enRow][bottom];
                i++;
            }
            //left of the matrix
            for(int left=enRow-1;left>=stRow+1;left--){
                if(stCol==enCol){
                    break;
                }
                arr[i]=Mat[left][stCol];
                i++;
            }
            stRow++;
            enRow--;
            stCol++;
            enCol--;
        }
        return arr[k-1];
    }

    public int findK(int a[][], int n, int m, int k) {
        // Your code goes here
        return spiral(a,k);
    }
}

//Given a matrix as 2D array. Find the reverse spiral traversal of the matrix.
//
//Example 1:
//
//Input: R = 3, C = 3
//a = {{9, 8, 7},
//        {6, 5, 4},
//        {3, 2, 1}}
//Output: 5 6 3 2 1 4 7 8 9
//Explanation: Spiral form of the matrix
//in reverse order starts from the centre
//and goes outward.

// User function Template for Java
class Solution {
    public static int[]  spiral(int r,int c,int Mat[][]){
        int n=Mat.length;
        int m=Mat[0].length;
        int stRow=0;
        int enRow=n-1;
        int stCol=0;
        int enCol=m-1;
        int  arr[]=new int [m*n];
        int i=0;
        while (stRow<=enRow && stCol<=enCol){
            // top of matrix
            for(int top=stCol;top<=enCol;top++){
                arr[i]=Mat[stRow][top];
                i++;
            }
            //right of the Matrix
            for(int right=stRow+1;right<=enRow;right++){
                arr[i]=Mat[right][enCol];
                i++;
            }
            //bottom of the matrix
            for(int bottom=enCol-1;bottom>=stCol;bottom--){
                if(stRow==enRow){
                    break;
                }
                arr[i]=Mat[enRow][bottom];
                i++;
            }
            //left of the matrix
            for(int left=enRow-1;left>=stRow+1;left--){
                if(stCol==enCol){
                    break;
                }
                arr[i]=Mat[left][stCol];
                i++;
            }
            stRow++;
            enRow--;
            stCol++;
            enCol--;
        }
        int start = 0, end = arr.length - 1;
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        return arr;
    }
    public int[] reverseSpiral(int R, int C, int[][] a) {
        // code here
        return spiral(R,C,a);
    }
}