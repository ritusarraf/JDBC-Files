package com.files.entities;
import java.util.ArrayList;
import java.util.Scanner;

public class Caller
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
//		System.out.println("enter id:");
//		String id=sc.nextLine();
		
		EmployeeDao edao=new EmployeeDao();
//		Employee records = edao.getRecords(id);
//		System.out.println(records);
		
		ArrayList<Employee>record = edao.fetchRecord();
		for(Employee e:record)
		{
			System.out.println(e);
		}
		
	}

}
