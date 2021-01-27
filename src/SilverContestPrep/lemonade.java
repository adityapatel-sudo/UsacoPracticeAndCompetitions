package SilverContestPrep;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class lemonade {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("lifeguards.in"));
        PrintWriter out = new PrintWriter(new FileWriter("lifeguards.out"));


        int n = scanner.nextInt();
        int[] locations = new int[n];
        for(int i = 0;i < n;i++){
            locations[i] = scanner.nextInt();
        }

        Arrays.sort(locations);

        for(int i = 0;i<n/2;i++){
            int temp = locations[i];
            locations[i] = locations[n-1-i];
            locations[n-1-i] = temp;
        }

        int count = 0;
        while(count<n&&locations[count]>=count){
            count++;
        }

        out.println(count);
        out.close();
    }
}
