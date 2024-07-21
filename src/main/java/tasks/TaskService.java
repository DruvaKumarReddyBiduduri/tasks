package tasks;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import db.Connector;


public class TaskService implements TaskDAO{
    Connection conn = null;


	public TaskService(){
		this.conn=Connector.getConn();
	}
	
	@Override
	public List<Task> findByUserId(int userId) {
		final String selectByUserId="select * from tasks where user_id=? and completed=false";
		List<Task> tasks=new ArrayList<>();
		try {
            PreparedStatement getUserQuery=conn.prepareStatement(selectByUserId);
            getUserQuery.setInt(1,userId);

            ResultSet rs=getUserQuery.executeQuery();
            while(rs.next()){
               tasks.add(new Task(rs.getInt(1),rs.getInt(4),rs.getString(2),rs.getString(3),rs.getBoolean(5)));
            }
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			return tasks;
		}
		return tasks;
	}

	@Override
	public List<Task> findCompleted(int userId) {
		final String selectByUserId="select * from tasks where user_id=? and completed=true";
		List<Task> tasks=new ArrayList<>();
		try {
            PreparedStatement selectStatement=conn.prepareStatement(selectByUserId);
            selectStatement.setInt(1,userId);

            ResultSet rs=selectStatement.executeQuery();
            while(rs.next()){
               tasks.add(new Task(rs.getInt(1),rs.getInt(4),rs.getString(2),rs.getString(3),rs.getBoolean(5)));
            }
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			return tasks;
		}
		return tasks;
	}

	@Override
	public Task findById(int id) {
		 final String selectByIdQuery="select * from tasks where id=?";
        try {
            PreparedStatement getUserQuery=conn.prepareStatement(selectByIdQuery);
            getUserQuery.setInt(1,id);

            ResultSet rs=getUserQuery.executeQuery();
            if(rs.next()){
                return new Task(rs.getInt(1),rs.getInt(4),rs.getString(2),rs.getString(3),rs.getBoolean(5));
            }else{
                return null;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }

	}

	@Override
	public boolean insert(Task task) {
		final String insert="insert into tasks(name,description,user_id,completed) values(?,?,?,?)";
        try{
        	System.out.println(task.getUserId());
            PreparedStatement insertUserQuery=conn.prepareStatement(insert);
            insertUserQuery.setString(1,task.getName());
            insertUserQuery.setString(2,task.getDescription());
			insertUserQuery.setInt(3,task.getUserId());
			insertUserQuery.setBoolean(4,task.isCompleted());
            insertUserQuery.executeUpdate();
            return true;
        }catch (SQLException e){
            System.out.println(e.getMessage());
            return false;
        }

	}

	@Override
	public void update(int id,String name,String description) {
		final String updateString="update tasks set name=?,description=? where id=?";
		try {
            PreparedStatement updateStatement=conn.prepareStatement(updateString);
            updateStatement.setString(1,name);
            updateStatement.setString(2,description);
            
            updateStatement.setInt(3, id);

            updateStatement.executeUpdate();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void delete(int id) {
		final String deleteByIdQuery="delete from tasks where id=?";
        try {
            PreparedStatement deleteStatement=conn.prepareStatement(deleteByIdQuery);
            deleteStatement.setInt(1,id);

            deleteStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
	}

	@Override
	public void update(int id, boolean completed) {
		final String updateQuery="update tasks set completed=? where id=?";
		try {
			PreparedStatement updateStatement=conn.prepareStatement(updateQuery);
			updateStatement.setBoolean(1, completed);
			updateStatement.setInt(2, id);
			updateStatement.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
