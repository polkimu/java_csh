package homework.h02;

import java.util.Scanner;

public class GameFunction {
    static int heal(int hp) {
        hp += 10;
        System.out.println("체력이 10 회복되었다");
        System.out.println("남은 체력은 " + hp + "입니다" );
        return hp;
    }

    static void useUltimateSkill(int hp, int enemyHp, int ultimateSkill){
        if(ultimateSkill > 0) {
            int chance = (int) (Math.random() * 2);
            int enemyDamage = enemyHp * chance;
            enemyHp -= enemyDamage;
            int damage = 0;
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

    static void ending(int hp, int enemyHp){
        if(hp <= 0) {
            System.out.println("당신은 사망했습니다. -The end");
        } else if (enemyHp <= 0) {
            System.out.println("전투에 승리했습니다. -The end");
        }
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("***멋쟁이 전사처럼***");
        System.out.println("캐릭터 이름을 지어주세요");
        String name = s.next();
        int hp = 100; //hp
        int damage = 0;
        int enemyHp = 0;
        int enemyDamage = 0;
        int ultimateSkill = 1; // 필살기 기술 수량
        System.out.println(name+ "님 어서오세요. 게임을 시작합니다.");

        enemyHp = (int)(Math.random() * 90) + 10; // 10 ~ 99

        while (true){
            System.out.println("적을 만났다. 어떻게 해야할까?");
            System.out.println("1) 싸운다 2) 도망간다 3) HP를 10 회복한다. 4)필살기를 사용한다");
            int action = s.nextInt();
            switch (action) {
                case 1 ->{
                    System.out.println("적과 싸웁니다");
                    enemyDamage = (int)(Math.random() * 11);
                    enemyHp -= enemyDamage;
                    damage = (int)(Math.random() * 11);
                    hp -= damage;
                    System.out.println("적에게 " +enemyDamage+ "만큼의 데미지를 주고" + damage + "의 데미지를 입었다");
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
                    hp = heal(hp);
                }

                case 4->{
                    useUltimateSkill(hp, enemyHp, ultimateSkill);
                }
            }

            if(hp<=0 || enemyHp<=0){
                break;
            }
        }

    }
}
