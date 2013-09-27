<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="container">
	<form role="form" id="setForm" action="#" method="POST" enctype="multipart/form-data">
		<div class="form-group">
			<label for="username">Username</label>
			<input type="text" class="form-control" id="username" placeholder="Your Username" name="username">
		</div>
		<div class="form-group">
			<label for="email">Email</label>
			<input type="text" class="form-control" id="email" placeholder="Email" name="email">
		</div>
		<div class="form-group">
			<label for="avatarFile">Avatar</label>
			<input type="file" id="avatarFile" name="avatarFile">
		</div>
		<div class="form-group">
			<table>
				<tbody>
					<tr>
						<td><img id="target" src="" style="width: 500px;" /></td>
						<td>
							<div style="width:100px;height:100px;overflow:hidden;margin-left:5px;">
								<img id="preview" src="" width="320px" style="display: inline;"/>
							</div>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
		
		<div class="form-group" style="display: none;">
			<input type="hidden" id="x" name="imagex">
			<input type="hidden" id="y" name="imagey">
			<input type="hidden" id="w" name="imagew">
			<input type="hidden" id="h" name="imageh">
		</div>
		
		<div class="modal-footer">
			<button type="button" class="btn btn-primary" id="save">Save</button>
		</div>
	</form>
</div>