package com.model;

public class TaskManagement {
	
	private int task_Id;
	private String taskDescription;
	private boolean completed;
	private  String taskDueDate;
	
	
	public TaskManagement() {
		// TODO Auto-generated constructor stub
	}


	public TaskManagement(int task_Id, String taskDescription, boolean taskSatus, String taskDueDate) {
		super();
		this.task_Id = task_Id;
		this.taskDescription = taskDescription;
		this.completed = taskSatus;
		this.taskDueDate = taskDueDate;
	}


	public int getTask_Id() {
		return task_Id;
	}


	public void setTask_Id(int task_Id) {
		this.task_Id = task_Id;
	}


	public String getTaskDescription() {
		return taskDescription;
	}


	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}


	public boolean isTaskSatus() {
		return completed;
	}


	public void setTaskSatus(boolean taskSatus) {
		this.completed = taskSatus;
	}


	public String getTaskDueDate() {
		return taskDueDate;
	}


	public void setTaskDueDate(String taskDueDate) {
		this.taskDueDate = taskDueDate;
	}


	@Override
	public String toString() {
		return "TaskManagement [task_Id=" + task_Id + ", taskDescription=" + taskDescription + ", taskSatus="
				+ completed + ", taskDueDate=" + taskDueDate + "]";
	}
	
     
	
	
	

}
