package Divide.conquer.com;

public class MergeStrings {
    public static String merge(String s1,String s2){
        int n=s1.length();
        int m=s2.length();
        StringBuilder str=new StringBuilder("");
        int i=0;
        int j=0;
        while(i<n && j<m){
            str.append(s1.charAt(i));
            str.append(s2.charAt(j));
            i++;
            j++;
        }
        while(i<n){
            str.append(s1.charAt(i));
            i++;
        }
        while(j<m){
            str.append(s2.charAt(j));
            j++;
        }
        return str.toString();
    }

    public static void main(String[] args) {
        String s1="Hello";
        String s2="Bye";
        System.out.println(merge(s1,s2));
    }
}
