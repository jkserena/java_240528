package day12;

import java.util.regex.Pattern;

public class I_RegexEx02 {
	
	// 비밀번호 
	// 해당문자가 꼭 있는 지 확인 (?=.*[문자])
	// 대문자,소문자,숫자,!@#$%^ 특수문자 8~20 글자
	// 모든 특수문자 표현 방법 => [^A-Za-z0-9]
	// 숫자 아니고 영문 아닌 나머지 오.. 
	// ^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[^A-Za-z0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{8,20}$
	public static void main(String[] args) {
		final String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{8,20}$";
		final String string = "asdsadas!@#\n"
				 + "SADFsd123\n"
				 + "ASd12321@3\n"
				 + "ASD1234se5!@!\n"
				 + "jke13\n"
				 + "3ksd\n"
				 + "asd656\n"
				 + "jjkl1234\n"
				 + "K1234asdasd\n"
				 + "K123123JGgfJV\n";

		String tmp = string.replace("\n\n", "\n");
		// tmp = string.replace(" ", "");
		String[] str = tmp.split("\n");

		for(int i=0; i<str.length; i++) {
			if(Pattern.matches(regex, str[i])) {
				System.out.println("Group " + i + ": " + str[i]);
			}
		}

//		final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
//		final Matcher matcher = pattern.matcher(string);
//
//		while (matcher.find()) {
//			System.out.println("Full match: " + matcher.group(0));
//
//			for (int i = 1; i <= matcher.groupCount(); i++) {
//				System.out.println("Group " + i + ": " + matcher.group(i));
//			}
//		}
	}

}
