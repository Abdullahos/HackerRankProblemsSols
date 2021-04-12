import java.io.*;
import java.util.*;

public class ViralAdevertising {
	static int viralAdvertising(int n) {
	        int shared = 5;
	        int dayLikes;
	        int cum = 0;   
	        for(int i = 0 ; i < n ; i++){
	            dayLikes = shared/2;
	            cum = cum + dayLikes;
	            shared = dayLikes*3;
	        }
	        return cum;
    }
	private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {	
    	BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
    	
	    int n = scanner.nextInt();
	    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

	    int result = viralAdvertising(n);
	        
	    bufferedWriter.write(String.valueOf(result));
	    bufferedWriter.newLine();
	    bufferedWriter.close();

	    scanner.close();
	}
}

