import java.io.*;

public class DayOfProgrammer {
    static String dayOfProgrammer(int year) {
        //checking if it's leap
    	if(year%4==0){
    		//if the chalender is julian
            if(year<1918)   return "12.09."+year;
            //if the chalender is gregorian
            if(year>=1919 && year % 100!=0 )  return "12.09."+year;
        }
    	//if the chalender is gregorian
        if(year % 400==0 && year>=1919)    return "12.09."+year;
        //if it's the transient special year
        if(year==1918)  return "26.09."+year;
        //not leap
        return "13.09."+year;
        
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int year = Integer.parseInt(bufferedReader.readLine().trim());

        String result = dayOfProgrammer(year);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

