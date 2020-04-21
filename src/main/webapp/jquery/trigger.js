$(function () {

        var user;


        /**纯动画放在 onload里，涉及ajax与数据库交互的在trigger，这样可以加一个调试模式的功能，现在每次调试都要看一遍动画比较麻烦*/
        /**确定用户姓名是否重复可以在设计弹框样式后再加，目前保存时可以确认用户名不重复*/
        /**message修改下，成功为1，失败为-1.三种状态比较麻烦*/
        /**目前提示先用 alert()方法，弹出框设计完成后再替换*/

        $("#denglu").click(function () {
            if ($(this).val() == "返回") {
                displayNone_enrol()
            }
            if ($(this).val() == "登录") {
                ajax_login($("#name").val(), $("#pass").val())
            }
        })

        function ajax_login(username, password) {
            $.ajax({
                url: "/user?opt=login",
                data: {
                    username: username,
                    password: password
                },
                type: "Post",
                dataType: "JSON",
                success: a
            })
            function a(data) {
                if (data.code == 1) {
                    user = data.data;
                    showImg()
                } else {
                    alert(data.message)
                }
            }
        }

           //登陆后的动画
        function showImg() {
            $("#OT").hide(300, function () {
                $("#OT").css("display", "none")
                $("#loginpage").stop().animate({
                    "marginLeft": "70%",
                    "marginTop": "-250",
                    "height": "205px",
                    "width": "170px"
                }, "slow", function () {
                    $(".img").attr("src", user.userPoto).css("display", "table-row")
                    $("#userPage span").text(user.userName)
                    $("#kongjian").animate({height:"toggle"},20)
                    $(".search").animate({width:"toggle"},10).css("display","block")
                    /*  $("#userPage").animate({left: '+=500'}, 500)
                    $("#userPage").animate({top: '+=500'}, 500)*/
                })
            })
        }

        function displayNone_enrol() {
            $("#photo").stop().animate({
                "width": "0px"
            }, "fast", function () {
                $("#photo").css("display", "none")
                $("#repass").stop().animate({
                    "width": "0px"
                }, "fast", function () {
                    $("#repass").css("display", "none")
                    $("#OT tr,td").stop().animate({
                        "height": "116px"
                    }, "normal", function () {
                        $("#denglu").attr("value", "登录")
                        $("#zhuce").attr("value", "注册")
                        $(".none").css("display", "none")
                        $("#OT").stop().animate({
                            "marginTop": "75px"
                        }, "normal", function () {
                            $("#repass").val("")
                            $("#photo").val("")
                        })
                    })
                })
            })
        }

        $("#zhuce").click(function () {
            if ($(this).val() == "注册") {
                $("#OT").stop().animate({
                    "marginTop": "50px"
                }, "normal", function () {
                    $(".none").css("display", "table-row")
                    $("#denglu").attr("value", "返回")
                    $("#zhuce").attr("value", "保存")
                    $("#OT tr,td").stop().animate({
                        "height": "58px"
                    }, "normal", function () {
                        $("#repass").css("display", "block")
                        $("#repass").stop().animate({
                            "width": "175px"
                        }, "fast", function () {
                            $("#photo").css("display", "block")
                            $("#photo").stop().animate({
                                "width": "175px"
                            }, "fast")
                        });
                    })
                })
            } else if ($(this).val() == "保存") {
                ajax_addUser(function () {
                    displayNone_enrol()
                })
            }
        })

        function ajax_addUser(callback) {
            $.ajax({
                url: '/user?opt=add',
                type: 'POST',
                cache: false,
                data: new FormData($('#uploadForm')[0]),
                processData: false,
                contentType: false,
                dataType: "JSON",
                success: a
            })

            function a(data) {
                if (data.code == 1) {
                    callback && callback()
                } else if (data.code == -1) {
                    alert(data.message)
                }
            }
        }

        //点击头像出css
        $("#userPage").click(function () {
           $.ajax({
               url:"/info?opt=getUserInfo",
               type:"POST",
               data:{
                   userId:user.userId
               },
               dataType:"JSON",
               success:a
           })
            function a(data) {
               $(".user_info").css("display","inline")
               if (data.code==1){
                   $("#hold").attr("value","编辑")
                   if (data.data.infoGender==1){
                       $("input[name=sex]").eq(0).attr("checked","checked")
                   }else {
                       $("input[name=sex]").eq(1).attr("checked","checked")
                   }
                   $("#phone").attr("placeholder",data.data.infoPhone)
                   $("#email").attr("placeholder",data.data.infoEmail)
                   $("#commend").attr("placeholder",data.data.infoComment)
               }else if(data.code=-1){
                   $("#hold").attr("value","保存")
               }
            }
        });
        //用户资料注册
        $("#hold").click(function () {
            var commend = $("[id=commend]").val();
            var email = $("[id=email]").val();
            var phone = $("[id=phone]").val();
            if (commend == "" || email == "" || phone == "") {
                alert("不能为空哦")
            }
            if ($(this).val() == "保存") {
                ajax_InfoUser();
            } else if ($(this).val() == "编辑"){
                ajax_InfoUpdate();
            }
        });
        function ajax_InfoUser() {
        $.ajax({
            url: "/info?opt=add",
            type: 'POST',
            dataType: "JSON",
            data: {
                infoGender: $("input[name=sex]:checked").val(),
                infoPhone: $("#phone").val(),
                infoEmail: $("#email").val(),
                infoComment: $("#commend").val(),
                userId: user.userId,
            },
            success: b,
        });

        function b(data) {
            if (data.code == 1) {
                alert("成功")
                $("#hold").attr("value", "编辑")
            } else if (data.code == -1) {
                alert("失败")
                alert(data.message)
            }
        }
    }
        //修改代码
        function ajax_InfoUpdate() {
        $.ajax({
            url: "/info?opt=update",
            data:{
                infoGender: $("input[name=sex]:checked").val(),
                infoPhone: $("#phone").val(),
                infoEmail: $("#email").val(),
                infoComment: $("#commend").val(),
                userId:user.userId,
                 },
            dataType:"JSON",
            type: 'POST',
            success:c
        })
        function c(data) {
            if (data.code==1){
                alert("修改成功")
            }else {
                alert("修改失败")
            }
        }
    }
        //取消个人资料框
        $(".user_info").click(function () {
        $(".user_info").animate({height:"toggle"})
    })
        //点击论坛
      $("#luntan").click(function () {
       $(".mold").animate({height:"toggle"}).css("display","block")
       $(".search").css("display","none")
      })
});
