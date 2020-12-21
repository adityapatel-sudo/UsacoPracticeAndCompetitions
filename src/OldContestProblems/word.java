package OldContestProblems;

//easy success, simple problem
//http://www.usaco.org/index.php?page=viewproblem2&cpid=987

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class word {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("buckets.in"));
        PrintWriter out = new PrintWriter(new FileWriter("word.out"));

        int numWords = scanner.nextInt();
        int max = scanner.nextInt();
        String[] words = new String[numWords];
        int cursor = 0;
        int lineLetters = 0;

        for(int i = 0; i< numWords;i++){
            words[i] = scanner.next();
        }
        while(cursor<numWords){
            if(lineLetters + words[cursor].length() <= max){
                out.print((lineLetters==0?(words[cursor]):" "+words[cursor]));
                lineLetters+= words[cursor].length();
            }else{
                out.print("\n"+words[cursor]);
                lineLetters = words[cursor].length();
            }
            cursor++;
        }
        out.close();
    }
}
