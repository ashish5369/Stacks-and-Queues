import java.util.*;

public class infixConersions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String exp = sc.next();
        Stack<String> post = new Stack<>();
        Stack<String> pre = new Stack<>();
        Stack<Character> ops = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);

            if (ch == '(') {
                ops.push(ch);
            } else if ((ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
                pre.push(ch + "");
                post.push(ch + "");
            } else if (ch == ')') {
                while (ops.peek() != '(') {
                    char op = ops.pop();

                    String prev2 = pre.pop();
                    String prev1 = pre.pop();
                    String prev = op + prev1 + prev2;
                    pre.push(prev);

                    String postv2 = post.pop();
                    String postv1 = post.pop();
                    String postv = postv1 + postv2 + op;
                    post.push(postv);

                }
                ops.pop();

            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                while (ops.size() > 0 && ops.peek() != '(' && precedence(ch) <= precedence(ops.peek())) {
                    char op = ops.pop();

                    String prev2 = pre.pop();
                    String prev1 = pre.pop();
                    String prev = op + prev1 + prev2;
                    pre.push(prev);

                    String postv2 = post.pop();
                    String postv1 = post.pop();
                    String postv = postv1 + postv2 + op;
                    post.push(postv);

                }
                ops.push(ch);
            }

        }
        while (ops.size() > 0) {
            char op = ops.pop();

            String prev2 = pre.pop();
            String prev1 = pre.pop();
            String prev = op + prev1 + prev2;
            pre.push(prev);

            String postv2 = post.pop();
            String postv1 = post.pop();
            String postv = postv1 + postv2 + op;
            post.push(postv);

        }

        System.out.println(post.peek());
        System.out.println(pre.peek());

        sc.close();
    }

    public static int precedence(char ch) {
        if (ch == '+' || ch == '-') {
            return 1;
        } else if (ch == '*' || ch == '/') {
            return 2;
        } else {
            return 0;
        }
    }
}