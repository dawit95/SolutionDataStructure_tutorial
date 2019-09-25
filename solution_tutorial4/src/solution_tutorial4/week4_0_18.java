package solution_tutorial4;

import java.util.Scanner;

public class week4_0_18 {
	public static boolean match_find(char[] word, int start_i, int start_j) {
		// 8방향에 대한 i, j 증가분을 기록해둔다
	    int[] di = {-1, -1, -1, 0, 1, 1, 1, 0};
	    int[] dj = {-1, 0, 1, 1, 1, 0, -1, -1};
	    int i, j, t, dir;
int m=0,n=0;
int[][]a=new int[6][6];
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
		
		String line = input.nextLine();
		
		String[] words = line.split(" ");
		
		String[][] base = new String[1][6];
		
		base[0] = words;
		
		for (int i = 0; i < 6; i++)
		{
			System.out.print(base[0][i] + " ");
		}
	}

}
