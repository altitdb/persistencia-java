package br.edu.fcv.exemplo;

import java.util.List;

public interface StudentDAO {

	void save(Student student);
	
	void update(Student student);
	
	void delete(Student student);
	
	List<Student> find(String name);
	
}
