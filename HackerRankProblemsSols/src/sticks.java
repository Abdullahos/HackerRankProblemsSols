
import java.io.*;
import java.util.*;

public class sticks { 
    static int getMin(int[] arr){
        int min = 1000;
        for(int  i = 0; i<arr.length; i++){
            if(arr[i]<min && arr[i] != 0)  min = arr[i];
        }
        return min;
    }
    // Complete the cutTheSticks function below.
    static Object[] cutTheSticks(int[] arr) {
        ArrayList<Integer>cuts = new ArrayList<Integer>();
        int min;
        int j = 0;
        int noOfCutts = 1000;
        while(true){
            noOfCutts = 0;
            min = getMin(arr);
            for(int i = 0; i<arr.length; i++){
                if(arr[i] != 0){
                    arr[i] = arr[i]-min;
                    noOfCutts++;
                }
            }
            if(noOfCutts ==0)   break;
            cuts.add(noOfCutts);
            j++;
        }
        Object []arrayOfCuts = new Object[cuts.size()];
        arrayOfCuts = cuts.toArray();
        return arrayOfCuts;
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

        Object[] result = cutTheSticks(arr);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
