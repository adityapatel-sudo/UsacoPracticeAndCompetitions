package OldContestProblems;

//working solution, just checks all possible trios of points for largest triangle
//v easy, did in 20 min
//http://www.usaco.org/index.php?page=viewproblem2&cpid=1011


import java.io.*;
import java.util.Scanner;

public class triangles {
    public static  void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("race.in"));
        PrintWriter out = new PrintWriter(new FileWriter("triangles.out"));

        int num = scanner.nextInt();
        int[][] locations = new int[num][2];


        for(int i = 0; i< num;i++){
            locations[i][0] = scanner.nextInt();
            locations[i][1] = scanner.nextInt();
        }

        int max = 0;
        for(int i = 0; i < num; i++){
            for(int j = 0; j<num;j++){
                if(locations[j][1]!=locations[i][1]  ||  i==j) continue;

                for(int k = 0; k < num;k++){
                    if((locations[k][0]!=locations[i][0] && locations[k][0]!=locations[j][0])  ||  i==k || k==j) continue;
                    if (checkSize(locations,i,j,k)>max) max = checkSize(locations,i,j,k);
                }

            }
        }
        out.println(max);
        out.close();
    }
    public static int checkSize(int[][] locations, int one, int two, int three){
        int width = Math.max(locations[one][0],locations[two][0]) - Math.min(locations[one][0],locations[two][0]);
        int height = Math.max(locations[one][1], locations[three][1]) - Math.min(locations[one][1], locations[three][1]);
        return width*height;
    }
}
