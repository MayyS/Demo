function findByPage(pageNo,totalPage) {
    if(pageNo==-1){
        var pageNo=$("#pn").val();
        if(pageNo<=0 || pageNo>totalPage){
            alert("输入不符合页数，为你跳转到最后一页");
            pageNo=totalPage;
        }
        $('#findpp').prop("action","book_bookList?pageNo="+pageNo).submit();
    }
    else if (pageNo){
        alert(pageNo);
        $('#findpp').prop("action","book_bookList?pageNo="+pageNo).submit();
    }
    else{
        alert(pageNo);
    }
}