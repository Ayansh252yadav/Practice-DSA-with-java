package OnlinePlatform;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PathCrossing1496 {
    public boolean isPathCrossing(String path) {
       Set<List<Integer>> set = new HashSet<>();
        int x=0;
        int y=0;
      set.add(Arrays.asList(x,y));
        for(char ch:path.toCharArray()){
            if(ch=='N'){
                y++;
            }
            if(ch=='S'){
                y--;
            }
            if(ch=='E'){
                x++;
            }
            if(ch=='W'){
                x--;
            }
            if(set.contains(Arrays.asList(x,y))){
                return true;
            }
           set.add(Arrays.asList(x,y));
        }
        return false;
    }
}
