package day10;

import java.util.Scanner;

public class A_VocabularyEx01 {

	// 메뉴판 출력
	// 단어가 있는 지 확인( 인덱스 추출 메소드)
	// 단어 의미 출력
	// 단어 의미 수정
	// 단어 삭제
	public static void sortWordList(Words[] words, int wordCount) {
		// bubble~ 젤 큰거 맨 뒤로
		for (int i = 0; i < wordCount - 1; i++) {
			for (int j = 0; j < wordCount - 1 - i; j++) {
				if (words[j].getWord().compareTo(words[j + 1].getWord()) > 0) {
					Words tmpWord = words[j];
					words[j] = words[j + 1];
					words[j + 1] = tmpWord;
				}
			}
		}
	}

	public static int showMenu(Scanner sc) {

		int menuNum;

		System.out.println("| 단어장 메뉴 |");
		System.out.print("| 1. 추가 ");
		System.out.print("| 2. 수정 ");
		System.out.print("| 3. 검색 ");
		System.out.print("| 4. 삭제 ");
		System.out.print("| 5. 종료 |\n");
		System.out.print("메뉴 선택 : ");
		menuNum = sc.nextInt();

		return menuNum;
	}

	public static boolean insertWord(Words[] words, int wordCount, Scanner sc) {

		Words tmpWord = tmpWord(sc, false);
		int indexWord = indexOfWord(words, tmpWord, wordCount);

		if (indexWord == -1) {
			words[wordCount] = tmpWord;
			System.out.println("단어를 등록 했습니다");
			return true;
		}
		System.out.println("단어가 이미 있습니다");
		return false;
	}

	public static void updateWord(Words[] words, int wordCount, Scanner sc) {

		Words tmpWord = tmpWord(sc, true);
		int indexWord = indexOfWord(words, tmpWord, wordCount);

		if (indexWord == -1) {
			System.out.println("수정할 단어가 없습니다.");
		} else {
			System.out.print("수정할 품사 입력 : ");
			words[indexWord].setPos(sc.nextLine());
			System.out.print("수정할 뜻 입력 : ");
			words[indexWord].setMeaning(sc.nextLine());
			System.out.println("수정 완료");
		}
	}

	public static void searchWord(Words[] words, int wordCount, Scanner sc) {

		Words tmpWord = tmpWord(sc, true);
		int indexWord = indexOfWord(words, tmpWord, wordCount);

		if (indexWord == -1) {
			System.out.println("조회할 단어가 없습니다");
		} else {
			words[indexWord].print();
		}
	}

	public static boolean deleteWord(Words[] words, int wordCount, Scanner sc) {

		Words tmpWord = tmpWord(sc, true);
		int indexWord = indexOfWord(words, tmpWord, wordCount);
		if (indexWord == -1) {
			System.out.println("삭제할 단어가 없습니다");
		} else {
			for (int i = indexWord; i < wordCount; i++) {
				words[i] = words[i + 1];
			}
			words[wordCount - 1] = null;
			System.out.println("삭제 완료");
			return true;
		}

		return false;
	}

	public static int indexOfWord(Words[] words, Words tmpWord, int wordCount) {
		int indexWord = -1;
		for (int i = 0; i < wordCount; i++) {
			if (words[i].getWord().equals(tmpWord.getWord())) {
				indexWord = i;
			}
		}
		return indexWord;
	}

	public static Words tmpWord(Scanner sc, boolean isSearch) {

		String word, meaning, pos;

		sc.nextLine();
		System.out.print("단어 입력 :");
		word = sc.nextLine();
		if (isSearch) {
			return new Words(word);
		}
		System.out.print("품사 입력 :");
		pos = sc.nextLine();
		System.out.print("뜻 입력 :");
		meaning = sc.nextLine();

		return new Words(word, pos, meaning);
	}

	public static void main(String[] args) {
		// 영어 단어를 관리하기 위한 Word 클래스를 만들고
		// 필요한 멤버변수 들을 선언 해보세요.

		Scanner sc = new Scanner(System.in);
		int menuNum;
		int wordCount = 0;
		final int wordMax = 10;
		Words[] words = new Words[wordMax];

		do {
			menuNum = showMenu(sc);

			switch (menuNum) {
			case 1:
				System.out.println("단어 추가");
				if (wordMax > wordCount) {
					if (insertWord(words, wordCount, sc)) {
						wordCount++;
						sortWordList(words, wordCount);
					}
				} else
					System.out.println("추가 불가 (갯수 초과)");
				break;
			case 2:
				System.out.println("단어 수정");
				if (wordCount != 0) {
					updateWord(words, wordCount, sc);
				} else
					System.out.println("수정 불가 (단어 없음)");
				break;
			case 3:
				System.out.println("단어 조회");
				if (wordCount != 0) {
					searchWord(words, wordCount, sc);
				} else
					System.out.println("조회 불가 (단어 없음)");
				break;
			case 4:
				System.out.println("단어 삭제");
				if (wordCount != 0) {
					if (deleteWord(words, wordCount, sc))
						wordCount--;
				} else
					System.out.println("삭제 불가 (단어 없음)");
				break;
			case 5:
				System.out.println("단어장 종료");
				break;
			}
		} while (menuNum != 5);

		sc.close();
	}
}

class Words {
	private String word, pos, meaning;

	public String getPos() {
		return pos;
	}

	public void setPos(String pos) {
		this.pos = pos;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getMeaning() {
		return meaning;
	}

	public void setMeaning(String meaning) {
		this.meaning = meaning;
	}

	public Words(String word, String pos, String meaning) {
		this.word = word;
		this.pos = pos;
		this.meaning = meaning;
	}

	public Words(String word) {
		this.word = word;
	}

	public void print() {
		System.out.println("---------------------");
		System.out.print("word : " + word);
		System.out.println(", pos : " + pos);
		System.out.println("meaning : " + meaning + "");
		System.out.println("---------------------");
	}

}
