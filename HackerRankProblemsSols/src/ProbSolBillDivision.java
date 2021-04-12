
import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

public class ProbSolBillDivision {

    // start@
    static void bonAppetit(List<Integer> bill, int k, int b) {
        int actual = 0 ; 
        for(int i = 0; i < bill.size(); i++){
            if(i!= k)
            actual = actual + bill.get(i);
        }
        actual = actual/2;
        int diff = b - actual;
        if(diff == 0)   System.out.println("Bon Appetit");
        else    System.out.println(diff);
    }
//end @
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] nk = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        List<Integer> bill = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int b = Integer.parseInt(bufferedReader.readLine().trim());

        bonAppetit(bill, k, b);

        bufferedReader.close();
    }
}