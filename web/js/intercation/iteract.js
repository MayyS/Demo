function addToCart(bid) {
    var url="interacted_add2Cart";
    $.ajax({
        url:url,
        data:{
            // "uid":uid,
            "bid":bid
        },
        type:"POST",
        success:function () {
            alert("add Success");
        },
        error:function () {
            alert("add Fail");
        }
    });
}

function mipu_oper(flag,goods_id,object){
    var url="interacted_";
    var num=parseInt($('#'+goods_id).val());
    // var num=$(object).next("input").attr("id");
    if(flag=="m"){
        url=url+"goods_minus";
        if(num==1){
            var r=confirm("delete?");
            if(r==false){
                return false;
            }
        }
    }
    else{
        url=url+"goods_plus";
    }
    $.ajax({
        url:url,
        data:{
            "bid":goods_id
        },
        type:"POST",

        success:function (result) {
            if(flag=="m"&&num==1){
                do_rm(object,'bid',goods_id);
                document.getElementById("orderList").removeChild(object.parentNode.parentNode.parentNode);
            }else if (flag=="m"){
                num=num-1-"0";
                $('#'+goods_id).val(num);
            }else {
                num=num+1-"0";
                $('#'+goods_id).val(num);
            }
            $('#total').html(result);
            $('#pay').html("结算("+result+")");


        },
        error:function () {
            alert("fail");
        }
    });
}

function selectALl(obj){
    var items=$("input[name=selected]");
    var status=$("#chose").is(":checked");
    for (var i=0; i<items.length; i++){
        // var status_i=items[i].checked;
        items[i].checked=status;
        /*if(status_i!=status){
            items[i].checked=status;
        }
        else{
            items[i].checked=(!status_i);
        }*/
    }
    changeSelected();
    // $("input[name=selected]").prop("checked",$("#chose").is(":checked"));
}

function do_rm(object,attr,val) {
    var url="interacted_rmGoods";
    var tr=object.parentNode.parentNode;
    // $("#orderList").removeChild(tr);

    $.ajax({
        url:url,
        data:{
            "bid":val
        },
        Type:"POST",
        success:function(result){
            document.getElementById("orderList").removeChild(tr);
            $('#total').html(result);
            $('#pay').html("结算("+result+")");
        },
        error:function(){
            alert(fail);
        }
    });
}

function doAllSel(){
    // var items=$("input[name=selected]:checked").length;
    var att=$("input[name=selected]:checked").serializeArray();
    var dat=$.param(att);
    url="interacted_delSelected";
    $.ajax({
        url:url,
        data:dat,
        type:"POST",
        success:function (result) {
          alert("ok");
          var items=document.getElementsByName("selected");
          var order=document.getElementById("orderList");
          for(var i=0; i<items.length; i++){
              if(items[i].checked){
                  var tr=items[i].parentNode.parentNode;
                  order.removeChild(tr);
                  i--;
              }
          }
            // $("#chose").checked=false;
            $("#chose").removeAttr("checked");
            $('#total').html(result);
            $('#pay').html("结算("+result+")");
        },
        error:function () {
            alert("NO");
        }
    });

}

function nologin() {
    alert(Tips['loginFist']);
}

function setNum(obj) {
    var chV=document.getElementById(obj).value;
    var reV=document.getElementById("num_"+obj).value;
    if(chV<=0){
        alert("请输入正确的数字");
        $('#'+obj).prop("value",reV);
        return false;
    }
    if(reV==chV){

        return false;
    }
    var url="interacted_setGoodsNum";
    $.ajax({
        url:url,
        data:{
            'bid':obj,
            'num':chV
        },
        type:"POST",
        success:function (result) {
            // alert("ok");
            $('#total').html(result);
            $('#pay').html("结算("+result+")");
        },
        error:function (jqXHR) {

        }
    });

}

function paid(uid,uname) {
    if(($("input[name=selected]:checked").length)<=0){
        alert("请选择商品");
        return false;
    }
    $("#af").prop("action","interacted_paid?uid="+uid+"&uname="+uname);
    // $("#af").prop("action","interacted_paid?uname="+uname);
    $("#af").submit();
}

function changeSelected() {
    var attr=$("input[name=selected]:checked").serializeArray();
    var dat=$.param(attr);
    url="interacted_selectedChange";
    $.ajax({
        url:url,
        data:dat,
        type:"POST",
        success:function (result) {
            $('#total').html(result);
            $('#pay').html("结算("+result+")");
        },
        error:function () {
            alert("fail");
        }
    });
}