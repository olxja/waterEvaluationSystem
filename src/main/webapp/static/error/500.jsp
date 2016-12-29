<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>500</title>
    <style>
        * {
            margin: 0 auto;
        }



        #content {
            width: 100%;
            background: url("${pageContext.request.contextPath}/static/images/404_bg.jpg") no-repeat center center;
            -webkit-background-size: 100% auto;
            background-size: 100% auto;
            position: relative;
        }

        .countdown {
            width: 40px;
            text-align: center;
            height: 56px;
            color: #fff;
            font-size: 56px;
            font-weight: bold;
            padding-top: 80px;
        }

        #content p:nth-of-type(2) {
            font-size: 40px;
            font-family: "黑体";
            font-weight: bold;
            color: #d9e1e9;
            width: 100px;
            text-align: center;
            position: absolute;
            bottom: 25%;
            left: 50%;
            margin-left: -50px;
        }

        #content p:nth-of-type(3) {
            font-size: 18px;
            font-weight: bold;
            color: #d9e1e9;
            width: 300px;
            text-align: center;
            position: absolute;
            bottom: 20%;
            left: 50%;
            margin-left: -150px;
        }

        .back a {
            display: block;
            background-color: #6289af;
            color: #d9e1e9;
            font-size: 14px;
            text-align: center;
            line-height: 36px;
            width: 140px;
            height: 36px;
            position: absolute;
            bottom: 6%;
            left: 50%;
            margin-left: -70px;
        }

        a {
            cursor: pointer;
        }
    </style>
    <script src="${pageContext.request.contextPath}/static/js/jquery-1.11.1.js"></script>
    <script>

        $(function () {
            var height = $(window).height();
            $("#content").css({"height": height});
            var count = 5,
                    countdown = setInterval(function () {
                        $("p.countdown").html(count);
                        if (count == 0) {
                            window.location.href = "/notepad/findNotepad";
                        } else {
                            count--;
                        }
                    }, 1000);
        });
    </script>
</head>
<body>
<div id="content">
    <p class="countdown"></p>
    <p>500</p>
    <p>对不起，您要找的页面去了水星~</p>
    <div class="back"><a href="/notepad/findNotepad">返回首页</a></div>
</div>
</body>
</html>