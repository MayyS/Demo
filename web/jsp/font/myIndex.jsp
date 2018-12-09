<%--
  Created by IntelliJ IDEA.
  User: SW
  Date: 18/10/22
  Time: 22:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
  <head>
    <title>$Title$</title>
    <link rel="stylesheet"  type="text/css" href="../../css/semantic.css">
    <script src="../../js/jquery.min.js"></script>
    <script src="../../js/semantic.js"></script>
    <script src="../../js/dropdown.js"></script>
  <script>
      $().ready(function(){

    <s:if test="#request.msg=='wrong'">
        $('.ui.small.modal').modal('show');
    </s:if>

        $(".ui.inverted.red.button").click(function () {
          $('.ui.small.modal').modal('show');
       });
      });
  </script>
  </head>
  <body>

<%@include file="userLog.jsp"%>
  <div class="ui inverted attached menu">
    <div class="ui container" style="font-size: 15px">
      <%--<s:text name="mylogo"/>--%>
      <s:a  class="item" action="home_homePage" target="mainContent">
        <i class="home icon"></i>
        <s:text name="homePage"/>
      </s:a>
      <s:a class="item" action="home_moviePage" target="mainContent">
        <i class="record icon"></i>
        <s:text name="moviePage"/>
      </s:a>
      <s:a class="item" action="home_bookPage" target="mainContent">
        <i class="mail icon"></i>
        <s:text name="bookPage"/>
      </s:a>
      <div class="ui simple dropdown item">
        <s:text name="more"/>
        <i class="dropdown icon"></i>
        <div class="menu">
          <a class="item"><i class="edit icon"></i> <s:text name="waiting"></s:text></a>
          <a class="item"><i class="globe icon"></i> <s:text name="waiting"></s:text></a>
          <a class="item"><i class="settings icon"></i> <s:text name="waiting"></s:text></a>
        </div>
      </div>
      <%--<div class="right ui simple dropdown item">--%>
          <s:if test='#session.user!=null'>
            <div class="right ui simple dropdown item">
             <%--<i class="user circle outline icon"></i>--%>
              <img class="ui avatar image" src="/img1/My.jpg">
              <s:property value="#session.user.username"/>
              <i class="dropdown icon"></i>
             <div class="menu">
              <s:a class="item" action="user_myOders" target="mainContent"><i class="align justify icon"></i><s:text name="personal"/></s:a>
              <a class="item"><i class="cogs icon"></i><s:text name="myManager"/></a>
              <s:a class="item" action="logio_logout"><i class="power off icon"></i><s:text name="logout"/></s:a>
              </div>
            </div>
              <div class="item">
                <s:a action="interacted_cart"><i class="shop large icon"></i></s:a>
              </div>
          </s:if>
          <s:else>
              <div class="right item" style="width:100%;font-size: 15px">
                  <button class="ui inverted red button" style="margin-left: 600px">
                  <i class="user circle outline icon"></i>
                  <s:text name="login"/>
                  </button>
              <s:a action="home_registerPage" target="mainContent">
                  <button class="ui inverted yellow button" style="margin-left: 50px">
                  <i class="add user icon"></i>
                  <s:text name="register"/>
                  </button>
              </s:a>
              </div>
          </s:else>
      </div>
    </div>
  </div>
  <div >
    <iframe name="mainContent" frameborder="0" scrolling="yes" width="100%" height="100%" src="/jsp/admin/home/homePage.jsp"></iframe>
  </div>



  </body>

</html>
