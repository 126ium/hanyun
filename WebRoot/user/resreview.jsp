<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="container">
	<div class="divider"></div>
	<table class="table table-hover">
		<thead>
			<tr>
				<th>File Name</th>
				<th>Size</th>
				<th>Upload Time</th>
				<th>Permission</th>
				<th>Operation</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>file1</td>
				<td>6.3 MB</td>
				<td>2020-2-20 19:30:20</td>
				<td>Public</td>
				<td>		
					<button class="btn btn-success" style="width: 50px; height: 30px; font-size: 11px; padding: 6px 10px">
						Pass
					</button>
					<button class="btn btn-warning" style="width: 50px; height: 30px; font-size: 11px; padding: 6px 10px;">
						Deny
					</button>
					<button class="btn btn-danger" data-toggle="modal" data-target="#adminDeleteModal" style="width: 50px; height: 30px; font-size: 11px; padding: 6px 10px">
						Delete
					</button>
				</td>
			</tr>
		</tbody>
	</table>
</div>

<div class="modal fade" id="adminDeleteModal" tabindex="-1" role="dialog" aria-labelledby="adminDeleteModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="adminDeleteModalLabel">Delete file</h4>
			</div>
			<div class="modal-body">
				<div class="container center">
					<h3>Are you sure?</h3>
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					<button type="submit" class="btn btn-danger">Delete</button>
				</div>	
			</div>
		</div>
	</div>
</div>