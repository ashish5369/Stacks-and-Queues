
// we have to build a stack and add the functionality like push pop display, its like we have an array now we are gong to five it stack ;ike functionaltiy
// if data is more than the array then do stack overflow and if less then do the stack underflow
import java.util.*;

public class buildNormalStack {

    public static class CustomStack {
        int[] data;
        int tos; // top of the stack
        // tos will mmove eveytime when we want to insert something ,its like a pointer

        public CustomStack(int cap) {
            data = new int[cap];
            tos = -1;
        }

        int size() {
            return tos + 1;
        }

        void display() {
            for (int i = tos; i >= 0; i--) {
                System.out.print(data[i] + " ");
            }
            System.out.println();
        }

        void push(int val) {
            if (tos == data.length - 1) {
                // if this is true that means tos on the top of the stack and there is nothing
                // to add in the stack
                System.out.println("Stack overflow");
            } else {
                tos++;
                data[tos] = val;

            }
        }

        int pop() {
            if (tos == -1) {
                System.out.println("Stack underflow");
                return -1;
            } else {
                int val = data[tos];
                tos--;
                return val;
            }

        }

        int top() {

            if (tos == -1) {
                System.out.println("Stack underflow");
                return -1;
            } else {
                return data[tos];
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        CustomStack st = new CustomStack(n);
        String str = sc.next();
        while (str.equals("quit") == false) {
            if (str.startsWith("push")) {
                int val = sc.nextInt();
                st.push(val);
            } else if (str.startsWith("pop")) {
                int val = st.pop();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("top")) {
                int val = st.top();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("size")) {
                System.out.println(st.size());
            } else if (str.startsWith("display")) {
                st.display();
            }
            str = sc.next();
        }
        sc.close();

    }
}
