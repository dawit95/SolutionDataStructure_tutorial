package solution_tutorial2;

import java.util.ArrayList;
import java.util.Scanner;

public class week2_3_1ver {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String str = null;
		String[] recode = new String[2];
		ArrayList<String> guest = new ArrayList<String>();
		ArrayList<String> food = new ArrayList<String>();

		int pi = 0, ham = 0, not = 0;

		while (input.hasNext()) {
			str = input.nextLine();
			recode = str.trim().split(" ");
			if (recode[0].equals("E")) {
				not += guest.size();
				break;
			}
			if (recode[0].equals("O") && !food.isEmpty()&& guest.size() < 2) {// food����
				if (food.contains(recode[1])) {// �䱸�� �´� food�� ����
					food.remove(recode[1]);
					if (recode[1].equals("Pizza"))
						pi++;
					else
						ham++;
					continue;
				} else if (recode[1].equals("Any")) {
					if (food.remove(0).equals("Pizza"))
						pi++;
					else
						ham++;
					continue;
				} else {
					guest.add(recode[1]);
					continue;
				}
			} else if (recode[0].equals("O") && food.isEmpty()&& guest.size() < 2) {// food ����
				guest.add(recode[1]);
				continue;
			} else if (recode[0].equals("O") && !guest.isEmpty() && guest.size() == 2) { // ��ٸ��� �մ���2��
				not++;
				continue;
			}
			if (recode[0].equals("F") && !guest.isEmpty()) {// �մ��� ����
				if (!guest.isEmpty() && guest.contains(recode[1])) {// �մ� �䱸�� ���� ������.
					if (recode[1].equals("Pizza"))
						pi++;
					else
						ham++;
					guest.remove(recode[1]);
					continue;
				} else if (!guest.isEmpty() && guest.contains("Any")) {// any ����.
					if (recode[1].equals("Pizza"))
						pi++;
					else
						ham++;
					guest.remove("Any");
					continue;
				}else {// �䱸�� ���� ����
					food.add(recode[1]);
					continue;
				}
			} else if (recode[0].equals("F") && guest.isEmpty()) { // �մ� ����
				food.add(recode[1]);
				continue;
			}
		}
		System.out.print("Pizza: " + pi + "\nHamburger: " + ham + "\nNothing: " + not);
		input.close();
	}

}