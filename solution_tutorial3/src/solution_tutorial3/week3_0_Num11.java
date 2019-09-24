package solution_tutorial3;

import java.util.Arrays;
import java.util.Scanner;

public class week3_0_Num11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int test, day, p, result;
		int[] h;

		test = input.nextInt();
		while (test != 0) {
			result = 0;
			day = input.nextInt();
			p = input.nextInt();
			h = new int[p];

			for (int j = 0; j < p; j++) {
				h[j] = input.nextInt();
			}

			Arrays.sort(h);

			while (day != 0) {
				if ((day - 1) % 7 < 5) {
					for (int k = 0; k < p; k++) {
						if (day%h[k] == 0) {
							result++;
							break;
						}
					}
				}
				day--;
			}
			System.out.println(result);
			test--;
		}

		input.close();
	}

}
