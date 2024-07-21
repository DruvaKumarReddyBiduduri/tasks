package tasks;

import java.io.Serializable;
import java.sql.Date;

public class Task implements Serializable{
	public int id,userId;
	public String name,description;
	public boolean completed;
	
	

	public Task(int userId, String name, String description, boolean completed) {
		this.userId = userId;
		this.name = name;
		this.description = description;
		this.completed = completed;
	}



	public Task(int id, int userId, String name, String description, boolean completed) {
		this.id = id;
		this.userId = userId;
		this.name = name;
		this.description = description;
		this.completed = completed;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public int getUserId() {
		return userId;
	}



	public void setUserId(int userId) {
		this.userId = userId;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public boolean isCompleted() {
		return completed;
	}



	public void setCompleted(boolean completed) {
		this.completed = completed;
	}



	@Override
	public String toString() {
		return "Task [id=" + id + ", userId=" + userId + ", name=" + name + ", description=" + description
				+ ", completed=" + completed + "]";
	}
	
	
}
