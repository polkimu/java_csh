package ch01;

public class TryCatchTest {
    void main() {
        divide(100, new String[] {"hello"});
        divide(100, new String[] {"  "});
        divide(100, new String[] {});
        divide(100, new String[] {null});
    }

    void divide(int num1, String[] arr){
        try{
            int num2 = arr[0].trim().length(); // str이 null일 경우 NullPointerException 발생
            int result = num1 / num2; // str이 ""일 경우 ArithmeticException 발생
            System.out.println(num1 + " / " + num2 + " = " + result);
        }catch(ArithmeticException e){
            System.out.println("0으로 나눌 수 없습니다.");
        }catch(NullPointerException e){
            System.out.println("arr[0]이 null입니다.");
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("arr 사이즈가 0입니다");
        }
        finally{System.out.println("finally는 try-catch 블럭이 실행된 뒤 항상 실행을 보장.");
        }
    }
}
