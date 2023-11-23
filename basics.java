import java.util.*;

public class basics {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(10);
        st.push(20);
        st.push(30);
        st.push(40);
        st.push(50);
        st.push(60);

        System.out.println(st);
        System.out.println(st.peek() + " " + st.size());

        st.pop();
        st.pop();
        st.pop();
        System.out.println(st);

        System.out.println(st.peek() + " " + st.size());

    }
}