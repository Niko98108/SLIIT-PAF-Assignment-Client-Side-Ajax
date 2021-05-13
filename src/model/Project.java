package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import org.json.JSONObject;

public class Project {
	

	
	public Connection getconnection() {
		
		Connection con = null;

		 try{
			 Class.forName("com.mysql.jdbc.Driver");
		 con= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/paf_rest_api" ,"root", "");
		 
		 //For testing

		 System.out.print("Successfully connected to Database");
		 }
		 catch(Exception e){
		 e.printStackTrace();
		 }

		 return con;
	}
	public String insertProject(String projectName, String projectDesc,String projectType, String managerId, String startDate,String endDate)
	{
	 String output = "";
	try
	 {
	 Connection con = getconnection();
	 if (con == null)
	 {
	 return "Error while connecting to the database";
	 }
	 // create a prepared statement
	 String query = " INSERT INTO paf_rest_api.project(`project_id`,`projectName`,`projectDesc`,`projectType`,`manager_id`,`startDate`,`endDate`)"
	 + " values (?, ?, ?, ?, ?,?,?)";
	 PreparedStatement preparedStmt = con.prepareStatement(query);
	 // binding values
	 preparedStmt.setInt(1, 0);
	 preparedStmt.setString(2, projectName);
	 preparedStmt.setString(3, projectDesc);
	 preparedStmt.setString(4, projectType);
	 preparedStmt.setString(5,managerId);// preparedStmt.setDouble(4, Double.parseDouble(price));
	 preparedStmt.setString(6, startDate); 
	 preparedStmt.setString(7, endDate); 

	System.out.println("in Model '"+projectName+"' ");
	//execute the statement
	 preparedStmt.execute();
	 con.close();
	 String newProject = readProject();
	 output =  "{\"status\":\"success\", \"data\": \"" + 
			 newProject + "\"}"; 

	 }
	catch (Exception e)
	 {
		output = "{\"status\":\"error\", \"data\": \"Error..! While Inserting the Project.\"}";
	 System.err.println(e.getMessage());
	 e.printStackTrace();
	 }
	return output;
	}
	
	//update Project data function
	public String updateProject(String projectId,String projectName, String projectDesc,String projectType, String managerId, String startDate,String endDate)
	{
	 String output = "";
	try
	 {
	 Connection con = getconnection();
	 if (con == null)
	 {
	 return "Error while connecting to the database";
	 }
	 // create a prepared statement
	 String query = "UPDATE project SET  projectName=?,  projectDesc=?, projectType=?, manager_id=?, startDate=? ,endDate=? WHERE project_id='"+projectId+"' ";
	 PreparedStatement preparedStmt = con.prepareStatement(query);
	 // binding values
	 
	 preparedStmt.setString(1, projectName);
	 preparedStmt.setString(2, projectDesc);
	 preparedStmt.setString(3, projectType);
	 preparedStmt.setInt(4, Integer.parseInt(managerId));
	 preparedStmt.setString(5, startDate);
	 preparedStmt.setString(6, endDate); 
	
	 
	//execute the statement
	 preparedStmt.execute();
	 con.close();
	 String newProject = readProject();
	 output =  "{\"status\":\"success\", \"data\": \"" + 
			 newProject + "\"}" ; 

	 }
	catch (Exception e)
	 {
		output = "{\"status\":\"error\", \"data\": \"Error..! While Updating the Project.\"}";
//	 System.err.println(e.getMessage());
	 e.printStackTrace();
	 }
	return output;
	}
	
	//Delete project data
	public String deleteProject(String projectId)
	{
	 String output = "";
	try
	 {
	 Connection con = getconnection();
	 if (con == null)
	 {
	 return "Error while connecting to the database";
	 }
	//create a prepared statement
	 String query = "DELETE FROM project WHERE project_id=?" ;
	 
	 PreparedStatement preparedStatement = con.prepareStatement(query);
	 
	 //binding Values
	 preparedStatement.setInt(1, Integer.parseInt(projectId));
	 
	 //execute the statement
	 
	 preparedStatement.execute();
	 
	 con.close();
	 String newProject = readProject();
	 output =  "{\"status\":\"success\", \"data\": \"" + 
			 newProject + "\"}" ; 
	 }
	catch (Exception e){
		output = "{\"status\":\"error\", \"data\": \"Error while deleting the Project.\"}";
	 System.err.println(e.getMessage());
	 e.printStackTrace();
	 }
	return output;
	}
	
	//Read Project Data
	public String readProject()
	{
	 String output = "";
	try
	 {
	 Connection con = getconnection();
	 if (con == null)
	 {
	 return "Error while connecting to the Database.";
	 }
	 // Prepare the HTML table to be displayed
	 output = "<table class='table table-bordered'>"
		 		+ "  <thead>"
		 		+ "    <tr>"
		 		+ "      <th scope='col'>Project ID</th>"
		 		+ "      <th scope='col'>Project Name</th>"
		 		+ "      <th scope='col'>Project Description</th>"
		 		+ "      <th scope='col'>Project Type</th>"
		 		+ "      <th scope='col'>Manager ID</th>"
		 		+ "      <th scope='col'>Manager Name</th>"
		 		+ "      <th scope='col'>Start Data</th>"
		 		+ "      <th scope='col'>End Data</th>"
		 		+ "      <th scope='col' colspan='2'>Upadate/Delete</th>"
		 		+ "    </tr>"
		 		+ "  </thead>"
		 		+ "</table";
	 

//	 output = "<table class='table table-bordered'>"
//		 		+ "  <thead class= 'thead-dark'>''
//		 		+ "    <tr>"
//		 		+ "      <th scope="col\">Project ID</th>"
//		 		+ "      <th scope="col">Project Name</th>"
//		 		+ "      <th scope=\"col\">Project Description</th>\r\n"
//		 		+ "      <th scope=\"col\">Project Type</th>\r\n"
//		 		+ "      <th scope=\"col\">Manager ID</th>\r\n"
//		 		+ "      <th scope=\"col\">Manager Name</th>\r\n"
//		 		+ "      <th scope=\"col\">Start Data</th>\r\n"
//		 		+ "      <th scope=\"col\">End Data</th>\r\n"
//		 		+ "      <th scope=\"col\" colspan=\"2\">Upadate/Delete</th>\r\n"
//		 		+ "    </tr>\r\n"
//		 		+ "  </thead>\r\n"
//		 		+ "</table";
	 
	 
	 String query = "SELECT *, projectmanager.managerName FROM project,projectmanager WHERE project.manager_id = projectmanager.manager_id";
	 
	 Statement stmt = con.createStatement();
	 ResultSet rs = stmt.executeQuery(query);
	 
	 // iterate through the rows in the result set
	 while (rs.next())
	 {
	 String projectId = Integer.toString(rs.getInt("project_id"));
	 String projectName = rs.getString("projectName");
	 String projectDesc = rs.getString("projectDesc");
	 String projectType = rs.getString("projectType") ;
	 String managerId = rs.getString("manager_id");
	 String startDate = rs.getString("startDate");
	 String endDate = rs.getString("endDate");
	 String managerName = rs.getString("managerName");
	 
	 // Add a row into the HTML table
	 output += "<tr><td><input id='hidprojiDUpdate' name='hidprojiDUpdate' type='hidden'  value='" + projectId + "'>"
	 		  + projectId + "</td>";
	output += "<td>" + projectName + "</td>";
	output += "<td>" + projectDesc + "</td>"; 
	output += "<td>" + projectType + "</td>";
	output += "<td>" + managerId + "</td>";
	output += "<td>" + managerName + "</td>";
	output += "<td>" + startDate + "</td>";
	output += "<td>" + endDate + "</td>";
	
	// buttons
	 output += "<td>"
			 + "<input name='btnUpdate'  type='button' class='btnUpdate btn btn-outline-dark' data-projectid='"+projectId+"' value='Update'> </td>"
			 + "<td><input name='btnRemove' type='button' class='btnRemove btn btn-outline-danger' data-projectid='"+projectId+"' value='Remove'></td></tr>";
	 }
	 con.close();
	 // Complete the HTML table
	 output += "</table>";
	 }
	catch (Exception e)
	 {
	 output = "Error while reading the Project.";
	 System.err.println(e.getMessage());
	 e.printStackTrace();
	 }
	return output;
	}
	
	
	
	public String projectSearch(int id)
	{
	 String output = "";
	try
	 {
	 Connection con = getconnection();
	 if (con == null)
	 {
	 return "Error while connecting to the Database.";
	 }

	 
	 String query = "SELECT * FROM project WHERE project_id= '"+id+"'";
	 
	 Statement stmt = con.createStatement();
	 ResultSet rs = stmt.executeQuery(query);
	 
	 // iterate through the rows in the result set
	 while (rs.next())
	 {
	 String projectId = Integer.toString(rs.getInt("project_id"));
	 String projectName = rs.getString("projectName");
	 String projectDesc = rs.getString("projectDesc");
	 String projectType = rs.getString("projectType") ;
	 String managerId = rs.getString("manager_id");
	 String startDate = rs.getString("startDate");
	 String endDate = rs.getString("endDate");
	 
	 JSONObject obj = new JSONObject();

     obj.put("projectId", projectId);
     obj.put("projectName",projectName );
     obj.put("projectDesc",projectDesc );
     obj.put("projectType",projectType );
     obj.put("managerId",managerId );
     obj.put("startDate",startDate);
     obj.put("endDate", endDate);
	 
	 output = " '"+obj+"' ";

	 }
	 con.close();

	 }
	catch (Exception e)
	 {
	 output = "Error while reading the Project.";
	 System.err.println(e.getMessage());
	 e.printStackTrace();
	 }
	return output;
	}

public String managerName(String id) { 
	 String output = "";
	try
	 {
	 Connection con = getconnection();
	 if (con == null)
	 {
	 return "Error while connecting to the Database.";
	 }

	 
	 String query = "SELECT projectmanager.managerName FROM `projectmanager` WHERE manager_id= '"+id+"'";
	 System.out.println(id);
	 

	 Statement stmt = con.createStatement();
	 ResultSet rs = stmt.executeQuery(query);
	
	// iterate through the rows in the result set
		 while (rs.next())
		 {
			 output = rs.getString("managerName");
		 }
	     System.out.println(output);
		 output =  "{\"status\":\"success\", \"data\": \"" +output+ "\"}" ;
	 }
	catch (Exception e)
	 {
		 output =  "{\"status\":\"error\", \"data\": \" error \"}" ;
	 System.err.println(e.getMessage());
	 e.printStackTrace();
	 }
	return output;
}
	}


	




