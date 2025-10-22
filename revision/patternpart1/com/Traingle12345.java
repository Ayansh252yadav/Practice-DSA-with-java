package revision.patternpart1.com;

public class Traingle12345 {
    public static void Triangle123(int n){
        for(int i=n;i>0;i--){
            for(int j=1;j<=i;j++){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Triangle123(5);
    }
}
