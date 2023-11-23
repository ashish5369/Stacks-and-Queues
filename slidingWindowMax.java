import java.util.*;

public class slidingWindowMax {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();// this is the size of the window
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        // find the next greater of all the element of the array
        Stack<Integer> st = new Stack<>();
        int[] nge = new int[n];
        st.push(arr.length - 1);
        nge[arr.length - 1] = arr.length;

        for (int i = arr.length - 2; i >= 0; i--) {
            while (st.size() > 0 && arr[i] >= arr[st.peek()]) {
                st.pop();
            }
            if (st.size() == 0) {
                nge[i] = arr.length;// here we are not taking this to be -1 as we need to compare it in future to
                                    // show that there is no element bigger than this we have to make wither the
                                    // size of the array or infinity,so that while comparing this is the max ,and
                                    // there is no bigger element in the right
            } else {
                nge[i] = st.peek();
            }
            st.push(i);
        }
        int j = 0;
        for (int i = 0; i <= arr.length - k; i++) {
            // enter into this loop to find the maximum of window starting at i
            if (j < i) {
                j = i;
            }
            while (nge[j] < i + k) {
                j = nge[j];
            }
            System.out.println(arr[j]);

        }

        sc.close();

    }
}

// demo test :--
// 8 //array size
// 4 // window size
// enter the array
// 2
// 9
// 3
// 8
// 1
// 7
// 12
// 6
// Output will be:-
// 9
// 9
// 8
// 12
// 12
