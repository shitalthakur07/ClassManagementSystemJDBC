package com.exponent.cms.controller;

import java.util.Scanner;

import com.exponent.cms.service.UserService;
import com.exponent.cms.serviceImpl.ServiceImpl;

public class AdminController {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		UserService us = new ServiceImpl();
		
		boolean flag = true;
		while (true) {
			System.out.println("================Welcome to CMS===============");
			System.out.println("===============================================");
			System.out.println("1.Add Course ");
			System.out.println("2.Display Course");
			System.out.println("3.Add faculty");
			System.out.println("4.Display Faculty");
			System.out.println("5.Add batch");
			System.out.println("6.Displey Batch");
			System.out.println("7.Add Student");
			System.out.println("8 Display Student");
			System.out.println("9.Exit");
			System.out.println("Enter your choice");
			int ch = sc.nextInt();

			switch (ch) {
			case 1:
				us.addCourse();
				break;
			case 2:
				us.displayCourse();
				break;
			case 3:
				us.addFaculty();
				break;
			case 4:
				us.displayFaculty();
				break;
			case 5:
				us.addBatch();
				break;
			case 6:
				us.displayBatch();
				break;
			case 7:
				us.addStudent();
				break;
			case 8:
				us.displayStudent();
				break;
			case 9:
				System.exit(0);

			}

		}

	}
}
