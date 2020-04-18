$(function () {

    onload()

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
                                        },1000)
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
    }  //页面初始化
    function text($text,str,callback,callbackspeed) {
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
        },callbackspeed)
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
        $("#loginpage").fadeIn(1000,function() {
            var $h1 = $("h1");
            text($h1.eq(0),"用户名:",function() {
                $("#name").css("display","block")
                $("#name").animate({
                    "width": "175px"
                },"fast",function() {
                    text($h1.eq(1),"密码:",function() {
                        $("#pass").css("display","block")
                        $("#pass").animate({
                            "width": "175px"
                        },"fast",function() {
                            $(".btn").fadeIn(1000)
                        })
                    },500)
                })
            },500)
        })
    }

    var color
    $(".btn").hover(function(){
        color= $(this).css("color")
        $(this).css("background-color" , color).css("color","black")
    },function() {
        $(this).css({"border-color":color,"background-color":"transparent","color":color})
        $(this).css("background-color","transparent").css("color",color)
    })
})