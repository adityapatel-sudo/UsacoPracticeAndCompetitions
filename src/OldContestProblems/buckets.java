package OldContestProblems;
//easy to solve, just shouldve done few more test cases
//http://www.usaco.org/index.php?page=viewproblem2&cpid=939
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class buckets {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("buckets.in"));
        PrintWriter out = new PrintWriter(new FileWriter("buckets.out"));


        int bx=0,by=0,lx=0,ly=0,rx=0,ry=0;
        String temp;
        for(int i = 9; i>=0;i--){
            temp = scanner.next();
            for(int j =0;j<10;j++){
                if(temp.charAt(j)=='B'){
                    bx = j;
                    by = i;
                }else if(temp.charAt(j) == 'L'){
                    lx = j;
                    ly = i;
                }else if (temp.charAt(j)== 'R'){
                    rx = j;
                    ry = i;
                }
            }
        }
        int x = Math.abs(bx-lx)+Math.abs(by-ly);
        if((rx==lx&&rx==bx) && ((ry<ly&&ry>by)||(ry>ly&&ry<by)))
            out.println(x+1);
        else if(rx==lx&&rx==bx)
            out.println(x-1);
        else
            out.println(x-1);


        out.close();
    }
}
