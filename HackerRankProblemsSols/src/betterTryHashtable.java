
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class betterTryHashtable {
    static int binarySearch(int[]cost,int money,int index){
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
        //clone to hashTable:
        Integer[] array;
        Hashtable<Integer,Integer[]>ht = new Hashtable<>();
        for(int i = 0; i<cost.length; i++){
            //initialize array of length 2
            array = new Integer [2];
            //make sure there's empty place for @least 2 index
            //not there's no need to add more than 2 indices as we only want 2 flavors
            if(ht.containsKey(cost[i]) && !(ht.get(cost[i])==null) && ht.get(cost[i])[1]==null){
                array[0] = ht.get(cost[i])[0];
                array[1] = i+1;
                ht.put(cost[i],array);
            }
            else{
                array[0] = i+1;
                ht.put(cost[i],array);
            }
        }
        
        //sort
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
                            id1 = ht.get(cost[i])[0];
                            id2 = ht.get(cost[i])[1];
                        }
                        else{
                            id1 = ht.get(cost[i])[0];
                            id2 = ht.get(cost[j])[0];
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
