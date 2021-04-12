
import java.io.*;
import java.util.*;
//if u tried to use loop it will take relative long time and exceed time limit.
public class SaveThePrisoner {
    //n prisons no, m candies, s start pos
    static int saveThePrisoner(int n, int m, int s) {
        int toEnd = n-s+1;
        if(m<=toEnd)  return toEnd;
        else{
            m = m-toEnd;
            //now i am @ 1st pos
            if(m>n && m%n ==0)  return n;
            else if(m>n)    return m%n;
            else    return m;
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] nms = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nms[0]);

            int m = Integer.parseInt(nms[1]);

            int s = Integer.parseInt(nms[2]);

            int result = saveThePrisoner(n, m, s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
