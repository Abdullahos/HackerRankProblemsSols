import java.io.*;
import java.util.*;
public class BeatifulTriplets {

    static int beautifulTriplets(int d, int[] arr) {
        //no of beatiful triplets 
        int noOfTri = 0;
        for(int i = 0 ; i<arr.length-2; i++)
        //find @j
            for(int j= i+1; j<arr.length; j++){
                //if found @ j -> find @ k
                if(arr[j] - arr[i] == d){
                    //find @k
                    for(int k= j+1; k<arr.length; k++){
                        if(arr[k] - arr[j] == d)    noOfTri++;
                    }
                }
            }
            return noOfTri;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = beautifulTriplets(d, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
