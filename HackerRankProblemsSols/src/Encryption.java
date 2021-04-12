//challenge link:
//https://www.hackerrank.com/challenges/encryption/problem
import java.io.*;
import java.util.*;

public class Encryption {

    //remove spaces:
    static String removeSpaces(String s){
        String newString = "";
        for(String word : s.split(" ")){
            newString = newString + word;
        }
        return newString;
    }
    //encrypting
    static String encryption(String s) {
        //return the string without spaces
        String noSpaces = removeSpaces(s);
        //calculating length
        int length = noSpaces.length();
        int width = (int)Math.sqrt(length);
        int hight = width;
        //modify width &/or hight till the correct values.
        while(hight*width<length){
            if(width<=hight) width++;
            else    hight++;
        }
    
        //filling
        String []arr = new String [hight];
        int start = 0 ;
        int end = start;
        int k = 0;
        //composing msg into words
        while(k<hight){
            if(end+width <= length){
                end = end+(int)width;
                arr[k] = noSpaces.substring(start,end);
                start = end;
                k++;
            }
            //if the remaining letters less than width
            else{
            	//just consider the remaining letters
                arr[k] = noSpaces.substring(start);  
                //no more letters to be processed
                break;
            }
        }
        //iterate over array elements to compose words vertical->horizontal
        String encrypted = "";
        int j = 0;
        int w = 0;
        //as w less than the width of word with maximum length 
        while(w<width){
            for(int i = 0 ; i < hight; i++){
            	//to avoid considering empty letters the last word's length might vary in length
                    if(j<arr[i].length()) {
                        encrypted = encrypted+ String.valueOf(arr[i].charAt(j));
                    }          
            }
            //to separate words
            encrypted = encrypted+" ";
            //Responsible for parsing over letters
            j++;
            //Responsible for iterating over words
            w++;
        }
        return encrypted;
    }
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = encryption(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();
    
        bufferedWriter.close();

        scanner.close();
    }
}
