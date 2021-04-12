
import java.io.*;
import java.util.*;
	    // start@public 
class ProbSolvDivisibleSumPairs {
	    static int divisibleSumPairs(int n, int k, int[] ar) {
	        int counter = 0;
	        for(int  i = 0 ; i < n-1 ; i++){
	            for(int j = i+1 ; j < n; j++){
	                if( (ar[i]+ar[j])%k == 0 )  counter++;
	            }
	        }
	    return counter;
	    }
	    //end@
	    private static final Scanner scanner = new Scanner(System.in);

	    public static void main(String[] args) throws IOException {
	        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

	        String[] nk = scanner.nextLine().split(" ");

	        int n = Integer.parseInt(nk[0]);

	        int k = Integer.parseInt(nk[1]);

	        int[] ar = new int[n];

	        String[] arItems = scanner.nextLine().split(" ");
	        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

	        for (int i = 0; i < n; i++) {
	            int arItem = Integer.parseInt(arItems[i]);
	            ar[i] = arItem;
	        }

	        int result = divisibleSumPairs(n, k, ar);

	        bufferedWriter.write(String.valueOf(result));
	        bufferedWriter.newLine();

	        bufferedWriter.close();

	        scanner.close();
	    }
	}
