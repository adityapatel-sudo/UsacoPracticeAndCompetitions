package OldContestProblems;
//http://www.usaco.org/index.php?page=viewproblem2&cpid=915
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class herding {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(new File("triangles.in"));
        PrintWriter out = new PrintWriter(new FileWriter("herding.out"));

        int left,middle,right;
        left = sc.nextInt();
        middle = sc.nextInt();
        right = sc.nextInt();

        //find minimum
        if(middle-left == right-middle) out.println(0);
        else if( Integer.min(middle-left,right-middle)==2) out.println(1);
        else out.println(2);
        //find maximum
        out.println(Integer.max(middle-left,right-middle)-1);


        out.close();
    }
}