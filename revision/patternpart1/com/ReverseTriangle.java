package revision.patternpart1.com;

public class ReverseTriangle {
    public static void Triangle(int n){
        int help=n-1;
         for(int i=0;i<n;i++){
             for(int k=0;k<i;k++){
                 System.out.print(" ");
             }
             for(int j=n+help-i;j>0;j--){
                     System.out.print("*");
             }
             help--;
             System.out.println();
         }
    }

    public static void main(String[] args) {
        Triangle(5);
    }
}
