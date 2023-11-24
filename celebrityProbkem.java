import java.util.*;

public class celebrityProbkem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            st.push(i);
        }

        while (st.size() >= 2) {
            int i = st.pop();
            int j = st.pop();
            if (arr[i][j] == 1) {
                // i knows j => i is not the celebrity so push j back in
                st.push(j);
            } else {
                // i does not know j => j is not the celebrity so push i back
                st.push(i);
            }
        }

        int pot = st.pop();
        for (int i = 0; i < n; i++) {
            if (i != pot) {
                if (arr[i][pot] == 0 || arr[pot][i] == 1) {
                    System.out.println("none");
                }
            }
        }

        System.out.println(pot);

        sc.close();
    }
}