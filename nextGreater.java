import java.util.*;

public class nextGreater {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] nge = new int[n];

        Stack<Integer> st = new Stack<>();

        st.push(arr[arr.length - 1]);
        nge[arr.length - 1] = -1;

        for (int i = arr.length - 2; i >= 0; i--) {
            // pop till there are no elemtns are left or the no element greater than this
            // element is found

            while (st.size() > 0 && arr[i] >= st.peek()) {
                st.pop();
            }

            // once we come outside of the loop so either the stack is empty or the topmost
            // element is greater than the ith element
            // so if the stack is empty the nge is -1

            // and if the topmost is greater than the nge is the topmost

            if (st.size() == 0) {
                nge[i] = -1;
            } else {
                nge[i] = st.peek();
            }
            st.push(arr[i]);

        }

        for (int i = 0; i < n; i++) {
            System.out.println(nge[i]);
        }

        sc.close();
    }
}
