package SilverContest2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class JustGreenEnough {
    static FastReader scanner = new FastReader();
    static int arraySize = scanner.nextInt();
    static ArrayList<Integer> sumSequence;

    public static void main(String[] args){
        int[][] matrix = new int[arraySize][arraySize];
        for(int i = 0; i < arraySize; i++){
            for(int j = 0; j < arraySize; j++){
                matrix[i][j] = scanner.nextInt();
            }
        }
        sumSequence = new ArrayList<>();
        sumSequence.add(1);
        while(sumSequence.size()< arraySize){
            sumSequence.add(sumSequence.size()+ sumSequence.get(sumSequence.size()-1)+1);
        }
        sumSequence.add(0,0);

        int[][] sumArrayWithout100 = new int[arraySize][arraySize];

        int min = 100;
        for(int i = 0; i < arraySize; i++){
            if(matrix[0][i]>min) sumArrayWithout100[0][i] = 1;
        }
        for(int i = 1; i < arraySize; i++){
            for(int j = 0; j < arraySize; j++){
                if(matrix[i][j]>min){
                    sumArrayWithout100[i][j] = sumArrayWithout100[i-1][j]+1;
                }
            }
        }

        int[][] sumArrayWith100 = new int[arraySize][arraySize];

        min = 99;
        for(int i = 0; i < arraySize; i++){
            if(matrix[0][i]>min) sumArrayWith100[0][i] = 1;
        }
        for(int i = 1; i < arraySize; i++){
            for(int j = 0; j < arraySize; j++){
                if(matrix[i][j]>min){
                    sumArrayWith100[i][j] = sumArrayWith100[i-1][j]+1;
                }
            }
        }

        long rectangles = getRectanglesCount(sumArrayWith100)- getRectanglesCount(sumArrayWithout100);
        System.out.println(rectangles);


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

    public static long getRectanglesCount(int[][] sumMatrix){
        long sum = 0;
        for(int[] bottom : sumMatrix){
            int temp = 0;
            boolean keepGoing = true;
            for(int index = 0; keepGoing; index++){
                keepGoing = false;
                int count = 0;
                for(int i = 0; i < arraySize; i++){

                    if(bottom[i]>index){
                        count++;
                        keepGoing = true;
                    }else if(count>0){
                        temp += sumSequence.get(count);
                        count = 0;
                    }

                    if(i+1 == arraySize && bottom[i]>index && count>0){
                        temp += sumSequence.get(count);
                        count = 0;
                    }
                }
            }
            sum += temp;
        }
        return sum;
    }
}
