package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.model.TaskManagement;
import com.utilty.DBUtility;

public class TaskManagementDAO {
	
	public int insertTask(TaskManagement addTask)
	{
		Connection con=DBUtility.getDBConnection();
		String sql="insert into  taskManagement values(?,?,?,?)";
		PreparedStatement ps=null;
		int insertRecord=0;
		try {
			
			ps=con.prepareStatement(sql);
			ps.setInt(1,addTask.getTask_Id());
			ps.setString(2,addTask.getTaskDescription());
			ps.setBoolean(3,addTask.isTaskSatus());
			ps.setDate(4,java.sql.Date.valueOf(addTask.getTaskDueDate()));
			insertRecord=ps.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("Exception in Add task Fuction."+e);
		}
		return insertRecord;
		
	}

	
	public int deleteTask(TaskManagement addTask)
	{
		Connection con=DBUtility.getDBConnection();
		String sql="delete from taskmanagement where Task_id=?";
		PreparedStatement ps=null;
		int deleteRecord=0;
		try {			
			ps=con.prepareStatement(sql);
			ps.setInt(1,addTask.getTask_Id());
			deleteRecord=ps.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("Exception in Add task Fuction."+e);
		}
		return deleteRecord;
		
	}
	public int updateTask(TaskManagement addTask) {
	    Connection con = DBUtility.getDBConnection();
	    String sql = "update taskmanagement set Task_Description=?, Task_Status=?, Task_DueDate=? where Task_id=?";
	    PreparedStatement ps = null;
	    int updateRecord = 0;
	    try {
	        ps = con.prepareStatement(sql);
	        ps.setString(1, addTask.getTaskDescription());
	        ps.setBoolean(2, addTask.isTaskSatus());
	        ps.setDate(3, java.sql.Date.valueOf(addTask.getTaskDueDate()));
	        ps.setInt(4, addTask.getTask_Id());	        
	        updateRecord = ps.executeUpdate();
	        ps.close();
	    } catch (Exception e) {
	        System.out.println("Exception in Update task Function." + e);
	    } 
	    
	    return updateRecord;
	}
	
	
	public List<TaskManagement> getAllTask()
	{
		 Connection con = DBUtility.getDBConnection();
		 String sql = "select * from taskmanagement ";
		 PreparedStatement ps = null;
		 List<TaskManagement> list=new ArrayList<>();
		 
		 try
		 {
			 ps = con.prepareStatement(sql);
			 ResultSet rs=ps.executeQuery();
			 
			 while(rs.next())
			 {
				 TaskManagement task=new TaskManagement();
				 
				 task.setTask_Id(rs.getInt(1));
				 task.setTaskDescription(rs.getString(2));
				 task.setTaskSatus(rs.getBoolean(3));
				 task.setTaskDueDate(rs.getString(4));	
				 list.add(task);
				 
				 
			 }
		 }catch (Exception e)
		  {
				System.out.println("Exception occured in All Task info:");			
		  }
	
		 return list;
		 
	}

	

}
