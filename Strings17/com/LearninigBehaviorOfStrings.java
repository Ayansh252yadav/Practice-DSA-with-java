package Strings17.com;

public class LearninigBehaviorOfStrings {
    public static void main(String[] args) {
        String s1="Tony";
        String s2="Tony";
        String s3=new String("Tony");
        System.out.println(s3.substring(0,2));
        if(s1==s2){
            System.out.println("equal");
        }else {
            System.out.println("non equal");
        }
        if(s1==s3){
            System.out.println("s1 and s3 are equal");
        }
        else{
            System.out.println("s1 and s3 are not equal");
        }
        if(s1.equals(s3)){
            System.out.println("s1 and s3 are equal using method s1.equals(s3)");
        }else{
            System.out.println("not equal");
        }
        int temp=s1.compareTo(s2);
        System.out.println(temp);
    }
}
