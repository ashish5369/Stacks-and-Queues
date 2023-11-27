import java.util.*;
// here the concept is that the stack is never going to fully fill that is we can store as much as we want 

// here when the array is full then we will create a new array double the size and then copy all the old data and move tos to the last pos+1 ,continue storing the elements

public class dynamicStack {
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
            for (int i = tos; i > 0; i--) {
                System.out.print(data[i] + " ");
            }
            System.out.println();
        }

        void push(int val) {
            if (tos == data.length - 1) {
                // if this is true that means tos on the top of the stack and there is nothing
                // to add in the stack
                // so dont returnoverflow rather make a new array wiht double the size
                int[] ndata = new int[2 * data.length];
                for (int i = 0; i < data.length; i++) {
                    ndata[i] = data[i];
                }
                data = ndata;
                tos++;
                data[tos] = val;
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