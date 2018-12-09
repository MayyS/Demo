<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/common.jsp"%>
<html>
<head>
    <script>
        $().ready(function () {
            var basePath="http://localhost:8080/home_myIndex";
            // $('.ui.sticky').sticky();
            $('.ui.sticky').sticky();
            $('#searchb').click(function () {
                var content=$('.prompt').val();
                if(content==""){
                    alert("can't no be none");
                    return 0;
                }
                else{
                    $('#toS').attr("href","movie_search?val="+content+"&attr=name").submit();
                }

            });
            $("#b_1,#b_2,#b_3,#b_4,#b_5").click(function () {
                var val=$(this).text();
                $('#toSS').attr("href","movie_search?val="+val+"&attr=genre").submit();
            });
        });
    </script>
</head>
<body>
<%--
<s:debug/>
user:<s:property  value="#session.user.movies"/>--%>
    <%--<div class="ui divider"></div>--%>
    <table border="3" cellspacing="10000" bgcolor="#dcdcdc" style="margin-top: 20px">
        <tr>
            <s:iterator value="pageResult.items" var="item" status="st">
                <s:if test="#st.index%4==0"><s:property value="'</tr><tr><td>'" escape="false"/></s:if>
                <s:else><s:property value="'<td >'" escape="false"/></s:else>
            <div class="ui card" >
                <div class="image">
                    <img src=<s:if test="#item.origin=='douban'">
                                 "/img1/movie/<s:property value="#item.name"/>.jpg"</s:if>
                        <s:else>
                            "/upload/<s:property value="#item.name"/>.jpg"
                    </s:else>
                    >
                </div>
                <div class="content">
                    <div class="header"><s:property value="#st.index"/>:<s:property value="#item.name"/></div>
                    <div class="description">
                        <s:text name="type"/>:<s:property value="#item.genre"/><br>
                        <s:text name="country"/>:<s:property value="#item.country"/><br>
                        <s:text name="score"/>:<s:property value="#item.rate"/><br>
                        <s:text name="playtime"/>:<s:property value="#item.runtime"/><br>
                        ss:<s:property value="#session.user==null"/>
                    </div>
                </div>
                <div class="ui two bottom attached buttons">
                    <div class="ui labeled button" tabindex="0">
                        <button class="ui blue button" id="state1_#item.id" onclick="javascript:to_detail(${item.id})">
                            <i class="eye icon"></i>
                            <s:text name="detail"/>
                        </button>
                    </div>
                        <%--<span id="stt">--%>
                    <div class="ui labeled button" tabindex="0">
                        <s:if test="#item.mark">
                            <button class="ui red button" id="state1_${item.id}" onclick="javascript:I_like(${sessionScope.user.id},${item.id},this)" >
                                <i class="heart icon"></i>
                                <span id="txt1_${item.id}"><s:text name="liked"/></span>
                            </button>
                        </s:if>
                        <s:else>
                            <button class="ui green button" id="state2_${item.id}" onclick=
                            <s:if test="#session.user==null">
                                "javascript:nologin()"
                            </s:if>
                            <s:else>
                                "javascript:I_like(${sessionScope.user.id},${item.id},this)"
                            </s:else> >
                            <i class="heart icon"></i>
                            <span id="txt2_${item.id}"><s:text name="like"/></span>
                            </button>
                        </s:else>
                    </div>
                </div>

            </div>
            </td>
            </s:iterator>
    </table>
    <jsp:include page="/common/pageNavigator.jsp"/>
</div>

</body>

</html>
<script type="text/javascript" src="/js/movie/function_movie.js"></script>
