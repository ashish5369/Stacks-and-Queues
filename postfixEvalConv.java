
//evaluate the postfix and find solution adn convert to infix and prefix
import java.util.*;

public class postfixEvalConv {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String exp = sc.next();
        Stack<String> is = new Stack<>();
        Stack<String> ps = new Stack<>();
        Stack<Integer> val = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);
            if (ch == '+' || ch == '-' || ch == '/' || ch == '*') {
                int v2 = val.pop();
                int v1 = val.pop();
                int v = process(v1, v2, ch);
                val.push(v);

                String iv2 = is.pop();
                String iv1 = is.pop();
                String ivr = "(" + iv1 + ch + iv2 + ")";

                is.push(ivr);

                String ps2 = ps.pop();
                String ps1 = ps.pop();
                String psr = ch + ps1 + ps2;
                ps.push(psr);

            } else {
                is.push(ch + "");
                ps.push(ch + "");
                val.push(ch - '0');
            }
        }
        System.out.println(is.pop());
        System.out.println(ps.pop());

        System.out.println(val.pop());

        sc.close();
    }

    public static int process(int v1, int v2, char ch) {
        if (ch == '+') {
            return v1 + v2;
        } else if (ch == '-') {
            return v1 - v2;
        } else if (ch == '/') {
            return v1 / v2;
        } else {
            return v1 * v2;
        }
    }
}
