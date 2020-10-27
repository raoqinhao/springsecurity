/* 
        login_1、login_2获取焦点 
*/
// #login_1中的第一个input
var log1_inp=document.querySelector("#login_1 input");
log1_inp.focus();
// #login_2中的第一个input
var $log2_inp=$("#login_2 input:first");
$log2_inp.focus();


/*  
        login_1中的用户输入完手机号之后点击“点击按钮进行验证”，进行验证，并显示相应的提示
*/

// 鼠标点击事件
$("#login_1 .btn_1").click(function(){
  // 3.找到要修改的元素
  // 当前输入框后边的额两个span
  // 4. 修改元素
  var reg=/0?(13|14|15|17|18|19)[0-9]{9}/;
  if(reg.test(log1_inp.value)){
    // 输入正确则边框变绿
    $(log1_inp).addClass("green_bor")
    // 清除红边框
    .removeClass("red_bor")
    // 当格式正确后则在后边第一个span加类名(显示“格式正确” correct 的图标)
    .next().addClass("pho_cor")
    // 把第二个span的类名清空
    .next().removeClass("pho_err")
    // 取消 验证按钮 的不可选中状态
    .next().next().prop("disabled",false)
    // 并且添加类名 btn_22
    .addClass("btn_22");
  }else{
    // 输入错误则边框变红,11
    $(log1_inp).addClass("red_bor")
    // 清除绿边框
    .removeClass("green_bor")
    // 把第一个span的类名清空
    .next().removeClass("pho_cor")
    // 当格式错误后则在后边第二个span加类名(显示“格式有误”和 error 的图标)
    .next().addClass("pho_err")
    // 输入有误， 验证按钮 改为的不可选中状态
    .next().next().prop("disabled",true)
    // 并且清除类名
    .removeClass("btn_22");
  }
});

/*  
        login_1用户手机号测试成功，点击“下一步”，则进入 录入信息的页面
*/
// 1. 查找
$(log1_inp)
.siblings(":last")
// 2. 绑定
  // 单击事件
.click(function(){
  // 3. 查找
  // #login_1
  // #login_2
  // log2_inp
  // 4. 修改
  // #login_1隐藏
  $("#login_1").css("display","none")
  // #login_2显示
  .next().css("display","block");
  /*  
        log_up 切换
  */
  // login_1-->login_2
  // 1. 查找绑定
  // 无需继续查找
  // 2. 绑定
  // 无需继续绑定
  // 3.1 查找修改
  $(".log_up .num_chan")
  // 4.1 修改
  .addClass("num_change")
  .css("border",0)
  .html(" ")
  .parent()
  .next()
  .removeClass("arrow")
  .addClass("arrow_change")
  .next()
  .children(".num")
  .addClass("num_chan")
  .next()
  .addClass("tip_change")
})

/*  
        login_2中的用户输入用户名和密码，显示相应提示，并且在输入结束要有对应的判断和提示
*/
// 1. 查找绑定
// 触发事件的元素时输入框
$("#login_2 input")
// 2. 绑定
  // 2.1 焦点获取事件
  .click(function(){
    // 3.查找修改
    // span
    $(this).next()
    // 4. 修改
    // input紧邻的下一个span出现提示
    .css("display","block")
    // 其他的span隐藏
    .siblings("span")
    .css("display","none");
  })
  // 2.2 失去焦点事件(第一个 用户名框 )
  $("#login_2 input:first").blur(function(){
    var reg=/^[a-zA-Z1-9_]{4,10}$/;
    if(reg.test($(this).val())){
      // 格式正确
      // 3.查找修改
      // span
      // input
      $(this)
      // 4. 修改
      // input添加类名log2_cor(边框绿、末尾加对勾)
      .addClass("log2_cor")
      // 去掉类名log2_err
      .removeClass("log2_err")
      // 加绿色边框
      .addClass("green_bor")
      // 清除红边框
      .removeClass("red_bor")
      // span隐藏
      .next()
      .css("display","none")
      // 去掉类名sp_err
      .removeClass("sp_err");
    }else{
      // 格式不正确
      // 3.查找修改
      // span
      // input
      $(this)
      // 4. 修改
      // input添加类名log2_err(末尾加红叉)
      .addClass("log2_err")
      // 清除绿色边框
      .removeClass("green_bor")
      // 加红边框
      .addClass("red_bor")
      // 去掉类名log2_cor
      .removeClass("log2_cor")
      // 清除绿边框
      .removeClass("green_bor")
      // 加红色色边框
      .addClass("red_bor")
      // 则把span换成红色背景图标
      .next()
      .addClass("sp_err");
    }
  });
  // 2.2 失去焦点事件( 密码框 )
  $("#login_2 input:eq(1)")
  .blur(function(){
    var reg=/[a-zA-Z1-9_$]{8,16}/;
    if(reg.test($(this).val())){
      // 格式正确
      // 3.查找修改
      // span
      // input
      $(this)
      // 4. 修改
      // input添加类名log2_cor(边框绿、末尾加对勾)
      .addClass("log2_cor")
      // 去掉类名log2_err
      .removeClass("log2_err")
      // 加绿色边框
      .addClass("green_bor")
      // 清除红边框
      .removeClass("red_bor")
      // span隐藏
      .next()
      .css("display","none")
      // 去掉类名sp_err
      .removeClass("sp_err");
    }else{
      // 格式不正确
      // 3.查找修改
      // span
      // input
      $(this)
      // 4. 修改
      // input添加类名log2_err(末尾加红叉)
      .addClass("log2_err")
      // 去掉类名log2_cor
      .removeClass("log2_cor")
      // 清除绿色边框
      .removeClass("green_bor")
      // 加红边框
      .addClass("red_bor")
      // 则把span换成红色背景图标
      .next()
      .addClass("sp_err");
    }
  });
// 2.2 失去焦点事件( 确认密码框 )
$("#login_2 input:eq(2)")
  .blur(function(){
    if($(this).val()!=""&&$(this).val()==$(this).siblings("input:eq(1)").val()){
      // 格式正确
      // 3.查找修改
      // span
      // input
      $(this)
      // 4. 修改
      // input添加类名log2_cor(边框绿、末尾加对勾)
      .addClass("log2_cor")
      // 去掉类名log2_err
      .removeClass("log2_err")
      // 加绿色边框
      .addClass("green_bor")
      // 清除红边框
      .removeClass("red_bor")
      // span隐藏
      .next()
      .css("display","none")
      // 去掉类名sp_err
      .removeClass("sp_err");
    }else{
      // 格式不正确
      // 3.查找修改
      // span
      // input
      $(this)
      // 4. 修改
      // input添加类名log2_err(边框红、末尾加红叉)
      .addClass("log2_err")
      // 去掉类名log2_cor
      .removeClass("log2_cor")
      // 清除绿色边框
      .removeClass("green_bor")
      // 加红边框
      .addClass("red_bor")
      // 则把span换成红色背景图标
      .next()
      .addClass("sp_err");
    }
  });

/*  
        login_2中的两个密码框后边的眼睛被按下时，密码可见，且图片更换
*/
// 密码
// 1. 查找绑定
// b
$("#login_2 b:first")
// 2.1 绑定
  // 鼠标按下事件 mousedown
  .mousedown(function(){
    // 3. 查找修改
    $(this)
    // 4. 修改
    // 更换背景图为look
    .addClass("look1")
    // 所在的输入框type=text
    .siblings("input:eq(1)")
    .attr("type","text")
  })
// 2.2 绑定
  // 鼠标抬起事件 mouseup
  .mouseup(function(){
    // 3. 查找修改
    // 
    $(this)
    // 4. 修改
    // 更换背景图为look
    .removeClass("look1")
    // 所在的输入框type=text
    .siblings("input:eq(1)")
    .attr("type","password")
  })
// 确认密码
// 1. 查找绑定
// b
$("#login_2 b:last")
// 2.1 绑定
  // 鼠标按下事件 mousedown
  .mousedown(function(){
    // 3. 查找修改
    $(this)
    // 4. 修改
    // 更换背景图为look
    .addClass("look2")
    // 所在的输入框type=text
    .siblings("input:eq(2)")
    .attr("type","text")
  })
// 2.2 绑定
  // 鼠标抬起事件 mouseup
  .mouseup(function(){
    // 3. 查找修改
    // 
    $(this)
    // 4. 修改
    // 更换背景图为look
    .removeClass("look2")
    // 所在的输入框type=text
    .siblings("input:eq(2)")
    .attr("type","password")
  })

/*  
          当login_2中的三个输入框都输入无误之后，可以提交信息，同时通过ajax向服务器发送信息
*/

// 1. 查找绑定
// login_2下的button键
$("#login_2 .btn_2")
// 2. 绑定
// 鼠标单击事件
.click(function(){
  // 判断如果上边的输入框都拥有类名("green_bor")else-if
  if(!$("#login_2 input:first").hasClass("green_bor")){
    // 如果没有
    // 3. 查找修改
    // 对应的span
    $("#login_2 span:first")
    // 4. 修改
    // 将span提示显示出来
    .css("display","block")
  }else if(!$("#login_2 input:eq(1)").hasClass("green_bor")){
    // 如果没有
    // 3. 查找修改
    // 对应的span
    $("#login_2 span:eq(1)")
    // 4. 修改
    // 将span提示显示出来
    .css("display","block")
  }else if(!$("#login_2 input:eq(2)").hasClass("green_bor")){
    // 如果没有
    // 3. 查找修改
    // 对应的span
    $("#login_2 span:eq(2)")
    // 4. 修改
    // 将span提示显示出来
    .css("display","block")
  }else{
    // 如果拥有
    // 3. 查找修改
    // 无需修改
    // 4. 修改
    // login_2隐藏
    $("#login_2")
    .css("display","none")
    // login_3显示
    .next()
    .css("display","block")
    /*  
        log_up 切换
    */
    // login_1-->login_2
    // 1. 查找绑定
    // 无需继续查找
    // 2. 绑定
    // 无需继续绑定
    // 3.1 查找修改
    $(".log_up .num_chan:eq(1)")
    // 4.1 修改
    .addClass("num_change")
    .css("border",0)
    .html(" ")
    .parent()
    .next()
    .removeClass("arrow")
    .addClass("arrow_change")
    .next()
    .children(".num")
    .addClass("num_chan")
    .next()
    .addClass("tip_change")
    /*  
        注册成功之后，自动读秒跳转，或手动进入 完善个人信息
    */
    // 1. 查找
    //查找#login_2下的提交信息button
    // 2. 绑定
      // 3. 查找
      // login_3下的第一个a元素
      var a=document.querySelector("div#login_3 a:last-child");
      // 的第一个字
      var num=a.innerHTML.slice(0,1);
      // 4. 修改
      // 通过定时器实现读秒效果
      setInterval(function(){
        if(num==0){
          location.replace("/toLogin");
        }else{
          num--;
          a.innerHTML= num + '秒后进入登录页面';
        }
      },1000);
  }
})
// ajax发送请求
.click(function(){
  // 1.get data
  var _phone=log1_inp.value;
  var _uname=$log2_inp.val();
  var _upwd=$log2_inp.next().next().val();
  // 2.check data
  // 无需测试
  // 3.create obj
  var xhr=new XMLHttpRequest();
  xhr.onreadystatechange=function(){
    if(xhr.readyState==4 && xhr.status==200){
      var r=xhr.responseText;
      if(r==0){
        alert("注册失败");
        return;
      }
      alert("注册成功");
    }
  };
  xhr.open("post","/toRegister",false);
  var formdata='{"mobilephone":"'+ _phone + '","username":"' + _uname + '","password":"' + _upwd + '"}';
  xhr.setRequestHeader("Content-type","application/json;charset=UTF-8");
  xhr.send(formdata);
});







/*  
  获得计算后的样式
    getComputedStyle(元素对象).具体属性
                      如果是有减号的则有驼峰原则
*/
