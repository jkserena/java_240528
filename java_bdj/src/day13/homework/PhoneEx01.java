package day13.homework;

import java.util.Scanner;

public class PhoneEx01 {

	public static int showMenu(Scanner sc) {

		int menuNum;

		System.out.println("| 연락처 메뉴 |");
		System.out.print("| 1. 추가 ");
		System.out.print("| 2. 수정 ");
		System.out.print("| 3. 검색 ");
		System.out.print("| 4. 삭제 ");
		System.out.print("| 5. 종료 |\n");
		System.out.print("메뉴 선택 : ");
		menuNum = sc.nextInt();

		return menuNum;
	}

	public static Phone[] expandWords(Phone[] pInfo, int newMax) {
		Phone tmp[] = new Phone[newMax];
		System.arraycopy(pInfo, 0, tmp, 0, pInfo.length);
		return tmp;
	}

	public static boolean insertWord(Phone[] pInfo, int pNumCount, Scanner sc) {

		Phone tmpPInfo = tmpPInfoGen(false, sc);

		for (int i = 0; i < pNumCount; i++) {
			if (tmpPInfo.getpNumber().equals(pInfo[i].getpNumber())) {
				return true;
			}
		}
		pInfo[pNumCount] = tmpPInfo;
		System.out.println("연락처를 등록 했습니다");

		return false;
	}

	public static Phone tmpPInfoGen(boolean isSearch, Scanner sc) {

		String name, pNum;

		sc.nextLine();
		System.out.print("이름 입력 :");
		name = sc.nextLine();
		if (isSearch) {
			return new Phone(name);
		}
		System.out.print("번호 입력 (010-1234-5678):");
		pNum = sc.nextLine();

		return new Phone(name, pNum);
	}

	public static void sortWordList(Phone[] pInfo, int pNumCount) {
		// bubble~ 젤 큰거 맨 뒤로
		for (int i = 0; i < pNumCount - 1; i++) {
			for (int j = 0; j < pNumCount - 1 - i; j++) {
				if (pInfo[j].getName().compareTo(pInfo[j + 1].getName()) > 0) {
					pInfo[j + 1] = myutils.utils.swap(pInfo[j], pInfo[j] = pInfo[j + 1]);
				}
			}
		}
	}

	// wordlist에서 searchword가 없다면 전체 출력.
	// searchword가 있다면 해당 연락처만 출력
	public static void printWordAll(Phone[] pInfo, int pNumCount, String searchName) {
		for (int i = 0; i < pNumCount; i++) {
			if (searchName == null)
				pInfo[i].print();
			else if (pInfo[i].getName().contains(searchName))
				pInfo[i].print();
		}
		System.out.println("---------------------");
	}

	public static void updateWord(Phone[] pInfo, int pNumCount, Scanner sc) {

		Phone tmpPInfo = tmpPInfoGen(true, sc);
		int indexPNum = indexOfWord(pInfo, tmpPInfo, pNumCount);

		if (indexPNum == -1) {
			System.out.println("수정할 연락처가 없습니다.");
		} else {

			int selectIndex = selectDuplicatedWord(tmpPInfo.getName(), pInfo, pNumCount, sc);

			tmpPInfo = tmpPInfoGen(false, sc);
			pInfo[selectIndex].updateWord(tmpPInfo);

			System.out.println("수정 완료");
		}
	}

	public static int indexOfWord(Phone[] pInfo, Phone tmpPInfo, int pNumCount) {
		int indexPNum = -1;
		for (int i = 0; i < pNumCount; i++) {
			if (pInfo[i].getName().contains(tmpPInfo.getName())) {
				// if (pInfo[i].getName().equals(tmpPInfo.getName())) {
				indexPNum = i;
			}
		}
		return indexPNum;
	}

	public static int selectDuplicatedWord(String searchName, Phone[] pInfo, int pNumCount, Scanner sc) {
		int dupIndexList[] = new int[pNumCount];
		int dupCount = 0;
		for (int i = 0; i < pNumCount; i++) {
			if (pInfo[i].getName().contains(searchName)) {
				dupIndexList[dupCount++] = i;
			}
		}

		int selectNum;
		for (int i = 0; i < dupCount; i++) {
			System.out.println(i + 1 + "번.");
			pInfo[dupIndexList[i]].print();
		}
		do {
			System.out.print("연락처의 번호를 선택하세요 : ");
			selectNum = sc.nextInt();
			if (selectNum <= dupCount && selectNum > 0) {
				return (dupIndexList[selectNum - 1]);
			} else
				System.out.println("번호를 잘 못 입력했습니다");
		} while (true);

	}
	
	public static void searchPInfo(Phone[] pInfo, int pNumCount, Scanner sc) {

		Phone tmpPInfo = tmpPInfoGen(true, sc);
		int indexPNum = indexOfWord(pInfo, tmpPInfo, pNumCount);

		if (indexPNum == -1) {
			System.out.println("조회할 연락처가 없습니다");
		} else {
			printWordAll(pInfo, pNumCount, tmpPInfo.getName());
			//words[indexPNum].print();
		}
	}
	
	public static boolean deleteWord(Phone[] pInfo, int pNumCount, Scanner sc) {

		Phone tmpPInfo = tmpPInfoGen(true, sc);
		int indexWord = indexOfWord(pInfo, tmpPInfo, pNumCount);
		if (indexWord == -1) {
			System.out.println("삭제할 연락처가 없습니다");
		} else {

			int selectIndex = selectDuplicatedWord(tmpPInfo.getName(), pInfo, pNumCount, sc);

			for (int i = selectIndex; i < pNumCount - 1; i++) {
				pInfo[i] = pInfo[i + 1];
			}
			pInfo[pNumCount - 1] = null;
			System.out.println("삭제 완료");
			return true;
		}

		return false;
	}

	public static void main(String[] args) {
		// 연락처 관리를 위한 프로그램을 만드세요.
		// 메뉴
		// 1. 연락처 추가
		// 2. 연락처 수정
		// 3. 연락처 삭제
		// 4. 연락처 검색
		// 5. 프로그램 종료
		// 메뉴선택

		// 1. 선택
		// 이름: bdj
		// 연락처: 010-1111-1111
		// ------------
		// 등록이 완료됐습니다.

		// 1. 선택
		// 이름: bdj
		// 연락처: 010-1234-1111
		// ------------
		// 등록이 완료됐습니다.

		// 1. 선택시 =>
		// 이름: bdj
		// 연락처: 010-1234-1111
		// ------------
		// 등록이 완료됐습니다.

		// 1. 선택시 =>
		// 이름: jkm
		// 연락처: 010-1234-1111
		// ------------
		// 이미 등록된 번호입니다.

		// 2. 선택시 =>
		// 이름: j
		// ------------
		// 1. jkm : 010-1234-1111
		// 2. jjj : 010-2662-6666
		// 번호선택 : 1
		// 이름: jbd
		// 번호: 010-2662-6666
		// -------------------
		// 이미 등록된 번호입니다. -> 아니라면 수정이 완료되었습니다.

		// 3. 선택시 =>
		// 이름: j
		// 1. jkm : 010-1234-1111
		// 2. jjj : 010-2662-6666

		Scanner sc = new Scanner(System.in);

		int max = 2;
		Phone[] ph = new Phone[max];
		int menuNum;
		int pNCount = 0;

		do {
			menuNum = showMenu(sc);

			switch (menuNum) {
				case 1:
					System.out.println("번호 추가");
					if (ph.length == pNCount) {
						System.out.println("휴대폰 저장 번호 확장");
						ph = expandWords(ph, ph.length + max);
					}

					boolean isExist = insertWord(ph, pNCount, sc);
					if (isExist) {
						System.out.println("저장 불가 (등록된 번호)");
					} else {
						pNCount++;
						sortWordList(ph, pNCount);
					}

					break;
				case 2:
					System.out.println("번호 수정");
					if (pNCount != 0) {
						updateWord(ph, pNCount, sc);
						// (ph, pNCount);
					} else
						System.out.println("수정 불가 (번호 없음)");
					break;
				case 3:
					System.out.println("연락처 조회");
					if (pNCount != 0) {
						 searchPInfo(ph, pNCount, sc);
					} else
						System.out.println("조회 불가 (번호 없음)");
					break;
				case 4:
					System.out.println("연락처 삭제");
					if (pNCount != 0) {
						if (deleteWord(ph, pNCount, sc))
						pNCount--;
					} else
						System.out.println("삭제 불가 (번호 없음)");
					break;
				case 5:
					System.out.println("종료");
					break;
				case 10:
					System.out.println("모든 연락처 출력");
					printWordAll(ph, pNCount, null);
					break;
			}
		} while (menuNum != 5);

		sc.close();

	}

}

class Phone {

	String name, pNumber;

	public Phone(String name, String pNumber) {
		this.name = name;
		this.pNumber = pNumber;
	}

	public Phone(String name) {
		this.name = name;
		this.pNumber = "";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getpNumber() {
		return pNumber;
	}

	public void setpNumber(String pNumber) {
		this.pNumber = pNumber;
	}

	public void print() {
		System.out.println("---------------------");
		System.out.println("이름 : " + name);
		System.out.println("번호 : " + pNumber + "");
		System.out.println("---------------------");
	}

	public void updateWord(Phone pInfo) {
		this.name = pInfo.name;
		this.pNumber = pInfo.pNumber;
	}

}
