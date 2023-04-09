package com.example.servlet;

import java.io.*;
import java.sql.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "servlet", urlPatterns = {"/servlet"})
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        Connection conn = null;
        try {
            // JDBC 드라이버 로딩
            Class.forName("com.mysql.jdbc.Driver");

            // 데이터베이스 연결 설정
            String url = "jdbc:mysql://localhost:3306/test";
            String username = "root";
            String password = "dydrkfl#7!";
            conn = DriverManager.getConnection(url, username, password);

            // 쿼리 실행
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM testtable";
            ResultSet rs = stmt.executeQuery(sql);

            // 결과 출력
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");

                message="ID: " + id + ", Name: " + name;
            }

            // 연결 해제
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println(message);
    }

    public void destroy() {
    }
}