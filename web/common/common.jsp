<%--
  Created by IntelliJ IDEA.
  User: SW
  Date: 18/10/30
  Time: 16:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link rel="stylesheet"  type="text/css" href="../../css/semantic.css">
<%--<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">--%>
<script src="../../js/jquery.min.js"></script>
<script src="../../js/semantic.js"></script>
<script src="../../js/dropdown.js"></script>
<script>
    Tips={
        "loginFist":"<s:text name="loginFist"/>",
        "UploadError":"<s:text name="upload.error.moviename"/>"
    }
</script>
<script type="text/javascript" src="/js/common.js"></script>



<%--<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>--%>

<%--

<html>
<head>
    <%
        String path=request.getContextPath();
        String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
        application.setAttribute("basePaht",basePath);
    %>
    <title></title>
</head>
<body>
</body>
</html>
--%>
