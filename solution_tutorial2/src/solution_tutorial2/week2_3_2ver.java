package solution_tutorial2;

import java.util.ArrayList;
import java.util.Scanner;

public class week2_3_2ver {

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
				System.out.print("Pizza: " + pi + "\nHamburger: " + ham + "\nNothing: " + not);
				guest.clear();
				food.clear();
				pi=0;
				ham=0;
				not=0;
				continue;
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
				for(Object object : guest) {
		            String element = (String) object;
		            if(element.equals(recode[1])) {
		            	if (recode[1].equals("Pizza"))
							pi++;
						else
							ham++;
		            	guest.remove(recode[1]);
						break;
		            }
		            else if(element.equals("Any")) {
		            	if (recode[1].equals("Pizza"))
							pi++;
						else
							ham++;
						guest.remove("Any");
						break;
		            }
					else {
						continue;
					}
		        }
				continue;
			} else if (recode[0].equals("F") && guest.isEmpty()) { // �մ� ����
				food.add(recode[1]);
				continue;
			}
		}
		input.close();
	}

}