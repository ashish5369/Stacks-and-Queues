import java.util.*;

public class largestAreaInHistogram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 00; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // and we going to store the index of the nse as when we'll subtract the indexes

        int[] rb = new int[n]; // the next smallest element(nse) on the right
        Stack<Integer> st = new Stack<>();
        st.push(arr.length - 1);// this store the last element
        rb[arr.length - 1] = arr.length;

        for (int i = arr.length - 2; i >= 0; i--) {
            while (st.size() > 0 && arr[i] < arr[st.peek()]) {
                st.pop();
            }

            if (st.size() == 0) {
                rb[i] = arr.length;
            } else {
                rb[i] = st.peek();
            }
            st.push(i);

        }

        int[] lb = new int[n]; // the next smallest element on the left
        st = new Stack<>();

        st.push(0);// this store the last element
        lb[0] = -1;

        for (int i = 1; i < arr.length; i++) {
            while (st.size() > 0 && arr[i] < arr[st.peek()]) {
                st.pop();
            }

            if (st.size() == 0) {
                lb[i] = -1;
            } else {
                lb[i] = st.peek();
            }
            st.push(i);

        }

        // we'll get the width of the rectangle
        // width=index of nse on right - index of nse on left
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int width = rb[i] - lb[i] - 1;
            int area = arr[i] * width;
            if (area > maxArea) {
                maxArea = area;
            }
        }

        System.out.println(maxArea);

        sc.close();

    }
}
