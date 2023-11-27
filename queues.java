import java.util.*;

public class queues {
    public static void main(String[] args) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(10);
        System.out.println(q);
        q.add(20);
        System.out.println(q);

        q.add(30);
        System.out.println(q);

        q.add(40);
        System.out.println(q);

        q.add(50);
        System.out.println(q);

        q.remove();
        System.out.println(q);

        q.remove();
        System.out.println(q);

        q.remove();
        System.out.println(q);

        q.peek();
        System.out.println(q.peek());

    }
}