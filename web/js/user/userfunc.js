function sendValidateCode() {
    var pho=document.getElementById("phone").value;
    var reg=/^[0-9]{11}$/;
    if(!reg.test(pho)){
        alert("请输入正确的手机号码");
        return false;
    }
    var url="validate_sendValidateCode";
    $.ajax({
        url:url,
        data:{
          "phone":pho
        },
        type:"POST",
        success:function (result) {
            alert(result);
        },
        error:function (jqXHR) {
            alert("fail");
        }
    });

}
function checkAndSubmit() {
    var account=document.getElementById("account").value;
    var vlc=document.getElementById("vlc").value;
    alert(account+" "+vlc);
    if(account==""){
        alert("account can't be empty");
        return false;
    }else if(vlc==""){
        alert("input vlc");
        return false;
    }

    var target_url="home_changePwd";
    var url="validate_checkValidateCode";
    var res=false;
    $.ajax({
        url:url,
        data:{
            valCode:vlc
        },
        type:"POST",
        async:false,
        success:function (result) {
            res=result;
        },
        error:function (jqXHR) {
            res=false;
        }
    });
    alert(res);
    if(res=="false"){
        alert("输入正确的验证码");
        return false;
    }
    $("#goChange").prop("action",target_url+"?fg_account="+account).submit();
}