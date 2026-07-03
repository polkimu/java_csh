package ch04.echo.multi;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServerTask implements Runnable{

    @Override
    public void run() {
        try( ServerSocket ss = new ServerSocket(50000)){
            System.out.println("ServerSocket 생성 완료.");

            // 클라이언트의 접속 대기
            Socket s = ss.accept(); // 블로킹 작업
            System.out.println("클라이언트 접속: " + s.getInetAddress().getHostAddress());

            // 클라이언트의 메세지를 수신하는 InputStream 생성
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            // 클라이언트에 메세지를 송신하는 OutputStream 생성
            PrintWriter out = new PrintWriter(new OutputStreamWriter(s.getOutputStream()), true);
        } catch (IOException e){
            System.err.println("네트워크 예외 발생 : " + e.getMessage());
        }
    }
}
