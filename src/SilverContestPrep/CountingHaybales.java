package SilverContestPrep;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class CountingHaybales {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = scanner.nextInt();
        int q = scanner.nextInt();
        int start;
        int end;

        int[] locations = new int[n];
        for(int i = 0; i< n;i++){
            locations[i] = scanner.nextInt();
        }
        Arrays.sort(locations);

        for(int i = 0; i< q;i++){
            start= scanner.nextInt();
            end = scanner.nextInt();

            out.println(Arrays.binarySearch(locations,end)-Arrays.binarySearch(locations,start)+1);
        }

        out.close();
    }
}
