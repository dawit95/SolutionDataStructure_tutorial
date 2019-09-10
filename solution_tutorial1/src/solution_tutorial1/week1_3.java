package solution_tutorial1;

import java.util.Scanner;

public class week1_3 {
	private static int cycleHas(int n, int x) {
		int max_length=0;
		for(int i = n;i <= x; i++) {
			int nbound = i, count =1;
			while (nbound != 1) {
				if (nbound == 0)
					nbound /= 2;
				else
					nbound = 3 * nbound + 1;
				count++;
			}
			if(count > max_length)
				max_length = count;
		}
		return max_length;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		while (input.hasNextInt()) {
			int n = input.nextInt();
			int x = input.nextInt();

			if (n > x)
				System.out.println(n+" "+x+" "+cycleHas(x, n));
			else
				System.out.println(n+" "+x+" "+cycleHas(n, x));
		}
		input.close();
	}
}
