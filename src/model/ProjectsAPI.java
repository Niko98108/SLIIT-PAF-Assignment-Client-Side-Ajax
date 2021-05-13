package model;
import model.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProjectsAPI
 */
@WebServlet("/ProjectsAPI")
public class ProjectsAPI extends HttpServlet {

       Project projectObject = new Project();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProjectsAPI() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 String output =  projectObject.managerName(request.getParameter("managerName")); 
		 response.getWriter().write(output);
		
			System.out.println("get method output '"+output+"'");  
			System.out.println("get method output '"+ request.getParameter("managerName")+"'");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String output = projectObject.insertProject(request.getParameter("projectName"), 
				request.getParameter("projectDesc"), 
				request.getParameter("projectType"), 
				request.getParameter("managerId"), 
				request.getParameter("startDate"), 
				request.getParameter("endDate")); 
		
				response.getWriter().write(output); 
				System.out.println("post method '"+output+"'");
				System.out.println("post method '"+request.getParameter("projectName")+"'");
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map paras = getParasMap(request); 
		String output= projectObject.updateProject(paras.get("hidProjIDSave").toString(), 
				 paras.get("projectName").toString(), 
				 paras.get("projectDesc").toString(), 
				 paras.get("projectType").toString(), 
				paras.get("managerId").toString(), 
				paras.get("startDate").toString(),
				paras.get("endDate").toString() ); 	
		response.getWriter().write(output); 
		System.out.println("put method '"+output+"'");
		System.out.println("put method '"+paras.get("hidProjIDSave").toString()+"'");
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Map paras = getParasMap(request); 
		 String output =  projectObject.deleteProject(paras.get("projectId").toString()); 
		 response.getWriter().write(output);
			System.out.println("delete method '"+paras.get("projectId").toString()+"'");
			System.out.println("delete method '"+output+"'");
	}
	
	private static Map getParasMap(HttpServletRequest request) 
	{ 
	 Map<String, String> map = new HashMap<String, String>(); 
	try
	 { 
	 Scanner scanner = new Scanner(request.getInputStream(), "UTF-8"); 
	 String queryString = scanner.hasNext() ? 
	 scanner.useDelimiter("\\A").next() : ""; 
	 scanner.close(); 
	 String[] params = queryString.split("&"); 
	 for (String param : params) 
	 { 
	String[] p = param.split("=");
	 map.put(p[0], p[1]); 
	 } 
	 } 
	catch (Exception e) 
	 { 
	 } 
	return map; 
	}	

}
