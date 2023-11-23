
import java.util.*;

//if we have correct closing and open brackets
public class balancedBrackets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                st.push(ch);
            } else if (ch == ')') {
                boolean val = handleClosing(st, '(');
                if (val == false) {
                    System.out.print(val);
                    return;
                }

            } else if (ch == ']') {
                boolean val = handleClosing(st, '(');
                if (val == false) {
                    System.out.print(val);
                    return;
                }

            } else if (ch == '}') {
                boolean val = handleClosing(st, '(');
                if (val == false) {
                    System.out.print(val);
                    return;
                }

            }
        }
        if (st.size() == 0) {
            System.out.println(true);

        } else {
            System.out.println(false);
        }
    }

    public static boolean handleClosing(Stack<Character> st, char cooreoch) {
        if (st.size() == 0) {

            return false;
        } else if (st.peek() != cooreoch) {

            return false;
        } else {
            st.pop();
            return true;
        }

    }
}
