function imgageshow(){
    $('#div1').prop('class','image dimmable dimmed');
    $('#div2').prop('class','ui dimmer transition visible active');
    $('#div2').style.display="block !important;";

}
function imagehidden(){
    $('#div1').prop('class','image dimmable');
    $('#div2').prop('class','ui dimmer transition hidden');

}
function addfile(){
    alert("click");
    $('#fileUpload_moviePhoto_file').click();
}

function previewImg(file){
    var windowURL=windowURL||window.webkitURL;
    var dataURL;
    var $img=$('#preview');
    // alert($img);
    // alert(document.getElementById('fileUpload_moviePhoto_file').value.trim());
    if(document.getElementById('fileUpload_moviePhoto_file').value.trim()==""){
        alert("NONE");
        return false;
    }
    // alert(file.files[0]);
    if(file.files&&file.files[0]){
        // alert(file.files[0]);
        dataURL=windowURL.createObjectURL(file.files[0]);
        var newPreview=document.getElementById('fileUpload_moviePhoto_file').value;
        // alert(newPreview);
        var regext=/\.jpg$|\.png$|\.jpeg$/gi;
        if(!regext.test(newPreview)){
            newPreview=="";
            alert("errorType");
            return false;
        }
        $img.attr('src',dataURL);
        $('.ui.inverted.button').html("改变图片");

    }
}

function changeImage(object) {
    $(object).attr("src","/imageCode?timestamp="+new Date().getTime());
}

function fileUploadCheck() {
    var name=$("#ident").val();
    if(name==""){
        alert(Tips['UploadError']);
        return false;
    }else {
        $("form").submit();
    }
}