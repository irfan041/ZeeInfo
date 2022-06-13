<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
	$(document).ready(function() {
		alert("how are you");
		$("#btnGData").click(function() {
			getData();
		});

	});
	/* function get(){
	 alert("how are you");
	 $.ajax({
		 type: 'POST',
		 url: "/userListJSON",
		 success:function(data,textStatus, jqXHR){
			 
		 }
	 })
	} */
	function getData() {
		alert("Hii Get Data");
		$.ajax({
			type :'POST',
			data:
			url : "userListJSON",
			success : function(data, textStatus, jqXHR) {
				alert("Hii inside Function");
				var grid = '';
				$.each(data, function(i, items) {

					grid += '<tr>';
					grid += '<td>' + (i + 1) + '</td>';
					grid += '<td>' + items.studentId + '</td>';
					grid += '<td>' + items.name + '</td>';
					grid += '<td>' + items.mail + '</td>';
					grid += '<td>' + items.password + '</td>';
					grid += '<td>' + items.mob + '</td>';
					grid +='<td> <button onclick="dataDelete('+items.studentId+');">Delete</button></td>';
					grid += '</tr>';
				});
				$("#gData").html(grid);
			},
			error : function(jqXHR, textStatus, errorThrown) {
				alert("Error" + jqXHR);
			}
		});
		//alert("Hii hello");
	}
	function dataDelete(studentId){
	alert(studentId) ; 
	$.ajax({
		type:'POST',
		url:'DeleteUserJson',
		data:{
			studentId:studentId
			},
			success:function(data,textStatus, jqXHR){
                if(data==true)
                {
                    window.location.reload();
                }
                else{
                	window.location.reload();
                }
            }
	});
	    
	} 
</script>
</script>
</head>
<body>
	<table border="1" width="50%">
		<thead>
			<tr>
				<td>Serial No</td>
				<td>Student Id</td>
				<td>Name</td>
				<td>Mail</td>
				<td>password</td>
				<td>Mobile no</td>
				<td>Action</td>
			</tr>
		</thead>
		<tbody id="gData">

		</tbody>

	</table>
	<button id="btnGData">Get Data</button>
</body>
</html>