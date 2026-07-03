package ch03;

import java.io.*;

// 4. 입력(output.txt) -> 출력(output-copy.txt)
public class FileCopyTest {
    void main(){
        long start = System.currentTimeMillis();

//        copyFile("lib/mysql-connector-j-9.7.0.jar", "output-copy.txt");
//        copyFileUseBuffer("lib/mysql-connector-j-9.7.0.jar", "output-copy.txt");
        copyFileCustomBuffer("lib/mysql-connector-j-9.7.0.jar", "output-copy.txt");

        long end = System.currentTimeMillis();
        System.out.println("소요시간 : " + (end - start) + "ms");
    }

    /**
     * 1차 스트림(FileInputStream, FileOutputStream)을 이용해서 파일을 복사한다
     * @param org 원본 파일명
     * @param dest 복사해서 새로 만들 파일명
     */
    void copyFile(String org, String dest){
        try(
                FileInputStream fis = new FileInputStream(org);
                FileOutputStream fos = new FileOutputStream(dest);
        ){
            // 표준 입력 장치로 부터 1Byte 읽어온다
            int readData = 0;
            while ((readData = fis.read()) != -1){
                // 표준 출력 장치로 1Byte 출력한다
                fos.write(readData);
            }
        } catch (IOException e) {
            System.out.println("입출력 예외 발생 : " + e.getMessage());
        }
    }

    /**
     * 2차 스트림(BufferedInputStream, BufferedOutputStream)을 이용해서 파일을 복사한다
     * @param org 원본 파일명
     * @param dest 복사해서 새로 만들 파일명
     */
    void copyFileUseBuffer(String org, String dest){
        try(
                InputStream bis = new BufferedInputStream(new FileInputStream(org)); // 8KB 버퍼를 생성
                OutputStream bos = new BufferedOutputStream(new FileOutputStream(dest));
        ){
            // 표준 입력 장치로 부터 1Byte 읽어온다
            int readData = 0;
            while ((readData = bis.read()) != -1){
                // 표준 출력 장치로 1Byte 출력한다
                bos.write(readData);
            }
        } catch (IOException e) {
            System.out.println("입출력 예외 발생 : " + e.getMessage());
        }
    }

    void copyFileCustomBuffer(String org, String dest){
        try(
                FileInputStream fis = new FileInputStream(org); //
                FileOutputStream fos = new FileOutputStream(dest);
        ){
            byte[] buffer = new byte[1024 * 8]; // 8KB 버퍼 생성
            int readSize = 0;
            while ((readSize = fis.read(buffer)) != -1){
                // 표준 출력 장치로 1Byte 출력한다
                fos.write(buffer, 0, readSize);
            }
        } catch (IOException e) {
            System.out.println("입출력 예외 발생 : " + e.getMessage());
        }
    }
}
