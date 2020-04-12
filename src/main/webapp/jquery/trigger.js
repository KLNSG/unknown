$(function () {

    /**纯动画放在 onload里，涉及ajax与数据库交互的在trigger，这样可以加一个调试模式的功能，现在每次调试都要看一遍动画比较麻烦*/
    /**确定用户姓名是否重复可以在设计弹框样式后再加，目前保存时可以确认用户名不重复*/
    /**message修改下，成功为1，失败为-1.三种状态比较麻烦*/
    /**目前提示先用 alert()方法，弹出框设计完成后再替换*/

    $("#denglu").click(function () {
        if ($(this).val()=="登录"){
            ajax_login($("#name").val(),$("#pass").val())
        }
    })

    function ajax_login(username,password) {
        $.ajax({
            url: "/user?opt=login",
            data:{
                username : username,
                password:password
            },
            type: "Post",
            dataType: "JSON",
            success:a
        })
        function a(data) {
            if (data.code==1){
                alert("成功")
                //TODO 成功后的逻辑
            }else {
                alert(data.message)
            }
        }
    }

    $("#zhuce").click(function () {
        if ($(this).val()=="注册") {
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
        }
        else if($(this).val()=="保存"){
            ajax_addUser()
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
            dataType : "JSON",
            success: a
        })
        function a(data) {
            if (data.code==1){
                callback&&callback()
            }else if (data.code==-1){
                alert(data.message)
            }
        }
    }
    
})