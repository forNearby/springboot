// require('jQuery')   //JQuery的提示作用
$(function () {
    //点击"去注册按钮"的链接
    $('#link-reg').on('click', function () {
        $('.login-box').hide()
        $('.reg-box').show()
    })
    //点击"去登录按钮"的链接
    $('#link_login').on('click', function () {
        $('.login-box').show()
        $('.reg-box').hide()
    })
    //消息提示框对象
    var layer = layui.layer
    //监听注册表单的提交事件
    $('#form_reg').on('submit', function (e) {
        e.preventDefault();//阻止表单自动提交
        $.ajax({
            url: '/api/reguser',
            method: 'POST',
            // 快速获取表单中的数据
            data: { userName: $('#form_reg [name=userName]').val(), password: $('#form_reg [name=password]').val() },
            success: function (res) {
                if (res.status !== 0) {
                    return layer.msg(res.message)
                }
                layer.msg('注册成功,请登录！')
                //模拟注册成功后点击登录行为
                $('#link_login').click()
            }
        })
    })
    //监听登录表单的提交事件
    $('#form_login').on('submit', function (e) {
        e.preventDefault();//阻止表单自动提交
        $.ajax({
            url: '/login/login',
            method: 'POST',
            contentType: 'application/json; charset=UTF-8',
            cache: false,
            // POST请求参数需要序列化
            data: JSON.stringify({ userName: $('#form_login [name=userName]').val(), password: $('#form_login [name=password]').val()}),
            success: function (res) {
                console.log(res)
                if (res.code !== 200) {
                    return layer.msg('登录失败！')
                }
                layer.msg('登录成功！')
                // 将登录成功得到的 token 字符串，保存到 localStorage 中
                localStorage.setItem('token', res.data.token)
                // 跳转到后台主页
                location.href = './index.html'
            }
        })
    })
})