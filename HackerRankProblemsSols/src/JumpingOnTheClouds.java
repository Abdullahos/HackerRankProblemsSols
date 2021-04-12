import java.io.*;
import java.util.*;

public class JumpingOnTheClouds {

    static int jumpingOnClouds(int[] c, int k) {
        
        int n  = c.length;
        int current = 0;
        int nextIndex = 0;
        int e = 100;
        while(true){
            nextIndex = (current+k)%n;
            //rotating
            if(nextIndex<=current) {
                    if( c[0]==1 )   e = e-3;
                    else    e--; 
                    break;
            }
            //not rotating
            if(c[nextIndex] == 1)   e = e-3;
            else    e--;
        
            current  = nextIndex;
        }
    return e;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int result = jumpingOnClouds(c, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
