import java.io.*;
import java.util.*;

public class SherlockAndSquares {

    // Complete the squares function below.
    static int squares(int a, int b) {
        int no = a;
        int noOfSqrs = 0;
        int diff = 0;
        int first = a;
        int last = 0;
        while(no<=b){
            double res = Math.sqrt(no);
            int test = (int)res;
            if(res-test == 0)   {
                noOfSqrs++;
                
                if(noOfSqrs == 1)  { last = no;  no++;}
                else{
                    diff = no - last;
                    last = no;
                    no = no + diff+2;
                }
            }
            
            else no++;
        }
        return noOfSqrs;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] ab = scanner.nextLine().split(" ");

            int a = Integer.parseInt(ab[0]);

            int b = Integer.parseInt(ab[1]);

            int result = squares(a, b);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}

