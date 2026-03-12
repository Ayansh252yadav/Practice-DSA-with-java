package OnlinePlatform;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class AssighnCookie455 {
    public static int findContentChildren(int[] g, int[] s) {
    int count=0;
    int i=0;
    int j=0;
        Arrays.sort(g);
        Arrays.sort(s);
    while(i<s.length && j<g.length){
        if(s[i]>=g[j]){
            count++;
            i++;
            j++;
        }else{
            i++;
        }
    }
    return count;
    }

    public static void main(String[] args) {
        int []g = {10,9,8,7}, s = {5,6,7,8};
        System.out.println(findContentChildren(g,s));
    }
}
