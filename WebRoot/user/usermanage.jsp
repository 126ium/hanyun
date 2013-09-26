<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="container">
	<div class="media">
  		<a class="pull-left" href="#">
    		<img style="width: 64px; height: 64px;" class="media-object" src="avatar/default_avatar.jpg" alt="">
  		</a>
  		<div class="media-body">
    		<h4 class="media-heading">User</h4>
    		<p>
    			<button class="btn btn-primary" style="width: 90px; height: 30px; font-size: 13px; padding: 6px 3px;">
					Set as User
				</button>
    			<button class="btn btn-warning" style="width: 90px; height: 30px; font-size: 13px; padding: 6px 3px;">
					Set as Admin
				</button>
    			<button class="btn btn-danger" data-toggle="modal" data-target="#userDeleteModal" style="width: 90px; height: 30px; font-size: 13px; padding: 6px 3px;">
					Delete
				</button>
			</p>
  		</div>
	</div>
	<div class="media">
  		<a class="pull-left" href="#">
    		<img style="width: 64px; height: 64px;" class="media-object" src="avatar/default_avatar.jpg" alt="">
  		</a>
  		<div class="media-body">
    		<h4 class="media-heading">CCAPP</h4>
    		<p>
    			<button class="btn btn-primary" style="width: 90px; height: 30px; font-size: 13px; padding: 6px 3px;">
					Set as User
				</button>
    			<button class="btn btn-warning" style="width: 90px; height: 30px; font-size: 13px; padding: 6px 3px;">
					Set as Admin
				</button>
    			<button class="btn btn-danger" data-toggle="modal" data-target="#userDeleteModal" style="width: 90px; height: 30px; font-size: 13px; padding: 6px 3px;">
					Delete
				</button>
			</p>
  		</div>
	</div>
</div>

<div class="modal fade" id="userDeleteModal" tabindex="-1" role="dialog" aria-labelledby="userDeleteModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="userDeleteModalLabel">Delete user</h4>
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