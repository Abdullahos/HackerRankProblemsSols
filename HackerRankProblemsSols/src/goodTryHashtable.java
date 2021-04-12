import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class goodTryHashtable {
    static int binarySearch(int[]cost,int money,int index){
        //to make sure i'm not miss any valid price
    	if(cost[index]<money){
            while(index+1<cost.length){
                index++;
                if(cost[index]>money) return  index;
            }
            return index;
        }
         return binarySearch(cost,money,index/2);
    }
    // Complete the whatFlavors function below.
    static void whatFlavors(int[] cost, int money) {
        ArrayList<Integer> list= new ArrayList<Integer>(); 
        //clone to hashTable:
        Hashtable<Integer,ArrayList<Integer>>ht = new Hashtable<>();
        for(int i = 0; i<cost.length; i++){
            list= new ArrayList<Integer>();
            //to avoid overwritting on the index if it exists
            if(ht.containsKey(cost[i])) list = ht.get(cost[i]);
            list.add(i+1);
            ht.put(cost[i],list);
        }
        
        //quick sort
        Arrays.sort(cost);
        
        //set best end index:
        int index = binarySearch(cost,money,cost.length/2);
        int id1;
        int id2;
        //search for matching flavors
        for(int i =0 ; i<=index; i++)
            for(int j = i+1; j<=index; j++){
                        if(cost[i]+cost[j]==money){
           
                        if(cost[i] == cost[j]){
                            id1 = ht.get(cost[i]).get(0);
                            id2 = ht.get(cost[i]).get(1);
                        }
                        else{
                            id1 = ht.get(cost[i]).get(0);
                            id2 = ht.get(cost[j]).get(0);
                        }
                        if(id1<id2) System.out.println(id1+" "+id2);
                        else    System.out.println(id2+" "+id1);
                        return;
                    }
            }

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int money = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] cost = new int[n];

            String[] costItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int costItem = Integer.parseInt(costItems[i]);
                cost[i] = costItem;
            }

            whatFlavors(cost, money);
        }

        scanner.close();
    }
}
