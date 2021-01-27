package SilverContestPrep;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class CountingHaybales {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("lifeguards.in"));
        PrintWriter out = new PrintWriter(new FileWriter("lifeguards.out"));

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
            start = scanner.nextInt();
            end = scanner.nextInt();

            start = Arrays.binarySearch(locations,start);
            if(start<0)start = -1*(start+1);
            end = Arrays.binarySearch(locations,end);
            if(end<0) end = -1*(end+1)-1;

            out.println(end-start+1);
        }

        out.close();
    }

}
