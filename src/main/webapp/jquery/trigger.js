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

    $("#userPage").click(function () {

    })
    //用户资料注册
    $("#hold").click(function () {
        var commend = $("[id=commend]").val();
        var email = $("[id=email]").val();
        var phone = $("[id=phone]").val();
        if (commend == "" || email == "" || phone == "") {
            alert("不能为空哦")
        }else {
            ajax_InfoUser();
        }
    });
    function ajax_InfoUser() {
           $.ajax({
               url:"/info?opt=add",
               type: 'POST',
               dataType:"JSON",
               data:{
                   infoGender:$("input[name=sex]:checked").val(),
                   infoPhone:$("#phone").val(),
                   infoEmail:$("#email").val(),
                   infoComment:$("#commend").val(),
                   userId:user.userId,
               },
               success:  b,
           });
        function b(data) {
            if (data.code==1){
                alert("成功")
                $("#hold").attr("value", "编辑")
            }else if (data.code==-1) {
                alert("失败")
                alert(data.message)
            }
        }
    }
    //用户返回取消
    $("#off").click(function () {

    })
})