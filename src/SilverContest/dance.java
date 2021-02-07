package SilverContest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class dance {
    static ArrayList<ArrayList<Integer>> paths;
    static ArrayList<Integer> path;
    static int[] positions;
    static ArrayList<HashSet<Integer>> u;

    public static void main(String[] args){
        FastReader in = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        int n = in.nextInt(),k = in.nextInt();
        positions = new int[n];
        paths = new ArrayList<>();
        path = new ArrayList<>();
        u = new ArrayList<>();
        for(int i =0;i<n;i++){
            paths.add(new ArrayList<>());
            paths.get(i).add(i);
            u.add(new HashSet<>());
            u.get(i).add(i);
            positions[i] = i;
        }

        for(int i = 0; i< k;i++){
            int x = in.nextInt()-1, y = in.nextInt()-1;
            u.get(positions[x]).add(y);
            u.get(positions[y]).add(x);

            paths.get(positions[x]).add(y);
            paths.get(positions[y]).add(x);

            //swap current
            int temp = positions[x];
            positions[x] = positions[y];
            positions[y] = temp;
        }
        Arrays.fill(positions,0);
        for(int i = 0; i< n;i++){
            if(positions[i]!=0)continue;
            recu(i, new HashSet<>(), new HashSet<>());

        }
        for(int i = 0; i < n; i++){
            out.println(positions[i]);
        }

        out.close();
    }
    static void recu(int i, HashSet<Integer> iHash, HashSet<Integer> jHash){
        if(jHash.contains(i)){
            for(int j : jHash){
                positions[j] = iHash.size();
            }
            return;
        }
        jHash.add(i);
        if(positions[i] != 0){
            for(int j : jHash){
                positions[j]=positions[i] ;
            }
            return;
        }
        iHash.addAll(u.get(i));
        path=paths.get(i);

        recu(path.get(path.size()-1),iHash,jHash);
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




