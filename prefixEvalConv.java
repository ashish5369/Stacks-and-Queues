
//here we'll the process in reverse
import java.util.*;

public class prefixEvalConv {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String exp = sc.next();

        Stack<Integer> vs = new Stack<>();
        Stack<String> is = new Stack<>();
        Stack<String> ps = new Stack<>();

        for (int i = exp.length() - 1; i >= 0; i--) {
            char ch = exp.charAt(i);

            if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {

                int vs1 = vs.pop();
                int vs2 = vs.pop();
                int vsr = calculation(vs1, vs2, ch);
                vs.push(vsr);

                String is1 = is.pop();
                String is2 = is.pop();
                String isr = "(" + is1 + ch + is2 + ")";
                is.push(isr);

                String ps1 = ps.pop();
                String ps2 = ps.pop();
                String psr = ps1 + ps2 + ch;
                ps.push(psr);

            } else {
                vs.push(ch - '0');
                is.push(ch + "");
                ps.push(ch + "");

            }
        }

        System.out.println(is.pop());
        System.out.println(vs.pop());
        System.out.println(ps.pop());
        sc.close();

    }

    public static int calculation(int vs1, int vs2, char ch) {
        if (ch == '+') {
            return vs1 + vs2;
        } else if (ch == '-') {
            return vs1 - vs2;

        } else if (ch == '/') {
            return vs1 / vs2;

        } else if (ch == '*') {
            return vs1 * vs2;

        } else {
            return 0;
        }

    }

}