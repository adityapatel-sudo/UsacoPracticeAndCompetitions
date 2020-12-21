package OldContestProblems;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class gymnastics {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("traffic.in"));
        PrintWriter out = new PrintWriter(new FileWriter("gymnastics.out"));

        int numOfComps = scanner.nextInt(),numCows=scanner.nextInt(),temp=0;
        int[][] cowsAndRankings = new int[numCows][numOfComps];
        for(int i =0; i<numOfComps;i++){
            for(int j =0 ; j<numCows;j++){
                temp = scanner.nextInt();
                cowsAndRankings[temp-1][i] = j;
            }
        }
        out.println(findRankings(cowsAndRankings));


        out.close();
    }
    static int findRankings(int[][] cowsAndRankings){
        int consistentPairs = 0;
        for(int cows = 0; cows<cowsAndRankings.length;cows++){
            for(int compareCow = 0; compareCow<cowsAndRankings.length;compareCow++){
                if(cows==compareCow) continue;
                if(compBetweenTwo(cowsAndRankings[cows],cowsAndRankings[compareCow])) consistentPairs++;

            }
        }
        return consistentPairs;
    }
    static boolean compBetweenTwo(int[] first, int[] second){
        for(int i =0;i< first.length;i++){
            if(first[i]<=second[i]) return false;
        }
        return true;
    }
}
