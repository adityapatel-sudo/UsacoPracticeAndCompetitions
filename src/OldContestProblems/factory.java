package OldContestProblems;
//factory problem : http://www.usaco.org/index.php?page=viewproblem2&cpid=940#
//was not too difficult
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class factory {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("traffic.in"));
        PrintWriter out = new PrintWriter(new FileWriter("factory.out"));

        int[] conveyors = new int[scanner.nextInt()];
        Arrays.fill(conveyors,-2);
        int temp;

        for(int i = 0; i< conveyors.length-1;i++){
            conveyors[scanner.nextInt()-1] = scanner.nextInt()-1;
        }

        HashSet<Integer> loopcheck = new HashSet<>();

        int checkFor = findFinal(conveyors,0,loopcheck);
        for(int i = 1; i< conveyors.length;i++){
            if(i == checkFor) continue;
            loopcheck.clear();
            temp = findFinal(conveyors,i,loopcheck);
            if(temp!= checkFor) {
                checkFor = -2;
                break;
            }
        }

        out.println(checkFor+1);
        out.close();
    }
    static int findFinal(int[] conveyors, int current, HashSet<Integer> loopCheck){
        if(loopCheck.contains(current)) return -2;
        else loopCheck.add(current);
        return (conveyors[current] == -2)? current:findFinal(conveyors,conveyors[current],loopCheck);
    }
}
