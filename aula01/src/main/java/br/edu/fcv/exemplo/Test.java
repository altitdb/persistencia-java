package br.edu.fcv.exemplo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Test {

	private static final Logger LOG = LogManager.getLogger(Test.class);
	
	public static void main(String[] args) throws SQLException {
		ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.getConnection();
		String sql = "CREATE TABLE STUDENTS (STUDENT_ID SMALLINT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), NAME VARCHAR(100), PHONE VARCHAR(15))";
		PreparedStatement create = connection.prepareStatement(sql);
		create.execute();
		
		StudentDAO dao = new StudentDAOImpl();
		List<Student> students = null;
		
		Student student = new Student();
		student.setName("John");
		student.setPhone("190");
		dao.save(student);
		LOG.info("Student Save");

		students = dao.find("%Jo%");
		LOG.info("Student Size: " + students.size());
		
		student = students.get(0);
		student.setName("Blond");
		dao.update(student);
		LOG.info("Student Update");
		
		students = dao.find("%Bl%");
		LOG.info("Student Size: " + students.size());
		
		student = students.get(0);
		dao.delete(student);
		LOG.info("Student Delete");
		
		students = dao.find("%Bl%");
		LOG.info("Student Size: " + students.size());
	}
}
