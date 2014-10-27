<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <title></title>
</head>
<body>
<s:guest>guest</s:guest>
<s:user>user</s:user>
<span>This is a secure resource</span>
<a href="${pageContext.request.contextPath}/logout">logout</a>
</body>
</html>
