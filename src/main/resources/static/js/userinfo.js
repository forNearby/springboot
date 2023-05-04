$(function (){
    var form = layui.form
    var layer = layui.layer
    initUserInfo()

    //自定义验证规则
    form.verify({
        nickname: function(value) {
            if (value.length > 6) {
                return '昵称长度必须在 1 ~ 6 个字符之间！'
            }
        }
    })
    function  initUserInfo(){
        $.ajax({
            url: '/user/getUserInfo',
            method: 'GET',
            contentType: 'application/json; charset=UTF-8',
            cache: false,
            success: function (res){
                if (res.code !== 200) {
                    return layer.msg('用户认证失败请重新登录！')
                }
                // 调用 form.val() 通过lay-filter属性 快速为表单赋值
                form.val('formUserInfo', res.data)
            }
        })
    }
    // 重置表单的数据
    $('#btnReset').on('click', function(e) {
        // 阻止表单的默认重置行为
        e.preventDefault()
        initUserInfo()
    })

    //提交更新数据
    $('#userinfoCommit').on('click',function (e){
        e.preventDefault()
        $.ajax({
            url: '/user/updateUserInfo',
            method: 'POST',
            contentType: 'application/json; charset=UTF-8',
            cache: false,
            data: JSON.stringify({nickName: $('#form_userinfo [name=nickName]').val(), email: $('#form_userinfo [name=email]').val()}),
            success: function(res) {
                if (res.code !== 200) {
                    return layer.msg('更新用户信息失败！')
                }
                layer.msg('更新用户信息成功！')
            }
        })
    })
})
