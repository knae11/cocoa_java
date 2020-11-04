package mission2.인디언이름짓기;

import java.util.Scanner;

public class IndianName {
    public final String[] INDIAN_YEAR ={"시끄러운","푸른","어두운","조용한","웅크린","백색","지혜로운","용감한","날카로운","욕심많은"};
    public final String[] INDIAN_MONTH ={
            "늑대", "태양", "양", "매","황소", "불꽃", "나무", "달빛", "말", "돼지", "하늘", "바람"
    };
    public final String[] INDIAN_DAY={
            "와(과) 함께춤을","의 기상", "~은(는) 그림자속에", "★","★","★","의 환생","의 죽음","아래에서","을(를) 보라",
            "이(가) 노래하다.","의 그림자","의 일격","에게 쫒기는 남자","의 행진","의 왕","의 유령","을 죽인자","은(는) 맨날 잠잔다.",
            "처럼..","의 고향","의 전사","은(는) 나의친구","의 노래","의 정령","의 파수꾼","의 악마","와(과)같은 사나이",
            "를(을) 쓰러트린자","의 혼","은(는) 말이없다."
    };
    int lastNumOfYear;
    int month;
    int day;

    public void askBirth (){
        Scanner sc = new Scanner(System.in);
        System.out.println("생년월일을 입력해 주세요>");
        String year = sc.next();
        lastNumOfYear = Integer.parseInt(year.substring(year.length()-1));
        month = sc.nextInt();
        day = sc.nextInt();

        sc.close();
    }
    public void printName(){
        System.out.println("당신의 이름은 '"+INDIAN_YEAR[lastNumOfYear] + " " + INDIAN_MONTH[month-1] + INDIAN_DAY[day-1]+"'입니다.");
    }

}
