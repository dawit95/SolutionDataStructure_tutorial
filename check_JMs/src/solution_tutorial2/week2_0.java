package solution_tutorial2;

import java.util.Scanner;

public class week2_0 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[] arr = new int[3000];
		boolean jolly = true;
		int num, diff, curr, prev;

		while (input.hasNextLine()) {
			num = input.nextInt();
			curr = input.nextInt();
			for (int i = 0; i < num; i++)
				arr[i] = 0;
			for (int i = 1; i < num; i++) {
				prev = input.nextInt();

				diff = curr - prev;
				diff = (diff < 0 ? -(diff) : diff);
				if (diff < 0 || diff >= num || arr[diff] == 1) {
					jolly = false;
					break;
				}
				arr[diff] = 1;
				curr = prev;
			}

			if (jolly)
				System.out.println("Jolly");
			else
				System.out.println("Not jolly");
		}

	}

}
