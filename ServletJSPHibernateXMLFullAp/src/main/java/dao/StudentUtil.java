package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import databaseUtil.HibernateUtil;

import databaseUtil.MySQLUtil;
import model.Student;

public class StudentUtil {
	Student s = new Student();
	Transaction transaction = null;
	/*
	 * public StudentUtil() { Student s = new Student(); s.setId(1);
	 * s.setName("Name1"); s.setAddress("Address1"); studentList.add(s); Student s1
	 * = new Student(); s1.setId(2); s1.setName("Name2"); s1.setAddress("Address2");
	 * studentList.add(s1); Student s2 = new Student(); s2.setId(3);
	 * s2.setName("Name3"); s2.setAddress("Address3"); studentList.add(s2); Student
	 * s3 = new Student(); s3.setId(4); s3.setName("Name4");
	 * s3.setAddress("Address4"); studentList.add(s3); Student s4 = new Student();
	 * s4.setId(5); s4.setName("Name5"); s4.setAddress("Address5");
	 * studentList.add(s4); }
	 * 
	 * public List<Student> getStudentList() {
	 * 
	 * return this.studentList; }
	 * 
	 * public Student getStudent(int id) { Student s = new Student(); s.setId(id);
	 * s.setName(""); s.setAddress(""); if (this.studentList.contains(s)) { return
	 * this.studentList.get(this.studentList.indexOf(s)); } else { return null; } }
	 */

	@SuppressWarnings("finally")
	public List<Student> getDatabaseStudentList() {

		List<Student> studentList = new LinkedList<Student>();
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			studentList = session.createQuery("from Student").list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return studentList;
	}

	@SuppressWarnings("finally")
	public Student getDatabaseStudent(int id)throws HibernateException {
		Student student = null;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			// start a transaction
			transaction = session.beginTransaction();
			student = (Student) session.get(Student.class, new Integer(id));
			return student;
		} catch (HibernateException ex) {
			ex.printStackTrace();
			return student;
		}

	}

	@SuppressWarnings("finally")
	public boolean insertDatabaseStudent (int id, String name, String address) throws HibernateException{
		Student student = new Student();
		student.setId(id);
		student.setName(name);
		student.setAddress(address);
		boolean result = false;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			// start a transaction
			transaction = session.beginTransaction();
			System.out.println("\n\n");
			// save the student objects
			session.save(student);
			// commit transaction
			transaction.commit();
			result = true;
			return result;
		} catch (HibernateException e) {
			// TODO: handle exception
			e.printStackTrace();
			return result;
		}

	}

	@SuppressWarnings("finally")
	public boolean updateDatabaseStudent(int id, String name, String address) throws HibernateException{
		Student student = new Student();
		student.setId(id);
		student.setName(name);
		student.setAddress(address);
		boolean result = false;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			// start a transaction
			transaction = session.beginTransaction();
			System.out.println("\n\n");
			// save the student objects
			session.update(student);
			// commit transaction
			transaction.commit();
			result = true;
			return result;
		} catch (HibernateException e) {
			// TODO: handle exception
			e.printStackTrace();
			return result;
		}
	}

	@SuppressWarnings("finally")
	public boolean deleteDatabaseStudent(int id) throws HibernateException {
		Student student = null;
		boolean result = false;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			// start a transaction
			transaction = session.beginTransaction();
			student = (Student) session.get(Student.class, new Integer(id));
		} 
		
		
		catch (HibernateException ex) {
			throw ex;
		}
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			// start a transaction
			transaction = session.beginTransaction();
			System.out.println("\n\n");
			// save the student objects
			session.delete(student);
			// commit transaction
			transaction.commit();
			result = true;
			return result;
		} catch (HibernateException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}
	}

	public static void main(String[] args) {
		StudentUtil sutil = new StudentUtil();
		/*
		 * for (Student s : sutil.studentList) { System.out.println(s.toString()); }
		 * 
		 * Student s = sutil.getStudent(4); System.out.println("===================>" +
		 * s.toString());
		 * 
		 * sutil.insertStudent(1, "Name11", "Address11"); for (Student s2 :
		 * sutil.studentList) { System.out.println(s2.toString()); }
		 * 
		 * sutil.updateStudent(1, "newName1", "NewAddress1"); for (Student s2 :
		 * sutil.studentList) { System.out.println(s2.toString()); }
		 * 
		 * sutil.deleteStudent(5); for (Student s1 : sutil.studentList) {
		 * System.out.println(s1.toString()); }
		 */
		// System.out.println(sutil.getDatabaseStudent(21).toString());
		/*
		 * if (sutil.insertDatabaseStudent(33, "Name32", "Address32")) {
		 * System.out.println("data inserted successfully...."); }
		 */
		/*
		 * try { if (sutil.updateDatabaseStudent(35, "NewName32", "NewAddress32")) {
		 * System.out.println("data updated successfully...."); } else {
		 * System.out.println("Error in data updation."); } } catch (SQLException e) {
		 * // TODO Auto-generated catch block e.printStackTrace(); }
		 */
		/*
		 * try { if (sutil.deleteDatabaseStudent(32)) {
		 * System.out.println("data deleted successfully...."); } } catch (SQLException
		 * e) { // TODO Auto-generated catch block e.printStackTrace(); }
		 */
		List<Student> list = sutil.getDatabaseStudentList();
		for (Student s : list) {
			System.out.println(s.toString());
		}
	}

}
