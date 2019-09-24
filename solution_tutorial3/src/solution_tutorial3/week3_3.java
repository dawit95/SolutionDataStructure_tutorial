package solution_tutorial3;

import java.util.Scanner;

public class week3_3 {

	public static boolean squt(int temp) {
		while (temp > 0) {
			if (temp > 1 && temp % 2 == 1) {
				return false;
			}
			temp /= 2;
		}
		return true;
	}

	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		int n, m, count;
		int[] number = new int[101];
		int[] result = new int[4];
		n = input.nextInt();
		m = input.nextInt();
		for (int i = 0; i < m; i++) {
			number[i] = input.nextInt();
		}
		for (int i = 0; i < 4; i++) {
			result[i] = 0;
		}
		for (int i = 1; i <= n; i++) {
			count = 0;
			if (squt(i)) { // 2제곱확인
				result[0]++;
				continue;
			}
			for (int j = 0; j < m; j++) {// 배수 확인
				if (i % number[j] == 0)
					count++;
			}
			switch (count) {
			case 3:
				result[0]++;
				break;
			case 2:
				result[1]++;
				break;
			case 1:
				result[2]++;
				break;
			default:
				result[3]++;
			}

		}

		for (int i = 0; i < 4; i++) {
			System.out.print(result[i] + " ");
		}
		input.close();
	}
}
