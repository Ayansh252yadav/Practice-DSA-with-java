package Hashing38;

import java.util.HashMap;
import java.util.Set;

public class IterateOverHashMap {
    public static void main(String[] args) {

        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("Apple", 1);
        hm.put("Mango", 2);
        hm.put("Banana", 3);
        hm.put("Leechi", 4);
        hm.put("Guava", 5);

        // iterate using keySet
        Set<String> keys = hm.keySet();

        for (String key : keys) {
            System.out.println(key + " -> " + hm.get(key));
        }
    }
}