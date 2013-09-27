function uploadTemp() {
	var fd = new FormData(document.getElementById("setForm"));
	fd.append("CustomField", "This is some extra data");
	$.ajax({
	  url: "avatarUpload",
	  type: "POST",
	  data: fd,
	  processData: false,  // tell jQuery not to process the data
	  contentType: false   // tell jQuery not to set contentType
	}).done(cutImage);
	
};

function cutImage() {
	$("#target").attr("src", "avatar/" + $.md5('1000').toUpperCase() + ".png.tmp");
	$("#preview").attr("src", "avatar/" + $.md5('1000').toUpperCase() + ".png.tmp");
	
	var aWidth = $("#target").css("width");
	var aHeight = $("#target").css("height");
	
	function showPreview(coords)
	{
		var rx = 100 / coords.w;
		var ry = 100 / coords.h;

		$('#preview').css({
			width: Math.round(rx * aWidth) + 'px',
			height: Math.round(ry * aHeight) + 'px',
			marginLeft: '-' + Math.round(rx * coords.x) + 'px',
			marginTop: '-' + Math.round(ry * coords.y) + 'px'
		});
		
		$('#x').val(coords.x);
		$('#y').val(coords.y);
		$('#w').val(coords.w);
		$('#h').val(coords.h);
	};
	
	$(function(){
		$('#target').Jcrop({
			onChange: showPreview,
			onSelect: showPreview,
			aspectRatio: 1
		});
	});
};

function saveFile() {
	var x = $('#x').val();
	var y = $('#y').val();
	var w = $('#w').val();
	var h = $('#h').val();
	$.post("saveAvatar", 
			{
				imagex: x,
				imagey: y,
				imagew: w,
				imageh: h,
			},
			fuck);
	
	function fuck() {
		alert("fuck");
	}
	
}

$("#avatarFile").change(uploadTemp);
$("#save").click(saveFile);
