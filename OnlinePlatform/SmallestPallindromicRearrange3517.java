package OnlinePlatform;

public class SmallestPallindromicRearrange3517 {
    public String smallestPalindrome(String s) {
        int []freq=new int[26];
        for(char ch:s.toCharArray()){
            freq[ch-'a']++;
        }
        int odd=0;
        char mid=0;
        for(int i=0;i<26;i++){
             if(freq[i]%2==1){
                 odd++;
                 mid=(char)(i+'a');
            }
        }
        if(odd>1){
            return "";
        }
        StringBuilder left=new StringBuilder();
        for(int i=0;i<26;i++){
            for(int j=0;j<freq[i]/2;j++){
                left.append((char)(i+'a'));
            }
        }
        StringBuilder ans=new StringBuilder();
        ans.append(left);
        if(odd==1){
            ans.append(mid);
        }
        ans.append(left.reverse());
        return ans.toString();
    }
}
