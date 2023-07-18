
	 	function myPhone()
		{
			var a=document.getElementById("phone").value;
			if(isNaN(a))
			{
				document.getElementById("message").innerHTML="Please Enter Only Number";
				return false;
			}
			if(a.length<=11)
			{
				document.getElementById("message").innerHTML="Must Enter 10 Digit";
				return false;
			}
			if(a.length<=11)
			{
				document.getElementById("message").innerHTML="Mobile Number Must Enter 10 Digit ";
				return false;
			}
		}
		function password()
		{
			var p=document.getElementById("password").value;
			var chars = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
			var pLength = 12;
			for (var i = 0; i <= pLength; i++){
			if(chars=="")
			{
				document.getElementById("pass").innerHTML="Specal Character are not allowed";
				return false;
			}
			}
			
		}
		function firstName()
		{
			var fname=document.getElementById("firstname").value
			var char="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
			if(char=="")
			{
				ocument.getElementById("fname").innerHTML="Specal Character are not allowed";
				return false;
			}
		}
		function lastName()
		{
			var fname=document.getElementById("lasttname").value
			var char1="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
			if(char1=="")
			{
				ocument.getElementById("lasname").innerHTML="Specal Character are not allowed";
				return false;
			}
		}
		
	function sweetalert()
	{
		var status=document.getElementById("status").value;
		if(status=="Success")
		{
			swal("Congrats","Account is Created in Audilytics","Success");
		}
	}