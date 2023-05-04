$(function (){
    getUserInfo()
    var layer = layui.layer
    // 点击按钮，实现退出功能
    $('#btnLogout').on('click', function() {
        layer.confirm('确定退出登录?', { icon: 3, title: '提示' }, function(index) {
            //do something
            // 1. 清空本地存储中的 token
            localStorage.removeItem('token')
            // 2. 重新跳转到登录页面
            top.location.href = './login.html'
            // 关闭 confirm 询问框
            layer.close(index)
        })
    })

    function  getUserInfo(){
        $.ajax({
            url: '/user/getUserInfo',
            method: 'GET',
            contentType: 'application/json; charset=UTF-8',
            cache: false,
            success: function (res){
                if (res.code !== 200) {
                    return layer.msg('用户认证失败请重新登录！')
                }
                // 调用 renderAvatar 渲染用户的头像
                renderAvatar(res.data)
            }
        })
    }

    // 渲染用户的头像
    function renderAvatar(user) {
        // 1. 获取用户的名称
        var name = user.nickName || user.userName
        // 2. 按需渲染用户的头像
        if (user.avatar !== null) {
            // 3.1 渲染图片头像
            $('.layui-nav-img')
                .attr('src', user.avatar)
                .show()
            $('.text-avatar').hide()
        } else {
            // 3.2 渲染文本头像
            $('.layui-nav-img').hide()
            var first = name[0].toUpperCase()
            $('.text-avatar')
                .html(first)
                .show()
        }
    }

})
