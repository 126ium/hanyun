<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="container">
	<form role="form" action="#" method="POST">
		<div class="alert alert-danger" id="alertDiv" style="display: none;">
			<p id="errMsg"></p>
		</div>
		<div class="alert alert-success" id="successDiv" style="display: none;">
			<p id="successMsg"></p>
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
			<button type="button" class="btn btn-primary" id="setSave">Save</button>
		</div>
	</form>
</div>