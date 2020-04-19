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
        <form id="uploadForm" method="post" enctype="multipart/form-data">
           <table id="OT">
            <tr>
                <td><h1></h1></td>
                <td><input name="name" id="name" class="inputBox" type="text"></td>
            </tr>
            <tr>
                <td><h1></h1></td>
                <td><input name="pass" id="pass" class="inputBox" type="password"></td>
            </tr>
            <tr class="none">
                <td><h2>确认密码:</h2></td>
                <td><input name="repass" id="repass" class="inputBox" type="password"></td>
            </tr>
            <tr class="none">
                <td><h2>选择头像:</h2></td>
                <td><input id="photo" name="photo" style="font-size: 20px" class="inputBox" type="file"></td>
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
        </form>
        <div id="userPage">
        <img src="" class="img" alt="用户头像"/>
            <span></span>
        </div>
    </div>
    <div class="user_info ">
        <form>
            <table id="info">
                <tr>
                    <td colspan="3"><h2>用户资料</h2></td>
                </tr>
                <tr>
                    <td>性别:</td>
                    <td>
                        <input value="1" checked="checked" type="radio" name="sex"/>男
                        <input value="0" style="margin-left: 30px" type="radio" name="sex"/>女
                    </td>
                </tr>
                <tr>
                    <td>手机号:</td>
                    <td><input type="text"  id="phone"/></td>
                </tr>
                <tr>
                    <td>邮箱:</td>
                    <td><input  type="text" id="email"></td>
                </tr>
                <tr>
                    <td>个人简介:</td>
                    <td><input type="text" id="commend"></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input id="hold" type="button" value="保存"/>
                        <input id="off" type="button" value="取消"/>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</div>
</body>
</html>