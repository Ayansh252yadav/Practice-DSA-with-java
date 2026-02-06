package SimpleArrayProblem;

public class TrionicArray {
    public static boolean isTrionic(int arr[]){
        int n=arr.length;
        if(n<3){
            return false;
        }
        int i=1;
        while(i<n && arr[i]>arr[i-1]){
            i++;
        }
        if (i == 1 || i == n) return false;

        while(i<n && arr[i]<arr[i-1]){
            i++;
        }
        if (i == 1 || i == n) return false;
        while(i<n && arr[i]>arr[i-1]){
            i++;
        }

        if(n==i){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int arr[]={1,3,5,4,2,6};
        System.out.println(isTrionic(arr));
    }
}
