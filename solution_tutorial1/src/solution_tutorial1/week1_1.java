package solution_tutorial1;

import java.util.Scanner;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		
		while(input.hasNextLine()){
			int words =0, letters = 0;
			String str = input.nextLine();
		
			for(int i =0; i<str.length(); i++){
				if(str.charAt(i) != ' ')
					letters++;
				if((i == 0 &&str.charAt(i) !=' ')||(i>0 && str.charAt(i-1)==' '&&str.charAt(i)!=' '))
					words++;
			}
			System.out.println(words +" "+ letters);
		}
		input.close();
	}
}