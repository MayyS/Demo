<%--
  Created by IntelliJ IDEA.
  User: SW
  Date: 18/11/29
  Time: 13:25
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="refresh" content="3;url=/home_homePage">
</head>
<body onload="run()">
<h1>
    更新成功
</h1>
页面将在<span id="tip">3</span>秒后跳转
</body>
<script>
    var x=3;
    function run() {
        var span = document.getElementById("tip");
        span.innerHTML = x;
        x--;
        window.setTimeout("run()",1000);
    }
</script>
</html>
