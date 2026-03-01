package OnlinePlatform;

public class PartioningIntoMinimum1689 {

    public static int minPartitions(String n) {
      int min=0;
        for(int i=0;i<n.length();i++){
            int temp=n.charAt(i)-'0';
            if(temp>min){
                min=temp;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        System.out.println(minPartitions("27346209830709182346"));
    }
}
