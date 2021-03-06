package SilverContest2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class ComfortableCows3 {
    static FastReader scanner = new FastReader();


    public static void main(String[] args) {
        int numCows = scanner.nextInt();
        Solution sol = new Solution();
        sol.calculate(numCows);
    }
    static class Solution {
        int[][] cowMap = new int[3000][3000];
        int imaginaryCount = 0;

        public Solution() {
            for(int[] eachRow : cowMap) {
                Arrays.fill(eachRow, -1);
            }
        }

        public void calculate(int n) {
            while(n>0) {
                placeCow(scanner.nextInt()+1000, scanner.nextInt() +1000, true);
                System.out.println(imaginaryCount);
                n--;
            }
        }

        private void placeCow(int r , int c , boolean real) {
            if (!real) imaginaryCount += 1;
            else if (cowMap[r][c] != -1) {
                imaginaryCount--;
                return;
            }

            int[][] neighbors = getNeighbors(r,c);

            // int neighborCount = cowMap[y][x];

            int neighborCount = 0;
            for (int[] neighbor : neighbors) {
                if (cowMap[neighbor[0]][neighbor[1]] != -1) {
                    neighborCount++;
                }
            }

            cowMap[r][c] = neighborCount;
            if (neighborCount == 3) { // make it 4
                // place cow in empty place
                int[] temp = getEmptyNeighbor(r, c);
                placeCow(temp[0], temp[1], false);
            }

            // now traverse neighbors to check if any of them became invalid
            for (int[] neighbor : neighbors) {
                if (cowMap[neighbor[0]][neighbor[1]] == -1) continue;
                // is any invalid, place cow for them

                int[][] neighborsN = getNeighbors(neighbor[0],neighbor[1]);
                int neighborNCount = 0;
                for (int[] neighborn : neighborsN) {
                    if (cowMap[neighborn[0]][neighborn[1]] != -1) {
                        neighborNCount++;
                    }
                }

                if (neighborNCount == 3) {
                    int[] emptyNeighbor = getEmptyNeighbor(neighbor[0],neighbor[1]);
                    placeCow(emptyNeighbor[0],emptyNeighbor[1], false);
                }
            }
        }
        private int[] getEmptyNeighbor(int r , int c){
            if(cowMap[r-1][c] == -1) return new int[]{r-1,c};
            if(cowMap[r+1][c] == -1) return new int[]{r+1,c};
            if(cowMap[r][c-1] == -1) return new int[]{r,c-1};
            if(cowMap[r][c+1] == -1) return new int[]{r,c+1};
            throw new IllegalArgumentException(" should not reach here");
        }
        private int[][] getNeighbors(int r, int c){
            int[][] neighbors = new int[4][2];
            neighbors[0] = new int[]{r-1,c};
            neighbors[1] = new int[]{r+1,c};
            neighbors[2] = new int[]{r,c+1};
            neighbors[3] = new int[]{r,c-1};
            return neighbors;
        }
    }
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt(){return Integer.parseInt(next());}

        long nextLong(){return Long.parseLong(next());}

        double nextDouble(){return Double.parseDouble(next());}

        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }
}