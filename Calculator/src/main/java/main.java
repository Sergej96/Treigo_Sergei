import java.util.List;
import java.util.Scanner;

public class main {
    public static void main(String args[]) {
        try {
            Scanner in = new Scanner(System.in);
            //while (true) {;
            String str = in.nextLine();
            List<String> expression = ExpressionParse.parse(str);
            System.out.println("Ответ: " + new Calculator().evaluationOfExpression(expression));
            // }
        }
        catch (NumberFormatException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
