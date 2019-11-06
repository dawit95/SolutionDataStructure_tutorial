package solution_tutorial9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class week9_2 {
	//����� ����
	static int[] quen;
	static int n;
	static ArrayList<String> arr;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		n = input.nextInt();
		arr = new ArrayList<String>();
		
		for (int i = 1; i <= n; i++) {
			quen = new int[n+1];
			quen[1] = i;

			// 1. DFS ���� (���� ���� 2�� �̵�)
			backtrack(2);
		}

		Collections.sort(arr);
		if(arr.isEmpty())
			for(int i=0;i<n;i++)
				System.out.print(0);
		else
			System.out.println(arr.get(0));
		
		input.close();
	}

	public static void backtrack(int k) {
		if (is_a_solution(k)) {
			process_solution(k);
        } else {
        	//i���� ������ �ĺ��� ã��
            for (int i = 1; i <= n; i++) {
            	quen[k] = i;
                if (construct_candiates(k)) {
                	backtrack(k + 1);
                } else {
                	//�ƹ� �ǹ� ����. ���⼭ ��
                	quen[k] = 0;
                }
            }
        }
	}

	
	
	public static void process_solution( int k) {
		String str = "";
		// 1�� ���� n����� ���ڷ� ����.
		for(int i =1; i<=n; i++){
			str += quen[i];
		}
		arr.add(str);
	}
	
	public static boolean is_a_solution(int k) {
		return k>n;
	}
	
	public static boolean construct_candiates(int c) {
		// ������ ���� ���� ���� �밢���� ���� �� ���� �ĺ��� ã�� ��, i�� ������ ��,c�� ���� ��.
        for (int i = 1; i < c; i++) {
            // ���� �࿡ ��
            if (quen[i] == quen[c]) {
                return false;
            }
            // �밢��
            if (Math.abs(quen[i] - quen[c]) == Math.abs(i - c)) {
                return false;
            }
        }
        return true;
	}

}
