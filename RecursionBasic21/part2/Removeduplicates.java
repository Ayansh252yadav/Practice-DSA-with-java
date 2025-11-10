package RecursionBasic21.part2;

public class Removeduplicates {
    public static void reoveduplicates(String str,StringBuilder newstr,int index,boolean map[]){
        if(index==str.length()){
            System.out.println(newstr);
            return;
        }
        char currentchar=str.charAt(index);
        if(map[currentchar-'a']==true){
            reoveduplicates(str,newstr,index+1,map);
        }else{
            map[currentchar-'a']=true;
            reoveduplicates(str,newstr.append(currentchar),index+1,map);
        }
    }

    public static void main(String[] args) {
        String str="appnnacollege";
        boolean map[]=new boolean[26];
        reoveduplicates(str,new StringBuilder(""),0,map);
    }
}
