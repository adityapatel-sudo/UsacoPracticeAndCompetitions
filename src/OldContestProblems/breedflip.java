package OldContestProblems;

//working solution, checks total different substrings, returns
//v easy, did in 15 min
//http://www.usaco.org/index.php?page=viewproblem2&cpid=1012#


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class breedflip {

    public static  void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("breedflip.in"));
        PrintWriter out = new PrintWriter(new FileWriter("breedflip.out"));

        int max = scanner.nextInt();
        String correct = scanner.next();
        String incorrect = scanner.next();
        StringBuilder differences = new StringBuilder();
        boolean beforeIsRight = true;
        int changes = 0;

        for(int i = 0; i< max;i++){
            if(correct.charAt(i)==incorrect.charAt(i)){
                differences.append("C");
                beforeIsRight = true;
            }
            else if(beforeIsRight){
                beforeIsRight = false;
                changes++;
                differences.append("N");
            }
            System.out.println(differences);
        }
        out.println(changes);
        out.close();
    }
}
