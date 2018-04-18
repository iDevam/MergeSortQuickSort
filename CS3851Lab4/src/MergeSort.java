import java.util.Arrays;

public class MergeSort implements Algorithm {

    @Override
    public String sort(int[] A) {
        long startTime = System.nanoTime();
        sort(A, 0, A.length - 1);
        System.out.println("[MergeSort] Sorted Array: " + Arrays.toString(A));
        return String.valueOf(System.nanoTime() - startTime);
    }

    private void merge(int A[], int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int L[] = new int [n1];
        int R[] = new int [n2];

        for (int i = 0; i < n1; i++) L[i] = A[l + i];
        for (int i = 0; i < n2; i++) R[i] = A[m + i + 1];

        int i = 0, j = 0;

        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                A[k] = L[i];
                i++;
            }
            else {
                A[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            A[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            A[k] = R[j];
            j++;
            k++;
        }
    }
    
    private void sort(int A[], int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;

            sort(A, l, m);
            sort(A , m + 1, r);

            merge(A, l, m, r);
        }
    }
}