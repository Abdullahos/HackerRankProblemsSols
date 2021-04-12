import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.Map;

final class MyEntry<K, V> implements Map.Entry<K, V> {
    private final K key;
    private V value;

    public MyEntry() {
        this.key = null;
        this.value = null;
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }

    @Override
    public V setValue(V value) {
        V old = this.value;
        this.value = value;
        return old;
    }
}
public class Solution {
    static int binarySearch(Hashtable<Integer,Integer> newht,int money,int index){
        if(newht.get(index)<money){
            return 2*index;
        }
         return binarySearch(newht,money,index/2);
    }
    static Map.Entry<Integer,Integer> getMin(Hashtable<Integer,Integer>ht){
        Map.Entry<Integer,Integer> min = new MyEntry<Integer,Integer>();
        min.setValue((int)Math.pow(10,10));
        //find min
        for(Map.Entry<Integer,Integer>e:ht.entrySet()){
            if(e.getValue()<min.getValue())    min = e;
        }
        return min;
    }
    static void whatFlavors(int[] cost, int money) {
        //ht has the those unsorted 
        Hashtable<Integer,Integer>ht = new Hashtable<>();
        //newht 'll hold the sorted ones
        Hashtable<Integer,Integer>newht = new Hashtable<>();
        
        //filling hashtable with values and ids
        for(int i = 0; i<cost.length; i++){
            ht.put(i+1,cost[i]);
        }
        //storing sorted costs
        int [] ids = new int[cost.length];
        for(int i = 0 ; i < cost.length; i++){
            //get new min
            Map.Entry<Integer,Integer> min = getMin(ht);
            //setting newht and correspondinf pass
            newht.put(i,min.getValue());
            ids[i] = min.getKey();
            //updating the unsorted hashtable
            ht.remove(ids[i]);
        }
        //System.out.println(newht);
        Hashtable<Integer,Integer>newht1 = new Hashtable<>(newht);
        int index = cost.length/2;
        index = binarySearch(newht,money,index);
   
           for(int i = 0 ; i <= index; i++){
            for(int j = i+1 ; j<=index; j++){
                if(newht.get(i)+newht.get(j) == money){
                    if(ids[i]<ids[j])   System.out.println(ids[i]+" "+ids[j]);
                    else   System.out.println(ids[j]+" "+ids[i]);
                    return;
                }
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

public class hash2try {

}
