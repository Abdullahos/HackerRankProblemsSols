import java.util.*;

public class _2DArrayHourglass {

    public static int maxHour(int arr[][]){
        //worst case 6*6*-9 -(-9*2) == -306
        int max = -306;

            //left top angle
            for(int ai = 0; ai+2 < arr.length; ai++){
            	//spread to right
                for(int aj = 0 ; aj+2<arr.length; aj++){
                    //now i am @ left top of a hourglass
                    int sum = 0;
                    //itereate over elements of hourglass
                    for(int i = ai ; i < ai+3; i++){
                        for(int j = aj ; j <aj+3; j++){
                            if(i == ai+1){
                                if(j == aj+1)   sum = sum + arr[i][j];   
                            }
                            else    sum = sum + arr[i][j];
                        }
                    }//end of hourglass
                    if(sum > max)   max = sum;
                }
            }
        return max;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }
        System.out.println(maxHour(arr));
        scanner.close();
    }
}
