package BronzeContestPrep;
//failed evetually but found solution, think triangle at top of graph
//http://www.usaco.org/index.php?page=viewproblem2&cpid=989
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class race {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("race.in"));
        PrintWriter out = new PrintWriter(new FileWriter("race.out"));

        int finPos = scanner.nextInt(),
                n = scanner.nextInt(),
                finSpe =0,
                curPos = 0,
                moves = 0,
                curSpe = 0;


        System.out.println(distToSlow(7,3));

        for(int i = 0; i< n ;i++){
            curPos = 0;
            curSpe = 0;
            moves = 0;
            finSpe = scanner.nextInt();


            while(curPos<finPos) {
                if (curSpe<finSpe||/*distToSlowArray[curSpe+1]*/distToSlow(curSpe+1,finSpe) <= (finPos - (curPos+curSpe+1))) {
                    curSpe++;
                    curPos += curSpe;
                } else if (distToSlow(curSpe,finSpe)<=(finPos-(curPos+curSpe))) {
                    curPos += curSpe;
                } else {

                    curSpe--;
                    curPos += curSpe;
                }
                moves++;

            }
            out.println(moves);
        }

        out.close();
    }

    public static int distToSlow(int curSpe,int finSpe){
        int distance = 0;
        curSpe--;
        for(;curSpe>=finSpe;curSpe--){
            distance += curSpe;
        }
        return distance;
    }
}
