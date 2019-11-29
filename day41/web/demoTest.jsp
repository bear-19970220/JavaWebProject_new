<%@ page import="domain.Student" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%--
  Created by IntelliJ IDEA.
  User: FTDN
  Date: 2019/11/26
  Time: 11:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="error.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    //    List<Student> students = new ArrayList<>(3);
//    students.add(new Student("极光之域", "男", new Date()));
//    students.add(new Student("墨尘溪", "男", new Date()));
//    students.add(new Student("绫地宁宁", "女", new Date()));
//    request.setAttribute("students", students);
    Map<String, String> map = new HashMap<>();
    map.put("s1", "张三");
    map.put("s2_2", "李四");
    map.put("s-3", "王五233");
    request.setAttribute("map", map);

%>

<%--${requestScope.students[0]}--%>
<%--${requestScope.students[0].sname}--%>
${requestScope.map.s1}
${requestScope.map.s2_2}
<%--${requestScope.map.s-3}--%>
<%--${requestScope.map['s-3']}--%>
${requestScope.map["s-3"]}


</body>
</html>
