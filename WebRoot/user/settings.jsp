<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="container">
	<form role="form" action="#" method="POST">
		<div class="alert alert-danger" id="alertDiv" style="display: block;">
			<p id="errMsg">Warning message.</p>
		</div>
		<div class="form-group">
			<label for="passwdOld">Old Password</label>
			<input type="password" class="form-control" id="passwdOld" placeholder="Your Old password" name="passwdOld">
		</div>
		<div class="form-group">
			<label for="passwdNew">New Password</label>
			<input type="password" class="form-control" id="passwdNew" placeholder="Your New password" name="passwdNew">
		</div>
		<div class="form-group">
			<label for="passwdConfirm">Confirm Password</label>
			<input type="password" class="form-control" id="passwdConfirm" placeholder="Confirm password" name="passwdConfirm">
		</div>
		<div class="modal-footer">
			<button id="saveInfoButton"type="submit" class="btn btn-primary">Save</button>
		</div>
	</form>
</div>
<script type="text/javascript">
	$("#saveInfoButton").click(function() {
		
		
		});
</script>