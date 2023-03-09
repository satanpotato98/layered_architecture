package com.manipal.main;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import com.manipal.entity.*;
import com.manipal.service.*;

public class user {
public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);

	IStudentService service = new StudentService();

	boolean flag = true;

	while (flag) {

		System.out.println("1. Add Employee");
		System.out.println("2. Get All Employees");
		System.out.println("3. delete student with id");
		System.out.println("4. update student with id");
		System.out.println("5. Exit/Logout");
		int choice = scanner.nextInt();

		int count = 0;
		int id;
		String name, dept;
		Date doj;
		switch (choice) {
		case 1:
			// accept inputs from end-users

			System.out.println("Enter id");

			id = scanner.nextInt();

			System.out.println("Enter Name");

			name = scanner.next();

			System.out.println("Enter dept");

			dept =scanner.next();
			
			doj=new Date(System.currentTimeMillis());

			student s= new student(id,name,dept,doj);

			count = service.addStudent(s);

			System.out.println(count + " record inserted..");

			break;
		case 2:
			System.out.println("------------------------------------");
			List<student> list = service.getStudents();

			Stream<student> stream1 =	list.stream();
			
			stream1.forEach((student)->{System.out.println(student);});
			System.out.println("------------------------------------");

			break;

		case 3:
			System.out.println("enter id of studetn to be deleted : ");
			int x=scanner.nextInt();
			count = service.delStudent(x);
			System.out.println(count + " record deleted..");
			break;
			
		case 4:
			System.out.println("enter id of student to be updated");
			int y=scanner.nextInt();
			System.out.println("enter new details of student ");
			System.out.println("Enter id");

			id = scanner.nextInt();

			System.out.println("Enter Name");

			name = scanner.next();

			System.out.println("Enter dept");

			dept =scanner.next();
			
			doj=new Date(System.currentTimeMillis());
			student s1= new student(id,name,dept,doj);
			
			count=service.updateStudent(y, s1);
			System.out.println(count + " record updated..");
			
			break;
		case 5:
			flag = false;
			
			System.out.print("Thank YOU");
			
			break;
		default:
			System.err.print("Invalid input");

			break;

		}

	}
}
}
