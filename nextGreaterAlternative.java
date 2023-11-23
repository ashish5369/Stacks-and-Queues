import java.util.*;

public class nextGreaterAlternative {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] nge = new int[n];

        Stack<Integer> st = new Stack<>();
        // here we are not pushing the elements rather we are pushing the indexes of the
        // element and that is why we are entering 0 rather tha arr[0]
        st.push(0);
        for (int i = 0; i < arr.length; i++) {
            while (st.size() > 0 && arr[i] > arr[st.peek()]) {
                int pos = st.peek();
                nge[pos] = arr[i];
                st.pop();
            }
            st.push(i);
        }
        while (st.size() > 0) {
            int pos = st.peek();
            nge[pos] = -1;
            st.pop();
        }

        for (int i = 0; i < n; i++) {
            System.out.println(nge[i]);
        }

        sc.close();
    }
}
