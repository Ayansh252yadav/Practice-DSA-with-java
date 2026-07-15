package OnlinePlatform;

import java.util.*;

public class KeysAndRooms841 {
    public static void addKeys(List<Integer> keys,Set<Integer>key){
        for(Integer room:keys){
            key.add(room);
        }
    }
    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> keys=new HashSet<>();
        addKeys(rooms.get(0),keys);
        boolean flag=false;
        ArrayList<Integer> temp=new ArrayList<>();
     for(int i=1;i<rooms.size();i++){
             if(!keys.contains(i) && !rooms.get(i).isEmpty()){
                 temp.add(i);
                 flag=true;
         }else{
                 addKeys(rooms.get(i),keys);
             }
     }
        System.out.println(keys.add(0));
     for(int e:temp){
         if(!keys.contains(e)){
             flag=true;
             return false;
         }else{
             addKeys(rooms.get(e),keys);
             flag=false;
         }
     }
     if(flag){
         return false;
     }
     return true;
    }

    public static void main(String[] args) {
        List<List<Integer>> keys = new ArrayList<>();
//[[6,7,8],[5,4,9],[],[8],[4],[],[1,9,2,3],[7],[6,5],[2,3,1]]
        keys.add(Arrays.asList(6,7,8));
        keys.add(Arrays.asList(5,4,9));
        keys.add(Arrays.asList());
        keys.add(Arrays.asList(8));
        keys.add(Arrays.asList(4));
        keys.add(Arrays.asList());
        keys.add(Arrays.asList(1,9,2,3));
        keys.add(Arrays.asList(7));
        keys.add(Arrays.asList(6,5));
        keys.add(Arrays.asList(2,3,1));
        System.out.println(canVisitAllRooms(keys));
    }
}
