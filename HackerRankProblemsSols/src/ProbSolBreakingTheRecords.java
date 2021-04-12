	import java.io.*;
	import java.util.*;

	public class ProbSolBreakingTheRecords {

	    // my function@
	    static int[] breakingRecords(int[] scores) {
	        int min = scores[0];    int max = min;
	        int minX = 0 ;
	        int maxX = 0;
	        for(int i = 1; i <scores.length; i++){
	            if(scores[i]< min) {
	                min = scores[i];    minX++;
	            }
	            if(scores[i]>max)  {
	                max = scores[i];    maxX++;
	            }
	        }
	        int [] maxAndMin = new int[2];
	        maxAndMin[0] = maxX;
	        maxAndMin[1] = minX;
	        return maxAndMin;
	    }

	    private static final Scanner scanner = new Scanner(System.in);

	    public static void main(String[] args) throws IOException {
	        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

	        int n = scanner.nextInt();
	        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

	        int[] scores = new int[n];

	        String[] scoresItems = scanner.nextLine().split(" ");
	        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

	        for (int i = 0; i < n; i++) {
	            int scoresItem = Integer.parseInt(scoresItems[i]);
	            scores[i] = scoresItem;
	        }

	        int[] result = breakingRecords(scores);

	        for (int i = 0; i < result.length; i++) {
	            bufferedWriter.write(String.valueOf(result[i]));

	            if (i != result.length - 1) {
	                bufferedWriter.write(" ");
	            }
	        }

	        bufferedWriter.newLine();

	        bufferedWriter.close();

	        scanner.close();
	    }
}
