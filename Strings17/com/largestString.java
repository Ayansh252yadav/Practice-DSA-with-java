package Strings17.com;

public class largestString {
    public static void main(String[] args) {
        String fruit[]={"apple","mango","banAna"};
        String largest=fruit[0];
        for(int i=1;i<fruit.length;i++){
            if(largest.compareToIgnoreCase(fruit[i])<0){
                largest=fruit[i];
            }
        }
        System.out.println(largest);
        StringBuilder sb =new StringBuilder();
        for(char ch='a';ch<='z';ch++){
            sb.append(ch);
            sb.append(" ");
        }
        System.out.println(sb);
        System.out.println(toUppercase("hi i am ayansh"));
    }
    public static String toUppercase(String str){
        StringBuilder sb=new StringBuilder();
        char ch=Character.toUpperCase(str.charAt(0));
        sb.append(ch);
        for(int i=1;i<str.length();i++){
            if(str.charAt(i)==' ' && i<str.length()){
                sb.append(str.charAt(i));
                i++;
                sb.append(Character.toUpperCase(str.charAt(i)));
            }else{
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }
}
