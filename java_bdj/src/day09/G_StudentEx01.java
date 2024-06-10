package day09;

import java.util.Scanner;

public class G_StudentEx01 {

	public static void setUpdate(Student05[] std, int stdCount, boolean isUpdate) {
		Scanner scan = new Scanner(System.in);

		int grade, classNum, stdNum;
		System.out.print("학년 반 번호 입력 : ");
		grade = scan.nextInt();
		classNum = scan.nextInt();
		stdNum = scan.nextInt();

		for(int i=0; i<stdCount; i++){
			if (std[i].getGrade() == grade && std[i].getClassNum() == classNum && std[i].getStdNum() == stdNum) {
				if (isUpdate) {
					int kor, eng, math;
					System.out.print("국어 영어 수학 성적 입력 : ");
					kor = scan.nextInt();
					eng = scan.nextInt();
					math = scan.nextInt();
					std[i].updateScore(kor, eng, math);
					break;
				} else {
					System.out.printf("성적 정보 : 국어 %d, 영어 %d, 수학 %d\n", std[i].getKor(), std[i].getEng(), std[i].getMath());
					break;
				}
			} 				
			if(i+1==stdCount)System.out.println("일치하는 학생 없슈");	
		}
		

	}

	public static void showMenu() {

		System.out.println("메뉴");
		System.out.println("1. 학생 등록");
		System.out.println("2. 성적 수정");
		System.out.println("3. 성적 확인");
		System.out.println("4. 종료");
		System.out.print("메뉴 선택 : ");
	}

	public static void runMenu() {

		Scanner scan = new Scanner(System.in);
		int stdCount = 0, totalStd = 10;
		Student05 std[] = new Student05[totalStd];
		int menuNum = -1;

		do {
			showMenu();
			menuNum = scan.nextInt();

			switch (menuNum) {
			case 1:
				if (totalStd > stdCount) {
					int grade, classNum, stdNum;
					String name;
					System.out.println("학생 등록");
					System.out.print("학년 반 번호 이름 입력 : ");
					grade = scan.nextInt();
					classNum = scan.nextInt();
					stdNum = scan.nextInt();
					name = scan.nextLine().replace(" ", "");
					std[stdCount++] = new Student05(grade, classNum, stdNum, name);

					break;
				} else
					System.out.println("정원 초과");

			case 2:
				System.out.println("성적 수정");
				setUpdate(std, stdCount, true);
				break;

			case 3:
				System.out.println("성적 확인");
				setUpdate(std, stdCount, false);
				break;
			case 4:
				System.out.println("종료");
				break;
			}

		} while (menuNum != 4);
		scan.close();
	}

	public static void main(String[] args) {
		// 학생 성적을 관리하기 위한 프로그램
		// 성적 : 국어, 영어, 수학
		// 1.메뉴가 출력되도록 코드를 작성.
		// 2.메뉴를 콘솔에서 입력 받는 코드 작성
		// 5.학생 등록 기능을 구현
		runMenu();

	}

}

class Student05 {
	private int kor, eng, math;
	private int grade, classNum, stdNum;
	private String name;

	Student05() {
	}

	public Student05(int grade, int classNum, int stdNum, String name) {
		this.grade = grade;
		this.classNum = classNum;
		this.stdNum = stdNum;
		this.name = name;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getClassNum() {
		return classNum;
	}

	public void setClassNum(int classNum) {
		this.classNum = classNum;
	}

	public int getStdNum() {
		return stdNum;
	}

	public void setStdNum(int stdNum) {
		this.stdNum = stdNum;
	}

	public void updateScore(int kor, int eng, int math) {
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

}
