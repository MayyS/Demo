<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: SW
  Date: 18/11/5
  Time: 14:26
  To change this template use File | Settings | File Templates.
--%><%--
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
&lt;%&ndash;<%@include file="../../LLM/MyIndex.jsp"%>&ndash;%&gt;
<html>
<head>
</head>
<body>
</body>
</html>--%>

<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <style>
        .hot{
            float:left;
            height:auto;
            text-align:center;
            margin-left:-250px;
        }
        .rank{
            height:auto;
            float:right;
            margin-right:300px;
            margin-top:-280px;
        }
        .rank table,.rank h4,.rank p{
            margin-left:500px;
        }
        #myCarousel{
            margin-top:10px;
        }
        .carousel-inner{
            margin-left:350px;
        }
        .panel-heading{
            text-align:center;
            text-decoration:none;
        }
        .panel-group{
            margin-top:50px;
        }
        .row img:hover{

        }

        .myImg {
            border-radius: 5px;
            cursor: pointer;
            transition: 0.3s;
        }
        .myImg:hover {opacity: 0.7;}

        /* The Modal (background) */
        .modal {
            display: none; /* Hidden by default */
            position: fixed; /* Stay in place */
            z-index: 1; /* Sit on top */
            padding-top: 100px; /* Location of the box */
            left: 0;
            top: 0;
            width: 100%; /* Full width */
            height: 100%; /* Full height */
            overflow: auto; /* Enable scroll if needed */
            background-color: rgb(0,0,0); /* Fallback color */
            background-color: rgba(0,0,0,0.9); /* Black w/ opacity */
        }

        /* Modal Content (image) */
        .modal-content {
            margin: auto;
            display: block;
            width: 80%;
            max-width: 700px;
        }

        /* Caption of Modal Image */
        #caption {
            margin: auto;
            display: block;
            width: 80%;
            max-width: 700px;
            text-align: center;
            color: #ccc;
            padding: 10px 0;
            height: 150px;
        }

        /* Add Animation */
        .modal-content, #caption {
            -webkit-animation-name: zoom;
            -webkit-animation-duration: 0.6s;
            animation-name: zoom;
            animation-duration: 0.6s;
        }

        @-webkit-keyframes zoom {
            from {-webkit-transform: scale(0)}
            to {-webkit-transform: scale(1)}
        }

        @keyframes zoom {
            from {transform: scale(0.1)}
            to {transform: scale(1)}
        }

        .close {
            position: absolute;
            top: 15px;
            right: 35px;
            color: #f1f1f1;
            font-size: 40px;
            font-weight: bold;
            transition: 0.3s;
        }

        .close:hover,
        .close:focus {
            color: #bbb;
            text-decoration: none;
            cursor: pointer;
        }

        @media only screen and (max-width: 700px){
            .modal-content {
                width: 100%;
            }
        }
    </style>
</head>
<div>
<div style="width: auto">
<div id="myCarousel" class="carousel slide">
    <!-- 轮播（Carousel）指标 -->
    <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active" ></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
        <li data-target="#myCarousel" data-slide-to="3"></li>
        <li data-target="#myCarousel" data-slide-to="4"></li>
        <li data-target="#myCarousel" data-slide-to="5"></li>
    </ol>
    <!-- 轮播（Carousel）项目 -->
    <div class="carousel-inner">
        <div class="item active">
            <img src="/image/1.jpg" alt="First slide">
        </div>
        <div class="item">
            <img src="/image/2.jpg" alt="Second slide">
        </div>
        <div class="item">
            <img src="/image/3.jpg" alt="Third slide">
        </div>
        <div class="item">
            <img src="/image/4.jpg" alt="Third slide">
        </div>
        <div class="item">
            <img src="/image/5.jpg" alt="Third slide">
        </div>
        <div class="item">
            <img src="/image/6.jpg" alt="Third slide">
        </div>
    </div>
    <!-- 轮播（Carousel）导航 -->
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
    </a>
</div>
<%--<div class="panel-group" id="accordion">--%>
    <%--<div class="panel panel-default">--%>
        <%--<div class="panel-heading">--%>
            <%--<h2 class="panel-title">--%>
                <%--<a data-toggle="collapse" data-parent="#accordion"--%>
                   <%--href="#collapseOne" class="record">--%>
                    <%--经典电影台词--%>
                <%--</a>--%>
            <%--</h2>--%>
        <%--</div>--%>
        <%--<div id="collapseOne" class="panel-collapse collapse in">--%>
            <%--<div class="panel-body">--%>
                <%--<div class="col-sm-6 col-md-3">--%>
                    <%--<a href="#" class="thumbnail">--%>
                        <%--<img src="/image/record/a.jpg" alt="通用的占位符缩略图" class="myImg" width="300" height="200">--%>
                    <%--</a>--%>
                <%--</div>--%>
                <%--<div class="col-sm-6 col-md-3">--%>
                    <%--<a href="#" class="thumbnail">--%>
                        <%--<img src="/image/record/b.jpg" alt="通用的占位符缩略图" class="myImg" width="300" height="200">--%>
                    <%--</a>--%>
                <%--</div>--%>
                <%--<div class="col-sm-6 col-md-3">--%>
                    <%--<a href="#" class="thumbnail">--%>
                        <%--<img src="/image/record/c.jpg" alt="通用的占位符缩略图" class="myImg" width="300" height="200">--%>
                    <%--</a>--%>
                <%--</div>--%>
                <%--<div class="col-sm-6 col-md-3">--%>
                    <%--<a href="#" class="thumbnail">--%>
                        <%--<img class="myImg" width="300" height="200" src="/image/record/d.jpg" alt="通用的占位符缩略图">--%>
                    <%--</a>--%>
                <%--</div>--%>
            <%--</div>--%>
            <%--<div class="col-sm-6 col-md-3">--%>
                <%--<a href="#" class="thumbnail">--%>
                    <%--<img class="myImg" width="300" height="200" src="/image/record/e.jpg" alt="通用的占位符缩略图">--%>
                <%--</a>--%>
            <%--</div>--%>
            <%--<div class="col-sm-6 col-md-3">--%>
                <%--<a href="#" class="thumbnail">--%>
                    <%--<img src="/image/record/f.jpg" alt="通用的占位符缩略图" class="myImg" width="300" height="200">--%>
                <%--</a>--%>
            <%--</div>--%>
            <%--<div class="col-sm-6 col-md-3">--%>
                <%--<a href="#" class="thumbnail">--%>
                    <%--<img src="/image/record/g.jpg" alt="通用的占位符缩略图"  class="myImg" width="300" height="200">--%>
                <%--</a>--%>
            <%--</div>--%>
            <%--<div class="col-sm-6 col-md-3">--%>
                <%--<a href="#" class="thumbnail">--%>
                    <%--<img src="/image/record/h.jpg" alt="通用的占位符缩略图"  class="myImg" width="300" height="200">--%>
                <%--</a>--%>
            <%--</div>--%>
            <%--<div class="col-sm-6 col-md-3">--%>
                <%--<a href="#" class="thumbnail">--%>
                    <%--<img src="/image/record/a.jpg" alt="通用的占位符缩略图" class="myImg" width="300" height="200">--%>
                <%--</a>--%>
            <%--</div>--%>
            <%--<div class="col-sm-6 col-md-3">--%>
                <%--<a href="#" class="thumbnail">--%>
                    <%--<img src="/image/record/b.jpg" alt="通用的占位符缩略图" class="myImg" width="300" height="200">--%>
                <%--</a>--%>
            <%--</div>--%>
            <%--<div class="col-sm-6 col-md-3">--%>
                <%--<a href="#" class="thumbnail">--%>
                    <%--<img src="/image/record/c.jpg" class="myImg" width="300" height="200" alt="通用的占位符缩略图">--%>
                <%--</a>--%>
            <%--</div>--%>
            <%--<div class="col-sm-6 col-md-3">--%>
                <%--<a href="#" class="thumbnail">--%>
                    <%--<img class="myImg" width="300" height="200" src="/image/record/d.jpg" alt="通用的占位符缩略图">--%>
                <%--</a>--%>
            <%--</div>--%>
        <%--</div>--%>
    <%--</div>--%>

    <%--<!-- <!-- The Modal -->--%>
    <%--<div id="myModal" class="modal">--%>
        <%--<span class="close">×</span>--%>
        <%--<img class="modal-content" id="img01">--%>
        <%--<div id="caption"></div>--%>
    <%--</div>--%>

    <%--<script>--%>
        <%--// 获取模态窗口--%>
        <%--var modal = document.getElementById('myModal');--%>

        <%--// 获取图片模态框，alt 属性作为图片弹出中文本描述--%>
        <%--var img = document.getElementsByClassName('myImg');--%>
        <%--var modalImg = document.getElementById("img01");--%>
        <%--var captionText = document.getElementById("caption");--%>
        <%--img.onclick = function(){--%>
            <%--modal.style.display = "block";--%>
            <%--modalImg.src = this.src;--%>
            <%--modalImg.alt = this.alt;--%>
            <%--captionText.innerHTML = this.alt;--%>
        <%--}--%>
        <%--// 获取 <span> 元素，设置关闭模态框按钮--%>
        <%--var span = document.getElementsByClassName("close")[0];--%>

        <%--// 点击 <span> 元素上的 (x), 关闭模态框--%>
        <%--span.onclick = function() {--%>
            <%--modal.style.display = "none";--%>
        <%--}--%>
    <%--</script> -->--%>
    <div>
        <div class="hot">
            <h4>热门推荐</h4>
            <div id="Carousel" class="carousel slide">
                <!-- 轮播（Carousel）指标 -->
                <ol class="carousel-indicators">
                    <li data-target="#Carousel" data-slide-to="0" class="active"></li>
                    <li data-target="#Carousel" data-slide-to="1"></li>
                    <li data-target="#Carousel" data-slide-to="2"></li>
                </ol>
                <!-- 轮播（Carousel）项目 -->
                <div class="carousel-inner">
                    <div class="item active">
                        <a href="https://movie.douban.com/trailer/239330/#content?from=gallery"><img src="/image/1.PNG" alt="First slide"></a>
                    </div>
                    <div class="item">
                        <a href="https://www.douban.com/note/696648492/?from=gallery"><img src="/image/2.PNG" alt="First slide"></a>
                    </div>
                    <div class="item">
                        <a href="https://www.douban.com/note/696616062/?from=gallery"><img src="/image/3.PNG" alt="First slide"></a>
                    </div>
                </div>
            </div>
        </div>
        <div class="rank">
            <h4>一周热门榜单</h4><p><a href="https://movie.douban.com/chart">更多榜单>></a></p>
            <table>
                <tr>
                    <td>1</td>
                    <td><a href="https://movie.douban.com/subject/26147417/">神奇动物：格林德沃之罪</a></td>
                </tr>
                <tr>
                    <td>2</td>
                    <td><a href="https://movie.douban.com/subject/27596249/">重金属囧途</a></td>
                </tr>
                <tr>
                    <td>3</td>
                    <td><a href="https://movie.douban.com/subject/26992114/">孤狼之血</a></td>
                </tr>
                <tr>
                    <td>4</td>
                    <td><a href="https://movie.douban.com/subject/4058933/">一个明星的诞生</a></td>
                </tr>
                <tr>
                    <td>5</td>
                    <td><a href="https://movie.douban.com/subject/27029495/">法外之王</a></td>
                </tr>
                <tr>
                    <td>6</td>
                    <td><a href="https://movie.douban.com/subject/27611421/">滑板少年</a></td>
                </tr><tr>
                <td>7</td>
                <td><a href="https://movie.douban.com/subject/2068290/">风的另一边</a></td>
            </tr>
                <tr>
                    <td>8</td>
                    <td><a href="https://movie.douban.com/subject/26147417/">狼屋</a></td>
                </tr>
                <tr>
                    <td>9</td>
                    <td><a href="https://movie.douban.com/subject/26147417/">麦昆</a></td>
                </tr>
                <tr>
                    <td>10</td>
                    <td><a href="https://movie.douban.com/subject/26147417/">我的冤家是条狗</a></td>
                </tr>
            </table>
        </div>
    </div>
</div>
</body>
</html>
