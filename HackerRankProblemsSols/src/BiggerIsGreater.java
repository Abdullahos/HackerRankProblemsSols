import java.io.*;
import java.util.*;


public class BiggerIsGreater {

    public static String re(String w , int start){
        //do it as long as !(no more)
        //can't be last element
        
        while(start<w.length()-1){
            int index = start;
            int min = w.charAt(start);
                for(int i = start+1; i<w.length(); i++){
                        if(w.charAt(i)-min<0)  {
                            min = w.charAt(i);
                            index = i;
                        }
                }
            //swap char @ start = (min@index) with @ start
            if(index!=start){
                w = w.substring(0,start)+w.charAt(index)+w.substring(start+1,index)+w.charAt(start);
                if(index+1 < w.length())    w = w+w.substring(index+1);
                //update start
            }
                start++;
        }
        
        return w;
    }
    // Complete the biggerIsGreater function below.
    static String biggerIsGreater(String w) {
        //pariority to the most j
        int maxPosj = 0;
        int maxPosi = 0;
        
        String minStr =w;
        int min = 10000000;
        String temp;
        
        int diff;
        boolean flag = false;
            for(int i =w.length()-1 ;i>maxPosj; i--){
                    for(int j = i-1; j>=maxPosj ; j--){
                        //smaller @ j - bigger @ i
                        diff = w.charAt(i)-w.charAt(j);
                        if(diff>0)   {
                            maxPosi = i;
                            maxPosj = j;
                            flag = true;
                             temp = w.substring(0,maxPosj)+w.charAt(maxPosi)+w.substring(maxPosj+1,maxPosi)+w.charAt(maxPosj)+w.substring(maxPosi+1);
                             if(temp.compareTo(w)<min){
                                 min = temp.compareTo(w);
                                 minStr = temp;
                             }
                        }
                    }
                }
            if(flag){
               
                        //no more
                        //System.out.println(minStr);
                        if(maxPosj==w.length()-2)    return minStr;
                        //there 2 or more elem after j
                        //start from j+1 to end
                        return re(minStr,maxPosj+1);
            }
            //if no change can be done
            return "no answer";
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int T = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int TItr = 0; TItr < T; TItr++) {
            String w = scanner.nextLine();

            String result = biggerIsGreater(w);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
