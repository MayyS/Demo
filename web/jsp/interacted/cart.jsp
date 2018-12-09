<%--
  Created by IntelliJ IDEA.
  User: SW
  Date: 18/11/22
  Time: 下午4:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/common.jsp"%>
<html>
<head>
<script src="/js/intercation/iteract.js"></script>
    <script type="text/javascript">
        $(document).ready(function(){
            var a_index = 0;
            $("body").click(function(e){
                var a = new Array("富强", "民主", "文明", "和谐", "自由", "平等", "公正" ,"法治", "爱国", "敬业", "诚信", "友善");
                var $i = $("<span/>").text(a[a_index]);
                a_index = (a_index + 1) % a.length;
                var x = e.pageX,y = e.pageY;
                $i.css({
                    "z-index": 99999,
                    "top": y - 20,
                    "left": x,
                    "position": "absolute",
                    "font-weight": "bold",
                    "color": "#ff6651"
                });
                $("body").append($i);
                $i.animate({"top": y-180,"opacity": 0},1500,function() {
                    $i.remove();
                });
            });
        });
    </script>
</head>
<body>
<%--<s:debug/>--%>
<div style="margin-top: 30px">
<button style="margin-left: 20px" class="ui labeled icon button active" onclick="history.go(-1)"><i class="left chevron icon"></i> 返回 </button>
<form action="#" id="af" method="post">
    <h1 style="text-align: center;color: orange">购物车</h1>
<table class="ui celled table" style="width: 1200px;margin-left: 100px">
    <thead>
    <th style="background-color: orange">
        <input type="checkbox" id="chose" onclick="selectALl(this)" >
    </th>
    <th>书名</th>
    <th>数量</th>
    <th>单价</th>
    <th>操作</th>
    <th>
        <i class="trash large icon" onclick="doAllSel()"></i>
    </th>
    </thead>
    <tbody id="orderList">
    <s:iterator value="pageResult.items" var="item" status="st">
        <tr>
            <td>
                <input type="checkbox" name="selected" value="${item.ISBN}" onchange="changeSelected()">
            </td>
            <td>
                <img src="/img1/book/<s:property value="#item.title"/>.jpg" alt="book" width="50" height="50">
                <s:property value="#item.title"/></td>
            <td>
                <div>
                    <i class="minus icon" id="minus_${st.index}" style="cursor: pointer" onclick="mipu_oper('m',${item.ISBN},this)"></i>
                    <input type="text" id="${item.ISBN}"  onchange="setNum(${item.ISBN})" style="width: 60px" value=<s:property value="#session.cart.quantity[#item.ISBN]"/>>
                    <i class="plus icon" id="plus_${st.index}" style="cursor: pointer" onclick="mipu_oper('p',${item.ISBN},this)"></i>
                </div>
                <input type="hidden" id="num_${item.ISBN}" value=<s:property value="#session.cart.quantity[#item.ISBN]"/>>
            </td>
            <td>
                <s:property value="#item.price_n"/>
            </td>
            <td>
                <a href="javascript:void(0)" onclick="do_rm(this,'bid',${item.ISBN})"><i class="trash large icon"></i>
                </a>
            </td>
            <td>

            </td>

        </tr>
    </s:iterator>
    </tbody>
    <%--<tfoot>--%>
        <%--<td style="float: right">--%>
            <%--合计：<s:property value="#session.cart.total"/>--%>
        <%--</td>--%>
    <%--</tfoot>--%>
</table>
</form>
<div style="float: right;margin-right: 180px;margin-top: 50px;font-size: large">
    合计：<span style="color: orange " id="total"><s:property value="0.0"/></span>
    <button id="pay" style="background-color: orange;margin-left:20px;color: white;height: 50px;-moz-border-radius: 20px;-webkit-border-radius: 20px;border-radius:20px;border-color: orange" onclick="paid(${sessionScope.user.id},'${sessionScope.user.username}')">结算(<s:property value="0.0"/>)</button>
</div>
</div>
</body>
</html>
