package Bharati.no;
import java.io.*;

public class Main {
    public static void main(String argv[]) {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer input = new StreamTokenizer(r);
        textAnalysis tree = new textAnalysis();
        try {
            int x = input.nextToken();

            while (x != StreamTokenizer.TT_EOF - 1) {
                if (input.ttype == StreamTokenizer.TT_WORD) {
                    tree.insert(input.sval.toUpperCase());
                }
                x = input.nextToken();
            }
        } catch (IOException e) {
            System.out.println("something went wrong while reading input");
        }
        System.out.println("----------Alphabetical Order----------");
        tree.inorder();
    }
}
