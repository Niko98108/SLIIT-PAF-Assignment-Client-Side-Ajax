
$(document).ready(function(){ 

if ($("#alertSuccess").text().trim() == "" ) { 
 $("#alertSuccess").hide(); 
 } 
 $("#alertError").hide(); 
}); 





// SAVE
$(document).on("click", "#btnSave", function(event) { 
// Clear alerts---------------------
 $("#alertSuccess").text(""); 
 $("#alertSuccess").hide(); 
 $("#alertError").text(""); 
 $("#alertError").hide(); 
// Form validation
var status = validateItemForm();
 console.log(status); 
if (status != true) 
 { 
 $("#alertError").text(status); 
 $("#alertError").show(); 
 return; 
 } 
// If valid

var type = ($("#hidProjIDSave").val() == "") ? "POST" : "PUT";
		 console.log(type);
		 console.log($("#formProject").serialize());
		 $.ajax( 
		 { 
		 url : "ProjectsAPI", 
		 type : type, 
		 data : $("#formProject").serialize(), 
		 dataType : "text", 
		 complete : function(response, status) 
		 { 
		 onItemSaveComplete(response.responseText, status); 
		 } 
 	});
}); 
// UPDATE
$(document).on("click", ".btnUpdate", function(event) 
{ 
 $("#hidProjIDSave").val($(this).closest("tr").find('#hidprojiDUpdate').val()); 
 $("#projectName").val($(this).closest("tr").find('td:eq(1)').text()); 
 $("#projectDesc").val($(this).closest("tr").find('td:eq(2)').text());
 $("#projectType").val($(this).closest("tr").find('td:eq(3)').text());
 $("#managerId").val($(this).closest("tr").find('td:eq(4)').text()); 
 $("#managerName").val($(this).closest("tr").find('td:eq(5)').text());
 $("#startDate").val($(this).closest("tr").find('td:eq(6)').text());  
 $("#endDate").val($(this).closest("tr").find('td:eq(7)').text()); 
}); 
// DELETE
	$(document).on("click", ".btnRemove", function(event)
	{ 
	 $.ajax( 
	 { 
	 url : "ProjectsAPI", 
	 type : "DELETE", 
	 data : "projectId=" + $(this).data("projectid"),
	 dataType : "text", 
	 complete : function(response, status) 
	 { 
	 onItemDeleteComplete(response.responseText, status); 
	 } 
	 }); 
});
// CLIENT-MODE
function validateItemForm() 
{ 
// CODE
if ($("#projectName").val().trim() == "") 
 { 
 return "Project Name Required!"; 
 } 
// NAME
if ($("#projectDesc").val().trim() == "") 
 { 
 return "Project Description Required!"; 
 }
//PRICE-------------------------------
if ($("#projectType").val().trim() == "") 
 { 
 return "Project Type Required!"; 
 } 
if ($("#managerId").val().trim() == "") 
 { 
 return "Manager ID Required!"; 
 } 
if ($("#startDate").val().trim() == "") 
 { 
 return "Start Date Required!"; 
 } 
if ($("#endDate").val().trim() == "") 
 { 
 return "End Date Required!"; 
 } 

return true; 
}
function onItemSaveComplete(response, status)
	{ 
	if (status == "success") 
	 { 
	 var resultSet = JSON.parse(response); 
	 console.log(resultSet);
	 if (resultSet.status.trim() == "success") 
	 { 
	 $("#alertSuccess").text("Successfully saved In Project Table."); 
	 $("#alertSuccess").show();
	 $("#divProjectGrid").html(resultSet.data); 
	 } else if (resultSet.status.trim() == "error") 
	 { 
	 $("#alertError").text(resultSet.data); 
	 $("#alertError").show(); 
	 } 
	 } else if (status == "error") 
	 { 
	 $("#alertError").text("Error..! While Saving."); 
	 $("#alertError").show(); 
	 } else
	 { 
	 $("#alertError").text("Unknown error while saving.."); 
	 $("#alertError").show(); 
	 } 
	 $("#hidProjIDSave").val(""); 
	 $("#formProject")[0].reset(); 
}
function onItemDeleteComplete(response, status) 
	{ 
	if (status == "success") 
	 { 
	 var resultSet = JSON.parse(response); 
	 console.log(resultSet);
	 if (resultSet.status.trim() == "success") 
	 { 
	 $("#alertSuccess").text("Successfully deleted."); 
	 $("#alertSuccess").show();
	 $("#divProjectGrid").html(resultSet.data); 
	 } else if (resultSet.status.trim() == "error") 
	 { 
	 $("#alertError").text(resultSet.data); 
	 $("#alertError").show(); 
	 } 
	 } else if (status == "error") 
	 { 
	 $("#alertError").text("Error while deleting."); 
	 $("#alertError").show(); 
	 } else
	 { 
	 $("#alertError").text("Unknown error while deleting.."); 
	 $("#alertError").show(); 
 } 
}

$(document).ready(function(){
    $("#managerId").on("change",function(){
	managerid=$("#managerId").val()
        console.log(managerid);
		 $.ajax( 
		 { 
		 url : "ProjectsAPI", 
		 type : "GET", 
		 data : "managerName=" + managerid, 
		 dataType : "text", 
		 complete : function(response, status) 
		 { 
		 onNameComplete(response.responseText, status); 
		 } 
	});
})});
function onNameComplete(response, status) 
	{ 
	if (status == "success") 
	 { 
	 var resultSet = JSON.parse(response); 
	 console.log(resultSet);
	 if (resultSet.status.trim() == "success") 
	 { 
	
	 $("#managerName").val(resultSet.data); 
	 } else if (resultSet.status.trim() == "error") 
	 { 
	 console.log("error.."); 
	 } else
	 { 
	 console.log("Unknown error while deleting..");
	 }
 } 
}



