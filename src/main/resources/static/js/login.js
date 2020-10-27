/* 扫码登录和账号登录的动态效果 */
/*	1.
实现效果： 用户点击扫码/账号登录，展示相应登录界面
	第一步，获取触发事件的两个div容器的控制按钮
	第二步，遍历给按钮添加单击事件
		第三步，查找要修改的容器
		第四步，相应事件触发，则更改容器的display(打开一个，关闭一个；切换账号登录页面时，输入框自动获取焦点)
*/
// 1.查找绑定事件按钮们
var btns=document.querySelectorAll(".body_account_header a");
// 2. 给按钮绑定事件
for(var btn of btns){// 遍历每个按钮添加事件
	btn.onclick=function(){
		// 3. 查找要修改的容器元素
		var reg_sees=document.querySelectorAll(".body_play>div");
		if(this.innerHTML=="扫码登陆"){// 扫码登录+界面
			reg_sees[0].style.display="none";// 账号页面
			reg_sees[1].style.display="block";// 扫码页面
		}else{
			console.log(this.innerHTML);
			reg_sees[0].style.display="block";// 账号页面
			reg_sees[1].style.display="none";// 账号页面
			// 查找要修改input元素
			var input=document.querySelector(".body_account_input input:first-child");
			input.focus();
		}
	}
}

/*  2.
	实现效果：鼠标移入样式改变；鼠标移除样式变回来
		第一步、鼠标移入元素添加指定类名
		第二步、鼠标移出元素清除指定类名
*/
// 1. 查找
var code_1=document.querySelector(".code_1");
// console.log(ewm); // 11
// 2. 绑定
// code_1.onmouseover=function(){/* over存在bug，使用enter */
code_1.onmouseenter=function(){
	// 3. 查找
	var ewm=document.querySelector(".code_1>img:first-child");
	var phone=document.querySelector(".code_1>img:last-child");
	phone.className="phone1";
	ewm.className="ewm1";
};
// code_1.onmouseout=function(){/* out存在bug，使用leave */
code_1.onmouseleave=function(){
	// 3. 查找
	var ewm=document.querySelector(".code_1>img:first-child");
	var phone=document.querySelector(".code_1>img:last-child");
	phone.className="phone";
	ewm.className="ewm";
};
// 1. 查找
// var phone=document.querySelector(".code_1>img:last-child");
// // console.log(ewm); // 11
// // 2. 绑定
// phone.onmouseover=function(){
// 	// console.log("over");// 11
// 	// console.log(this.className);// 11
// 	// 3. 查找
// 	this.className="phone1";
// 	console.log(this.className);
// };
// phone.onmouseout=function(){
// 	// 3. 查找
// 	this.className="phone";
// };