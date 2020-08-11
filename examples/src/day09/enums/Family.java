package day09.enums;

// 열거형 생성자를 이용한 enum 상수 초기화
public enum Family {
    FATHER("아버지"), MOTHER("어머니"), SON("아들"), DAUGHTER("딸"); // 열거형 상수
    private String koreanWord; // 멤버 변수 (객체에 속하는 변수)

    Family(String koreanWord) {
        this.koreanWord = koreanWord;
    }

    public String getKoreanWord() {
        return koreanWord;
    }

    public void setKoreanWord(String koreanWord) {
        this.koreanWord = koreanWord;
    }
}
