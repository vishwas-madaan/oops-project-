package vishu;
import java.util.Scanner;

public class MissingNumber {
    public static int findMissingNumber(int[] arr, int N) {
        int expectedSum = N * (N + 1) / 2;
        int actualSum = 0;
        for (int num : arr) {
            actualSum += num;
        }
        return expectedSum - actualSum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the value of N (range from 1 to N): ");
        int N = scanner.nextInt();

        int[] arr = new int[N - 1]; 

        System.out.println("Enter " + (N - 1) + " numbers (one number is missing): ");
        for (int i = 0; i < N - 1; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println("Missing Number: " + findMissingNumber(arr, N));

        scanner.close();
    }
}

