package solution_tutorial4;

import java.util.Scanner;
import java.util.regex.Pattern;

public class week4_3 {
	static String name;

	public static int find(String ch) {
		int result = 0;
		String[] arrs = name.split("(?<!^)");
		for (int i = 0; i < arrs.length; i++) {
			if (arrs[i].equalsIgnoreCase(ch))
				result = i;
		}
		return result;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		char[][] arr = new char[6][6];
		String str, temp, check;

		name = input.nextLine();
		name = name.toUpperCase();
		check = "^(?i)[" + name + "\\s]*$";
		str = input.nextLine();
		for (int i = 0; i < 6; i++) {
			temp = str.substring(i * 6, i * 6 + 6);
			arr[i] = temp.toCharArray();
		}

		while (input.hasNext()) {
			String str_temp, answer = "";
			int index_i, index_j;
			str_temp = input.nextLine();
			String[] temp1 = new String[str_temp.length()];
			temp1 = str_temp.split("(?<!^)");
			int che = 0;
			boolean confirm = false;
			for (int i = 0; i < temp1.length; i++) {
				if (!temp1[i].equals(" ")) {
					che++;
				} else if (che % 2 == 1) {
					confirm = true;
					che = 0;
				} else {
					che = 0;
				}
			}
			if (che % 2 == 1)// 마지막단어 색출
				confirm = true;
			boolean bool = Pattern.matches(check, str_temp);
			if (!bool || confirm) {
				System.out.println("-ERROR-");
				continue;
			}
			int i = 0;
			while (i < temp1.length) {
				if (temp1[i].equals(" ")) {
					i++;
					answer += " ";
				} else {
					index_i = find(temp1[i].toUpperCase());
					index_j = find(temp1[i + 1].toUpperCase());
					answer += arr[index_i][index_j] + "";
					i += 2;
				}
			}
			System.out.println(answer);
		}
		input.close();
	}

}
