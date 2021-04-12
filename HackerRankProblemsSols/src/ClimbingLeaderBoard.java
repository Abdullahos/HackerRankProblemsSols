import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'climbingLeaderboard' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY ranked
     *  2. INTEGER_ARRAY player
     */
    
public static int binarySearch(Hashtable<Integer,Integer> ht,int playerScore,int index){  
        if(index/2!=0) {
            index = index/2;
            if(playerScore>ht.get(index)) return binarySearch(ht,playerScore,index);
            else    return index;
        }
        else    return  index;
    }
    
public static List<Integer>climbingLeaderboard(List<Integer>ranked,List<Integer> player){
        //mapping scores:
        int rankedSize = ranked.size();
        Hashtable<Integer, Integer> ht = new Hashtable<Integer, Integer>();
        int k = 1;
        for(int i = 0 ; i < rankedSize; i++){
                if(! ht.contains(ranked.get(i)))  {
                    ht.put(k,ranked.get(i));
                    k++;
                }
        }
        //to store player's ranks
        int playetSize = player.size();
        List<Integer> playerRank = new ArrayList<Integer>(playetSize);
               
        for(int i = 0 ; i < playetSize; i++){
            int playerInstantScore = player.get(i);
            
            //to return the best rank to start asking from
            int j = binarySearch(ht,playerInstantScore,ht.size());
            while(j<=ht.size()){
                if(playerInstantScore>=ht.get(j))   break;
                j++;
            }
            playerRank.add(j);
        }
        
        return playerRank;
    }
}
public class ClimbingLeaderBoard {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int rankedCount = Integer.parseInt(bufferedReader.readLine().trim());

        String[] rankedTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> ranked = new ArrayList<>(rankedCount);

        for (int i = 0; i < rankedCount; i++) {
            int rankedItem = Integer.parseInt(rankedTemp[i]);
            ranked.add(rankedItem);
        }

        int playerCount = Integer.parseInt(bufferedReader.readLine().trim());

        String[] playerTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> player = new ArrayList<>(playerCount);

        for (int i = 0; i < playerCount; i++) {
            int playerItem = Integer.parseInt(playerTemp[i]);
            player.add(playerItem);
        }

        List<Integer> result = Result.climbingLeaderboard(ranked, player);

        for (int i = 0; i < result.size(); i++) {
            bufferedWriter.write(String.valueOf(result.get(i)));

            if (i != result.size() - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
