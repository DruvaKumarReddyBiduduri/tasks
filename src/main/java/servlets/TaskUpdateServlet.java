package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tasks.Task;
import tasks.TaskService;
import java.io.IOException;


@WebServlet(name="task-update",value="/task/update")
public class TaskUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TaskService taskService;

    public TaskUpdateServlet() {
        super();
    }

	public void init() throws ServletException {
		super.init();
		taskService=new TaskService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("tid"));
		Task task=this.taskService.findById(id);
		request.setAttribute("task", task);
		request.getRequestDispatcher("/edit-task.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String description=request.getParameter("description");
		int id=Integer.parseInt(request.getParameter("tid"));
		this.taskService.update(id,name,description);
		response.sendRedirect("/home");
	}
	
	public void destroy() {
		this.taskService=null;
		super.destroy();
	}

}
