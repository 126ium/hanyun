<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="modal fade" id="uploadModal" tabindex="-1" role="dialog" aria-labelledby="uploadModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="uploadModalLabel">Upload file</h4>
			</div>
			<div class="modal-body">
				<div class="container">
					<form role="form" action="upload" method="POST" enctype="multipart/form-data">
						<div class="form-group">
							<label for="filenameInput">Filename</label>
							<input type="text" class="form-control" id="filenameInput" placeholder="Enter filename" name="filenameInput">
						</div>
						<div class="form-group">
							<label for="permission">Permission:</label>
							<select name="permission">
								<option value="public" selected="selected">Public</option>
								<option value="protected">Registered User Only</option>
								<option value="private">Private</option>
							</select>
						</div>
						<div class="form-group">
							<label for="fileupload">File upload</label>
							<input type="file" id="fileupload" name="fileUpload">
							<p class="help-block">Support type: .doc....</p>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
							<button type="submit" class="btn btn-primary">Upload</button>
						</div>
					</form>
				</div>	
			</div>
		</div>
	</div>
</div>