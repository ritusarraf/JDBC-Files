package com.files.entities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class EmployeeDao
{
	Connection con;
	Statement st;
	ResultSet rs;
	
	public EmployeeDao()
	{
		//connect to driver class
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("driver found");
			
			//create connection
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/abc","root","1234");
			System.out.println("connection created");
		} 
		catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Employee getRecords(String eid)
	{
		Employee emp=null; 
		try {
			st=con.createStatement();
			rs=st.executeQuery("select * from employee where id='"+eid+"'");
			
			if(rs.next())
			{
				emp=new Employee();
				emp.setId(rs.getString(1));
				emp.setName(rs.getString(2));
				emp.setPassword(rs.getString(3));
				emp.setAge(rs.getInt(4));
				emp.setPhone(rs.getLong(5));
				emp.setCity(rs.getString(6));
				emp.setSalary(rs.getFloat(7));
			}
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		System.out.println(emp);
		return emp;
	}
	
	public ArrayList<Employee> fetchRecord()
	{
		ArrayList<Employee> elist=new ArrayList<>();
		
		try {
			st=con.createStatement();
			rs=st.executeQuery("select * from employee");
			
			while(rs.next())
			{
				Employee emp=new Employee();
				emp.setId(rs.getString(1));
				emp.setName(rs.getString(2));
				emp.setPassword(rs.getString(3));
				emp.setAge(rs.getInt(4));
				emp.setPhone(rs.getLong(5));
				emp.setCity(rs.getString(6));
				emp.setSalary(rs.getFloat(7));
				elist.add(emp);
			}
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return elist;
		
	}
}
