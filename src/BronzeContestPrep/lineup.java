package BronzeContestPrep;
//solution simple, brute force only has 8! permutations, check if each follows patterm
//problem : http://www.usaco.org/index.php?page=viewproblem2&cpid=965
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class lineup {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(new File("lifeguards.in"));
        PrintWriter out = new PrintWriter(new FileWriter("lineup.out"));

        String[] locations = new String[]{"Bessie","Buttercup", "Belinda", "Beatrice", "Bella", "Blue", "Betsy", "Sue"};


        out.println();

        out.close();

    }
    static String[] moveBeside(String[] locations,int a,int b){
        return null;
    }
}
