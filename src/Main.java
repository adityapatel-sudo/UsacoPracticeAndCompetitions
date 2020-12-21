import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {

        String test = "200 123";
        StringTokenizer st = new StringTokenizer(test);

        System.out.println(st.nextToken());
        System.out.println(st.nextToken());
   }

}
