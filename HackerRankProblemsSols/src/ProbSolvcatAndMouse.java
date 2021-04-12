
import java.io.*;
import java.util.*;
public class ProbSolvcatAndMouse {

  //  start @
    static String catAndMouse(int x, int y, int z) {
        if(Math.abs(z-x)<Math.abs(z-y)) return "Cat A";
        else if(Math.abs(z-x)>Math.abs(z-y)) return "Cat B";
        else    return "Mouse C";
    }
//end
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] xyz = scanner.nextLine().split(" ");

            int x = Integer.parseInt(xyz[0]);

            int y = Integer.parseInt(xyz[1]);

            int z = Integer.parseInt(xyz[2]);

            String result = catAndMouse(x, y, z);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
