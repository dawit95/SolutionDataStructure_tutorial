package solution_tutorial9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class week9_2 {
	//행들의 집합
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

			// 1. DFS 수행 (다음 열인 2열 이동)
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
        	//i열의 가능한 후보자 찾기
            for (int i = 1; i <= n; i++) {
            	quen[k] = i;
                if (construct_candiates(k)) {
                	backtrack(k + 1);
                } else {
                	//아무 의미 없음. 여기서 끝
                	quen[k] = 0;
                }
            }
        }
	}

	
	
	public static void process_solution( int k) {
		String str = "";
		// 1행 부터 n행까지 문자로 만듬.
		for(int i =1; i<=n; i++){
			str += quen[i];
		}
		arr.add(str);
	}
	
	public static boolean is_a_solution(int k) {
		return k>n;
	}
	
	public static boolean construct_candiates(int c) {
		// 지나온 행의 놓인 퀸의 대각선과 같은 열 빼고 후보자 찾기 즉, i는 지나온 행,c는 현재 행.
        for (int i = 1; i < c; i++) {
            // 같은 행에 퀸
            if (quen[i] == quen[c]) {
                return false;
            }
            // 대각선
            if (Math.abs(quen[i] - quen[c]) == Math.abs(i - c)) {
                return false;
            }
        }
        return true;
	}

}
