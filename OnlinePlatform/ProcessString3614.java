package OnlinePlatform;

public class ProcessString3614 {
    public char processStr(String s, long k) {
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(Character.isLowerCase(ch)){
                sb.append(ch);
            }
            else if(ch=='*' && !sb.isEmpty()){
                sb.deleteCharAt(sb.length()-1);
            }
            else if(ch=='#'){
                sb.append(sb);
            }
            else if(ch=='%'){
                sb.reverse();
            }
        }
        String temp=sb.toString();
        if(k<temp.length()){
            return temp.charAt((int)k);
        }
        return '.';
    }

    public static void main(String[] args) {
        String s = "*mi#";
        long k = 442;
        ProcessString3614 ps=new ProcessString3614();
        System.out.println(ps.processStr(s,k));
    }
}
