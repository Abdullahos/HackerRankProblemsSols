
import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

public class ProbSolMigratoryBirds {
    //start@
    static int getMostOcc(HashMap<Integer,Integer>freqs){
        int maxFreq = 0;
        int mostBird = 0;
        for(int birds : freqs.keySet()){
            if(freqs.get(birds) > maxFreq){
                maxFreq = freqs.get(birds);
                mostBird =  birds;
            }
            else if(freqs.get(birds) == maxFreq){
                if(birds<mostBird)  mostBird = birds;
            }
        }
        return mostBird;
    }
    static int migratoryBirds(List<Integer> arr) {
        HashMap<Integer,Integer>freqs = new HashMap<Integer,Integer>();
        for(int i = 0 ; i < arr.size(); i++){
            if(freqs.containsKey(arr.get(i))){
                int freq = freqs.get(arr.get(i));
                freq = freq + 1 ;
                freqs.put(arr.get(i),freq);
            }
            else    freqs.put(arr.get(i),1);
        }       
        return getMostOcc(freqs); 
    }
//end@
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = migratoryBirds(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
