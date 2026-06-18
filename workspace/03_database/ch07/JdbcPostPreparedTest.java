package ch07;

import java.sql.*;

public class JdbcPostPreparedTest {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/board_db?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
    private static final String DB_USER = "user1";
    private static final String DB_PASSWORD = "1111";

    public static void main(String[] args){
        findAll();
        insert(2, "2번이 등록한 게시글", "안녕하세요. 자바 공부 해요.");
        findById(10);
        update(10, "수정된 10번 게시글", "수정했어요");
        findAll();
        delete(10);
        findAll();
        deleteAll(2);
        findAll("자바");

        login("haru@gmail.com", "123");
        login("haru@gmail.com", "pwd123");
        login("haru@gmail.com' or '1'='1", "111" );
    }
    // 로그인
    public static void login(String email, String password){
        String sql = "select * from member where email = ? and password = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try{ // 플랜 A
            // 1. 데이터베이스 연결(Connection 객체 생성)
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // 2. SQL 실행하는 객체 생성(Statement 객체 생성)
            pstmt = conn.prepareStatement(sql);

            // 3. SQL 실행
            pstmt.setString(1, email);
            pstmt.setString(2, password);
            // 4. 결과 수신(ResultSet 객체)
            rs = pstmt.executeQuery();

            if(rs.next()){ // 커서를 하나씩 내림
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String phone = rs.getString("phone");

                System.out.println("로그인에 성공했습니다.");
                System.out.println("ID : " + id + ", 이메일 : " + email + ", 이름 : " + name + ", 전화번호 : " + phone);
            } else{
                System.out.println("아이디와 패스워드를 확인하세요");
            }


        }catch(Exception e){ // 플랜 B
            System.out.println("에러 발생" + e.getMessage());
        }
        finally {
            // 5. 생성된 리소스를 생성의 역순으로 해제
            try{if(rs!=null) rs.close();} catch (Exception e) {}
            try{if(pstmt!=null) pstmt.close();} catch (Exception e) {}
            try{if(conn!=null) conn.close();} catch (Exception e) {}
        }
    }
    // 등록(C)
    static void insert(int memberId, String title, String content){
        String sql = "INSERT INTO post (member_id, title, content) VALUE(?, ?, ?)";
        Connection conn = null;
        PreparedStatement pstmt = null;

        try{ // 플랜 A
            // 1. 데이터베이스 연결(Connection 객체 생성)
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // 2. SQL 실행하는 객체 생성(Statement 객체 생성)
            pstmt = conn.prepareStatement(sql);

            // 3. SQL 실행 (insert)
            pstmt.setInt(1, memberId);
            pstmt.setString(2, title);
            pstmt.setString(3, content);
            int affectedRows = pstmt.executeUpdate();

            //System.out.println("게시글 등록 완료, " + affectedRows + "건 반영됨");

        }catch(Exception e){ // 플랜 B
            System.out.println("에러 발생" + e.getMessage());
        }
        finally {
            // 5. 생성된 리소스를 생성의 역순으로 해제
            try{if(pstmt!=null) pstmt.close();} catch (Exception e) {}
            try{if(conn!=null) conn.close();} catch (Exception e) {}
        }
    }

    static void findAll(){
        findAll("");
    }
    // 목록 조회(R)
    static void findAll(String keyword){
        String sql = "SELECT id, title, view_count as viewCount, created_at as createdAt FROM post";

        boolean hasKeyword = keyword != null && keyword.equals("");
        if(hasKeyword){
            sql += " WHERE title LIKE ? OR content LIKE ?";
        }
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try{ // 플랜 A
            // 1. 데이터베이스 연결(Connection 객체 생성)
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // 2. SQL 실행하는 객체 생성(Statement 객체 생성)
            pstmt = conn.prepareStatement(sql);

            // 3. SQL 실행
            if(hasKeyword) {
                pstmt.setString(1, "%" + keyword + "%");
                pstmt.setString(2, "%" + keyword + "%");
            }
            // 4. 결과 수신(ResultSet 객체)
            rs = pstmt.executeQuery();

            while(rs.next()){ // 커서를 하나씩 내림
                int id = rs.getInt("id");
                String title = rs.getString("title");
                int viewCount= rs.getInt("viewCount");
                String createdAt = rs.getString("createdAt");

                System.out.println("id : " + id +  ", 제목 : " + title + ", 조회수 : " + viewCount + ", 게시일 : " + createdAt);
            } // 각 column


        }catch(Exception e){ // 플랜 B
            System.out.println("에러 발생" + e.getMessage());
        }
        finally {
            // 5. 생성된 리소스를 생성의 역순으로 해제
            try{if(rs!=null) rs.close();} catch (Exception e) {}
            try{if(pstmt!=null) pstmt.close();} catch (Exception e) {}
            try{if(conn!=null) conn.close();} catch (Exception e) {}
        }
    }

    // 한건 조회(R)
    static void findById(int id){
        String sql = "SELECT id, title, content, view_count as viewCount, created_at as createdAt FROM post WHERE id = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try{ // 플랜 A
            // 1. 데이터베이스 연결(Connection 객체 생성)
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // 2. SQL 실행하는 객체 생성(Statement 객체 생성)
            pstmt = conn.prepareStatement(sql);

            // 3. SQL 실행
            pstmt.setInt(1,id);
            // 4. 결과 수신(ResultSet 객체)
            rs = pstmt.executeQuery();

            while(rs.next()){ // 커서를 하나씩 내림
                String title = rs.getString("title");
                String content = rs.getString("content");
                int viewCount= rs.getInt("viewCount");
                String createdAt = rs.getString("createdAt");

                System.out.println("id : " + id + ", 제목 : " + title + ", 내용 : " + content + ", 조회수 : " + viewCount + ", 게시일 : " + createdAt);
            } // 각 column


        }catch(Exception e){ // 플랜 B
            System.out.println("에러 발생" + e.getMessage());
        }
        finally {
            // 5. 생성된 리소스를 생성의 역순으로 해제
            try{if(rs!=null) rs.close();} catch (Exception e) {}
            try{if(pstmt!=null) pstmt.close();} catch (Exception e) {}
            try{if(conn!=null) conn.close();} catch (Exception e) {}
        }
    }

    // 수정(U)
    static void update(int id, String title, String content){
        String sql = "UPDATE post SET title = ? , content = ? WHERE id = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;

        try{ // 플랜 A
            // 1. 데이터베이스 연결(Connection 객체 생성)
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // 2. SQL 실행하는 객체 생성(Statement 객체 생성)
            pstmt = conn.prepareStatement(sql);

            // 3. SQL 실행 (insert)
            pstmt.setString(1,title);
            pstmt.setString(2,content);
            pstmt.setInt(3,id);
            // 4. 결과 수신(ResultSet 객체)
            int affectedRows = pstmt.executeUpdate();
            System.out.println("회원 수정 완료 : " + affectedRows + "건 반영 됨");

        }catch(Exception e){ // 플랜 B
            System.out.println("에러 발생" + e.getMessage());
        }
        finally {
            // 5. 생성된 리소스를 생성의 역순으로 해제
            try{if(pstmt!=null) pstmt.close();} catch (Exception e) {}
            try{if(conn!=null) conn.close();} catch (Exception e) {}
        }
    }

    // 삭제(D)
    static void delete(int id){
        String sql ="DELETE FROM post WHERE id =?";
        Connection conn = null;
        PreparedStatement pstmt = null;

        try{ // 플랜 A
            // 1. 데이터베이스 연결(Connection 객체 생성)
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // 2. SQL 실행하는 객체 생성(Statement 객체 생성)
            pstmt = conn.prepareStatement(sql);

            // 3. SQL 실행 (insert)
            pstmt.setInt(1,id);
            // 4. 결과 수신(ResultSet 객체)
            int affectedRows = pstmt.executeUpdate();
            System.out.println("게시글 삭제 완료 : " + affectedRows + "건 반영 됨");

        }catch(Exception e){ // 플랜 B
            System.out.println("에러 발생" + e.getMessage());
        }
        finally {
            // 5. 생성된 리소스를 생성의 역순으로 해제
            try{if(pstmt!=null) pstmt.close();} catch (Exception e) {}
            try{if(conn!=null) conn.close();} catch (Exception e) {}
        }
    }

    // 전체 게시글 삭제(D)
    static void deleteAll(int memberId){
        String sql ="DELETE FROM post WHERE member_id = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;

        try{ // 플랜 A
            // 1. 데이터베이스 연결(Connection 객체 생성)
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // 2. SQL 실행하는 객체 생성(Statement 객체 생성)
            pstmt = conn.prepareStatement(sql);

            // 3. SQL 실행 (insert)
            pstmt.setInt(1,memberId);
            // 4. 결과 수신(ResultSet 객체)
            int affectedRows = pstmt.executeUpdate();
            System.out.println("전체 게시글 삭제 완료. " + affectedRows +"건 반영됨" );

        }catch(Exception e){ // 플랜 B
            System.out.println("에러 발생" + e.getMessage());
        }
        finally {
            // 5. 생성된 리소스를 생성의 역순으로 해제
            try{if(pstmt!=null) pstmt.close();} catch (Exception e) {}
            try{if(conn!=null) conn.close();} catch (Exception e) {}
        }
    }
}