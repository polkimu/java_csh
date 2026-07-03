package ch03;

import java.io.FileOutputStream;
import java.io.IOException;

// 2. 표준 입력 장치(키보드) -> 파일(output.txt)
public class KeyboardToFile {
    void main(){
        try(
                FileOutputStream fos = new FileOutputStream("output.txt");
        ){
            // 표준 입력 장치로 부터 1Byte 읽어온다
            int readData = 0;
            while ((readData = System.in.read()) != -1){
                // 표준 출력 장치로 1Byte 출력한다
                fos.write(readData);
            }
        } catch (IOException e) {
            System.out.println("입출력 예외 발생 : " + e.getMessage());
        }
    }
}
