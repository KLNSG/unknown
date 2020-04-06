$(function () {

    //刷新式响应，需要页面，user.servlet，js三者配合，代码复杂,不符合高内聚，低耦合的编程思想,不建议使用
/*    window.location.href ="/user?username=沈国超"*/
    //ajax代码简单，无需刷新页面即可响应请求
   /* ajax_text()
    function ajax_text() {
        var name="吕欣"
        $.ajax({
            url: "user",
            data:{
                username : name
            },
            type: "Post",
            dataType: "text",
            success:a
        })
        function a(data) {
            alert(data)
        }
    }*/

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
    
})