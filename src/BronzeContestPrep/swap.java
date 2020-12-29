package BronzeContestPrep;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

//Done all three problems in under 2 hours, this one was hardest,
//http://www.usaco.org/index.php?page=viewproblem2&cpid=1013

public class swap {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("race.in"));
        PrintWriter out = new PrintWriter(new FileWriter("swap.out"));

        int n = scanner.nextInt(),
        k = scanner.nextInt(),
        a1 = scanner.nextInt()-1,
        a2 = scanner.nextInt()-1,
        b1 = scanner.nextInt()-1,
        b2 = scanner.nextInt()-1;
        int[] currentPositions = new int[n];
        for(int i = 0; i< n; i++){
            currentPositions[i] = i+1;
        }

        if(a2<b1){
            k=k%2;
        }


        int[] copy = Arrays.copyOf(currentPositions,currentPositions.length);

        for(int cursor = 0; cursor<k;cursor++){
            leftReverse(currentPositions,a1,a2);
            leftReverse(currentPositions,b1,b2);
            if(Arrays.equals(currentPositions,copy)){
                k = k%(cursor+1);
                currentPositions = Arrays.copyOf(copy,copy.length);
                for(int i = 0; i< k;i++){
                    leftReverse(currentPositions,a1,a2);
                    leftReverse(currentPositions,b1,b2);
                }
            }


        }
        for(int i = 0; i< currentPositions.length;i++){
            out.println(currentPositions[i]);
        }
        out.close();
    }
    public static void leftReverse(int[] sequence, int start, int finish){
        int temp = 0;
        for(int i =0; i< (finish-start) / 2 + 1;i++){
            temp = sequence[finish-i];
            sequence[finish-i] = sequence[start+i];
            sequence[start+i] = temp;
        }
    }
}
