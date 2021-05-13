<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
	$(function(){
		$("#checkJson").click(function(){
			var jsonStr = '{"age":[22, 33, 44]}';
			var jsonInfo = JSON.parse(jsonStr);
			var output = "memeber age<br>";
			output += "=======<br>";
			
			for(var i in jsonInfo.age){
				output += jsonInfo.get[i]+"<br>";
			}
			$("#output").html(output);
		});
	});
</script>
</head>
<body>
	<a id="checkJson" style="cursor:pointer">out</a><br><br>
	<div id="output"></div>
</body>
</html>