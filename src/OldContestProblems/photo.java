package OldContestProblems;
//also doesn't work, i dont understand problem
//
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class photo {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("lineup.in"));
        PrintWriter out = new PrintWriter(new FileWriter("photo.out"));

        int[] aList = new int[scanner.nextInt()];
        int[] bList = new int[aList.length-1];
        for(int i = 0; i< bList.length;i++) bList[i] = scanner.nextInt();

        aList[0] = bList[0]-1;
        for(int i = 1;i<aList.length;i++){
            aList[i] = bList[i-1]-aList[i-1];
        }

        for(int x = 0; x< aList.length-1;x++)out.print(aList[x]+" ");
        out.print(aList[aList.length-1]);
        out.close();
    }

}