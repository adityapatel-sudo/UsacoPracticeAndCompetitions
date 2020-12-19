package USACOTraining;

/*
ID: adityap12
LANG: JAVA
TASK: gift1
*/

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class gift1 {
    public static void main(String[] args) throws IOException {

        BufferedReader f = new BufferedReader(new FileReader("triangles.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));

        int people = Integer.parseInt(f.readLine());
        HashMap<String, Integer> namesAndMoney = new HashMap<String, Integer>();
        String[] names = new String[people];

        for (int i = 0; i< people;i++){
            String name = f.readLine();
            namesAndMoney.put(name,0);
            names[i] = name;
        }


        for(int i = 0; i < people;i++){

            String gifter = f.readLine();
            StringTokenizer st = new StringTokenizer(f.readLine());

            int money = Integer.parseInt(st.nextToken());
            int recipients = Integer.parseInt(st.nextToken());

            if(recipients == 0 ){
                continue;
            }
            if(money == 0){
                for(int j = 0; j<recipients;j++ ){
                    f.readLine();
                }
                continue;
            }
            int giftLoss = namesAndMoney.get(gifter);
            giftLoss -= money;
            giftLoss += money%recipients;
            namesAndMoney.put(gifter,giftLoss);

            if(recipients!=0) {

                money = money / recipients;
            }
            while(recipients != 0){
                String giftee = f.readLine();

                int giftGain = namesAndMoney.get(giftee);
                giftGain += money;
                namesAndMoney.put(giftee,giftGain);

                recipients--;
            }
        }
        for(int i = 0; i < people; i++){
            out.println(names[i]+" "+namesAndMoney.get(names[i]));
        }

        out.close();                                  // close the output file
    }
}
