<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src ="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
	$(function(){
		$("#checkJson").click(function(){
			var jsonStr = '{"name":["hong", "lee", "lim"]}';
			var jsonInfo = JSON.parse(jsonStr);
			var output = "회원 이름<br>";
			output += "======<br>";
			
			for (var i in jsonInfo.name){
				output += jsonInfo.name[i] + "<br>";
			}
			$("#output").html(output);
		});
	});
</script>
</head>
<body>
	<a id="checkJson" style="cursor:pointer">출력</a><br><br>
	<div id="output"></div>
</body>
</html>