package util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import tasks.Task;

public class Util {
	public static Cookie getCookie(HttpServletRequest req, String name) {
    	Cookie[] cookies = req.getCookies();
		if(cookies != null) {
			for(Cookie cookie : cookies) {
				if(cookie.getName().equals(name)) {
					return cookie;
				}
			}
		}
		return null;
	}
	
	public static Map<String, List<Task>> filterTasksByComplete(List<Task> tasks){
		List<Task> completedTasks=new ArrayList<Task>();
		List<Task> activeTasks=new ArrayList<Task>();
		
		Map<String, List<Task>> map=new HashMap<>();
		
		for (int i = 0; i < tasks.size(); i++) {
			Task task=tasks.get(i);
			if(task.completed) {
				completedTasks.add(task);
			}else {
				activeTasks.add(task);
			}
		}
		
		map.put("completed", completedTasks);
		map.put("active", activeTasks);
		
		return map;
	}
}
