import java.io.*;
import java.util.*;

public class AppendAndDelete {

	static String appendAndDelete(String s, String t, int k) {
        //if s empty
        if(s.isEmpty()){
            if(k>= t.length())  return "Yes";
            else return "No";
        }
        //if t 's empty
        if(t.isEmpty()){
            if(k>= s.length())  return "Yes";
            else    return "No";
        }
        //if they are the same Strig
        if(s.equals(t)){
            if(k>=2*s.length()) return "Yes";
            if (k%2==0)   return "Yes";
            return "No";
        }
        int dx = -1;
        //to avoid exception
        while(dx+1 <= s.length()-1 && dx+1 <= t.length()-1){
            if( s.charAt(dx+1) != t.charAt(dx+1) )   break;
            dx++;
        }
        //d is the last identical coressponding letter
        int diff = k-(s.length() - (dx+1) + t.length()-(dx+1));
        //append then del,rep...
        if(diff>=0 && diff%2 == 0)   return "Yes";
        //delete* append*
        if(k>=s.length()+t.length())   return "Yes";
        //if nothing in common
        if(dx == -1 && diff>=0)       return "Yes";
        else    return"No";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String t = scanner.nextLine();

        int k = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String result = appendAndDelete(s, t, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}