package solution_tutorial9;

import java.util.Scanner;

public class week9_1 {
	static int count;
	static String num;
	static String result;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		while (input.hasNext()) {
			num = input.nextLine();
			count = 0;
			result = null;
			// 원본크기
			int len = num.length();
			backtrack("", len);

			if (count == 0)
				System.out.println("zero");
			else if (count == 1)
				System.out.println(result);
			else
				System.out.println("multiple");

		}

		input.close();
	}

	public static void backtrack(String k, int len) {
		int k_Len = k.length();
		if (k_Len == len && is_a_solution(k, len, k_Len)) {
			count++;
			result = k;
		} else if (k_Len < len) {
			for (int i = 0; i < 2; i++) {
				// k+i값은 현재 함수stack으로 복귀시 k
				if (construct_candiates(k + i, k_Len + 1)) {
					backtrack(k + i, len);
				}
			}
		}
	}

	public static boolean is_a_solution(String k, int len, int k_Len) {
		char[] arrCh1 = num.toCharArray();
		char[] arrCh2 = k.toCharArray();
		if (arrCh2[1] == arrCh2[k_Len - 1] && arrCh1[0] != arrCh2[0])
			return false;
		else if (arrCh2[1] != arrCh2[k_Len - 1] && arrCh1[0] == arrCh2[0])
			return false;
		else if (arrCh2[0] == arrCh2[k_Len - 2] && arrCh1[k_Len - 1] != arrCh2[k_Len - 1])
			return false;
		else if (arrCh2[0] != arrCh2[k_Len - 2] && arrCh1[k_Len - 1] == arrCh2[k_Len - 1])
			return false;
		return true;
	}

	public static boolean construct_candiates(String k, int k_Len) {
		if (k_Len < 3)
			return true;
		char[] arrCh1 = num.toCharArray();
		char[] arrCh2 = k.toCharArray();
		for (int i = 0; i < k_Len - 2; i++) {
			if (arrCh2[i] == arrCh2[i + 2] && arrCh1[i + 1] != arrCh2[i + 1])
				return false;
			else if (arrCh2[i] != arrCh2[i + 2] && arrCh1[i + 1] == arrCh2[i + 1])
				return false;
		}
		return true;
	}

}
