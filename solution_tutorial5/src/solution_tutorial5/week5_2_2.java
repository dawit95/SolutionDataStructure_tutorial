package solution_tutorial5;

import java.util.Scanner;

public class week5_2_2 {
	// ���ĺ� ���� ����
	public static int count(String str) {
		int result = 0;
		int[] origin = new int[26];
		char[] arr;

		arr = new char[str.length()];
		arr = str.toCharArray();
		for (int i = 0; i < str.length(); i++) {
			if (origin[arr[i] - 'a'] == 0)
				origin[arr[i] - 'a']++;
		}
		for (int i = 0; i < origin.length; i++) {
			result += origin[i];
		}
		return result;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		while (input.hasNext()) {
			String temp;
			String[] code = new String[20], deco = new String[20];
			char[] ch1 = new char[10], ch2 = new char[10];
			char[] map = new char[256], map2 = new char[256];

			temp = input.nextLine();
			code = temp.trim().split(" ");
			temp = input.nextLine();
			deco = temp.trim().split(" ");

			boolean ccc = false;
			for (int i = 0; i < code.length; i++) {
				int check = 0;
				int cceck = 0;
				ch1 = code[i].toCharArray();
				for (int j = 0; j < deco.length; j++) {
					if (code[i].equals("") || deco[j].equals(""))
						continue;
					// ������ ���� ã��
					if (code[i].length() == deco[j].length()) {
						check++;
						ch2 = deco[j].toCharArray();
						cceck = j;

					}

				}
				// ������ ���̸� map�� �ֱ� 1����
				if (check == 1 && !code[i].equals("")) {
					for (int k = 0; k < ch1.length; k++) {
						map[ch1[k]] = ch2[k];
					}
					code[i] = "";
					deco[cceck] = "";
				}

				if (!code[i].equals(""))
					ccc = true;

			}
			// �ʼ��� �� ������
			if (ccc) {
				for (int i = 0; i < code.length; i++) {
					if (code[i].equals(""))
						continue;
					for (int j = 0; j < deco.length; j++) {
						if (deco[j].equals(""))
							continue;
						if (code[i].length() == deco[j].length() && (count(code[i]) == count(deco[j]))) {
							boolean hi = true;
							ch1 = code[i].toCharArray();
							ch2 = deco[j].toCharArray();
							for (int k = 0; k < ch1.length; k++) {
								if ((map[ch1[k]] != 0 && map[ch1[k]] != ch2[k])||(map2[ch1[k]] != 0 && map2[ch1[k]] != ch2[k])) {
									map2 = new char[256];
									hi = false;
									break;
								} else {
									map2[ch1[k]] = ch2[k];
								}
							}
							if (hi) {
								for (int t = 97; t < 123; t++) {
									if (map[t] == 0)
										map[t] = map2[t];
								}
								code[i] = "";
								deco[j] = "";
							}
						}
					}
				}
			}
			String str = "the quick brown fox jumps over the lazy dog";
			char[] chstr = new char[str.length()];
			chstr = str.toCharArray();
			for (int i = 0; i < str.length(); i++) {
				System.out.print(chstr[i] == ' ' ? " " : map[chstr[i]]);
			}
			System.out.print("\n");
			for (int i = 97; i < 123; i++) {
				System.out.println((char) i + " " + map[i]);
			}
		}
		input.close();
	}

}
