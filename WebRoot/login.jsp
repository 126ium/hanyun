<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Multimedia Resources Management System for HAN YUN</title>
<link rel="stylesheet" type="text/css" href="css/demo.css"/>
<link rel="stylesheet" type="text/css" href="css/style.css"/>
<link rel="stylesheet" type="text/css" href="css/animate-custom.css"/>
</head>

<body>
	<div class="container">
		<header>
			<h1>Login and Registration Form</h1>
				<nav class="codrops-demos">
					<span>Click <strong>"Join us"</strong> to see the form switch</span>
				</nav>
		</header>
		<section>
			<div id="container_demo">
				<a class="hiddenanchor" id="toregister"></a>
				<a class="hiddenanchor" id="tologin"></a>
					<div id="wrapper">
						<div id="login" class="animate form">
							<form action="login.action" autocomplete="on">
								<h1>Log in</h1>
								<p>
									<label for="username" class="uname" data-icon="u"> Your email or username</label>
									<input id="username" name="userName" required="required" type="text" placeholder="myusername or mymail@mail.com"/>
								</p>
								<p>
									<label for="password" class="youpasswd" data-icon="p">Your password</label>
									<input id="password" name="password" required="required" type="password" placeholder="wing"/>
								</p>
								<p class="keeplogin">
									<input type="checkbox" name="loginkeeping" id="loginkeeping" value="loginkeeping"/>
									<label for="loginkeeping">Keep me logged in</label>
								</p>
								<p class="login button"><input type="submit" value="Log in"/>
								</p>
								<p class="change_link">Not a member yet ?<a href="#toregister" class="to_register">Join us</a>
								</p>
							</form>
						</div>

						<div id="register" class="animate form">
							<form action="reg.action" autocomplete="on">
								<h1>Sign up</h1>
								<p>
									<label for="usernamesignup" class="uname" data-icon="u">Your username</label>
									<input id="usernamesignup" name="userName" required="required" type="text" placeholder="RESPIRE" />
								</p>
								<p>
									<label for="emailsignup" class="youemail" data-icon="e">Your email</label>
									<input id="emailsignup" name="email" required="required" type="email" placeholder="mymail@mail.com"/>
								</p>
								<p>
									<label for="passwordsignup" class="youpasswd" data-icon="p">Your password</label>
									<input id="passwordsignup" name="password" required="required" type="password" placeholder="wing"/>
								</p>
								<p>
									<label for="passwordsignup_confirm" class="youpasswd" data-icon="p">Please confirm your password</label>
									<input id="passwordsignup_confirm" name="password_confirm" required="required" type="password" placeholder="wing"/>
								</p>
								<p class="singin button"><input type="submit" value="Sign up"/>
								</p>
								<p class="change_link"> Already a member ? <a href="#tologin" class="to_register">Go and log in</a>
								</p>
							</form>
						</div>
					</div>
			</div>
		</section>

</body>
</html>
