package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tasks.TaskService;

import java.io.IOException;


@WebServlet(name="task-complete",value = "/task/complete")
public class TaskComplete extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	TaskService taskService;
	
	

    public TaskComplete() {
        super();
    }
    
    @Override
    public void init() throws ServletException {
    	// TODO Auto-generated method stub
    	super.init();
    	this.taskService=new TaskService();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean completed =Boolean.parseBoolean( request.getParameter("completed"));
		int id=Integer.parseInt(request.getParameter("tid"));
		
		this.taskService.update(id, completed);
		response.sendRedirect("/home");
	}
	
	@Override
	public void destroy() {
		this.taskService=null;
		super.destroy();
	}

}
