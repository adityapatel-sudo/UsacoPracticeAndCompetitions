import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {

        StringBuilder stringh = new StringBuilder();
        stringh.append("123456");
        stringh.delete(2,3);
        stringh.replace(2,2,"b");
        System.out.println(stringh.toString());
   }

}
