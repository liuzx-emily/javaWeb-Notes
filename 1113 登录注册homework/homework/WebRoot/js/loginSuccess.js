
$(function() {
	
	//显示用户信息
	showUserInfo();

	// [绑定事件]打开"修改用户信息"面板
	OpenInfoChange();
	
	// [绑定事件]修改用户信息
	infoChange();
	
});

//显示用户信息
function showUserInfo(){
	var userType = getUrlParams().userType;
	switch (userType) {
	case "1":
		userInfoType1()
		break;
	case "2":
		userInfoType2()
		break;
	case "3":
		userInfoType3()
		break;
	}
	$("#infoChangeBtn").css("display", "block");
}

function userInfoType1() {
	var nickname = getUrlParams().nickname;
	var sex = (getUrlParams().sex === '1' ? "先生" : "女士");
	$("#userInfoType1 .nickname").text(nickname + sex + "：");

	var registerDate = getUrlParams().registerDate;
	$("#userInfoType1 .registerDate").text(registerDate);

	var phone = getUrlParams().phone;
	$("#userInfoType1 .phone").text(phone);

	$("#userInfoType1").css("display", "block");
}

function userInfoType2() {

	var nickname = getUrlParams().nickname;
	$("#userInfoType2 .nickname").text("超级管理员" + nickname + "：");

	var registerDate = getUrlParams().registerDate;
	$("#userInfoType2 .registerDate").text(registerDate);

	var phone = getUrlParams().phone;
	$("#userInfoType2 .phone").text(phone);

	var phoneLast3 = getUrlParams().phoneLast3;
	$("#userInfoType2 .phoneLast3").text(phoneLast3);

	$("#userInfoType2").css("display", "block");

}

function userInfoType3() {

	var nickname = getUrlParams().nickname;
	$("#userInfoType3 .nickname").html("尊敬的客户" + nickname + "：");

	var registerDate = getUrlParams().registerDate;
	$("#userInfoType3 .registerDate").text(registerDate);

	var phone = getUrlParams().phone;
	$("#userInfoType3 .phone").text(phone);

	var phone;
	$("#userInfoType3 .phone").html(phone);

	$("#userInfoType3").css("display", "block");
}

// [绑定事件]打开"修改用户信息"面板
function OpenInfoChange(){
	$("#ShowInfoChangeBtn").click(function(){
		$("#nickname").val(getUrlParams().nickname);
		$("#userType"+getUrlParams().userType).prop("checked","true");
		$("#sex"+getUrlParams().sex).prop("checked","true");
		$("#phone").val(getUrlParams().phone);
		
		$("#infoChangeForm").css("display","block");
	});
}

//[绑定事件]修改用户信息
function infoChange(){
	$("#infoChangeBtn").click(function(){
		if(inputCheck()){
			var params={
				action : 'infoChange',
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

//前端验证格式
function inputCheck(){
	var nickname=$("#nickname").val();
	var phone=$("#phone").val();
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