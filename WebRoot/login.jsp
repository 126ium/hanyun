<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title> Han Yun | Sign in/up </title>
		<link href="css/bootstrap.css" rel="stylesheet">
		<link href="css/navbar-fixed-top.css" rel="stylesheet">
		<link href="css/custom.css" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="css/demo.css" />
        <link rel="stylesheet" type="text/css" href="css/style.css" />
		<link rel="stylesheet" type="text/css" href="css/animate-custom.css" />
		<script type="text/javascript" src="js/jquery-1.8.0.min.js"></script>
		<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
		<script type="text/javascript" src="js/easyui-lang-zh_CN.js"></script>
		<link rel="stylesheet" href="css/easyui.css" type="text/css"/>
		<link rel="stylesheet" href="css/icon.css" type="text/css"/>
	</head>
<body>
	<%@ include file="layouts/_header.jsp"%>
	<div class="container" id="login_container">
		<section>
			<div id="container_demo">
				<a class="hiddenanchor" id="toregister"></a>
				<a class="hiddenanchor" id="tologin"></a>
				<div id="wrapper">
                        <div id="login" class="animate form">
                            <form id="loginForm" mothod="post" autocomplete="on"> 
                                <h1>Log in</h1> 
                                <div class="alert alert-danger" id="loginAlertDiv" style="display: none;">
									<p id="loginErrMsg">Warning message.</p>
								</div>
                                <p> 
                                    <label for="username" class="uname" data-icon="u" > Your email or username </label>
                                    <input id="username" name="userName" required type="text" placeholder="myusername or mymail@mail.com"/>
                                </p>
                                <p> 
                                    <label for="password" class="youpasswd" data-icon="p"> Your password </label>
                                    <input id="password" name="password" required type="password" placeholder="eg. X8df!90EO" /> 
                                </p>
                                <p class="keeplogin"> 
									<input type="checkbox" name="loginkeeping" id="loginkeeping" value="loginkeeping" /> 
									<label for="loginkeeping">Keep me logged in</label>
								</p>
                                <p class="login button"> 
                                   <input type="button" class="login" onclick="javacript:void(0)" value="Login"/> 
								</p>
                                <p class="change_link">
									Not a member yet ?
									<a href="#toregister" class="to_register">Join us</a>
								</p>
                            </form>
                        </div>

                        <div id="register" class="animate form">
                            <form id="regForm" method="post" autocomplete="on"> 
                                <h1> Sign up </h1> 
								<div class="alert alert-danger" id="alertDiv" style="display: none;">
									<p id="errMsg">Warning message.</p>
								</div>
                                <p> 
                                    <label for="usernamesignup" class="uname" data-icon="u">Your username</label>
                                    <input id="usernamesignup" name="userName" required type="text" placeholder="mysuperusername690" />
                                </p>
                                <p> 
                                    <label for="emailsignup" class="youmail" data-icon="e" > Your email</label>
                                    <input id="emailsignup" name="email" required type="email" placeholder="mysupermail@mail.com"/> 
                                </p>
                                <p> 
                                    <label for="passwordsignup" class="youpasswd" data-icon="p">Your password </label>
                                    <input id="passwordsignup" name="password" required type="password" placeholder="eg. X8df!90EO"/>
                                </p>
                                <p> 
                                    <label for="passwordsignup_confirm" class="youpasswd" data-icon="p">Please confirm your password </label>
                                    <input id="passwordsignup_confirm" name="password_confirm" required type="password" placeholder="eg. X8df!90EO"/>
                                </p>
                                <p class="signin button"> 
									<input type="button" class="reg" onclick="javacript:void(0)" value="Sign up"/> 
								</p>
                                <p class="change_link">  
									Already a member ?
									<a href="#tologin" class="to_register"> Go and log in </a>
								</p>
                            </form>
                        </div>
				</div>
			</div>
		</section>
		<%@ include file="layouts/_footer.jsp" %>
	</div>
	<script type="text/javascript">
		$(function(){
			$(".reg").click(function(){				
				$('#regForm').form('submit', {   
					url:'reg.action',   
					onSubmit: function(){ 
						if ($("#usernamesignup").val().length < 5) {
							$("#alertDiv").attr("style", "display: block;");
							$("#errMsg").html("Username is null or too short!");
							return false;
						}
						if ($("#passwordsignup").val().length < 5) {
							$("#alertDiv").attr("style", "display: block;");
							$("#errMsg").html("Password is null or too short!");
							return false;
						}
						if ($("#passwordsignup").val() != $("#passwordsignup_confirm").val()) {
							$("#alertDiv").attr("style", "display: block;");
							$("#errMsg").html("Passwords do NOT match!");
							return false;
						}
						var isEmail = /[a-z0-9-]{1,30}@[a-z0-9-]{1,65}.[a-z]{3}/ ;       
						if (!isEmail.test($("#emailsignup").val().toLowerCase())) {
							$("#alertDiv").attr("style", "display: block;");
							$("#errMsg").html("Invalid Email Address!");
							return false;
						}
					},   
					success: function(data){ 
						//alert("提交！");
						var data = eval('(' + data + ')'); 
						if (data.msg == null){
							window.location="index.jsp";
						} else {
							$("#alertDiv").attr("style", "display: block;");
							$("#errMsg").html(data.msg);						
						}  
					}       
				}); 
			});
			
			$(".login").click(function() {
				$("#loginForm").form('submit', {
					url:'login.action',
					onSubmit: function() {
						//check						
					},
					success : function(data) {
						var data = eval('(' + data + ')');
						if (data.msg == null) {
							window.location = "index.jsp";
						} else {
							$("#loginAlertDiv").attr("style", "display: block;");
							$("#loginErrMsg").html(data.msg);	
						}
					
					}					
				});				
			});
			 
		});	 													 							 							 
	</script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>
