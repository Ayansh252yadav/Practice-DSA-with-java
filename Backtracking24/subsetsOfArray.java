package Backtracking24;
import java.util.ArrayList;
import java.util.List;

public class subsetsOfArray {
    public static ArrayList<ArrayList<Integer>> subset(int[] num, int i, ArrayList<ArrayList<Integer>> newArr, ArrayList<Integer>help) {
        if (i == num.length) {
            newArr.add(new ArrayList<>(help));
            return newArr;
        }
        //include
            help.add(num[i]);
            subset(num, i + 1, newArr, help);
            //exclude
            help.remove(help.size() - 1);
            subset(num, i + 1, newArr, help);
        return newArr;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        ArrayList<ArrayList<Integer>> newArr = new ArrayList<>();
        ArrayList<Integer> help = new ArrayList<>();

        ArrayList<ArrayList<Integer>> ans = subset(arr, 0, newArr, help);
        System.out.println(ans);
    }

}
//leetcode 78
class Solution1 {
    public static void subset(int[] num, int i,List<List<Integer>> newArr, ArrayList<Integer>help) {
        if (i == num.length) {
            newArr.add(new ArrayList<>(help));
            return ;
        }
        //include
        help.add(num[i]);
        subset(num, i + 1, newArr, help);
        //exclude
        help.remove(help.size() - 1);
        subset(num, i + 1, newArr, help);

    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> newArr = new ArrayList<>();
        ArrayList<Integer> help = new ArrayList<>();

        subset(nums, 0, newArr, help);
        return newArr;

    }
}
//gfg
class Solution {
    public static void subset(int[] num, int i,ArrayList<ArrayList<Integer>> newArr, ArrayList<Integer>help) {
        if (i == num.length) {
            newArr.add(new ArrayList<>(help));
            return ;
        }
        //include
        help.add(num[i]);
        subset(num, i + 1, newArr, help);
        //exclude
        help.remove(help.size() - 1);
        subset(num, i + 1, newArr, help);

    }

    public ArrayList<ArrayList<Integer>> subsets(int[] nums) {
        ArrayList<ArrayList<Integer>> newArr = new ArrayList<>();
        ArrayList<Integer> help = new ArrayList<>();

        subset(nums, 0, newArr, help);
        return newArr;

    }
}
