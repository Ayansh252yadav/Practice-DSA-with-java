package OnlinePlatform;

import java.util.*;

public class BlockPlacementQuery3161 {
    public static List<Boolean> getResults(int[][] queries) {
     TreeSet<Integer> set=new TreeSet<>();
     List<Boolean> ls=new ArrayList<>();
     set.add(0);
     for(int []temp:queries){
         ArrayList<Integer>arr=new ArrayList<>();
         if(temp[0]==1){
             set.add(temp[1]);
         }
         else if(temp[0]==2) {
             boolean chotuTrack=false;
             if(!set.contains(temp[1])){
                 chotuTrack=true;
                 set.add(temp[1]);
             }
             Iterator<Integer> it = set.iterator();
             while (it.hasNext()) {
                 int t = it.next();
                 if (t == temp[1]) {
                     arr.add(t);
                     break;
                 }
                 arr.add(t);
             }
             if(chotuTrack){
                 set.remove(temp[1]);
             }
             boolean track=false;
             for (int i = 0; i < arr.size() - 1; i++) {
                 if (Math.abs(arr.get(i) - arr.get(i + 1)) >= temp[2]) {
                     track=true;
                     ls.add(true);
                     break;
                 }
             }
             if (!track){
                 ls.add(false);
             }
         }
     }

     return ls;
    }
    public static void main(String[] args) {
       int [][] queries = {{1,7},{2,7,6},{1,2},{2,7,5},{2,7,6}};
        System.out.println(getResults(queries));
    }
}
