<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset = "UTF-8" />

	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/datatables/1.10.19/css/jquery.dataTables_themeroller.css">
	
	<link rel="stylesheet" type="text/css" href="<c:url value="/theme/css/mystyle.css" />">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

</head>
<body>


	<div class="header">
		<img alt="logo" class="imgalign" src="<c:url value="/theme/image/keclogo.png" />">
		<h1>Student Management System</h1>

	</div>


	<div class="container-fluid">

	
		<button type="button" id="addButton" data-toggle="modal" data-target="#mymodal"
			class="btn btn-primary btn-lg">Add</button>
		
		
	
		<div id="mymodal" class="modal fade">
			<div class="modal-dialog">
				<div class="modal-content">
					<form id="theform" method="post">
						<div class="modal-header">
							<h4 class="modal-title">Add Employee</h4>
							<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						</div>
						<div class="modal-body">
							<div class="form-group">
								<label>Name</label>
								<input type="text"  id="name" class="form-control" name="name" required />
							</div>
							<div class="form-group">
								<label>Adress</label>
								<input type="text" id="address" class="form-control" required />
							</div>
							<div class="form-group">
								<label>Email</label>
								<input type="email" id="email" class="form-control"  required />
							</div>
							<div class="form-group">
								<label>Contact No</label>
								<input type="text" id="contact" class="form-control" required />
							</div>
						</div>
						<div class="modal-footer">
							<input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
							<input type="button" class="btn btn-success" id="addBtn" onclick="addDataToTable()"
								value="Submit">

						</div>
					</form>


				</div>
			</div>
		</div>


		<!--Modal end-->



		<!--DATA Table-->
		<table id="myTable" class="display" border="1px">
			<thead>
				<tr>
					<th rowspan="2">ID</th>
					<th rowspan="2">Name</th>
					<th rowspan="2">Address</th>
					<th rowspan="2">Email</th>
					<th rowspan="2">Contact no</th>
					<th colspan="2" style="text-align:center">Action</th>

				</tr>

				<tr>
					<th>Edit</th>
					<th>Delete</th>

				</tr>
			</thead>
			<tbody>

			</tbody>

		</table>

		<!--EditForm-->
		<div id="editmodal" class="modal fade">
			<div class="modal-dialog">
				<div class="modal-content">
					<form id="theform">
						<div class="modal-header">
							<h4 class="modal-title">Edit Information</h4>
							<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						</div>
						<div class="modal-body">
						<div class="form-group">
								<label>ID</label>
								<input type="text" id="editID" class="form-control" readonly  >
							</div>
							<div class="form-group">
								<label>Name</label>
								<input type="text" id="editname" class="form-control"  >
							</div>
							<div class="form-group">
								<label>Adress</label>
								<input type="text" id="editaddress" class="form-control"  >
							</div>
							<div class="form-group">
								<label>Email</label>
								<input type="text" id="editemail" class="form-control"  >
							</div>
							<div class="form-group">
								<label>Contact No</label>
								<input type="text" id="editcontactno" class="form-control"  >
							</div>
							<div class="form-group">
								<input type="hidden" id="error" >
							</div>
							
						</div>
						<div class="modal-footer">
							<input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">

							<input type="button" class="btn btn-success" id="update" value="Update" name="Update" />
						</div>
					</form>


				</div>
			</div>

		</div>
	</div>




	<div class="footer">
		<ul class="list-unstyled list-inline text-center">
			<li class="list-inline-item">

				<i class="fa fa-facebook-square" style="font-size:24px"></i>

			</li>
			<li class="list-inline-item">
				<i class="fa fa-linkedin-square" style="font-size:24px"></i>
			</li>
			<li class="list-inline-item">
				<i class="fa fa-twitter-square" style="font-size:24px"></i>
			</li>

		</ul>
		<div class="footer-copyright text-center py-3">© 2019 Copyright:
			<a href="#"> Sapana Shrestha</a>
		</div>
	</div>

</body>
</html>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>


<script type="text/javascript" charset="utf8" src="https://cdnjs.cloudflare.com/ajax/libs/datatables/1.10.19/js/dataTables.dataTables.min.js"></script>

<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.css">
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.js"></script>

<script>

var A_PAGE_CONTEXT_PATH = "${pageContext.request.contextPath}"
	/* For Adding Data */
	function addDataToTable(){
	//alert("inside addButton");
		var studentObj = {
			name : $("#name").val(),
			address :  $("#address").val(),
			email : $("#email").val(),
			contact : $("#contact").val(),
		};
		
		if(studentObj.name=="" || studentObj.address=="" || studentObj.email==""||studentObj.contactno==""){
		       alert("All Fields are required to be filled!!!");
		    }
		else{
		
		$.ajax({
			method : "POST",
			url : A_PAGE_CONTEXT_PATH + '/save',
			data : JSON.stringify(studentObj),
			//dataType : "json",
			contentType : "application/json",
			cache : false,
			success : function(data, textStatus, xhr) {
				if(data=="ok"){
				alert("success");
				}
				else 
					{
					alert(data);
					 $('input[type="text"], textarea').val('');
					    $('input[type="email"], textarea').val('');
					    $('#editmodal').reload();
					}
				 
				
			},
			error:function (data, textStatus, xhr) {
								
				alert(d);
		        alert("status"+textStatus);
		        
		      },
		    
		 	complete : function(response) {
				 $("#myModal").modal('hide'); 
				location.reload();
				SequentialExecutor.executeNext();
			} 
			
		});
	}
}
	$('#myTable').DataTable(
					{
						 destroy: true,
					        scrollY:        200,
					        scrollCollapse: true,
					        scroller:       true,
						
						"ajax" : {
						"url" : A_PAGE_CONTEXT_PATH + '/DataTableStudentList',
							dataSrc : ""
						},

						"columns" : [
								{
									"data" : "id",
									render: function (data, type, row, meta) {
								        return meta.row + meta.settings._iDisplayStart + 1;
								    }
								},
								{
									"data" : "name"
								},
								{
									"data" : "address"
								},
								{
									"data" : "email"
								},
								{
									"data" : "contact"							
								},
								{
					                data: function (param_obj, type, full, meta, oData) {
					                    return '<button type="button" style="color:green"  id="edit' + param_obj.id + '" data-toggle="modal" data-target="#editmodal" onclick="onEdit(this)" >' + '<span class="glyphicon  glyphicon-pencil"/>' + '</button>';
					                }
					            },
					            {
					                data: function (param_obj, type, full, meta, oData) {
					                    return '<button type="button" style="color:red"  id="del' + param_obj.id + '"  onclick="onDelete(this)" >' + '<span class="glyphicon  glyphicon-remove"/>' + '</button>';
					                }
					            } ]
					});
	
	
	function onEdit(ctl) {

	    id = parseInt($(ctl).attr("id").replace("edit", ""));
	    //alert(id);
	    $.ajax({
			method : "GET",
			url : A_PAGE_CONTEXT_PATH + '/editStudent/'+id,
			dataType : "json",
			contentType : "application/json",
			cache : false,
			success : function(response) {
				console.log(response);
				$("#editID").val(response.id);
				$("#editname").val(response.name);
			    $("#editaddress").val(response.address);
			    $("#editemail").val(response.email);
			    $("#editcontactno").val(response.contact);
			}
			
		});
	}

	    
	$("#update").click(function()
			{
		//alert("inside update function");
		
		 var editObj={
		 id : $("#editID").val(),
		 name : $("#editname").val(),
		 address : $("#editaddress").val(),
		 email :  $("#editemail").val(),
		 contact :  $("#editcontactno").val()
		 };
		 
		// alert(editObj.id+" name="+editObj.name);
		 
		 $.ajax({
			 method : "POST",
			 url : A_PAGE_CONTEXT_PATH+'/updateStudent',
			 data : JSON.stringify(editObj),
				dataType : "json",
				contentType : "application/json",
				cache : false,
				success : function(data, textStatus, xhr) {
				 alert("Data updates Successfully");  
					
				},
			 	complete : function(response) {
					 $("#editModal").modal('hide'); 
					location.reload();
					SequentialExecutor.executeNext();
				} 
		 });
			});
	
	function onDelete(clt){
		
		delID=parseInt($(clt).attr("id").replace("del",""));
		//alert(delID);
		var r = confirm("Are you sure?");
		if (r == true){
		$.ajax({
			method : "POST",
			url : A_PAGE_CONTEXT_PATH+'/deleteStudentByID/'+delID,
			dataType: "json",
			contentType : "application/json",
			cache : "false",
			success : function(data, textStatus, xhr){
				alert("Data Deleted successfully");
				location.reload();
			}
			
			
		})
		
	}
	}
	
	
/* /* //if(data==1){
			 alert("Duplicate data" );
			 $('input[type="text"], textarea').val('');
			    $('input[type="email"], textarea').val('');
			    
			 form.reload();
			 }
				else{
					
					alert("Data successfully added to the database");
				} */ 
				



</script>