import java.util.Scanner;
import java.util.regex.*;
public class RegexPatternSyntaxChecker {
	int i = 0 , j = 0;
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());
		while(testCases>0){
			String pattern = in.nextLine();
            //try this pattern if valid(no exception thrown->print Valid else print Invalid)
            try{
          	    Pattern.compile(pattern);
                System.out.println("Valid");
                  
            }
            catch(PatternSyntaxException  ex){
                System.out.println("Invalid");
            }
            testCases--;
		}
		in.close();
	}
}
/*
 * very good regex example from hackerRank
 * 
 * String regex = "^[aA-zZ]\\w{7,29}$";
 * 
 * in detail, why this works. ^ represents that starting character of the string.
 *  [aA-zZ] makes sure that the starting character is in the lowercase or uppercase alphabet.
 *   \\w{7,29} represents a check to make sure that the remaining items are word items, 
 *   which includes the underscore, until it reaches the end and that is represented with $.
 *    The {7,29} represents the 8-30 character constraint given to us minus the predefined first character.
 * 
 * 
 * 
 * */


