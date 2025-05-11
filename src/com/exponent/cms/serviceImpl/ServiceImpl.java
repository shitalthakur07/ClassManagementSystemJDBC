package com.exponent.cms.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.exponent.cms.connection.ConnectionDesignpattern;
import com.exponent.cms.service.UserService;

public class ServiceImpl implements UserService {

	@Override
	public void addCourse() {
		Scanner sc = new Scanner(System.in);
		try {
			Connection con = ConnectionDesignpattern.generateConnection();
			String query = "insert into course value(?,?)";
			PreparedStatement pstmt = con.prepareStatement(query);

			System.out.println("Enter course id");
			pstmt.setInt(1, sc.nextInt());
			System.out.println("Enter course name");
			pstmt.setString(2, sc.next());

			pstmt.execute();

			System.out.println("Course added.....");

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	@Override
	public void displayCourse() {
		Scanner sc = new Scanner(System.in);
		try {
			Connection con = ConnectionDesignpattern.generateConnection();
			String query = "select * from course";

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				System.out.println("Courseid: " + rs.getInt(1));
				System.out.println("Course name: " + rs.getString(2));
			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@Override
	public void addFaculty() {
		Scanner sc = new Scanner(System.in);
		try {
			Connection con = ConnectionDesignpattern.generateConnection();
			String query = "insert into faculty value(?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(query);

			System.out.println("Enter faculty id");
			pstmt.setInt(1, sc.nextInt());
			System.out.println("Enter faculty name");
			pstmt.setString(2, sc.next());
			System.out.println("insert course id");
			pstmt.setInt(3, sc.nextInt());

			pstmt.execute();

			System.out.println("faculty added.....");

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	@Override
	public void displayFaculty() {
		Scanner sc = new Scanner(System.in);
		try {
			Connection con = ConnectionDesignpattern.generateConnection();
			String query = "select faculty.fname,course.cname from faculty inner join course on faculty.courseid=course.cid";

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {

				System.out.println("Faculty name: " + rs.getString(1));
				System.out.println("Course name " + rs.getString(2));
			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@Override
	public void addBatch() {
		Scanner sc = new Scanner(System.in);
		try {
			Connection con = ConnectionDesignpattern.generateConnection();
			String query = "insert into batch value(?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(query);

			System.out.println("Enter batch id");
			pstmt.setInt(1, sc.nextInt());
			System.out.println("Enter batch name");
			pstmt.setString(2, sc.next());
			System.out.println("insert faculty id");
			pstmt.setInt(3, sc.nextInt());

			pstmt.execute();

			System.out.println("Batch added.....");

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	@Override
	public void displayBatch() {

		// fac batchfaculty
		Scanner sc = new Scanner(System.in);
		try {
			Connection con = ConnectionDesignpattern.generateConnection();
			String query = "select batch.bname,faculty.fname,course.cname, from faculty inner join faculty on batch.facultyid=faculty.fid inner join course on faculty.courseid=course.cid";
						Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				System.out.println("Batch name: " + rs.getString(1));
				System.out.println("Faculty name: " + rs.getString(2));
				System.out.println("Course name: " + rs.getString(3));
			}

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@Override
	public void addStudent() {
		Scanner sc = new Scanner(System.in);
		try {
			Connection con = ConnectionDesignpattern.generateConnection();
			String query = "insert into student value(?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(query);

			System.out.println("Enter student id");
			pstmt.setInt(1, sc.nextInt());
			System.out.println("Enter student name");
			pstmt.setString(2, sc.next());
			System.out.println("insert batch id");
			pstmt.setInt(3, sc.nextInt());

			pstmt.execute();

			System.out.println("student added.....");

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	@Override
	public void displayStudent() {
		try {
			Connection con = ConnectionDesignpattern.generateConnection();

			String query = "select student.sname,batch.bname,faculty.fname,course.cname from batch inner join faculty on batch.facultyid="
					+ "faculty.fid inner join course on course.cid=faculty.courseid inner join student on student.batchid=batch.bid";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				System.out.println(("Student name: " + rs.getString(1)));
				System.out.println("Batch name: " + rs.getString(2));
				System.out.println("Faculty name: " + rs.getString(3));
				System.out.println("Course name: " + rs.getString(4));

			}

		} catch (Exception e) {
			System.out.println(e);
		}
//fac course student batch
	}

}
