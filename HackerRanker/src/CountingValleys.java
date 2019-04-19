package HackerRanker.src;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/**
 * Created by Gloria on 4/15/19.
 */
public class CountingValleys {


    // Complete the countingValleys function below.
    static int countingValleys(int n, String s) {

        int seaLevel = 0;
        int count = 0;
        boolean flag = false;

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'U'){
                seaLevel ++;
                if(seaLevel == 0 ){
                    count++;
                }
            }else if(s.charAt(i) == 'D'){
                seaLevel --;
            }


        }
        return count;

    }

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {


        File file = new File("/Users/Gloria/JavaPractise/src/HackerRanker/test/CountingValleys.txt");
        scanner = new Scanner(file);

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int result = countingValleys(n, s);

        System.out.println("Valley: " + result);
        scanner.close();
    }
}
