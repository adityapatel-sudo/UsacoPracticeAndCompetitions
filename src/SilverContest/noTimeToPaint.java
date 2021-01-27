package SilverContest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class noTimeToPaint {
    static HashSet<Character> chars;
    static String string;
    static int n,k;
    static int count = 0;
    public static void main(String[] args){
        FastReader scanner = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        n = scanner.nextInt();
        k = scanner.nextInt();
        string = scanner.next();

        chars = new HashSet<>();
        for(char i = 65;i<91;i++){
            if(string.contains(String.valueOf(i)))
                chars.add(i);
        }

        int[] right = new int[n];
        checker(string,right);
        StringBuilder reverse = new StringBuilder(string);
        reverse.reverse();
        int[] left = new int[n];
        checker(reverse.toString(),left);

        for(int i = 0; i < k; i++ ){
            int start = scanner.nextInt(),end = scanner.nextInt(),toReturn = 0;
            if(start != 1){
                toReturn += right[start-2];
            }
            if(end!=n){
                toReturn += left[n-end-1];
            }
            out.println(toReturn);
        }
        out.close();

    }
    public static void checker(String string,int[] vals){
        HashSet<Character> usedChars = new HashSet<>();
        int count=0;
        for(int i =0 ;i<string.length();i++){
            if(usedChars.contains(string.charAt(i))){
                if(string.charAt(i)>string.charAt(i-1))count++;
                else
                for(int j = i-1;j>=0;j--){
                    if(string.charAt(j)<string.charAt(i)) {
                        count++;
                        break;
                    }
                    if(string.charAt(j)==string.charAt(i)){
                        break;
                    }
                }
            }else{//new char
                usedChars.add(string.charAt(i));
                count++;
            }
            vals[i] = count;
        }
    }

    static class FastReader
    {
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

        int nextInt()
        {
            return Integer.parseInt(next());
        }

        long nextLong()
        {
            return Long.parseLong(next());
        }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

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
