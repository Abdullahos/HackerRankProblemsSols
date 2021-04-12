//working but not time optimizing
import java.util.*;

public class Hashtable {
    static int binarySearch(int[]cost,int money,int index){
        if(cost[index]<money){
            return index+1;
        }
         return binarySearch(cost,money,index/2);
    }

    static void whatFlavors(int[] cost, int money) {
        int[] id = new int[cost.length];
        //set id
        for(int i = 0; i<id.length; i++){
            id[i] = i+1;
        }
        //sort asc
        for(int i = 0; i<cost.length; i++){
            for(int j = 0; j+1< cost.length; j++){
               //swap costs and corresp ids 
                if(cost[j]>cost[j+1]){
                    //swap costs
                    int temp = cost[j];
                    cost[j] = cost[j+1];
                    cost[j+1] = temp;
                    //swap ids
                    temp = id[j];
                    id[j] = id[j+1];
                    id[j+1] = temp;
                }//if
            }//inner for
        }//outer for
        
        int index = cost.length/2;
        index = binarySearch(cost,money,index);
        for(int i = 0; i<=index; i++){
            for(int j = i+1; j<=index; j++){
                if(cost[i]+cost[j] == money){
                    if(id[j]>id[i])
                    System.out.println(id[i]+" "+id[j]);
                    else
                    System.out.println(id[j]+" "+id[i]);
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

