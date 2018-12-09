<%--
  Created by IntelliJ IDEA.
  User: SW
  Date: 18/11/29
  Time: 10:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/common.jsp"%>
<html>
<head>
    <script>
        function ch_sb() {
            var pwd1=document.getElementById("pwd1").value;
            var pwd2=document.getElementById("pwd2").value;
            if(pwd1==null){
                alert("pwd1 can't");
                return false;
            }else if(pwd2==null){
                alert("pwd2 can't");
                return false;
                return false;
            }else if(pwd1!=pwd2){
                alert("pwd1 not equal pwd2");
                return false;
            }
            $("#form1").submit();

        }
    </script>
</head>
<body>
<s:debug/>
<form method="POST" action="/user_changePwd" id="form1">
    <table align="center" style="line-height: 40px;margin-top: 50px">
        <tbody>
        <tr>
            <td>
                <s:text name="account"/>:
                <input type="text" name="account" value="<s:property value="fg_account"/>" readonly>
            </td>
        </tr>
        <tr>
            <td>
                <s:text name="password"/>:
                <input type="password" id="pwd1" name="password"placeholder="password" value="1234"/>
            </td>
        </tr>
        <tr>
            <td>
                <s:text name="cof_pwd"/>:
                <input type="password" id="pwd2" name="password_cof" placeholder="password" value="1234"/>
            </td>
        </tr>
        <tr>
            <td>
                <div>
                    <div class="ui tiny positive button" onclick="ch_sb()"><s:text name="submit"/></div>
                </div>
            </td>
        </tr>
        </tbody>
    </table>
</form>
</body>
</html>
