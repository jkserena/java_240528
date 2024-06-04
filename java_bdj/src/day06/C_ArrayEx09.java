package day06;

import java.util.Scanner;

public class C_ArrayEx09 {

	public static void main(String[] args) {

		// 문자열을 입력받아 입력받은 문자열이 있는 지 알려주는 코드를 작성
		Scanner scan = new Scanner(System.in);

		String[] list = { "dog", "cat", "java", "cup", "computer" };
		String str;
		System.out.print("문자열을 입력해보세요 : ");
		str = scan.nextLine();

		boolean isExist = false;
		for (String tmp : list) {
			if (tmp.equals(str)) {
				// System.out.println(tmp+ " 문자열이 있습니다.");
				isExist = true;
				break;
			}
		}
		System.out.println(str + "문자열이 " + (isExist ? "있습니다." : "없습니다."));

		scan.close();
	}

}
