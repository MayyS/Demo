<%--
  Created by IntelliJ IDEA.
  User: SW
  Date: 18/11/22
  Time: 上午9:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/common.jsp"%>
<html>
<head>
    <style>
        .desc{
            width: 350px;
        }
        /*.desc_container{*/
            /*width: 200px;*/
            /*margin-top: -100px;*/
            /*float: left;*/
        /*}*/
        .danao >p{
            display: block;
            width: 100%;
            text-overflow: ellipsis;
            overflow: hidden;
            white-space: nowrap;
        }
        .danao >p:hover{
            display: block;
            width: 100%;
            overflow: auto;
            white-space: normal;
        }
    </style>
    <script>
        $().ready(function () {
            var basePath="http://localhost:8080/home_myIndex";
            // $('.ui.sticky').sticky();
            $('.ui.fixed.bottom.sticky').sticky();
            $('#searchb').click(function () {
                var content=$('.prompt').val();
                if(content==""){
                    alert("can't no be none");
                    return 0;
                }
                else{
                    // alert("book_search?val="+content+"&attr=name");
                    $('#toS').attr("href","book_search?val="+content+"&attr=title").submit();
                }

            });
        });
    </script>

</head>
<body>
<%--<s:debug/>--%>
<div class="six wide column" style="margin-left: 1150px">
    <div class="ui right aligned category search">
        <div class="ui icon input">
            <input class="prompt" type="text" placeholder=<s:text name="searchBook"/>>
            <s:a id="toS">
                <button class="blue circular ui icon button" id="searchb">
                    <i class="search yellow icon"></i>
                </button>
            </s:a>
        </div>
    </div>
</div>
<div style="margin-top: 20px">
    <table border="1">
        <tr>
        <s:iterator value="pageResult.items" var="item" status="st">
            <s:if test="#st.index%4==0"><s:property value="'</tr><tr><td>'" escape="false"/></s:if>
            <s:else><s:property value="'<td >'" escape="false"/></s:else>
                 <img src="/img1/book/<s:property value="#item.title"/>.jpg" alt="book" width="350" height="300"><br>
                 <div class="desc">
                  <%--<div class="desc_container">--%>
                     <div class="danao">
                         <p><s:text name="book_title" />:<s:property value="#item.title"/></p><br>
                         <p style="margin-top: -30px"><s:text name="author"/>:<s:property value="#item.author"/></p><br>
                     </div>
                      <div style="margin-top: -25px">
                          <del style="color: blue"><s:text name="price_r"/>:<s:property value="#item.price_r"/><br></del>
                          <span style="color: orange"><s:text name="price_s"/>:<s:property value="#item.price_s"/><br></span>
                          <span style="color: orange"><s:text name="price_n"/>:<s:property value="#item.price_n"/></span>
                      </div>

                 <%--</div>--%>
                         <div class="ui button" tabindex="0" style="margin-right: 20px;margin-bottom: 50px;float: right">
                            <%-- <div class="hidden content">
                                 <s:property value="#item.price_n"/>
                             </div>--%>
                             <div class="content" onclick=
                             <s:if test="#session.user==null">
                                     "javascript:nologin()"
                                </s:if>
                                <s:else>
                                    "javascript:addToCart(${item.ISBN})"
                                </s:else> >

                                 <i class="add to cart big icon"></i>
                             </div>
                         </div>
                 </div>
            </td>
        </s:iterator>
        </tr>
    </table>
    <jsp:include page="/common/pageNavigator.jsp"/>
</div>
<script src="/js/intercation/iteract.js"></script>
<script src="/js/book/book.js"></script>
</body>
</html>
