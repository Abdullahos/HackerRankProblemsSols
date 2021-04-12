import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class ChocholateFeast {

    // Complete the chocolateFeast function below.
    //n money he has, c cost of one bar, m amount of Wrappers to exchange
    static int chocolateFeast(int n, int c, int m) {
        //can't effort any bars
        if(n<m) return 0;
        //can effort at least 1
        int eatedBars = 0;
        int wrappers = 0;
        //buy with all money he has
        eatedBars = n/c;
        wrappers = eatedBars;
        while (true){
            //if the wrappers can't affort the exchange
            if(wrappers<m) return eatedBars;
            eatedBars = eatedBars+wrappers/m;   //eated + ex
            wrappers = wrappers/m + wrappers%m; //ex + rem
        }    

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] ncm = scanner.nextLine().split(" ");

            int n = Integer.parseInt(ncm[0]);

            int c = Integer.parseInt(ncm[1]);

            int m = Integer.parseInt(ncm[2]);

            int result = chocolateFeast(n, c, m);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
