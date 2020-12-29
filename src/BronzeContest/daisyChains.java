package BronzeContest;

//also a very easy problem, 2nd easiest in the contest
//http://www.usaco.org/index.php?page=viewproblem&cpid=1047

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class daisyChains {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int numberFlowers = scanner.nextInt();
        int[] petalNumbers = new int[numberFlowers];
        int numberHaveAverage = 0;

        for(int i = 0; i < numberFlowers;i++){
            petalNumbers[i] = scanner.nextInt();
        }
        out.println(Arrays.toString(petalNumbers));

        for(int i = 0; i<numberFlowers;i++){
            for(int j = 0; j+i<numberFlowers;j++){
                int[] temp = Arrays.copyOfRange(petalNumbers,j,j+i+1);
                out.println(Arrays.toString(temp));
                if(checkIfAverageExists(temp)) numberHaveAverage++;
            }
        }
        out.print(numberHaveAverage);
        out.close();
    }
    static boolean checkIfAverageExists(int[] petalNumbers){
        double average = 0;
        for (int number : petalNumbers) {
            average += number;
        }
        average /= petalNumbers.length;

        for (int petalNumber : petalNumbers) {
            if (average == petalNumber) return true;
        }
        return false;
    }
}
