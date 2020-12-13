package OldContestProblems;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class sleepy {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("sleepy.in"));
        PrintWriter out = new PrintWriter(new FileWriter("herding.out"));

        int max = scanner.nextInt();
        int[] locations = new int[max+1];
        for(int i = 0; i< max;i++) locations[i] = scanner.nextInt();
        locations[max] = Integer.MAX_VALUE;

        out.println(findLowestSort(locations));

        out.close();
    }
    public static int findLowestSort(int[] locations){
        int count = 0,temp;
        return count;
    }
    public static int[] swapFirstWith(int[] locations, int swapWith){
        int temp = locations[0];
        for(int i = 0; i<swapWith;i++){
            locations[i] = locations[i+1];
        }
        locations[swapWith] = temp;
        return locations;
    }
}
