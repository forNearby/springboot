$(function (){
    var form = layui.form
    var layer = layui.layer
    //自定义验证规则
    form.verify({
        samePwd: function(value) {
            if (value === $('[name=oldPwd]').val()) {
                return '新旧密码不能相同！'
            }
        },
        rePwd: function(value) {
            if (value !== $('[name=newPwd]').val()) {
                return '两次密码不一致！'
            }
        }
    })
    //提交更新数据
    $('#pwdCommit').on('click',function (e){
    // $('.layui-form').on('submit(formDemo)', function (e){
        e.preventDefault()
        $.ajax({
            url: '/user/updateUserPWD',
            method: 'POST',
            contentType: 'application/json; charset=UTF-8',
            cache: false,
            data: JSON.stringify({oldPwd:$('#form_userpwd [name=oldPwd]').val(), newPwd: $('#form_userpwd [name=newPwd]').val()}),
            success: function(res) {
                console.log("修改成功")
                if (res.code === 205) {
                    layer.msg('密码更新成功,请重新登录',{
                        offset:['50%'],
                        time: 2000 //1秒关闭（如果不配置，默认是3秒）
                    },function(){
                        // 1. 清空本地存储中的 token
                        localStorage.removeItem('token')
                        // 2. 重新跳转到登录页面
                        top.location.href = './login.html'
                    });
                }else {
                    layer.msg('修改密码失败！')
                }
            }
        })
    })
})