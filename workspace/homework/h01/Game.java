package homework.h01;

import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        int difficulty = 0; // 난이도
        int retry = 0;
        System.out.println("***멋쟁이 전사처럼***");
        while (true) { // 그만 둘때 까지
            System.out.println("캐릭터 이름을 지어주세요.");
            Scanner s1 = new Scanner(System.in);
            String name = s1.next();
            System.out.println("난이도");
            System.out.println("1.이지  2.하드");
            Scanner s2 = new Scanner(System.in);
            difficulty = s2.nextInt();
            while (difficulty != 1 && difficulty != 2){ // 1번이나 2번을 입력할때 까지 반복{
                System.out.println("1번 또는 2번을 입력해 주세요.");
                System.out.println("1.이지  2.하드");
                Scanner s3 = new Scanner(System.in);
                difficulty = s3.nextInt();
            } while (difficulty != 1 && difficulty != 2); // 1번이나 2번을 입력할때 까지 반복
            if (difficulty == 1) { // easy 선택
                easyMode(name);
            } else { // hard 선택
                hardMode(name);
            }
            System.out.println("\n1.continue  2.quit"); // 재도전 여부 물어봄
            Scanner s4 = new Scanner(System.in);
            retry = s4.nextInt();
            while (retry != 1 && retry != 2){ // 1번이나 2번을 입력할때 까지 반복
                System.out.println("1번 또는 2번을 입력해 주세요.");
                System.out.println("1.continue  2.quit");
                Scanner s5 = new Scanner(System.in);
                retry = s5.nextInt();
            }
            if (retry == 2) { // 2번 quit을 선택한다면
                break;
            } // 1번 continue를 선택하면 다시 반복
        }
    }

    static void easyMode(String name) { // 이지 모드, 기존 코드
        int hp = 50; //hp
        int damage = 0;
        int enemyHp = 0;
        int enemyDamage = 0;
        int ultimateSkill = 1; // 필살기 기술 수량
        System.out.println(name + "님 어서오세요. 이지 모드를 시작합니다.");

        enemyHp = (int)(Math.random() * 90) + 10; // 10 ~ 99

        while (true){
            System.out.println("적을 만났다. 어떻게 해야할까?");
            System.out.println("1) 싸운다 2) 도망간다 3) HP를 10 회복한다. 4) 필살기를 사용한다.");
            Scanner s = new Scanner(System.in);
            int action = s.nextInt();
            switch (action) {
                case 1 ->{
                    System.out.println("적과 싸웁니다");
                    enemyDamage = (int)(Math.random() * 11);
                    enemyHp -= enemyDamage;
                    damage = (int)(Math.random() * 11);
                    hp -= damage;
                    System.out.println("적에게 " +enemyDamage+ "만큼의 데미지를 주고 " + damage + "의 데미지를 입었다");
                    System.out.println("남은 체력은 " + hp + "입니다");
                    System.out.println("적의 남은 체력은 " + enemyHp + "입니다");
                }

                case 2 -> {
                    damage = (int)(Math.random() * 3);
                    hp -= damage;
                    enemyHp = (int)(Math.random() * 90) + 10; // 새로운 적 생성
                    System.out.println("도망친다. 하지만 " + damage + "의 체력이 소비되었다");
                    System.out.println("남은 체력은 " + hp + "입니다");
                }

                case 3 -> {
                    hp += 10;
                    System.out.println("체력이 10 회복되었다");
                    System.out.println("남은 체력은 " + hp + "입니다" );
                }
                case 4 -> {
                    if(ultimateSkill > 0) {
                        int chance = (int) (Math.random() * 2);
                        enemyDamage = enemyHp * chance;
                        enemyHp -= enemyDamage;
                        damage = 0;
                        ultimateSkill--;
                        System.out.println("궁극의 필살기를 사용했다.");
                        System.out.println("적에게 " + enemyDamage + "의 데미지를 주고 " + damage + "의 데미지를 입었다.");
                        System.out.println("나의 남은 체력은 " + hp + "입니다.");
                        System.out.println("적의 남은 체력은 " + enemyHp + "입니다.");
                    }
                    else {
                        System.out.println("사용할 수 있는 필살기가 없습니다.");
                    }
                }
                default -> {
                    System.out.println("1에서 4까지의 숫자를 입력해 주세요.");
                }
            }

            if(hp<=0 || enemyHp<=0){
                break;
            }
        }
        if(hp <= 0) {
            System.out.println("당신은 사망했습니다. -The end");
        } else if (enemyHp <= 0) {
            System.out.println("전투에 승리했습니다. -The end");
        }
    }

    static void hardMode(String name){
        int hp = 50; // 내 에너지
        int damage = 0; // 내 피해량
        int ultimateSkill = 1; // 필살기 기술 수량
        int enemyHp = 0; // 적군 에너지
        int enemyDamage = 0; // 적군 피해량
        int heal = 0; // 내 회복
        int enemyHeal = 0; // 적 회복
        double hitProbability = 0.0; // 적을 공격할 확률
        double hurtProbability = 0.0; // 적에게 공격 당할 확률
        double runProbability = 0.0; // 도망칠 확률

        enemyHp = (int)(Math.random() * 90) + 10; // 10 ~ 99

        System.out.println(name + "님 어서오세요. 하드 모드를 시작합니다.");
        while(true){
            System.out.println(enemyHp + " 체력을 가진 적을 만났다. 어떤 행동을 하시겠습니까?");
            System.out.println("1) 싸운다 2) 도망간다 3) HP를 회복한다. 단, 적도 HP를 회복한다. 4) 필살기를 사용한다");
            Scanner s = new Scanner(System.in);
            int action = s.nextInt();

            switch(action){
                case 1 -> {
                    System.out.println("적과 싸웁니다.");

                    //내가 적을 공격
                    hitProbability = Math.random(); // 내 공격 확률
                    if(hitProbability <0.3){ // 30% 확률로 나의 공격이 빗나감
                        System.out.println("나의 공격이 빗나갔다!");
                    } else { // 빗나가지 않았을 때 -> 적의 체력이 줄어든다
                        enemyDamage = (int)(Math.random() * 10) + 1; // 1~10 범위의 데미지
                        enemyHp -= enemyDamage;
                        System.out.println("적에게 " + enemyDamage + "의 데미지를 주었다.");
                    }

                    // 적이 나를 공격
                    hurtProbability = Math.random(); // 적 공격 확률
                    if(hurtProbability <0.3){ // 30% 확률로 적의 공격이 빗나감
                        System.out.println("적의 공격이 빗나갔다!");
                    } else { // 빗나가지 않았을 때 -> 내 체력이 줄어든다
                        damage = (int) (Math.random() * 10) + 1; // 1~10 범위의 데미지
                        hp -= damage;
                        System.out.println("내가 " + damage + "의 데미지를 입었다");
                    }
                    System.out.println("적의 남은 체력은 " + enemyHp + "입니다.");
                    System.out.println("나의 남은 체력은 " + hp + "입니다.");
                }
                case 2 -> {
                    damage = (int)(Math.random() * 3);
                    hp -= damage;
                    runProbability = Math.random(); //도망칠 확률
                    if(runProbability<0.5) { //도망 실패
                        System.out.println("도망치지 못했다! " + damage + "의 체력이 소비되었다.");
                        System.out.println("남은 체력은 " + hp + "입니다.");
                    }
                    else { // 도망 성공
                        enemyHp = (int) (Math.random() * 90) + 10; // 10 ~ 99
                        System.out.println("도망간다. 대신 " + damage + "의 체력이 소비되었다.");
                        System.out.println("남은 체력은 " + hp + "입니다.");
                    }
                }
                case 3 -> {
                    heal = (int)(Math.random() * 10); //0 ~ 10 랜덤하게 회복
                    enemyHeal = (int)(Math.random() * 10);// 적군도 랜덤하게 hp 회복
                    hp += heal;
                    enemyHp += enemyHeal;
                    System.out.println("체력이 "+ heal +"회복 되어 나의 남은 체력은 " + hp + "입니다.");
                    System.out.println("적의 체력이 " + enemyHeal + "회복 되어 적의 남은 체력은 " + enemyHp + "입니다");
                }
                case 4 -> {
                    if (ultimateSkill > 0) {
                        int chance = (int) (Math.random() * 2);
                        enemyDamage = (enemyHp * chance)/2;
                        enemyHp -= enemyDamage;
                        damage = 0;
                        ultimateSkill--;
                        System.out.println("궁극의 필살기를 사용했다.");
                        System.out.println("적에게 " + enemyDamage + "의 데미지를 주고 " + damage + "의 데미지를 입었다.");
                        System.out.println("나의 남은 체력은 " + hp + "입니다.");
                        System.out.println("적의 남은 체력은 " + enemyHp + "입니다.");
                    } else {
                        System.out.println("사용할 수 있는 필살기가 없습니다.");
                    }
                }
                default -> {
                    System.out.println("1에서 4까지의 숫자를 입력해 주세요.");
                }
            }

            // 게임 종료
            if(hp<=0 || enemyHp<=0){
                break;
            }
        }
        if(hp <= 0) {
            System.out.println("당신은 사망했습니다. -The end");
        } else if (enemyHp <= 0) {
            System.out.println("전투에 승리했습니다. -The end");
        }
    }
}