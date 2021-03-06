package SilverContest2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ComfortableCows {
    static int[][] m = new int[3000][3000];
    static FastReader sc = new FastReader();
    static int imc = 0;
    public static int[] getENeig(int rows , int col){
        if(m[rows-1][col] == -1) return new int[]{rows-1,col};
        if(m[rows+1][col] == -1) return new int[]{rows+1,col};
        if(m[rows][col-1] == -1) return new int[]{rows,col-1};
        if(m[rows][col+1] == -1) return new int[]{rows,col+1};
        return null;
    }
    public static int[][] getNeigh(int row, int col){
        int[][] neigh = new int[4][2];
        neigh[0] = new int[]{row-1,col};
        neigh[1] = new int[]{row+1,col};
        neigh[2] = new int[]{row,col+1};
        neigh[3] = new int[]{row,col-1};
        return neigh;
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
    public static void pcow(int row , int col , boolean real) {
        if (!real) imc += 1;
        else if (m[row][col] != -1) {
            imc--;
            return;
        }
        int[][] neis = getNeigh(row,col);

        // int neighborCount = cowMap[y][x];

        int ncount = 0;
        for (int[] neighbor : neis) {
            if (m[neighbor[0]][neighbor[1]] != -1) {
                ncount++;
            }
        }

        m[row][col] = ncount;
        if (ncount == 3) { // make it 4
            // place cow in empty place
            int[] x = getENeig(row, col);
            pcow(x[0], x[1], false);
        }

        // now traverse neighbors to check if any of them became invalid
        for (int[] nei : neis) {
            if (m[nei[0]][nei[1]] == -1) continue;
            // is any invalid, place cow for them

            int[][] neighborsN = getNeigh(nei[0],nei[1]);
            int neighborNCount = 0;
            for (int[] neighborn : neighborsN) {
                if (m[neighborn[0]][neighborn[1]] != -1) {
                    neighborNCount++;
                }
            }

            if (neighborNCount == 3) {
                int[] empNeigh = getENeig(nei[0],nei[1]);
                pcow(empNeigh[0],empNeigh[1], false);
            }
        }
    }    public static void main(String[] args) {
        int nCow = sc.nextInt();
        for(int[] eachRow : m) {
            Arrays.fill(eachRow, -1);
        }
        while(nCow>0) {
            pcow(sc.nextInt()+1000, sc.nextInt() +1000, true);
            System.out.println(imc);
            nCow--;
        }
    }

}