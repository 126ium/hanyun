<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="container">
	<button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#uploadModal">
		Upload
	</button>
	<div class="divider"></div>
	<table class="table table-hover">
		<thead>
			<tr>
				<th>File Name</th>
				<th>Size</th>
				<th>Upload Time</th>
				<th>Review Status</th>
				<th>Permission</th>
				<th>Download Times</th>
				<th>Browse Times</th>
				<th>Operation</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>file1</td>
				<td>6.3 MB</td>
				<td>2020-2-20 19:30:20</td>
				<td>Pass</td>
				<td>Public</td>
				<td>2</td>
				<td>5</td>
				<td>
					<button class="btn btn-danger btn-lg" data-toggle="modal" data-target="#deleteModal">
						Delete
					</button>
				</td>
			</tr>
		</tbody>
	</table>
</div>