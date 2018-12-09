<%--
  Created by IntelliJ IDEA.
  User: SW
  Date: 18/10/27
  Time: 16:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
    <title>try</title>
</head>
<body>
    <%
        String path=request.getContextPath();
        response.sendRedirect(path+"/home_myIndex");
    %>
</body>
</html>
