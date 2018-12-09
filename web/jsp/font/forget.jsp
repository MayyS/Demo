<%--
  Created by IntelliJ IDEA.
  User: SW
  Date: 18/11/29
  Time: 08:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/common.jsp"%>
<html>
<head>
    <script src="/js/user/userfunc.js"></script>
</head>
<body>
<s:form method="POST" id="goChange">
    <table  align="center" style="line-height: 40px;margin-top: 50px">
        <tbody>
        <tr>
            <td>
                <s:text name="account"/>:
                <input type="text" name="account" id="account" placeholder="account" value="admin"/>
            </td>
        </tr>
        <tr>
            <td>
                <s:text name="phone"/>:
                <input type="text" id="phone" name="phone"placeholder="phone" value="15800043940"/>
                <div class="negative ui inverted button" onclick="sendValidateCode()"><s:text name="send"/></div>
            </td>
        </tr>
        <tr>
            <td>
                <s:text name="validate"/>:
                <input type="text" name="valCode" id="vlc" placeholder="vail.." value="123456">
            </td>
        </tr>
        <tr>
            <td>
                <div>
                    <div class="ui tiny positive button" id="triger" onclick="checkAndSubmit()"><s:text name="submit"/></div>
                </div>
            </td>
        </tr>
        </tbody>
    </table>
</s:form>
</body>
</html>
