package BinaryTree32;


import java.util.ArrayList;
import java.util.Arrays;

public class Fruits3477{
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        for (int fruit : fruits) {
            for (int j = 0; j < baskets.length; j++) {
                if (baskets[j] >= fruit) {
                    baskets[j] = -1;
                    break;
                }
            }
        }
       int cout=0;
        for (int basket : baskets) {
            if (basket != -1) {
                cout++;
            }
        }
       return cout;
    }

    public static void main(String[] args) {
        int[]fruit={4,2,5};
        int[]basket={3,5,4};
        Fruits3477 fr=new Fruits3477();
        System.out.println(fr.numOfUnplacedFruits(fruit,basket));
    }
}