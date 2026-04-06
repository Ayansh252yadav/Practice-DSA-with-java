package OnlinePlatform;

import java.util.HashSet;
import java.util.Set;

public class WalkingRobotSimulation874 {
    public static int robotSim(int[] commands, int[][] obstacles) {
    int [][]dirs={{0,1},{1,0},{0,-1},{-1,0}};
//               North   East   South   West

    int dir=0;
        Set<String>obs=new HashSet<>();
        for(int []ob:obstacles){
            obs.add(ob[0]+" ,"+ob[1]);
        }
        int x=0;
        int y=0;
        int maxDist=0;
        for(int cmd:commands){
            if(cmd==-1){
                //turn right
                dir=(dir+1)%4;
            }else if(cmd==-2){
                //turn right
                dir=(dir+3)%4;
            }else{
                for(int i=0;i<cmd;i++){
                    int nx=x+dirs[dir][0];
                    int ny=y+dirs[dir][1];
                    if(obs.contains(nx+" ,"+ny)){
                        break;
                    }
                    x=nx;
                    y=ny;
                    maxDist=Math.max(maxDist,x*x+y*y);
                }
            }
        }
        return maxDist;
  }

    public static void main(String[] args) {
        int []commands={4,-1,3};
        int [][]obstacles={{0,0}};
        System.out.println(robotSim(commands,obstacles));
    }
}
