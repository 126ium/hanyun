function submitChange() {
	if ($("#passwdNew").val() != $("#passwdConfirm").val()) {
		$("#errMsg").text("Passwords do NOT match!");
		$("#alertDiv").attr("style", "display: block;");
		return false;
	}
	
	var oldPasswd = $("#passwdOld").val();
	var newPasswd = $("#passwdNew").val();
	
	$.post("userSetPsswd", 
			{
				oldPassword: oldPasswd,
				newPassword: newPasswd
			},
			displayErr,
			"json"
	);

	function displayErr(data) {
		if (data.msg != null) {
			$("#errMsg").text(data.msg);
			$("#alertDiv").attr("style", "display: block;");
		} else {
			$("#alertDiv").attr("style", "display: none;");
			$("#successDiv").attr("style", "display: block;");
			$("#successMsg").text("Password set successful");
		}
	};
}

$("#setSave").click(submitChange);