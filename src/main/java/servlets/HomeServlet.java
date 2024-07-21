package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tasks.TaskService;
import util.Util;
import tasks.Task;
import java.io.IOException;
import java.util.List;
import java.util.Map;


@WebServlet(name="home",value="/home")
public class HomeServlet extends HttpServlet {
	TaskService taskService;
	public void init() throws ServletException {
		super.init();
		taskService=new TaskService();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie cookie = Util.getCookie(request, "uid");
		if(cookie!=null) {
			int userId=Integer.parseInt(cookie.getValue());
			
			List<Task> tasks=taskService.findByUserId(userId);
			List<Task> completedTasks=taskService.findCompleted(userId);
			
			request.setAttribute("activeTasks", tasks);
			request.setAttribute("completedTasks", completedTasks);
			request.getRequestDispatcher("/home.jsp").forward(request, response);
		}else {
			response.sendRedirect("/login.jsp");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	public void destroy() {
		this.taskService=null;
		super.destroy();
	}

}
