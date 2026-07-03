package ch03;

import java.io.*;

// 4. 입력(input.txt) -> 출력(output.txt)
public class FileToFile {
    void main(){
        try(
                InputStream fis = new FileInputStream("input.txt");
                OutputStream fos = new FileOutputStream("output.txt");
        ){
            int readData = 0;
            while ((readData = fis.read()) != -1){
                // 표준 출력 장치로 1Byte 출력한다
                fos.write(readData);
            }
        } catch (IOException e) {
            System.out.println("입출력 예외 발생 : " + e.getMessage());
        }
    }
}
