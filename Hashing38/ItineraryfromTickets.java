package Hashing38;

import java.util.HashMap;

public class ItineraryfromTickets {
    public static String getstart(HashMap<String,String>tickets){
        HashMap<String,String>revMap=new HashMap<>();
        for(String key: tickets.keySet()){
            revMap.put(tickets.get(key),key);
        }
        for(String key: tickets.keySet()){
            if(!revMap.containsKey(key)){
                System.out.print(key+" ");
//                return key;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        HashMap<String,String>tickets=new HashMap<>();
        tickets.put("Chennai","Banglore");
        tickets.put("Mumbai","Delhi");
        tickets.put("Goa","Chennai");
        tickets.put("Delhi","Goa");
        String start=getstart(tickets);
        System.out.println(start);
    }
}
