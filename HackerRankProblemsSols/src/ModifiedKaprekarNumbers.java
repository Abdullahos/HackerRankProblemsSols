//challenge ling: https://www.hackerrank.com/challenges/kaprekar-numbers/problem
import java.math.*;
import java.util.*;

public class ModifiedKaprekarNumbers {

    // Complete the kaprekarNumbers function below.
    static void kaprekarNumbers(int p, int q) {
    	//to check 2 end if there was at least one kaprekar number
    	boolean ever = false;
        for(int n = p ; n<=q; n++){
            //convert square to string
            if(n == 1)  {
                System.out.print(n+" ");
            }
            //there's no kaperekar number less than 9 except 1
            else if(n>=9){
                //get the length of no
                int d = String.valueOf(n).length();
                //use BigInteger as String.valueOf(n*n) won't work with very big numbers-> 0
                BigInteger N = new  BigInteger(String.valueOf(n));
                //big-<big *big
                N = N.multiply(N);
                //convert bigInteger to String to divide it
                String number = String.valueOf(N);
                //dividing
                String _rHalf = number.substring(number.length()-d);
                String _lHalf = number.substring(0,number.length()-d);
                //back to numbers
                int l = Integer.parseInt(_lHalf);
                int r = Integer.parseInt(_rHalf);
                //checking if kaprekar number
                if(l+r == n)  {
                    System.out.print(n+" ");
                    ever = true;
                }
            }
        }
        
        if(!ever)   System.out.print("INVALID RANGE");
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int p = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        kaprekarNumbers(p, q);

        scanner.close();
    }
}
