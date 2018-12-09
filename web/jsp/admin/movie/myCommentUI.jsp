<%--
  Created by IntelliJ IDEA.
  User: SW
  Date: 18/11/4
  Time: 23:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/common.jsp"%>
<html>
<head>
</head>
<body>
    <div class="html ui top attached segment">
        <div class="ui grid" style="margin-top: -20px">
            <div class="ten wide column">
                <h1>我的推荐</h1>
            </div>
            <div class="six wide column">
                <button class="ui inverted grey large button" style="margin-left: 130px"><s:a action="movie_goCommentUI" cssStyle="color: darkgrey">我要推荐</s:a></button>
            </div>
        </div>
    </div>
        <%--<div class="ui divider"></div>--%>
        <s:iterator value="pageResult.items" var="item" status="st">
            <div class="ui divided items">
                <div class="item">
                    <div class="image" style="width: 200px;height: 200px;">
                        <%--<img src="/img/static/image.png">--%>
                            <img src="/upload/<s:property value="#item.name"/>.jpg">
                    </div>
                    <div class="content">
                        <a class="header"><s:property value="#item.name"/></a>
                        <div class="meta">
                            <%--<span class="cinema"><s:text name="country"/>:<s:property value="#item.country"/></span>--%>
                        </div>
                        <div class="description">
                            <s:text name="directors"/>:<s:property value="#item.director"/><br>
                            <s:text name="genre"/>:<s:property value="#item.genre"/><br>
                            <s:text name="country"/>:<s:property value="#item.country"/><br>
                            <s:text name="runtime"/>:<s:property value="#item.runtime"/><br>
                        </div>
                        <div class="extra">
                            <s:a action="movie_edit?attr=%{#item.id}">
                                <div class="ui label">
                                    <i class="edit icon"></i>
                                    <s:text name="edit"/>
                                </div>
                            </s:a>
                            <s:a action="movie_delete?attr=%{#item.id}&val=%{#session.user.id}">
                                <div class="ui label">
                                    <i class="trash outline icon"></i>
                                    <s:text name="delete"/>
                                </div>
                            </s:a>
                        </div>
                    </div>
                </div>
            </div>
        </s:iterator>
<%--<s:debug/>--%>
</body>
</html>
