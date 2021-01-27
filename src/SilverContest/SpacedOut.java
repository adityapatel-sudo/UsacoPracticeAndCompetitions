package SilverContest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class SpacedOut {
    static int[][] beauty;
    static int n;
    static int[] squareCheck = new int[3];
    static HashSet<Integer> squareCheckHash;
    static int[][] visited;

    public static void main(String[] args){
        FastReader in = new FastReader();
        PrintWriter out = new PrintWriter(System.out);

        n = in.nextInt();
        beauty = new int[n][n];
        visited = new int[n][n];
        squareCheckHash = new HashSet<>();

        for(int i = 0;i<n;i++){
            for(int j =0;j<n;j++){
                beauty[i][j] = in.nextInt();
            }
        }

        out.println(recu(1,0,0));
        out.close();
    }

    static int recu(int direc, int y,int x){
        int count = 0;
        int beautyCount = beauty[y][x];
        int yChange = 0;
        int fillabillity = checkFill(y,x);
        if(direc==1&&x==n-1){
            yChange = 1;
            direc = 0;
        }else if(direc==-1&&x==0){
            yChange = 1;
            direc = 0;
        }else if(direc==0&&x==n-1){
            direc = -1;
        }else if(direc==0&&x==0){
            direc = 1;
        }if(y==n-1&& direc==0){

            if(fillabillity==-1) {
                return count;
            }
            return beautyCount;
        }

        if(fillabillity==-1){//CANNOT FILL
            visited[y][x] = 1;//marked empty
            count+=recu(direc,y+yChange,x+direc);
            visited[y][x] = 0;//marked untouched
            return count;
        }
        else if(fillabillity==0){
            visited[y][x] = 1;//marked empty
            count+=recu(direc,y+yChange,direc+x);
            visited[y][x] = 2;//go into again, MARKED FULL
            beautyCount += recu(direc,y+yChange,direc+x);
            visited[y][x] = 0;//marked untouched
            return Integer.max(count,beautyCount);
        }else if(fillabillity==1){//MUST BE FILLED
            visited[y][x] = 2;////MARKED FULL
            beautyCount+=recu(direc,y+yChange,x+direc);
            visited[y][x] = 0;//marked untouched
            return beautyCount;
        }
        return count;

    }

    static int checkFill(int y, int x){
        squareCheckHash.clear();
        if(x>0&&y>0){
            squareCheckHash.add(checkSquare(y,x,y-1,x-1));
        }if(x<n-1&&y>0){
            squareCheckHash.add(checkSquare(y,x,y-1,x+1));

        }
        if(squareCheckHash.contains(-1)){
            if(squareCheckHash.contains(1)){
                return -2;//CAN NOT BE FILLED due to differing responses, return
            }
            return -1;//can not fill this one
        }
        if(squareCheckHash.contains(1)) return 1;//MUST BE FILLED

        return 0; //CAN CHOOSE FILL OR NOT


    }
    static int checkSquare(int y, int x, int yOut, int xOut){
        Arrays.fill(squareCheck,0);
        squareCheck[visited[yOut][xOut]]++;
        squareCheck[visited[y][xOut]]++;
        squareCheck[visited[yOut][x]]++;
        squareCheck[visited[y][x]]++;

        if(squareCheck[2]>1)return -1;//CANT fill
        if(squareCheck[1]>1)return 1;//MUST fill
        return 0;//can choose either
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
