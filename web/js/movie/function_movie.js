function findByPage(pageNo,totalPage) {
    if(pageNo==-1){
        var pageNo=$("#pn").val();
        if(pageNo<=0 || pageNo>totalPage){
            alert("输入不符合页数，为你跳转到最后一页");
            pageNo=totalPage;
        }
        $('#findpp').prop("action","movie_topUI?pageNo="+pageNo).submit();
    }
    else if (pageNo){
        alert(pageNo);
        $('#findpp').prop("action","movie_topUI?pageNo="+pageNo).submit();
    }
    else{
        alert(pageNo);
    }
}

function to_detail(object){
    window.location.href="/movie_detailPage?val="+object;
}



function I_like(uid,mid,object) {
    var url;
    var state=$(object).children("span").attr("id");
    if(state=='txt2_'+mid){
        url="interacted_addMovie";
    }
    else{
        url="interacted_rmMovie";
    }
    $.ajax({
        url:url,
        data:{
            "uid":uid,
            "mid":mid
        },
        type:"POST",
        success:function(){
            if(state=='txt2_'+mid){
                $(object).prop("class","ui red button");
                // $('#state2_'+mid).prop("class","ui red button");
                $('#'+state).html('已收藏');
                $('#'+state).prop("id",'txt1_'+mid);
            }
            else{
                $(object).prop("class","ui green button");
                // $('#state1_'+mid).prop("class","ui green button");
                $('#'+state).html('收藏');
                $('#'+state).prop("id",'txt2_'+mid);
            }
        },
        error:function(){
            alert("like_fail");
        }
    });
}

function nologin() {
    alert(Tips['loginFist']);
}