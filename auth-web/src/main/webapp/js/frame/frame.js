var menus = {
    "children": [
        {"id": "0", "icon": "icon-sys", "text": "系统管理",
            "children": [
                {"id": "00", "text": "用户列表", "icon": "icon-nav", "url": "user/user_init"},
                {"id": "00", "text": "角色列表", "icon": "icon-nav", "url": "role/role_init"},
                {"id": "00", "text": "菜单列表", "icon": "icon-nav", "url": "menu/menu_init"}
            ]
        }
    ]
};
$(function () {
    ilm();
    var formLogin = $("#formLogin");
    var name = getCookie("userName");
    if (name == null) {
        formLogin.dialog({
            modal: true,
            closable: false,
            buttons: [{
                text: "登录",
                handler: function () {
                    if (!formLogin.form("validate")) {
                        return;
                    }
                    name = $("#name").val().trim();
                    var password = $("#password").val().trim();
                    $.getJSON('user/login', {name: name, password: password}, function(json) {
                        if (success(json)) {
                            setCookie("userName", name);
                            $.messager.alert("提示", "登录成功", "info");
                            formLogin.dialog("close");
                            $("#userNameShow").text(name);
                        }
                    });
                }}]
        });
    } else {
        $("#userNameShow").text(name);
    }
    ilo();
});

function ilo() {
    $("#loginOut").click(function () {
        $.messager.confirm("系统提示", "您确定要退出本次登录吗?", function (r) {
            if (r) {
                delCookie("userName");
                window.location.reload();
            }
        });
    });
}

function ilm() {
    $("#nav").empty();
    var ml = "";
    $.each(menus.children, function (i, n) {
        ml += "<div title='" + n.text + "' icon='" + n.icon + "' style='overflow:auto;'><ul>";
        $.each(n.children, function (j, o) {
            ml += "<li><div><a ref='" + o.id + "' href='#' rel='" + o.url
                + "' ><span class='icon " + o.icon + "' >&nbsp;</span><span class='nav'>" + o.text
                + "</span></a></div></li> ";
        });
        ml += "</ul></div>";
    });
    $("#nav").append(ml);
    $("#nav").accordion();
    $("#nav li a").click(function () {
        var t = $(this).children(".nav").text();
        var u = $(this).attr("rel");
        var id = $(this).attr("ref");
        var i = gi(id);
        ad(t, u, i);
        $("#nav li div").removeClass("selected");
        $(this).parent().addClass("selected");
    }).hover(function () {
        $(this).parent().addClass("hover");
    }, function () {
        $(this).parent().removeClass("hover");
    });
}

function gi(id) {
    var i = 'icon ';
    $.each(menus.children, function (i, n) {
        $.each(n.children, function (j, o) {
            if (o.id == id) {
                i += o.icon;
            }
        });
    });
    return i;
}

function ad(s, u, i) {
    if ($('#tabs').tabs('exists', s)) {
        $('#tabs').tabs('select', s);
    } else {
        $('#tabs').tabs('add', {
            title: s,
            content: cf(u),
            closable: true,
            icon: i
        });
    }
    tc();
}

function cf(u) {
    return '<iframe scrolling="auto" frameborder="0"  src="' + u + '" style="width:100%;height:100%;"></iframe>';
}

function tc() {
    $(".tabs-inner").dblclick(function () {
        var t = $(this).children(".tabs-closable").text();
        $('#tabs').tabs('close', t);
    });
    $(".tabs-inner").bind('contextmenu', function (e) {
        $('#mm').menu('show', {
            left: e.pageX,
            top: e.pageY
        });
        var t = $(this).children(".tabs-closable").text();
        $('#mm').data("currtab", t);
        $('#tabs').tabs('select', t);
        return false;
    });
}