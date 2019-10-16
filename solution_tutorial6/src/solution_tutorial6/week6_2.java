package solution_tutorial6;

import java.util.Scanner;

public class week6_2 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		String standInt = input.nextLine();
		int count = Integer.parseInt(input.nextLine());
		int wh = count;
		while (wh != 0) {
			String temp = input.nextLine();
			char[] set = temp.toCharArray();
			String result ="";
			for (int j = 0; j < standInt.length(); j++) {
				for (int i = 0; i < set.length; i++) {
					if (standInt.charAt(j) == set[i]) {
						result += set[i];
					}
				}
			}
			System.out.println(result);
			wh--;
		}
		input.close();

	}

}
