
import java.io.*;
import java.util.*;

public class MinimumDistance {


    // Complete the minimumDistances function below.
    static int minimumDistances(int[] a) {
        //initilaize with max possible value
        int min = a.length;
        //to hold elem(s) which already taken
        ArrayList <Integer> isTaken = new ArrayList <Integer>(a.length);
        //find matched pairs and map them to their indecies
        //get the least distance pairs
        //repeate but exiplict the checked 
        for(int i = 0; i< a.length-1; i ++){
            if(! isTaken.contains(a[i]) ){
                //updating isTaken
                isTaken.add(a[i]);
                //to hold the indecies of the matched elems
                ArrayList<Integer>indecies = new ArrayList<Integer>();
                int lastIndex = 0;
                //adding the index of the first occurecnce.
                indecies.add(i);
                for(int j = i+1; j < a.length; j++){
                    //if they are matched
                    if(a[i] == a[j]){
                        //add index of the matched one
                        indecies.add(j);
                        //to limit the time for parsing
                        lastIndex++;
                    }
                }
                //to get least distance of these pairs
                for(int x = 0; x <lastIndex; x++){
                    if(indecies.get(x+1)-indecies.get(x)<min)   min = indecies.get(x+1)-indecies.get(x);
                }
            }
        }
        if(min==a.length)   return -1;
        else    return min;  
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int result = minimumDistances(a);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
