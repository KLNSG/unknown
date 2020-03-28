$(function () {

    //刷新式响应，需要页面，servlet，js三者配合，代码复杂,不符合高内聚，低耦合的编程思想,不建议使用
    window.location.href ="/user?username=沈国超"
    //ajax代码简单，无需刷新页面即可响应请求
/*    ajax_text()*/

    function ajax_text() {
        $.ajax({
            "url": "user?username=吕欣",
            "type": "Post",
            "dataType": "text",
            success:a
        })
        function a(data) {
            alert(data)
        }
    }
    
})