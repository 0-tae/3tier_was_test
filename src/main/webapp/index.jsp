<%@ page import="com.example.servlet.HelloServlet" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
    <h1>3Tier 테스트 페이지</h1>
    <br>
    <button id="generate_button">DB에서 데이터 가져오기</button>
    <br>
    <div id="generate_zone">
        <%
            HelloServlet servlet = new HelloServlet();
            servlet.doGet(request, response);
        %>
    </div>
    <script src="test.js"></script>
</body>
</html>