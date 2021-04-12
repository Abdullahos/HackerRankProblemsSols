import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class ArrayEqualizer {

    // Complete the equalizeArray function below.
    static int equalizeArray(int[] arr) {
        Hashtable <Integer, Integer> freqs  = new Hashtable<>();
        //counting freqs
        for(int i = 0; i < arr.length; i++ ){
            if(freqs.containsKey(arr[i])){
                int f = freqs.get(arr[i]);
                freqs.put(arr[i],f+1);
            }
            else{
                freqs.put(arr[i],1);
            }
        }
        int max = 1;
        for(int num : freqs.keySet()){
            if(freqs.get(num)>max)   
                max = freqs.get(num);        
        }
        return arr.length-max; 

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = equalizeArray(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
