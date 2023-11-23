import java.util.*;

public class infixEvaluation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String exp = sc.next();

        Stack<Integer> opdns = new Stack<>();
        Stack<Character> optors = new Stack<>();
        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);
            if (ch == '(') {
                optors.push(ch);
            } else if (ch == ')') {
                while (optors.peek() != '(') {
                    char optor = optors.pop();
                    int v2 = opdns.pop();
                    int v1 = opdns.pop();
                    int opv = operation(v1, v2, optor);
                    opdns.push(opv);

                }
                optors.pop();

            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                // ch wants the higher proprity opeators to get rpocessd so waits
                while (optors.size() > 0 && optors.peek() != '(' && precedence(ch) <= precedence(optors.peek())) {
                    char optor = optors.pop();
                    int v2 = opdns.pop();
                    int v1 = opdns.pop();
                    int opv = operation(v1, v2, optor);
                    opdns.push(opv);
                }
                // now as all the high priooty are processed so we can push ch as well into the
                // stack
                optors.push(ch);

            } else if (Character.isDigit(ch)) {

                opdns.push(ch - '0');
            }

            // now as all the higher priortiy operators are processed so now we can

        }
        while (optors.size() != 0) {
            char optor = optors.pop();
            int v2 = opdns.pop();
            int v1 = opdns.pop();
            int opv = operation(v1, v2, optor);
            opdns.push(opv);

        }
        System.out.println(opdns.peek());

        sc.close();
    }

    public static int precedence(char optor) {
        // this returns the precedence of the operators
        if (optor == '+') {
            return 1;
        } else if (optor == '-') {
            return 1;
        } else if (optor == '*') {
            return 2;
        } else {
            return 2;
        }
    }

    public static int operation(int v1, int v2, char optor) {
        if (optor == '+') {
            return v1 + v2;
        } else if (optor == '-') {
            return v1 - v2;
        } else if (optor == '*') {
            return v1 * v2;
        } else {
            return v1 / v2;
        }

    }

}
