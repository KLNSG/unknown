<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<head>
    <script src="jquery/jquery-1.12.4.js"></script>
    <script src="jquery/onload.js"></script>
    <script src="jquery/trigger.js"></script>
    <link href="css/onload.css" rel="stylesheet" type="text/css" media="all"/>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<div class="repect" id="bottom">
    <div id="titleSentence">
        <p style="margin-left: 5%"></p>
        <p style="margin-left: 45%"></p>
    </div>
    <div class="mat">
        <div id="navigationBar">
            <ul class="homeUl" id="homeui">
                <li><a class="home" id="Login"><span>登录</span></a></li>
                <li><a class="home"><span>论坛</span></a></li>
                <li><a class="home"><span>热点</span></a></li>
                <li><a class="home"><span>消息</span></a></li>
                <li><a class="home"><span>我的空间</span></a></li>
            </ul>
        </div>
    </div>
    <div class="deng" id="loginpage">

    </div>
</div>
<script>
    <%String mess=request.getParameter("message");%>
    <%if (mess!=null && !"".equals(mess)){%>
    alert("<%=mess%>")
    <%}%>
</script>
</body>
</html>