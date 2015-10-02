package br.edu.fcv.exemplo;

import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Test {
	
	private static final Logger LOG = LogManager.getLogger(Test.class);

	public static void main(String[] args) {
		StudentDAO dao = new StudentDAOImpl();
		List<Student> results = null;
		
		Student student = new Student();
		student.setName("Dolinho Developer");
		student.setPhone("190");
		student.setBirthday(new Date());
		
		dao.save(student);
		results = dao.findAll();
		LOG.info("Students Size Save: " + results.size());
		
		student = results.get(0);
		student.setName("Developer");
		dao.update(student);
		results = dao.findAll();
		LOG.info("Students Size Update: " + results.size());
		
		student = results.get(0);
		dao.delete(student);
		results = dao.findAll();
		LOG.info("Students Size Delete: " + results.size());
		
		Student studentMerge = new Student();
		studentMerge.setName("Name");
		studentMerge.setPhone("194");
		dao.update(studentMerge);
		results = dao.findAll();
		LOG.info("Students Size Merge 01: " + results.size());
		
		studentMerge = results.get(0);
		studentMerge.setName("New name");
		dao.update(studentMerge);
		results = dao.findAll();
		LOG.info("Students Size Merge 02: " + results.size());
		
		dao.close();
	}
}
