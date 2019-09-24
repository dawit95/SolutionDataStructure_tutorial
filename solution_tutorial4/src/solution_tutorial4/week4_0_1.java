package solution_tutorial4;

import java.util.Scanner;

public class week4_0_1 {

	/*
	 * 1 3 abc aad 5 aad 4 aad 4
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int number;
		String origin;
		char[] temp;
		String comparison;
		int[] alphabet = new int[26];
		int[] target;
		int result = 0;

		int test = 0;
		test = Integer.parseInt(input.nextLine());

		while (test != 0) {

			number = Integer.parseInt(input.nextLine());
			origin = input.nextLine();
			temp = new char[origin.length()];
			temp = origin.toLowerCase().toCharArray();

			for (int i = 0; i < temp.length; i++) {
				alphabet[(temp[i] - 'a')]++;
			}

			while (number != 0) {
				comparison = input.nextLine();
				temp = new char[comparison.length()];
				temp = comparison.toLowerCase().toCharArray();
				target = new int[26];

				for (int i = 0; i < temp.length; i++) {
					target[(temp[i] - 'a')]++;
				}

				for (int i = 0; i < 26; i++) {
					result += Math.abs(alphabet[i] - target[i]);
				}
				System.out.println(result);
				result = 0;
				number--;
			}
			test--;
		}

		input.close();
	}

}
