
public class chess {

}
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the queensAttack function below.
    static int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles) {
        //compute the utopian no of squares:
        //l-> c-1
        //r-> n-c
        //up->n-r
        //down-> r-1
        //full 4 diagonals:        
        int nearestUp = n-r_q;
        int nearestDown = r_q-1;
        int nearestLeft = c_q-1;
        int nearestRight = n-c_q;
        
        int nearestDiaUpR;
        if(n-r_q>=n-c_q)    nearestDiaUpR = n-c_q;
        else            nearestDiaUpR= n-r_q;
        
        int nearestDiaUpL;
        if(n-r_q>=c_q-1)    nearestDiaUpL = c_q-1;
        else    nearestDiaUpL = n-r_q;
        
        int nearestDiaDownR;
        if(r_q-1>=n-c_q)    nearestDiaDownR = n-c_q;
        else    nearestDiaDownR = r_q-1;
        
        int nearestDiaDownL;
        if(r_q-1>=c_q-1)    nearestDiaDownL = c_q-1;
        else        nearestDiaDownL = r_q-1;
        
        //int utopian = c_q-1 + n- c_q + n-r_q + r_q-1;
        
        //to subtract the effected squares caused by obstacles:  
        for(int r = 0 ; r <k ; r++){
                //check if on same row of queen
                if(obstacles[r][0] == r_q){
                    //on left
                    if(obstacles[r][1] < c_q && c_q-obstacles[r][1]-1<nearestLeft)
                    nearestLeft = c_q-obstacles[r][1]-1;
                    //on right
                    else if(obstacles[r][1] > c_q && obstacles[r][1]-c_q-1 <nearestRight)
                    nearestRight = obstacles[r][1]-c_q-1;
                }
                //on same column
                else if(obstacles[r][1] == c_q){
                    //above?
                    if(obstacles[r][0] > r_q && obstacles[r][0]-r_q-1<nearestUp) 
                    nearestUp = obstacles[r][0]-r_q-1;
                    //under
                    else if( obstacles[r][0] < r_q &&  r_q-obstacles[r][0]-1<nearestDown)
                    nearestDown = r_q-obstacles[r][0]-1;
                }
                
                //if obs on diagonals:
                else if(Math.abs(obstacles[r][0]-r_q) == Math.abs(obstacles[r][1]-c_q)){
                    //dia up 
                    if(obstacles[r][0]>r_q){
                        //dia up R
                        if(obstacles[r][1]>c_q && Math.abs(obstacles[r][1]-c_q-1)<nearestDiaUpR)         {
                            nearestDiaUpR  = Math.abs(obstacles[r][1]-c_q-1);
                        }
                        //dia up l
                        else if(obstacles[r][1]>c_q && Math.abs(obstacles[r][1]-r_q-1)<nearestDiaUpL)         {
                        nearestDiaUpL  = Math.abs(obstacles[r][1]-c_q-1);
                        }
                    }
                       //dia down
                        else{
                            //down l
                            if(obstacles[r][1]<r_q && Math.abs(c_q-obstacles[r][1]-1)<nearestDiaDownL)           {
                                nearestDiaDownL = Math.abs(c_q-obstacles[r][1]-1);
                            }
                             //down r
                             else if(obstacles[r][1]>r_q && Math.abs(obstacles[r][1]-c_q-1)<nearestDiaDownR)    {
                                nearestDiaDownR = Math.abs(obstacles[r][1]-c_q-1);
                             }
                        }
                }
        }//for
        return nearestUp + nearestDown + nearestLeft+ nearestRight+ nearestDiaUpR + nearestDiaUpL + nearestDiaDownR + nearestDiaDownL;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        String[] r_qC_q = scanner.nextLine().split(" ");

        int r_q = Integer.parseInt(r_qC_q[0]);

        int c_q = Integer.parseInt(r_qC_q[1]);

        int[][] obstacles = new int[k][2];

        for (int i = 0; i < k; i++) {
            String[] obstaclesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int obstaclesItem = Integer.parseInt(obstaclesRowItems[j]);
                obstacles[i][j] = obstaclesItem;
            }
        }

        int result = queensAttack(n, k, r_q, c_q, obstacles);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
