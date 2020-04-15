package Exam;

class GfG {

    // function to return the maximum
    // sum of decreasing subsequence
    // in arr[]
    public static int maxSumDS(int arr[], int n)
    {
        int i, j, max = 0;
        int[] MSDS = new int[n];
        for (i = 0; i < n; i++)
            MSDS[i] = arr[i];

        // Compute maximum sum values
        // in bottom up manner
        for (i = 1; i < n; i++)
            for (j = 0; j < i; j++)
                if (arr[i] >arr[j] &&
                        MSDS[i]> MSDS[j] + arr[i])
                    MSDS[i] = MSDS[j] + arr[i];

        // Pick maximum of all msds values
        for (i = 0; i < n; i++)
            if (max > MSDS[i])
                max = MSDS[i];

        return max;
    }

    // Drive Code
    public static void main(String argc[])
    {
        int arr[] = { 1, 5, 2, 3, 4 };

        int n = 5;

        System.out.println("Sum of maximum sum"
                + " decreasing subsequence is: "
                + maxSumDS(arr, n));
    }
}
