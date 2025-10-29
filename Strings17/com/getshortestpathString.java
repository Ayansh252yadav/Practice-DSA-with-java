package Strings17.com;

public class getshortestpathString {
    public static     double shortestPath(String Str) {
            // your code here
            int x=0;
            int y=0;
            for(int i=0;i<Str.length();i++){
                char dir=Str.charAt(i);
                //east
                if(dir=='E'){
                    x++;
                }
                //west
                else if(dir=='W'){
                    x--;
                }
                //north
                else if(dir=='N'){
                    y++;
                }
                //south
                else {
                    y--;
                }
            }
            return Math.sqrt(Math.pow(x,2)+Math.pow(y,2));
        }

    public static void main(String[] args) {
        System.out.println(shortestPath("WNEENESENNN"));
    }
}
