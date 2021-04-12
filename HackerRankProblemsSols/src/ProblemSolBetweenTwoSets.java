import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Res {
    public static int findMin(List<Integer> a){
        int min = 100;
        for(int i = 0 ; i <a.size(); i++){
            if(a.get(i) < min)  min  = a.get(i);
        }
        return min;
    }
    public static int findMax(List<Integer> b){
        int max = 1;
        for(int i = 0 ; i <b.size(); i++){
            if(b.get(i) > max)  max  = b.get(i);
        }
        return max;
    }
    public static int getTotalX(List<Integer> a, List<Integer> b) {
    // Write your code here
    boolean forA = true;    boolean forB = true;
    int counter = 0;
        for(int  i = findMin(a); i <=findMax(b); i++){
            //check for array a
            for(int n = 0 ; n < a.size(); n++){
                if(i%a.get(n) != 0) {forA = false;  break;}
            }
            if(forA){
                //check for array b
                for(int m = 0 ; m < b.size(); m++){
                    if(b.get(m)%i != 0 ){forB = false;  break;}
                }
                if(forB)    counter++;
            }
            forA = true;    forB = true;
        }
        return counter;
    }  

}

public class ProblemSolBetweenTwoSets {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int total = Res.getTotalX(arr, brr);

        bufferedWriter.write(String.valueOf(total));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
