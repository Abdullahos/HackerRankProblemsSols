import java.io.*;
import java.util.stream.*;
class Ressult {

//be aware of overflow->>i changed the first 4 params to long instead of int for the summing process
    public static long taumBday(long b, long w, long bc, long wc, int  z) {
        
        if(bc+z<wc) wc = bc+z;
        else if(wc+z<bc)    bc = wc+z;
        return (b*bc)+(w*wc);
    }

}

public class TaumAndBDay {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                long b = Integer.parseInt(firstMultipleInput[0]);

                long w = Integer.parseInt(firstMultipleInput[1]);

                String[] secondMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                long bc = Integer.parseInt(secondMultipleInput[0]);

                long wc = Integer.parseInt(secondMultipleInput[1]);

                int z = Integer.parseInt(secondMultipleInput[2]);

                long result = Ressult.taumBday(b, w, bc, wc, z);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
