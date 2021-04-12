import java.util.Scanner;

public class HRSubstring {

    public static String getSmallestAndLargest(String s, int k) {
        //initilalizing with worst cases
        String smallest = "z";
        String largest = "A";
        
        for(int i = 0; i <s.length()-(k-1); i++){
            String sub = s.substring(i,i+k);
            //neg if smaller
            if(sub.compareTo(smallest)<0)   smallest = sub;
            //pos if bigger
            if(sub.compareTo(largest)>0)    largest = sub;
        }
        return smallest + "\n" + largest;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int k = scan.nextInt();
        scan.close();
      
        System.out.println(getSmallestAndLargest(s, k));
    }
}
