<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: SW
  Date: 18/11/10
  Time: 22:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/common.jsp"%>
<script src="/js/movie/function_movie.js"/>
<html>
<head>
    <title>Title</title>
</head>
<body>
<s:debug></s:debug>

<div class="ui divided items">
    <div class="item">
        <div class="image" style="height: 300px;width: 300px;">
            <img src="/img1/movie/<s:property value="model.name"/>.jpg">
        </div>
        <div class="content">
            <a class="header"><s:text name="name"/>:<s:property value="model.name"/></a>
            <div class="description">
                <p>
                    <s:text name="genre"/>:<s:property value="model.genre"/><br>

                    <s:text name="releaseDate"/>:
                    <s:date name="model.releaseDate" format="yyyy-MM-dd"/><br>

                    <s:text name="score"/>:<s:property value="model.rate"/><br>

                    <s:text name="directors"/>:<s:property value="model.director"/><br>

                    <s:text name="celeberityPage"/>:<s:property value="model.celebrity"/><br>

                </p>
            </div>
            <div class="extra">

                <div class="ui labeled button" tabindex="0">
                    <s:if test="#.mark">
                        <button class="ui red button" id="state1_${model.id}" onclick="javascript:I_like(${sessionScope.user.id},${model.id},this)" >
                            <i class="heart icon"></i>
                            <span id="txt1_${model.id}"><s:text name="liked"/></span>
                        </button>
                    </s:if>
                    <s:else>
                        <button class="ui green button" id="state2_${model.id}" onclick="javascript:I_like(${sessionScope.user.id},${model.id},this)" >
                            <i class="heart icon"></i>
                            <span id="txt2_${model.id}"><s:text name="like"/></span>
                        </button>
                    </s:else>
                </div>

            </div>
        </div>
    </div>

</div>
</body>
</html>
