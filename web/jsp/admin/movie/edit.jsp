<%--
  Created by IntelliJ IDEA.
  User: SW
  Date: 18/11/24
  Time: 下午11:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/common/common.jsp"%>
<html>
<head>
    <script type="text/javascript" src="/js/movie/common.js"></script>
</head>
<body>
<s:debug/>
<div style="margin-left: -250px">
    <s:form action="/fileUpload_moviePhoto.action" enctype="multipart/form-data">
        <table align="center">
            <tr>
                <div  style="margin-top: 50px" class="ui centered card" onmouseenter="imgageshow()" onmouseleave="imagehidden()">
                    <div id="div1" class="image dimmable" >
                        <div id="div2" class="ui dimmer transition hidden">
                            <div class="content">
                                <div class="center">
                                    <div class="ui inverted button" onclick="addfile()">
                                        <s:text name="addPhoto"/>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <img id="preview"  style="height: 300px" src="/upload/<s:property value="model.name"/>.jpg"/>
                    </div>
                </div>
            </tr>
            <tr>
                <s:file name="file" label="%{getText('upload')}" onChange="previewImg(this)"/>
            </tr>
        </table>
        <div class="html ui top attached segment">
            <table align="center" style="line-height: 30px">
                <tbody>
                <tr>
                    <td>
                            <%--<td><s:textfield id="ident" name="name" label="%{getText('name')}" value="#session.user.id"/></td>--%>
                        <s:text name="name"/>:
                        <input type="text" name="name" value="<s:property value="model.name"/> ">
                    </td>
                </tr>
                <tr>
                        <%--<td><s:textfield name="directors" label="%{getText('directors')}"/></td>--%>
                    <td>
                        <s:text name="directors"/>:
                        <input type="text" name="directors" value="<s:property value="model.director"/>">
                    </td>
                </tr>
                <tr>
                        <%--<td><s:textfield name="genre" label="%{getText('genre')}"/></td>--%>
                    <td>
                        <s:text name="genre"/>:
                        <input type="text" name="genre" value="<s:property value="model.genre"/>">
                    </td>
                </tr>
                <tr>
                        <%--<td><s:textfield name="country" label="%{getText('country')}"/></td>--%>
                    <td>
                        <s:text name="country"/>:
                        <input type="text" name="country" value="<s:property value="model.country"/>">
                    </td>
                </tr>
                <tr>
                        <%--<td><s:textfield name="runtime" label="%{getText('runtime')}"/></td>--%>
                    <td>
                        <s:text name="runtime"/>:
                        <input type="text" name="runtime" value="<s:property value="model.runtime"/>">
                    </td>
                </tr>
                <tr>
                    <td>
                        <s:date name="releaseDate"/>
                    </td>
                </tr>
                <tr>
                    <s:hidden name="origin" value="%{#session.user.username}"/>
                </tr>
                <tr>
                    <td>
                        <div class=" tiny ui buttons" style="margin-top: 20px">
                            <button class="tiny ui button" onclick="javascript:history.go(-1)"><s:text name="cancel"/></button>
                            <div class="or"></div>
                            <div class="ui tiny positive button" onclick="fileUploadCheck()"><s:text name="submit"/></div>
                        </div>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
    </s:form>
</div>
</body>
</html>