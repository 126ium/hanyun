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
		<link rel="stylesheet" type="text/css" href="css/demo.css"/>
		<link rel="stylesheet" type="text/css" href="css/style.css"/>
		<link rel="stylesheet" type="text/css" href="css/animate-custom.css"/>
		<style type="text/css"></style>
		<script>window["_GOOG_TRANS_EXT_VER"] = "1";</script>
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
						<form action="#" autocomplete="on">
							<h1>Sign in</h1>
							<p>
								<label for="username" class="uname" data-icon="u"> Your email or username</label>
								<input id="username" name="username" required="required" type="text" placeholder="mymail@mail.com"/>
							</p>
							<p>
								<label for="password" class="youpasswd" data-icon="p">Your password</label>
								<input id="password" name="password" required="required" type="password" placeholder="wing"/>
							</p>
							<p class="keeplogin">
								<input type="checkbox" name="loginkeeping" id="loginkeeping" value="loginkeeping"/>
								<label for="loginkeeping">Keep me logged in</label>
							</p>
							<p class="login button"><input type="submit" value="Log in"/></p>
							<p class="change_link">Not a member yet ?<a href="#toregister" class="to_register">Join us</a></p>
						</form>
					</div>

					<div id="register" class="animate form">
						<form action="#" autocomplete="on">
							<h1>Sign up</h1>
							<p>
								<label for="usernamesignup" class="uname" data-icon="u">Your username</label>
								<input id="usernamesignup" name="usernaamesignup" required="required" type="text" placeholder="Your username" />
							</p>
							<p>
								<label for="emailsignup" class="youemail" data-icon="e">Your email</label>
								<input id="emailsignup" name="emailsignup" required="required" type="email" placeholder="mymail@mail.com"/>
							</p>
							<p>
								<label for="passwordsignup" class="youpasswd" data-icon="p">Your password</label>
								<input id="passwordsignup" name="passwordsignup" required="required" type="password" placeholder="wing"/>
							</p>
							<p>
								<label for="passwordsignup_confirm" class="youpasswd" data-icon="p">Please confirm your password</label>
								<input id="passwordsignup_confirm" name="passwordsignup_confirm" required="required" type="password" placeholder="wing"/>
							</p>
							<p class="singin button"><input type="submit" value="Sign up"/></p>
							<p class="change_link"> Already a member ? <a href="#tologin" class="to_register">Go and log in</a></p>
						</form>
					</div>
				</div>
			</div>
		</section>
		<%@ include file="layouts/_footer.jsp" %>
	</div>
	<script src="js/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>
