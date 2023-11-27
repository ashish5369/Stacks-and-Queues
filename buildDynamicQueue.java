import java.util.*;

//here we are not going to do the overflow rather we are going to double the array, copy the old array and start inserting there

public class buildDynamicQueue {
    public static class CustomQueue {
        int[] data;
        int front;
        int size;
        // these 2 variables are used as we need tow locations at any time - the
        // starting location to remove or peekl adn the last location for adding

        CustomQueue(int cap) {
            data = new int[cap];
            front = 0;
            size = 0;
        }

        int size() {
            return size;
        }

        void display() {
            for (int i = 0; i < size; i++) {
                int idx = (front + i) % data.length;
                System.out.print(data[idx]);
            }
            System.out.println();

        }

        void add(int val) {
            if (size == data.length) {
                int[] ndata = new int[2 * data.length];
                for (int i = 0; i < size; i++) {
                    int idx = (front + 1) % data.length;
                    ndata[i] = data[idx];
                }
                data = ndata;
                front = 0;
                int rear = (front + size) % data.length;
                data[rear] = val;
                size++;

            } else {
                int rear = (front + size) % data.length;
                data[rear] = val;
                size++;
            }

        }

        int remove() {
            if (size == 0) {
                System.out.println("underflow");
                return -1;

            } else {
                int val = data[front];
                front = (front + 1) % data.length;
                size--;
                return val;

            }

        }

        int peek() {
            if (size == 0) {
                System.out.println("underflow");
                return -1;
            } else {
                return data[front];

            }

        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        CustomQueue st = new CustomQueue(n);
        String str = sc.next();
        while (str.equals("quit") == false) {
            if (str.startsWith("add")) {
                int val = sc.nextInt();
                st.add(val);
            } else if (str.startsWith("remove")) {
                int val = st.remove();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("peek")) {
                int val = st.peek();
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
