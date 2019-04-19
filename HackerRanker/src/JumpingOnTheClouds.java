package HackerRanker.src;
import java.io.*;
        import java.math.*;
        import java.security.*;
        import java.text.*;
        import java.util.*;
        import java.util.concurrent.*;
        import java.util.regex.*;

public class JumpingOnTheClouds {
    // Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] c) {

        int counter = 0;
        for(int i = 0;i < c.length;){
            if(c[i] == 1){
                counter++;
                i = i + 2;
            }else if(c[i] == 0 && i + 2 <c.length ){
                if(c[i + 2] == 0){
                    counter++;
                    i += 2;
                }else if(c[i + 2] == 1){
                    i++;
                    counter++;
                }
            }else if(c[i] == 0 && i + 1 < c.length){
                if(c[i + 1] == 0){
                    counter++;
                    i++;
                }else{
                    i++;
                }
            }else{
                break;
            }
        }
        return counter;

    }

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        File file = new File("/Users/Gloria/JavaPractise/src/HackerRanker/test/JumpingOnTheClouds.txt");
        scanner = new Scanner(file);

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int result = jumpingOnClouds(c);
        System.out.println("Min Jump" + result);

        scanner.close();
    }
}
