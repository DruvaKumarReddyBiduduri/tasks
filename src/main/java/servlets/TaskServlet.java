package servlets;

import jakarta.servlet.ServletException;


import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tasks.Task;
import tasks.TaskService;
import util.Util;

import java.io.IOException;


@WebServlet(name="task",value="/task")
public class TaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	TaskService taskService;
	
	public void init() {
		this.taskService=new TaskService();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie cookie = Util.getCookie(request, "uid");
		String name=request.getParameter("name");
		String description=request.getParameter("description");
		Task task=new Task(Integer.parseInt(cookie.getValue()),name,description,false);
		this.taskService.insert(task);
		response.sendRedirect("/home");
	}
	
	public void destroy() {
		this.taskService=null;
		super.destroy();
	}

}
