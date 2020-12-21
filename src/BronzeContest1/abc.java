package BronzeContest1;
//easiest problem in first contest!!
//http://www.usaco.org/index.php?page=viewproblem&cpid=1047
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class abc {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int[] numbers = new int[7];
        for(int i = 0;i<7;i++){
            numbers[i] = scanner.nextInt();
        }
        Arrays.sort(numbers);
        out.print(numbers[0]+" "+ numbers[1]+" ");
        if(numbers[2] == numbers[0]+numbers[1]){
            out.print(numbers[3]);
        }else out.print(numbers[2]);

        out.close();
    }
}
