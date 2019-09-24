package solution_tutorial3;

import java.util.Arrays;
import java.util.Scanner;

public class week3_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int test, n, p, count, result, value;
		String str;
		int[] h;

		test = input.nextInt();
		while (test != 0) {
			result = 0;
			str = "";
			n = input.nextInt();
			p = input.nextInt();
			h = new int[p];

			for (int i = 0; i < p; i++) {
				h[i] = input.nextInt();
			}

			Arrays.sort(h);

			for (int i = 1; i <= n; i++) {
				value = i % 7;
				if (value != 4 && value != 1 && value != 0) {
					count = 0;
					for (int j = 0; j < p; j++) {
						if (i % h[j] == 0)
							count++;
						if ((p - (p / 2)) <= count) {
							result++;
							switch (value) {
							case 2:
								str += "Mon: " + i + "\n";
								break;
							case 3:
								str += "Tue: " + i + "\n";
								break;
							case 4:
								str += "Wed: " + i + "\n";
								break;
							case 5:
								str += "Thu: " + i + "\n";
								break;
							case 6:
								str += "Fri: " + i + "\n";
								break;
							case 0:
								str += "Sat: " + i + "\n";
								break;
							case 1:
								str += "Sun: " + i + "\n";
								break;
							default:
							}
							break;
						}
					}
				}
			}
			System.out.println("Lost: " + result + "\n" + str);
			test--;
		}
		input.close();

	}

}
