<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: SW
  Date: 18/11/5
  Time: 21:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="sx" uri="/struts-dojo-tags" %>
<%@include file="/common/common.jsp"%>
<html>
<head>
    <s:head/>
    <sx:head/>
    <title><s:text name="register"/></title>
    <script>
        $().ready(function () {
            $('#triger').click(function () {
                $('#registerForm').attr("action","user_register").submit();
            });
        });
    </script>
</head>
<body>
<div class="html ui top attached segment" style="height: 100%;margin-top: -10px">
    <s:form method="POST" id="registerForm">
        <table align="center" style="line-height: 40px;margin-top: 50px">
            <tbody>
            <tr>
                <td>
                    <s:textfield name="username" key="user_name"/>
                </td>
            </tr>
            <tr>
                <td>
                    <s:textfield name="account" label="%{getText('account')}"/>
                </td>
            </tr>
            <tr>
                <td>
                    <s:textfield name="phonenum" label="%{getText('phonenum')}"/>
                </td>
            </tr>
            <tr>
                <td><s:password name="password" label="%{getText('password')}"/></td>
            </tr>
            <tr>
                <%--<td><s:textfield name="birthday" label="%{getText('birthday')}"/></td>--%>
                <td>
                    <sx:datetimepicker name="birthDate" label="%{getText('birthday')}" displayFormat="yyyy-MM-dd"/>
                </td>
            </tr>
            <tr>
                <td>
                    <s:radio name="gender" list="#{'0':getText('male'),'1':getText('female')}" value="0"/>
                </td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <div class=" tiny ui buttons" >
                        <s:a action="home_homePage">
                            <button class="tiny ui button"><s:text name="cancel"/></button>
                        </s:a>
                        <div class="or"></div>
                            <button class="ui tiny positive button" id="triger"><s:text name="submit"/></button>
                    </div>
                </td>
            </tr>
            </tbody>
        </table>

    </s:form>
</div>
</body>
</html>
