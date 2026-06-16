package OnlinePlatform;

public class LeetcodePeakNAdValley3751 {
    public boolean isPeak(String s){
        return s.charAt(0) < s.charAt(1) && s.charAt(1) > s.charAt(2);
    }
    public boolean isValley(String s){
        return s.charAt(0) > s.charAt(1) && s.charAt(1) < s.charAt(2);
    }
    public int isValleyOrPeak(int n){
        String str=Integer.toString(n);
        int count=0;
        for(int i=0;i<=str.length()-3;i++){
            String s=str.substring(i, i + 3);
            if(isValley(s)){
                count++;
            }
            else if(isPeak(s)){
                count++;
            }
        }
        return count;
    }
    public int totalWaviness(int num1, int num2) {
        int count=0;
        for(int i=num1;i<=num2;i++){
            if(i>=100){
                count+=  isValleyOrPeak(i);
            }
        }
        return count;
    }
    public static void main(String[] args) {
        LeetcodePeakNAdValley3751 lt=new LeetcodePeakNAdValley3751();
        System.out.println(lt.totalWaviness(120,130));
    }
}
