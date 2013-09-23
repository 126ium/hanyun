<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="container">
	<form role="form" action="#" method="POST" enctype="multipart/form-data">
		<div class="form-group">
			<label for="username">Username</label>
			<input type="text" class="form-control" id="username" placeholder="Your Username" name="username">
		</div>
		<div class="form-group">
			<label for="email">Email</label>
			<input type="text" class="form-control" id="email" placeholder="Email" name="email">
		</div>
		<div class="form-group">
			<label for="avatar">Avatar</label>
			<input type="file" id="avatar" name="avatar">
		</div>
		<div class="modal-footer">
			<button type="submit" class="btn btn-primary">Save</button>
		</div>
	</form>
</div>