package solution_tutorial4;

import java.util.Scanner;

public class week4_0_18 {
	public static boolean match_find(char[] word, int start_i, int start_j) {
		// 8���⿡ ���� i, j �������� ����صд�
	    int[] di = {-1, -1, -1, 0, 1, 1, 1, 0};
	    int[] dj = {-1, 0, 1, 1, 1, 0, -1, -1};
	    int i, j, t, dir;

	    for (dir = 0; dir < 8; dir++) {
	        i = start_i;
	        j = start_j;
	        t = 0;
	        while (i >= 0 && i < m && j >= 0 && j < n
	            && word[t] != '\0' && word[t] == a[i][j]) {
	            i += di[dir];
	            j += dj[dir];
	            t++;
	        }
	        if (word[t] == '\0')
	            return true;
	    }
		return false;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		char[][] str = new char[5][11];
		while(input.hasNext()) {
			String a = input.next();
			str[0] = a;
		}
		
		input.close();
	}

}