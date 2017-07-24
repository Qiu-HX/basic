/**
 * Created by user on 2017/7/20.
 */
$(function(){
    var layerLoading = null;

    //回车登录
    function keydownLogin () {
        event.keyCode == 13 && login();
    }
    //登录
    function login() {
        if(!$('#username').val()){
            layer.msg('请输入帐号');
            return;
        }
        if(!$('#password').val()){
            layer.msg('请输入密码');
            return;
        }
        $.ajax({
            type: 'POST',
            url: '/api/manage/login',
            contentType: 'application/x-www-form-urlencoded',
            dataType: 'json',
            data: {
                account: $('#username').val(),
                password: md5($('#password').val()),
                rememberMe:$("#rememberUser").get(0).checked
            },
            beforeSend: function() {
                layerLoading = layer.load();
            },
            success: function(result) {
                if (result.code == 0) {
                    location.href = '/';
                } else {
                    layer.alert(result.message);
                }
            },
            complete:function(){
                layer.close(layerLoading);
            }
        });
    }

    //登出
    function logout() {
        $.ajax({
            type: 'GET',
            url: '/api/manage/logout',
            success: function(data) {
                location.href = '/user/login';
            }
        });
    }

    //如果嵌套在iframe
    if(window.parent) {
        window.parent.toLogin();
    }
});