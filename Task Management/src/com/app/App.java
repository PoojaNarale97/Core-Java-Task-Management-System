package com.app;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.dao.TaskManagementDAO;
import com.model.TaskManagement;

public class App {
	
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	
	TaskManagementDAO dao=new TaskManagementDAO();
	int op,conti;
	
	do
	{
		System.out.println("1.Add Task");
		System.out.println("2.Delete Task");
		System.out.println("3.Update Task");
		System.out.println("4.Show All Task");
		System.out.println("Plaese Enter Your Choice:");
		op=sc.nextInt();
		
		switch (op) 
		{
		case 1:
			System.out.println("Enter Task Id:");
			int tId=sc.nextInt();
			System.out.println("Enter Task Description");
			sc.nextLine();
			String tDes=sc.nextLine();
			System.out.println("Enter Task Status");
			boolean tStatus=sc.nextBoolean();
			System.out.println("Enter Task DueDate(yyyy-mm-dd)");
			sc.nextLine();
			String date=sc.nextLine();
			
			TaskManagement addTask=new TaskManagement(tId,tDes,tStatus,date);
			
			int inserRecord=dao.insertTask(addTask);
			
			if(inserRecord>0)
			{
				System.out.println("Task Added Successfully");
			}
			else
			{
				System.out.println("Failed to add Task");
			}
			break;
		case 2:
			System.out.println("Enter Task Id:");
			int dtaskId=sc.nextInt();
			
			TaskManagement deleteTask=new TaskManagement();
			deleteTask.setTask_Id(dtaskId);
			int deleteRecord=dao.deleteTask(deleteTask);
			
			if(deleteRecord>0)
			{
				System.out.println("Task Deleted Successfully");
			}
			else
			{
				System.out.println("Failed to Delete Task");
			}
			break;
		case 3:
			System.out.println("Enter Task Id:");
			int uTaskId=sc.nextInt();
			System.out.println("Enter Task Description");
			sc.nextLine();
			String uDes=sc.nextLine();
			System.out.println("Enter Task Status");
			boolean uStatus=sc.nextBoolean();
			System.out.println("Enter Task DueDate(yyyy-mm-dd)");
			sc.nextLine();
			String uDate=sc.nextLine();
			
			TaskManagement updateTask=new TaskManagement(uTaskId,uDes,uStatus,uDate);
			
			int updateRecord=dao.updateTask(updateTask);
			
			if(updateRecord>0)
			{
				System.out.println("Task Updated Successfully");
			}
			else
			{
				System.out.println("Failed to Update Task");
			}
		
			break;
		case 4:
			   List<TaskManagement> list=dao.getAllTask();
			   
			   Iterator<TaskManagement> itr=list.iterator();
			   
			   System.out.println("Task_id  Task_Description  Task_Status   Task-Due-Date");
			   System.out.println("-------------------------------------------------------");
			   
			   while(itr.hasNext())
			   {
				  TaskManagement task=itr.next();
				  System.out.print(""+task.getTask_Id());
				  System.out.print("          "+task.getTaskDescription());
				  System.out.print("              "+task.isTaskSatus());
				  System.out.println("    "+task.getTaskDueDate());
				   
			   }
			   break;
			   
			   
		default:
			break;
		}
		System.out.println("Do You Want to Continue Press 1...");
		conti=sc.nextInt();
	}while(conti==1);
  
  }
	
	

}
