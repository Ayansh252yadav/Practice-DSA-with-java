package OnlinePlatform;

public class RemoveElement {
    public static int remove(int num[],int val) {
        int k = 0;
        for (int i = 0; i < num.length; i++) {
            if (num[i] != val) {
                num[k] = num[i];
                k++;
            }
        }
        for(int i=0;i< num.length;i++){
            System.out.print(num[i]+" ");
        }
        System.out.println();
        return k;
    }
    public static void main(String[] args) {
        int nums[] = {3,2,2,3};
        int val = 3;

        System.out.println(remove(nums,val));
    }
}
