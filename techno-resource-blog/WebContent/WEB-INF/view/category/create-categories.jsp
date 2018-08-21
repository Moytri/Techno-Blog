<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<title>Create Categories</title>
	<link type = "text/css" rel = "stylesheet"
		  href = "${pageContext.request.contextPath}/resources/css/add-category-style.css" />
		  	
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">	  
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>	

	
</head>
<body>
	<div id = "container">		
		<div>
			<h3>Save Category</h3>
		</div>
		<div class="row">	
			<div class="col-md-2">
			</div>
			<div class="col-md-8">
				<form:form action="saveCategory" modelAttribute="category" method="POST">
					<fieldset>
						<legend>
							<button type="button" class="btn btn-default btn-xs" id="addCategory">
    							<span class="glyphicon glyphicon-plus"></span>
  		  					</button>
						</legend>
						<div class="row">
							<div class="col-md-2">
							</div>
							<div class="col-md-8">
								<table id="catTable" class="table table-striped">
									<thead>
										<tr>
											<th><label> Category Code: </label></th>
											<th><label> Category Name: </label></th>
											<th><label> Action: </label></th>
										</tr>
									</thead>
									<tbody>
					
									</tbody>
								</table>
							</div>
							<div class="col-md-2">
							</div>
						</div>		
					</fieldset>	
					<br><br>
					<button type="submit" name="save" value="Save" class="btn btn-primary" style="position:absolute; right:0; bottom:0;">Save</button>			
				</form:form> 
			</div>
			<div class="col-md-2">
			</div>	
		</div>	
	</div>
	
	<!-- start modal creation code -->
	
	<div class="modal" id="catModal" role="dialog" aria-labelledby="modal" aria-hidden="true" style="display: none;">
		<div class="wrap-content">
			<div class="modal-dialog modal-lg" style="background-color: #00ff00;">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" id="btnModalclose">
							<span class="glyphicon glyphicon-remove"></span>
						</button>
						<h4 class="modal-title">Create Category</h4>
					</div>
					<div class="modal-body">
						<input id="modal_id" name="modal_id" placeholder="Id" value="0" type="hidden" value="0"/>
                        <div class="form-group">
                            <label for="category_code">Category Code:</label>
                            <input id="modal_category_code" name="modal_category_code" placeholder="category code" class="form-control" type="text" value=""/>
                        </div>
                        <div class="form-group">
                            <label for="category_name">Category Name:</label>
                            <input id="modal_category_name" name="modal_category_name" placeholder="category name" class="form-control" type="text" value=""/>
                        </div>
						<div class="row">
							<div class="col-md-10"></div>
							<div class="col-md-2">
								<button type="button" class="btn btn-primary" id="createCategory">
	    							<span class="glyphicon glyphicon-ok"></span>
	  		  					</button>
	  		  					<button type="button" class="btn btn-primary" id="closeCategory">
	    							<span class="glyphicon glyphicon-remove"></span>
	  		  					</button>
							</div>
						</div>
					</div>
				</div>
		  </div>
		</div>
	</div>
	
	<!-- end of modal -->
	
</body>
<script type="text/javascript">

/*   <!-- List of categories from the table  -->  */
	var categories = ${categoriesJson};

/*   <!-- reset modal text and hidden input for each open click -->  */
	function ResetInputs(selector){
		$(selector).find("input[type='text']").val("");
		$(selector).find("input[type='hidden']").val("");
	}


  /*   <!-- open model when button is clicked -->  */
	$("#addCategory").on("click", function() {
		$("#catModal").modal();
		ResetInputs("#catModal");
	});
	
	/*  <!-- create dynamic table with modal value  -->  */
	$("#createCategory").on("click", function() {
		
		if ($(".current-row").length == 0) {
			$("#catTable tbody").append('<tr class="current-row"></tr>');
		}	
		
		var id = $("#modal_id").val();
		var code = $("#modal_category_code").val(); 
		var name = $("#modal_category_name").val();
		
		var html = ""+
					'<td class="code">'+ code + '</td>'+ 
					'<td class="name">'+ name + '</td>'+
					'<td class="width-80">' + 
						'<button type="button" class="btn-xs"> <span class="glyphicon glyphicon-edit"></span></button>' +
						'<button type="button" onclick="delRow(this);" class="btn-xs"><span class="glyphicon glyphicon-trash"></span></button>' +
						'<input name="id[]" type="hidden" class="category-id" value="' + id  + '"/>' +
						'<input name="category_code[]" type="hidden" class="category-code" value="' + code  + '"/>' + 
						'<input name="category_name[]" type="hidden" class="category-name" value="' + name  + '"/>' +
					'</td>';
		
		$("#catTable tbody .current-row").html(html);
		$("tr").removeClass("current-row");				
		$("#catModal").modal("hide");
	});
	
	/* close button action */
	$("#btnModalclose, #closeCategory").on("click", function(){
		$("#catModal").modal("hide");
	});
	
	/*   <!-- load all the already stored categories  -->  */
	loadCategories();
	function loadCategories() {
		
		var html = "";
		
		for(var i = 0; i < categories.length; i++) { 
			var id = categories[i].id;
			var code = categories[i].categoryCode;
			var name = categories[i].categoryName;
			
			html += "" +
				'<tr>' + 
					'<td class="code">'+ code + '</td>'+ 
					'<td class="name">'+ name + '</td>'+
					'<td class="width-80">' + 
						'<button type="button" class="btn-xs"> <span class="glyphicon glyphicon-edit"></span></button>' +
						'<button type="button" onclick="delRow(this);" class="btn-xs"><span class="glyphicon glyphicon-trash"></span></button>' +
						'<input name="id[]" type="hidden" class="category-id" value="' + id  + '"/>' +
						'<input name="category_code[]" type="hidden" class="category-code" value="' + code  + '"/>' + 
						'<input name="category_name[]" type="hidden" class="category-name" value="' + name  + '"/>' +
					'</td>'+
				'</tr>';	

			$("#catTable tbody").html(html);			
			$("#catModal").modal("hide");
		}
	}

</script>
</html>
