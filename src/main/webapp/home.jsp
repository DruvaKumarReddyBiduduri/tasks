<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="tasks.Task" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href='https://unpkg.com/css.gg@2.0.0/icons/css/trash.css' rel='stylesheet'>
<link href='https://unpkg.com/css.gg@2.0.0/icons/css/pen.css' rel='stylesheet'>
<link href='https://unpkg.com/css.gg@2.0.0/icons/css/check.css' rel='stylesheet'>
<script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="p-2 bg-gray-700 min-h-screen">
  <form action="/task" method="post" class="grid grid-cols-3 gap-4">
    <input class="w-full border-1 outline-none border-black rounded-lg p-2" placeholder="Enter task name" name="name" required/>
    <input class="w-full border-1 outline-none border-black rounded-lg p-2" placeholder="Enter task description"  name="description"/>
    <button class="border-2 border-indigo-500 text-white font-bold rounded-lg hover:bg-indigo-500 p-2" type="submit">create task</button>
  </form>
  <div class="w-full grid grid-cols-1 gap-3 px-12 mt-10">
   	<div>
	  	<h1 class="text-white font-bold mb-2">Active Tasks :</h1>
	    <%ArrayList<Task> activeTasks=(ArrayList<Task>) request.getAttribute("activeTasks");  %>
	    <div class="grid grid-cols-1 gap-5">
	        <%  for(int i=0;i<activeTasks.size();i++){ %>
	    		<div class="flex border-2 p-3 justify-between rounded-lg w-[500px]">
	    		    <div class="flex items-center">
		      		    <form class="mr-2" action="/task/complete" method="post">
		      		    	<input type="hidden" name="tid" value=<%= activeTasks.get(i).id %> />
			   		        <input type="hidden" name="completed" value = <%= !activeTasks.get(i).completed %> />
			   		    	<button type="submit" class="border-2 rounded-full w-5 h-5">
			   		    	</button>
			   		    </form>
			   		    <div>
				   		    <p class="font-bold text-white"><%= activeTasks.get(i).name %> </p>	
				   		     <p class="text-sm text-white"><%= activeTasks.get(i).description %> </p>	
			   		    </div>			   		   
	    		    </div>
	    		    <div class="flex items-center">
   	    		    	
    		      		<a class="mr-4" href=<%="/task/update?tid="+activeTasks.get(i).id%>><i class="gg-pen"></i></a>
    		    		
	    		 	 	<form action="/task/delete" method="post">
	    		 	 		<input type="hidden" name="tid" value=<%= activeTasks.get(i).id %> />
	    		 	   		<button type="submit"><i class="gg-trash "></i></button>
	    		 	 	</form>
	    		    </div>
	    		</div>
	    	<%}%>
	    	</div>
  		</div>
  	<div >
	  <h1 class="text-white font-bold mb-2">Completed Tasks :</h1>
	     <%ArrayList<Task> completedTasks=(ArrayList<Task>) request.getAttribute("completedTasks");  %>
	        <div class="w-[400px] grid grid-cols-1 gap-5">
	        <%  for(int i=0;i<completedTasks.size();i++){ %>
	    		<div class="flex border-2 p-3 justify-between rounded-lg">
	    		    <div class="flex items-center">
		      		    <form class="mr-2" action="/task/complete" method="post">
		      		    	<input type="hidden" name="tid" value=<%= completedTasks.get(i).id %> />
			   		        <input type="hidden" name="completed" value = <%= !completedTasks.get(i).completed %> />
			   		    	<button type="submit" class="flex items-center border-2 rounded-full w-6 h-6"><i class="gg-check"></i></button>
			   		    </form>
		   		    	<p class="font-bold text-gray-400 line-through"><%= completedTasks.get(i).name %> </p>	
			   		   
	    		    </div>
	    		 	 <form action="/task/delete" method="post">
	    		 	 	<input type="hidden" name="tid" value=<%= completedTasks.get(i).id %> />
	    		 	   <button type="submit"><i class="text-color gg-trash "></i></button>
	    		 	 </form>
	    		</div>
	    	<%}%>
	    	</div>
  		</div>
  	</div>
</body>
</html>