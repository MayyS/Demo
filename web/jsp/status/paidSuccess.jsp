<%--
  Created by IntelliJ IDEA.
  User: SW
  Date: 18/11/25
  Time: 下午8:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/common.jsp"%>
<html>
<head>
    <%--<title></title>--%>
</head>
<body>
<button class="ui button" style="margin: 10px" onclick="history.go(-2)">
 返回
</button>
<h1 style="text-align: center;color: orange">订单详情</h1>

<table class="ui celled padded table" style="text-align: center">
    <thead>
        <th><h3>订单编号</h3></th>
        <th><h3>客户编号</h3></th>
        <th><h3>客户名字</h3></th>
        <th><h3>创建时间</h3></th>
        <th><h3>支付状态</h3></th>
        <th><h3>总金额</h3></th>
    </thead>
    <tr>
        <td><s:property value="#session.orders.id"/></td>
        <td><s:property value="#session.orders.customer_id"/></td>
        <td><s:property value="#session.orders.customer_name"/></td>
        <td><s:date name="#session.orders.createdTime" format="yyyy-MM-dd hh:mm:ss"/></td>
        <td><s:property value="#session.orders.status"/></td>
        <td><s:property value="#session.orders.total"/></td>
    </tr>
</table>
<h1 style="text-align: center;color: orange">商品详情</h1>
<table class="ui celled padded table">
    <thead>
    <th>商品序号</th>
    <th>商品名称</th>
    <th>商品数量</th>
    <th>商品单价</th>
    <th>商品总价</th>
    </thead>
    <s:iterator value="#session.orders.details" var="item" status="st">
        <tr>
            <td><s:property value="#st.count"/></td>
            <td><s:property value="#item.name"/></td>
            <td><s:property value="#item.quantity"/></td>
            <td><s:property value="#item.price"/></td>
            <td><s:property value="#item.total"/></td>
        </tr>
    </s:iterator>　　
</table>

</body>
</html>
