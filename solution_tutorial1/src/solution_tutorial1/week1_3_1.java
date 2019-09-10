package solution_tutorial1;

import java.util.Scanner;

public class week1_3_1 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		

		while (input.hasNextInt()) {
			char result = 'N';
			int nbound = input.nextInt();
			int x = input.nextInt();

			if (nbound == x)
				result = 'Y';
			else
				while (nbound != 1) {
					if (nbound%2 == 0)
						nbound /= 2;
					else
						nbound = 3 * nbound + 1;
					if (nbound == x) {
						result = 'Y';
						break;
					}
				}

			System.out.println(result);
		}
		input.close();
	}
}