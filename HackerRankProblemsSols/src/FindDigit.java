import java.io.*;
import java.util.*;

public class FindDigit{
    static int findDigits(int n) {
        int counter = 0;
        String num = String.valueOf(n);
        for(int i = 0; i<num.length(); i++){
            try{
                if(n% Integer.parseInt(num.substring(i,i+1)) == 0) counter++;
            }
            catch(Exception ex){
                
            }
        }
        return counter;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int result = findDigits(n);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}

