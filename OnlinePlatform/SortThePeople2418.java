package OnlinePlatform;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortThePeople2418 {
    static class Node {
        int age;
        String name;
        Node(int age,String name){
            this.age=age;
            this.name=name;
        }
    }
    public static void main(String[] args) {
        String str[]={"Mary","John","Emma"};
        int []age={180,165,170};
        List<Node> list=new ArrayList<>();
        for(int i=0;i<str.length;i++){
            list.add(new Node(age[i],str[i]));
        }
        list.sort((a,b)->b.age-a.age);
        String res[]=new String[str.length];
        for(int i=0;i< str.length;i++){
            res[i]=list.get(i).name;
        }
        System.out.println(Arrays.toString(res));
    }
}
