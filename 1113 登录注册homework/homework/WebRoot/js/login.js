$(function() {

	// 绑定所有事件
	bindEvents();

	// 把form定位到窗口中央
	setFormPosition();

	// 判断是否登录失败
	loginFail();

});

// 把form定位到窗口中央
function setFormPosition() {
	var w = $(window).width();
	var left = (w - 352) / 2;
	var h = $(window).height();
	var top = (h - 235) / 2 - 50;

	$("form").css('left', left);
	$("form").css('top', top);
}
// 绑定所有事件
function bindEvents() {

	// [绑定事件]使用form表单进行数据交互
	// loginUsingForm();
	// [绑定事件]使用ajax进行数据交互
	loginUsingAjax();

	// [绑定事件]注册
	register();
}

// [绑定事件]登录：使用form表单进行数据交互
function loginUsingForm() {
	// 登录
	$("#loginBtn").click(function() {
		if (inputCheck()) {
			$("#formLogin").submit();
		}
	});
}

// [绑定事件]登录：使用ajax进行数据交互
function loginUsingAjax() {
	// 登录
	$("#loginBtn").click(
			function() {
				if (inputCheck()) {
					var params = {
						action : 'login',
						method : 'ajax',
						username : $("#username").val(),
						password : $("#password").val()
					};
					$.ajax({
						url : 'servlet/UserServlet',
						type : 'POST',
						data : params,
						dataType : 'text',
						success : function(res) {
							res = res.replace(/=/g, ":'");
							res = res.replace(/,/g, "',");
							res = res.replace(/}/g, "'}");
							var obj = eval('(' + res + ')');

							if (obj.success === "false") {
								alert("用户名/密码不正确，请重新输入");
								$("#password").val("");
							} else {
								var info = "nickname=" + obj.nickname + "&sex=" + obj.sex
										+ "&registerDate=" + obj.registerDate + "&phone="
										+ obj.phone + "&phoneLast3=" + obj.phoneLast3
										+ "&userType=" + obj.userType;
								window.location.href = "loginSuccess.html?" + info;
							}
						},
						error : function(err) {
							alert("oops");
						}

					});
				}
			});
}

// 前端验证用户名、密码的格式：不能是空str
function inputCheck() {
	var username = $("#username").val();
	var password = $("#password").val();
	if (username === "") {
		alert("请输入用户名");
		return false;
	}
	if (password === "") {
		alert("请输入密码");
		return false;
	}
	return true;
}

// [绑定事件] 注册
function register() {
	$("#registerBtn").click(function() {
		window.location.href = "register.html";
	});
}

// 判断是否登录失败
function loginFail() {
	if (/loginfail/.test(window.location.href)) {
		alert("用户名/密码错误，请重新输入");
	} else if (/registersucess/.test(window.location.href)) {
		alert("注册成功，请登录");
	}
}