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
                <li><a class="home" id="Login"><span>首页</span></a></li>
                <li><a class="home"><span>论坛</span></a></li>
                <li><a class="home"><span>热点</span></a></li>
                <li><a class="home"><span>消息</span></a></li>
                <li><a class="home"><span>我的空间</span></a></li>
            </ul>
        </div>
    </div>
    <div class="deng" id="loginpage">
        <table id="OT">
            <tr>
                <td><h1></h1></td>
                <td><input id="name" class="inputBox" type="text"></td>
            </tr>
            <tr>
                <td><h1></h1></td>
                <td><input id="pass" class="inputBox" type="password"></td>
            </tr>
            <tr class="none">
                <td><h2>确认密码:</h2></td>
                <td><input id="repass" class="inputBox" type="password"></td>
            </tr>
            <tr class="none">
                <td><h2>选择头像:</h2></td>
                <td><input id="photo" style="font-size: 20px" class="inputBox" type="file"></td>
            </tr>
            <tr>
                <td>
                    <input id="denglu" class="btn" type="button" value="登录">
                </td>
                <td>
                    <input id="zhuce" class="btn" type="button" value="注册">
                </td>
            </tr>
        </table>
    </div>
</div>
</body>
<script>
    <%String mess=request.getParameter("message");%>
    <%if (mess!=null && !"".equals(mess)){%>
        alert("<%=mess%>")
        <%}%>
</script>//刷新式响应代码
</html>