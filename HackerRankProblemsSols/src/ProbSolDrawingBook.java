
import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class ProbSolDrawingBook {
//start of @
    static int pageCount(int n, int p) {
        int flips = 0;
      //start from left
      if(n/2>=p)
      for(int i = 1 ; i <= p ; i = i+2){
          if(i >= p)    break;
          flips++;
      }
      //start from right
      else
      for(int i = n ; i >=p ; i = i-2){
          if(i <= p)    break;
          if(i-1 <= p && n%2 != 0)    break;
          flips++;
      }
      return flips;
    }
//end of@
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        int p = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        int result = pageCount(n, p);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
