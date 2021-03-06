package SilverContest2;


import java.io.*;
import java.util.*;
public class YearOfTheCow {
    static int[] firstList = new int[100000];
    static FastReader sc = new FastReader();
    static int n = sc.nextInt();
    static int jumps = sc.nextInt() - 1;
    public static void main(String[] args){
        int max = 0;
        max = m1(sc, n, firstList, max);
        ArrayList<Integer> js = m2(firstList);
        reverseSor(js);
        int jumpsSkipped = m3(jumps, js);
        System.out.println((max-jumpsSkipped)*12);
    }

    private static int m3(int jumps, ArrayList<Integer> js) {
        int jumpsSkipped = 0;
        for(int i = 0; i< jumps && js.size()>i; i++){
            jumpsSkipped += js.get(i);
        }
        return jumpsSkipped;
    }

    private static int m1(FastReader sc, int n, int[] firstList, int max) {
        for(int i = 0; i < n; i++){
            int temp = sc.nextInt();
            temp /= 12;
            if(temp> max) max = temp+1;
            firstList[temp] = firstList[temp] +1;
        }
        return max;
    }

    private static ArrayList<Integer> m2(int[] firstList) {
        ArrayList<Integer> js = new ArrayList<>();
        int count = 0;
        for (int j : firstList) {
            if (j == 0) count++;
            else if (count > 0) {
                js.add(count);
                count = 0;
            }
        }
        return js;
    }

    private static void reverseSor(ArrayList<Integer> js) {
        Collections.sort(js);
        Collections.reverse(js);
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
