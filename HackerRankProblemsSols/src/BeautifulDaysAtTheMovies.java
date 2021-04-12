
import java.io.*;
import java.util.*;

public class BeautifulDaysAtTheMovies {
    //evenly divisible===remainder==0
    //is the first day in range,j is the last one, k is the demonimator
    static int beautifulDays(int i, int j, int k) {
        int counter = 0;
        while(i<=j){
            int rev;
            String revNum = String.valueOf(i);
            StringBuilder str = new StringBuilder("0");
            //reverse
            for(int x = 0 ; x < revNum.length(); x++){
                str = str.append(revNum.charAt(revNum.length()-1-x));
            }
            //convert to integer
            rev = Integer.parseInt(str.toString());
            //check if it beautiful day
            if( (Math.abs(i-rev))%k == 0)  counter++;
            i++;
        }
        return counter;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] ijk = scanner.nextLine().split(" ");

        int i = Integer.parseInt(ijk[0]);

        int j = Integer.parseInt(ijk[1]);

        int k = Integer.parseInt(ijk[2]);

        int result = beautifulDays(i, j, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

