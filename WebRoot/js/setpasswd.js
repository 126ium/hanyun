function submitChange() {
	if ($("#passwdNew").val() != $("#passwdConfirm").val()) {
		$("#errMsg").text("Passwords do NOT match!");
		$("#alertDiv").attr("style", "display: block;");
		return false;
	}
	
	var oldPasswd = $("#passwdOld").val();
	var newPasswd = $("#passwdNew").val();
	
	$.post("setpassword.action", 
			{
				oldPassword: oldPasswd,
				newPassword: newPasswd
			},
			displayErr,
			"json"
	);

	function displayErr(data) {
		if (data != null) {
			$("#errMsg").text(data);
			$("#alertDiv").attr("style", "display: block;");
		} else {
			$("#alertDiv").attr("style", "display: none;");
			$("#successDiv").attr("style", "display: block;");
			$("#successMsg").text("Password set successful");
		}
	};
}

$("#setSave").click(submitChange);