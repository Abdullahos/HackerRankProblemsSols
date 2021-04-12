
public class JavaSubstring {

}
import java.util.Scanner;

public class Solution {
    public static String getSmallestAndLargest(String s, int k) {
        String smallest = "";
        String largest = "";
        boolean flag = true;
        String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwsyz";
        
        for(int i = 0; i<s.length() ; i++){
            char ch = s.charAt(i);
            
                if(alpha.indexOf(ch)==-1){ 
                flag = false;   break;
                }
        }
        
        if(s.length()<=1000 && s.length()>=1 && flag && k<=s.length()){
            int  i = 1 ;
            int min = alpha.indexOf(s.charAt(0));
            int max = alpha.indexOf(s.charAt(0));
        
             while(i+k <= s.length()){
                if(alpha.indexOf(s.charAt(i))<min)  {
                    smallest  = s.substring(i,i+k);
                    min = alpha.indexOf(s.charAt(i));
                }
                 if(alpha.indexOf(s.charAt(i))>max) {
                    largest = s.substring(i,i+k);
                    max = alpha.indexOf(s.charAt(i));
            }
            i++;
        }
        if(largest == "")   largest = s.substring(0,0+k);
        if(smallest =="")    smallest = s.substring(0,0+k);
        // Complete the function
        // 'smallest' must be the lexicographically smallest substring of length 'k'
        // 'largest' must be the lexicographically largest substring of length 'k'
        }
        return smallest + "\n" + largest;
    }
    

