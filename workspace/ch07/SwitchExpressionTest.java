package ch07;

public class SwitchExpressionTest {
    public static void main(String[] args) {
        String role = "ADMIN";
        switch (role) {
            case "ADMIN" :
                System.out.println("관리자 권한");
                break;
            case "USER" :
                System.out.println("일반 사용자 권한");
                break;
            default :
                System.out.println("권한 없음");
                break;
        }

        //switch expression
        switch (role) {
            case "ADMIN" -> System.out.println("관리자 권한");
            case "USER" -> System.out.println("일반 사용자 권한");
            default -> System.out.println("권한 없음");
        }

        String result = switch (role) {
          case "ADMIN" -> "관리자 권한";
          case "USER" -> "일반 사용자 권한";
          default -> "권한 없음";
        };
        System.out.println(result);

        String day = "금";
         String type = switch(day) {
            case "월", "화", "수", "목", "금" -> "평일";
            case "토", "일" -> "주말";
            default -> "잘못된 요일";
        };
        System.out.println(type);

        int score = 90;
        String grade = switch (score){
          case 100, 90 -> {
              System.out.println("훌륭한 성적");
              yield "A";
          }
          case 80 -> "B";
          case 70 -> "C";
          case 60 -> "D";
          default -> "F";
        };
    }
}
