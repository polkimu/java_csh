package ch07;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class JdbcPostTestHW {

//    private static final String DB_URL = "jdbc:mysql://localhost:3306/board_db?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
//    private static final String DB_USER = "user1";
//    private static final String DB_PASSWORD = "1111";

    private static final ResourceBundle bundle = ResourceBundle.getBundle("hikari");
    private static final String DB_URL = bundle.getString("jdbcUrl");
    private static final String DB_USER = bundle.getString("username");
    private static final String DB_PASSWORD = bundle.getString("password");

    public static void main(String[] args){
        findAll();
        insert(2, "2번이 등록한 게시글", "안녕하세요. 자바 공부 해요.");
        findById(10);
        update(10, "수정된 10번 게시글", "수정했어요");
        findAll();
        delete(10);
        findAll();
    }

    // 등록(C)
    static void insert(int memberId, String title, String content){
        Connection conn = null;
        Statement stmt = null;

        try{ // 플랜 A
            // 1. 데이터베이스 연결(Connection 객체 생성)
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // 2. SQL 실행하는 객체 생성(Statement 객체 생성)
            stmt = conn.createStatement();

            // 3. SQL 실행 (insert)

            // 4. 결과 수신(ResultSet 객체)
            int affectedRows = stmt.executeUpdate("INSERT INTO post (member_id, title, content) VALUES \n" +
                    "    ("+memberId+", '"+title+"', '"+content+"')");
            System.out.println("게시글 등록 완료, " + affectedRows + "건 반영됨");
        }catch(Exception e){ // 플랜 B
            System.out.println("에러 발생" + e.getMessage());
        }
        finally {
            // 5. 생성된 리소스를 생성의 역순으로 해제
            try{if(stmt!=null) stmt.close();} catch (Exception e) {}
            try{if(conn!=null) conn.close();} catch (Exception e) {}
        }
    }

    // 목록 조회(R)
    static void findAll(){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try{ // 플랜 A
            // 1. 데이터베이스 연결(Connection 객체 생성)
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // 2. SQL 실행하는 객체 생성(Statement 객체 생성)
            stmt = conn.createStatement();

            // 3. SQL 실행

            // 4. 결과 수신(ResultSet 객체)
            rs = stmt.executeQuery("SELECT * FROM post");

            while(rs.next()){ // 커서를 하나씩 내림
                int id = rs.getInt("id");
                int memberId = rs.getInt("member_id");
                String title = rs.getString("title");
                String content = rs.getString("content");
                String viewCount= rs.getString("view_count");
                String createdAt = rs.getString("created_at");

                System.out.println("id : " + id + ", 회원 id : " + memberId + ", 제목 : " + title + ", 내용 : " + content + ", 조회수 : " + viewCount + ", 게시일 : " + createdAt);
            } // 각 column


        }catch(Exception e){ // 플랜 B
            System.out.println("에러 발생" + e.getMessage());
        }
        finally {
            // 5. 생성된 리소스를 생성의 역순으로 해제
            try{if(rs!=null) rs.close();} catch (Exception e) {}
            try{if(stmt!=null) stmt.close();} catch (Exception e) {}
            try{if(conn!=null) conn.close();} catch (Exception e) {}
        }
    }

    // 한건 조회(R)
    static void findById(int id){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try{ // 플랜 A
            // 1. 데이터베이스 연결(Connection 객체 생성)
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // 2. SQL 실행하는 객체 생성(Statement 객체 생성)
            stmt = conn.createStatement();

            // 3. SQL 실행

            // 4. 결과 수신(ResultSet 객체)
            rs = stmt.executeQuery("SELECT * FROM post WHERE id="+id);

            while(rs.next()){ // 커서를 하나씩 내림
                int memberId = rs.getInt("member_id");
                String title = rs.getString("title");
                String content = rs.getString("content");
                String viewCount= rs.getString("view_count");
                String createdAt = rs.getString("created_at");

                System.out.println("id : " + id + ", 회원 id : " + memberId + ", 제목 : " + title + ", 내용 : " + content + ", 조회수 : " + viewCount + ", 게시일 : " + createdAt);
            } // 각 column


        }catch(Exception e){ // 플랜 B
            System.out.println("에러 발생" + e.getMessage());
        }
        finally {
            // 5. 생성된 리소스를 생성의 역순으로 해제
            try{if(rs!=null) rs.close();} catch (Exception e) {}
            try{if(stmt!=null) stmt.close();} catch (Exception e) {}
            try{if(conn!=null) conn.close();} catch (Exception e) {}
        }
    }

    // 수정(U)
    static void update(int id, String title, String content){
        Connection conn = null;
        Statement stmt = null;

        try{ // 플랜 A
            // 1. 데이터베이스 연결(Connection 객체 생성)
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // 2. SQL 실행하는 객체 생성(Statement 객체 생성)
            stmt = conn.createStatement();

            // 3. SQL 실행 (insert)

            // 4. 결과 수신(ResultSet 객체)
            int affectedRows = stmt.executeUpdate("UPDATE post SET title = '"+title+"', content = '"+content+"' WHERE id = " + id);
            System.out.println("회원 수정 완료 : " + affectedRows + "건 반영 됨");

        }catch(Exception e){ // 플랜 B
            System.out.println("에러 발생" + e.getMessage());
        }
        finally {
            // 5. 생성된 리소스를 생성의 역순으로 해제
            try{if(stmt!=null) stmt.close();} catch (Exception e) {}
            try{if(conn!=null) conn.close();} catch (Exception e) {}
        }
    }

    // 삭제(D)
    static void delete(int id){
        Connection conn = null;
        Statement stmt = null;

        try{ // 플랜 A
            // 1. 데이터베이스 연결(Connection 객체 생성)
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // 2. SQL 실행하는 객체 생성(Statement 객체 생성)
            stmt = conn.createStatement();

            // 3. SQL 실행 (insert)

            // 4. 결과 수신(ResultSet 객체)
            int affectedRows = stmt.executeUpdate("DELETE FROM post WHERE id =" + id);
            System.out.println("회원 삭제 완료 : " + affectedRows + "건 반영 됨");

        }catch(Exception e){ // 플랜 B
            System.out.println("에러 발생" + e.getMessage());
        }
        finally {
            // 5. 생성된 리소스를 생성의 역순으로 해제
            try{if(stmt!=null) stmt.close();} catch (Exception e) {}
            try{if(conn!=null) conn.close();} catch (Exception e) {}
        }
    }

}