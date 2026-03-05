package OnlinePlatform;



public class MinimumChanges1758 {
    public static int minOperations(String s) {
       int right=s.length()-1;
       int left=0;
       int count=0;
       while (left<=right){
           if(s.charAt(left)==s.charAt(right)){
               count++;
           }
           left++;
           right--;
       }
       return count;
    }
 public static int minOperation(String s){
        int count1=0;
        int count2=0;
        for (int i=0;i<s.length();i++){
            char expected1=(i%2==0)?'0':'1';
            char expected2=(i%2==0)?'1':'0';
            if(s.charAt(i)!=expected1){
                count1++;
            }
            if(s.charAt(i)!=expected2){
                count2++;
            }
        }
        return Math.min(count2,count1);
 }
    public static void main(String[] args) {
        String s="10010100";
        System.out.println(minOperation(s));
    }
}
