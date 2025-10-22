package revision.patternpart1.com;

public class DiamondPattern {
    public static void Diamond(int n){

        for(int i=0;i<=n;i++){
            for(int k=n-i+1;k>0;k--){
                System.out.print(" ");
            }
            for(int j=0;j<i;j++){
                System.out.print(" *");
            }
            System.out.println();
        }
        for(int i=n;i>=1;i--){
            for(int k=n-i+1;k>0;k--){
                System.out.print(" ");
            }
            for(int j=0;j<i;j++){
                System.out.print(" *");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        Diamond(2);
    }
}
