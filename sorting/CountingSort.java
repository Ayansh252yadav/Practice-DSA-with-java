package sorting.com;

public class CountingSort {
    public static void countingsort(int arr[]){
        int largest=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            largest=Math.max(largest,arr[i]);
        }
        int count[]=new int[largest+1];
        for(int i=0;i<arr.length;i++){
            count[arr[i]]++;
        }
        int k=0;
        for(int i=0;i< count.length;i++){
            while(count[i]!=0){
                arr[k]=i;
                k++;
                count[i]--;
            }
        }
    }

    public static void main(String[] args) {
        int arr[]={5,4,3,1,2};
        countingsort(arr);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
