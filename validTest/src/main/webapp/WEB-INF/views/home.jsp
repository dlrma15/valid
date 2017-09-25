<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
	$(function(){
		$("#validCheck").on("keyup",function(){
			$.ajax({
				url:"/valid/check",
				data:{valid:$("#validCheck").val()},
				dataType:"json",
				type:"POST",
				success:function(result){
					alert(result);
				}
			})
		})
	})
</script>
<body>
	<form action="#">
		<input type="text" id="validCheck">
	</form>
</body>
</html>
