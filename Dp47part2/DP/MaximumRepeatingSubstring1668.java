package Dp47part2.DP;

public class MaximumRepeatingSubstring1668 {
           static int cost=0;
        public static  void recursionMaxRepeating(String str1,String str2,int n,int m){
            if(n==0){
                return ;
            }
            if(str2.charAt(m-1)==str1.charAt(n-1)){
               m--;
               if(m==0){
                   cost++;
                   m=str2.length();
               }
            }else{
                m= str2.length();
            }
   recursionMaxRepeating(str1,str2,n-1,m);
    }
    public static int maxRepeating(String sequence, String word) {
        int n=sequence.length();
        int m=word.length();
        int [][]holder=new int[n+1][m+1];
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(sequence.charAt(i-1)==word.charAt(j-1)){
                    holder[i][j]=1+holder[i-1][j-1];
                }else{
                    holder[i][j]=holder[i-1][j];
                }
            }
        }
        return holder[n][m];
    }

    public static void main(String[] args) {
       String sequence = "ababc", word = "ac";
//        System.out.println(maxRepeating(sequence,word));
        cost=0;
        recursionMaxRepeating(sequence,word,sequence.length(),word.length());
        System.out.println(cost);
    }
}
