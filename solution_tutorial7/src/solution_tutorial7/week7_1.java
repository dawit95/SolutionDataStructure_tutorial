package solution_tutorial7;

import java.util.Scanner;

public class week7_1 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while (input.hasNext()) {
			String str = input.nextLine();
			String[] arrStr = str.trim().split(" ");
			int n, k;
			n = Integer.parseInt(arrStr[0]);
			k = Integer.parseInt(arrStr[1]);
			int[] arr = new int[21];

			if(n>k) {
				// k까지의 값
				for (int i = 1; i < k + 1; i++)
					arr[i] = fibonacci(i);
				
				// k이후의 값
				for (int i = k + 1; i <= n; i++) {
					for (int j = 1; j <= k; j++)
						arr[i] += arr[i - j];
				}
			}else {
				for (int i = 1; i <= n; i++) {
					arr[i] = fibonacci(i);
				}
			}
			System.out.println(arr[n]);
		}
		input.close();
	}
	// 자신을 포함하는 피보나치
	static int fibonacci(int n) {
		int re = 0;
		if (n <1)
			return 0;
		else {
			for (int i = 1; i < n; i++)
				re += fibonacci(n - i);
			return re + 1;
		}
	}

}
