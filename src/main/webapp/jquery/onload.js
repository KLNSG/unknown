$(function () {

    function onload() {
        setTimeout(function () {
            $("#bottom").animate({
                "opacity": "0.2"
            }, "slow", function () {
                $("body").append("<div id='up' class='line' style='top: 270px; width: 0px;'></div>")
                $("body").append("<div id='do' class='line' style='left: 100%;top: 460px; width: 70%'></div>")
                $("body").append("<div id='cen' style='left:47%;top: 320px;position: absolute;opacity: 0;color : rgba(255,255,255,0.9);width: 250px;height: 150px;font-size: 65px'>登陆</div>")
                $("#up").animate({
                    "width":"70%"
                },"slow",function () {
                    $("#cen").animate({
                        "opacity":"1"
                    },"slow",function () {
                        setTimeout(function () {
                            $("#cen").animate({
                                "opacity":"0"
                            },"slow",function () {
                                $("#up").animate({
                                    "width":"0"
                                },"slow")
                                $("#do").animate({
                                    "left":"100%"
                                },"slow",function () {
                                    $("#bottom").animate({
                                        "opacity": "0.6"
                                    },"slow",function () {
                                        var $p = $("p");
                                        text($p.eq(0),"世事漫心随流水",function() {
                                            text($p.eq(1),"江南烟雨报春寒",function() {
                                                loginpage()
                                            })
                                        })
                                        navigationBar()
                                    })
                                    setTimeout(function () {
                                        $("#up").remove();
                                        $("#do").remove();
                                        $("#cen").remove();
                                    },200)
                                })
                            })
                        },1000)
                    })
                })
                $("#do").animate({
                    "left":"30%"
                },"slow")
            })
        },1000)
    }
    function text($text,str,callback) {
        var index = 0;
        var timer = setInterval(function() {
                var current = str.substr(index, 1);
                if (current == '<') {
                    index = str.indexOf('>', index) + 1;
                } else {
                    index++;
                }
                $text.html(str.substring(0, index));
                if (index >= str.length) {
                    clearInterval(timer);
                }
            },
            100);
        setTimeout(function () {
            callback&&callback()
        },1000)
    }
    function navigationBar() {
        var index = 0;
        var $home = $(".home");
        var interval = setInterval(function () {
            var eq = $home.eq(index);
            index++
            eq.animate({
                "opacity": "1"
            },"slow")
            if (index>=$home.length){
                clearInterval(interval)
            }
        },500);
    }
    function loginpage() {
        $("#loginpage").animate({
            "opacity":"0.4",
            "marginTop":"-320px"
        },"slow")
    }

})