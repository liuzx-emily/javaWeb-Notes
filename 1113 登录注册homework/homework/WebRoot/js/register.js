//用户名是否可以注册（是否已经被占用）
var nameOK=false;

$(function(){
	
	// 绑定所有事件
	bindEvents();
	
	// 把form定位到窗口中央
	setFormPosition();
	
	// 判断是否注册失败
	registerFail();
	
	
});

// 把form定位到窗口中央
function setFormPosition(){
	var w=$(window).width();
	var left=(w-453)/2;
	var h=$(window).height();
	var top=(h-483)/2-20;

	$("form").css('left', left);
	$("form").css('top', top);
}

//绑定所有事件
function bindEvents(){
	// [绑定事件]注册：使用form表单进行数据交互
 	// registerUsingForm();

	// [绑定事件]注册：使用ajax进行数据交互
 	registerUsingAjax();
 	
 	// [绑定事件]验证用户名是否已经被占用
 	nameCheck();
}

// [绑定事件]注册：使用form表单进行数据交互
function registerUsingForm() {
	$("#registerBtn").click(function() {
		if (inputCheck()) {
			$("#formRegister").submit();
		}
	});
}
// [绑定事件]注册：使用ajax进行数据交互
function registerUsingAjax(){
	 $("#registerBtn").click(function(){
		if(inputCheck()){
			var params={
				action : 'register',
				method : 'ajax',
				username : $("#username").val(),
				password : $("#password").val(),
				nickname : $("#nickname").val(),
				userType : $("input[name='userType']").val(),
				sex : $("input[name='sex']").val(),
				phone : $("#phone").val()				
			};
			$.ajax({
				url:'servlet/UserServlet',
				type:'POST',
				data:params,
				dataType:'text',
				success:function(res){
					if(res==="true"){
						// 注册成功
						window.location.href="login.html?registersucess";
					}else{
						// 注册失败
						window.location.href="register.html?registerfail";						
					}
				},
				error:function(){
					alert('oops');
				}				
			});
		}
	}); 
}

// 判断是否注册失败
function registerFail() {
	if (/registerfail/.test(window.location.href)) {
		alert("注册失败");
	} 
}

// 前端验证格式
function inputCheck(){
	var username=$("#username").val();
	var password=$("#password").val();
	var nickname=$("#nickname").val();
	var phone=$("#phone").val();
	if(nameOK===false){
		// 用户名已经被占用
		alert("用户名已被占用，请使用其他的用户名");
		return false;
	}	
	if(/^[\u4e00-\u9fa5\w]{5,10}$/.test(username)===false){
		// 长度限制为5-10个中文或英文字符
		alert("用户名格式不正确，请重新输入");
		return false;
	}
	if(/^[\u4e00-\u9fa5\w]{5,10}$/.test(password)===false){
		alert("密码格式不正确，请重新输入");
		return false;
	}
	if(/^[\u4e00-\u9fa5\w]{5,10}$/.test(nickname)===false){
		alert("昵称格式不正确，请重新输入");
		return false;
	}
	if(/^1[3578]\d{9}$/.test(phone)===false){
		alert("电话格式不正确，请重新输入");
		return false;
	}
	return true;
}

// [绑定事件]验证用户名是否已经被占用
function nameCheck(){
	$("#username").blur(function(){
		var params={
			action : 'nameCheck',
			method : 'ajax',
			username : $("#username").val()			
		};
		console.log(params);
		$.ajax({
			url:'servlet/UserServlet',
			type:'POST',
			data:params,
			dataType:'text',
			success:function(res){
				if(res==="true"){
					nameOK=true;
					$("#nameCheckInfo").css("color","green");
					$("#nameCheckInfo").text("用户名可以使用");
				}else{
					nameOK=false;
					$("#nameCheckInfo").css("color","red");
					$("#nameCheckInfo").text("用户名已被占用");	
				}
			},
			error:function(){
				alert('oops');
			}				
		});
			
	});
}
