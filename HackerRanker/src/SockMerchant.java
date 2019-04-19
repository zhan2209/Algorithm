import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class SockMerchant{

    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {

        int pair = 0;
        Arrays.sort(ar);
        int count = 1;

        for(int i = 0; i < n - 1; i++){
            System.out.print(ar[i] + " ");
            if(ar[i] == ar[i + 1]){
                count++;
            }else{
                pair += count/2;
                System.out.println("count=" + count);
                count = 1;
            }
        }

        if(count != 1) {
            System.out.println("count=" + count);
            pair += count/2;
        }
        return pair;
    }

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {


        File file = new File("/Users/Gloria/JavaPractise/src/HackerRanker/test/SockMerchant.txt");
        scanner = new Scanner(file);

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        int[] ar = new int[n];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = sockMerchant(n, ar);


        System.out.println("result: " + result);
        scanner.close();
    }
}
