<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Spring Boot Application with JSP</title>
</head>
<body>
<input type="button" id="boj_problem_refreshAll" value="갱신하기">
</body>
<script>
    const boj_problem_refreshAll_btn = document.querySelector("#boj_problem_refreshAll");

    boj_problem_refreshAll_btn.addEventListener('click',()=>{
        fetch("/refresh/1");
    })
</script>
</html>