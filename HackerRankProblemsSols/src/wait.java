
public class wait {

}
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    static void binarySearch(Hashtable<Integer,Integer>table,int money,int index+1){
        //if true then go left
        if(table.get(index)>=money) {
            index = index/2;
            binarySearch(table,money,index);
        }
        else{
            index = index*2;
            int i = 0;
            int j;
            for(int id : table.keySet()){
                j = 0;
                if(i<=index){
                    int instCost = table.get(id);
                    for(int ID : table.keySet()){
                        if(ID != id && j<=index){
                            if(instCost+table.get(ID)==money){
                                System.out.println(id+" "+ID);
                                return;
                            }
                            j++;
                        }
                    }
                i++;
                }
            }    
    }
    }

    static void whatFlavors(int[] cost, int money) {
        Hashtable<Integer,Integer>table = new Hashtable<Integer,Integer>(cost.length+1);
        //clonning
        table.put(0,Math.pow(10,9));
        for(int i = 0; i<cost.length; i++){
            table.put(i+1,cost[i]);
        }
        //sorting
        for(int i = 0; i<cost.length; i++){
            for(int j = 0; j+1< cost.length; j++){
               
                if(table.get(j+1)>table.get(j+2)){
                    int temp = table.get(j+1);
                    table.put(j+1,table.get(j+2));
                    table.put(j+2,temp);
                }
            }
            
        }
        int index = table.size()/2;
        binarySearch(table,money,index);
        //searching then pringting
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
