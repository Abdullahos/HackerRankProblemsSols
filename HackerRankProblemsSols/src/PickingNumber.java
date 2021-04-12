import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
	class Resu {

	    /*
	     * Complete the 'pickingNumbers' function below.
	     *
	     * The function is expected to return an INTEGER.
	     * The function accepts INTEGER_ARRAY a as parameter.
	     */

	    public static int pickingNumbers(List<Integer> a) {
	        int maxLength = 0;
	        List <Integer> temp= new ArrayList<Integer>();
	        for(int i = 0; i < a.size(); i++){
	            temp.clear();
	            int no = a.get(i);
	             temp.add(no);
	            //to parse over the numbers in the list
	            for(int j = 0; j<a.size(); j++ ){
	                if(i != j){
	                    int num = a.get(j);
	                    boolean suit = true;
	                    //qualifying
	                    for(int k = 0 ; k < temp.size(); k++){
	                        //don't add, try another number 
	                        if(Math.abs(num-temp.get(k))>1 )  {suit = false;   break;}
	                    }
	                    if(suit)    temp.add(num);
	                    if(maxLength< temp.size())  maxLength = temp.size();
	                }
	            }
	        }
	        return maxLength;
	    }

	}

	public class PickingNumber {
	    public static void main(String[] args) throws IOException {
	        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

	        int n = Integer.parseInt(bufferedReader.readLine().trim());

	        String[] aTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

	        List<Integer> a = new ArrayList<>();

	        for (int i = 0; i < n; i++) {
	            int aItem = Integer.parseInt(aTemp[i]);
	            a.add(aItem);
	        }

	        int result = Resu.pickingNumbers(a);

	        bufferedWriter.write(String.valueOf(result));
	        bufferedWriter.newLine();

	        bufferedReader.close();
	        bufferedWriter.close();
	    }
}