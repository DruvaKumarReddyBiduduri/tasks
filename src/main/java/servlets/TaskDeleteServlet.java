package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tasks.TaskService;
import java.io.IOException;


@WebServlet(name="task-delete",value="/task/delete")
public class TaskDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	TaskService taskService;

    public TaskDeleteServlet() {
        super();
        this.taskService=new TaskService();
    }
    
    public void init() {
    	
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("tid"));
		this.taskService.delete(id);
		response.sendRedirect("/home");
	}
	
	public void destroy() {
		this.taskService=null;
		super.destroy();
	}

}
