<%--
  Created by IntelliJ IDEA.
  User: SW
  Date: 18/10/27
  Time: 23:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../../common/common.jsp"%>
<html>
<head>
    <title></title>
    <script>
    $().ready(function(){
    $("a").click(function(){
    $(this).attr("class","active item");
    $(this).siblings("a").attr("class","item");
    });
    });
    </script>
</head>
<body>
    <div class="ui bottom attached segment pushable">
        <div class="ui visible left vertical sidebar menu blue">
            <s:a class="item" target="_Content" action="movie_topUI"><s:text name="movieTop_250"/></s:a>
            <s:a class="item" target="_Content" action="movie_netizeComment"><s:text name="netize_comment"/></s:a>
            <s:a class="item" target="_Content" action="movie_myCommentUI?val=%{#session.user.username}"><s:text name="my_comment"/></s:a>
            <s:a class="item" target="_Content" action="movie_goCommentUI"><s:text name="go_comment"/></s:a>
            <s:a class="item" target="_Content" action="movie_myLike"><s:text name="myLike"/></s:a>
        </div>
        <div class="pusher">
            <iframe name="_Content" frameborder="3" scrolling="yes" width="100%" height="100%" src="movie_topUI"></iframe>
        </div>
        </div>
    </div>
</body>
</html>
