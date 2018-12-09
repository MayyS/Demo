<%--
  Created by IntelliJ IDEA.
  User: SW
  Date: 18/11/2
  Time: 15:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/common.jsp"%>
<html>
<head>
    <script>
        $().ready(function () {
        // $('.ui.basic.modal').modal('show');
    <s:if test="#request.msg=='wrong'">
        alert(<s:property value="#requset.msg"/>);
            $('.ui.small.modal').modal('show');
    </s:if>
        $('.positive.ui.inverted.button').click(function () {
            $('.ui.large.form').attr("action","logio_login").submit();

        });
    });
      function m_h() {
        $('.ui.small.modal').modal('hide');
    }
    </script>
    <script src="/js/movie/common.js"></script>
</head>
<body>
  <div class="ui small modal">
    <i class="close icon"></i>
    <div class="header">
     <s:text name="userLogin"/>
    </div>
    <div class="content">
    <s:form class="ui large form" method="post">
     <div class="ui stacked segment">
       <div class="field">
        <div class="ui left icon input">
        <i class="user icon"></i>
        <input type="text" name="account" placeholder='<s:text name="account"/>' value="admin">
        </div>
       </div>
       <div class="field">
            <div class="ui left icon input">
            <i class="lock icon"></i>
            <input type="password" name="password" placeholder='<s:text name="password"/>' value="1234">
            </div>
       </div>
        <div>
            <input type="text" name="scode" placeholder='<s:text name="Scode"/>' style="width: 300px" value="<s:property value="#session.securityCode"/>"/>
            <img src="/imageCode" onclick="changeImage(this)" style="cursor: pointer">
        </div>
        <div>
            <s:a action="home_forget" target="mainContent" onclick="m_h()"><s:text name="forget Password"/></s:a>
        </div>
        <div class="field">
        <s:actionmessage cssErrorStyle="color: red"/>
        <s:actionerror cssErrorStyle="color: red;"/>
        </div>
        <div class="actions" align="center">
            <button class="negative ui inverted button" onclick="javascript:history.go(-1)"><s:text name="cancel"/></button>
            <div class="positive ui inverted button"><s:text name="login"/></div>
        </div>
     </div>
     </s:form>
    </div>
    <div class="ui bottom attached warning message">
        <i class="icon info circle"></i><s:text name="registerTip"/><a href="#"><s:text name="toRegister"/></a>
    </div>
  </div>
</body>
</html>
