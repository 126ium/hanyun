<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>Hadoop Search</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" href="../bootstrap/dist/css/bootstrap.css" type="text/css"></link>
	<script type="text/javascript" src="../JQuery/jquery-2.0.3.js"></script>
	<script type="text/javascript" src="../JQuery/jquery-ui.js"></script>
	<link rel="stylesheet" href="../JQuery/jquery-ui.css" type="text/css"></link></head>
  	
  <script>
  	$(document).ready(function(){
  		$("#query").autocomplete({
  			source:	function(request,response)
  			{
  				$.ajax({
  				url :"ajax/sug.action",
  				dataType: "json",
  				data:{
  					query : $("#query").val()
  				},
  				success: function(data){
  					response($.map(data.result,function(item){
						return {value:item};					
  					}));
  				}
  				});
  			},
  			minLength:1,
  		});
  	});
  </script>
  
  
  <body>
    <div class="container">
    	<h1>Hadoop Search</h1>
    	<div class="well">
    		<form action="sug.jsp">
    			<label>Search</label>
    			<input id="query" name="q"></input>
    			<input type="submit"></input>
    		</form>
    	</div>
    </div>
  </body>
</html>
