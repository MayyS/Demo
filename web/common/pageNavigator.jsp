<%@ taglib prefix="S" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: SW
  Date: 18/11/7
  Time: 22:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common.jsp"%>
<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>


<div style="float:left">
    <s:form id="findpp"/>
    <span style="color: blue">
    <s:text name="总页数："/>
        <s:property value="pageResult.totalCount"/></span>
    <button class="ui blue tiny button" onclick="javascript:findByPage(${pageNo-1})"
            <s:if test="pageNo-1<=0">disabled</s:if>
    >
        <i class="left chevron icon"></i>
        <s:text name="上一页"/>
    </button>
    <font style="color: blue">
        第<s:property value="pageNo"/>页
        /
        总<s:property value="pageResult.totalPage"/>页
    </font>
    <button class="ui blue tiny button"onclick="javascript:findByPage(${pageNo+1})"
            <s:if test="pageNo+1>pageResult.totalPage">disabled</s:if>
    >
        <s:text name="下一页"/>
        <i class="right chevron icon"></i>
    </button>
    <s:textfield id="pn" name="pageNo" key="toPage" style="width:30px"/>
    <button class="ui tiny button" onclick="javascript:findByPage(-1,${pageResult.totalPage})">跳页</button>

</div>

<%--

<s:form id="findpp"/>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
        <td>
            总共${pageResult.totalCount}条记录，当前第${pageResult.pageNo}页，共${pageResult.totalPage} 页 &nbsp;&nbsp;
            每页显示<select name="pageSize" onchange="javascript:findByPage(1)">
            <option value="3" ${pageResult.pageSize==3? 'selected="selected"' :'' }>3</option>
            <option value="5" ${pageResult.pageSize==5? 'selected="selected"' :'' }>5</option>
            <option value="10" ${pageResult.pageSize==10? 'selected="selected"' :'' }>10</option>
        </select>条，
            <c:if test="${pageResult.pageNo>1}">
                <a href="javascript:findByPage(${pageResult.pageNo-1})">上一页</a>
            </c:if>
            <c:if test="${pageResult.pageNo < pageResult.totalPage}">
                <a href="javascript:findByPage(${pageResult.pageNo+1})">下一页</a>
            </c:if>

            到&nbsp;<input type="text" style="width: 30px;"
                          onkeypress="if(event.keyCode == 13){findByPage( (this.value > ${pageResult.totalPage} || this.value <1)? ${pageResult.totalPage}:this.value)}" min="1"
                          max="" /> &nbsp;&nbsp;
        </td>
    </tr>
</table>--%>
