package br.edu.fcv.exemplo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StudentDAOImpl implements StudentDAO {
	
	private static final Logger LOG = LogManager.getLogger(StudentDAOImpl.class);

	public void save(Student student) {
		ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "INSERT INTO STUDENTS (NAME, PHONE) VALUES (?, ?)";
			int generatedKeys = PreparedStatement.RETURN_GENERATED_KEYS;
			statement = connection.prepareStatement(sql, generatedKeys);
			statement.setString(1, student.getName());
			statement.setString(2, student.getPhone());
			statement.executeUpdate();
			statement.close();
		} catch (Exception ex) {
			LOG.error("Error ao salvar");
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				LOG.error("Error desconhecido ao fechar statement");
			}
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				LOG.error("Error desconhecido ao fechar conexao");
			}
		}
	}

	public void update(Student student) {
		ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "UPDATE STUDENTS SET NAME = ?, PHONE = ? WHERE STUDENT_ID = ?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, student.getName());
			statement.setString(2, student.getPhone());
			statement.setLong(3, student.getStudentId());
			statement.executeUpdate();
			statement.close();
		} catch (Exception ex) {
			LOG.error("Error ao atualizar");
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				LOG.error("Error desconhecido ao fechar statement");
			}
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				LOG.error("Error desconhecido ao fechar conexao");
			}
		}
	}

	public void delete(Student student) {
		ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "DELETE FROM STUDENTS WHERE STUDENT_ID = ?";
			statement = connection.prepareStatement(sql);
			statement.setLong(1, student.getStudentId());
			statement.executeUpdate();
			statement.close();
		} catch (Exception ex) {
			LOG.error("Error ao deletar");
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				LOG.error("Error desconhecido ao fechar statement");
			}
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				LOG.error("Error desconhecido ao fechar conexao");
			}
		}
	}

	public List<Student> find(String name) {
		List<Student> students = new ArrayList<Student>();
		ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.getConnection();
		PreparedStatement statement = null;
		ResultSet result = null;
		try {
			String sql = "SELECT STUDENT_ID, NAME, PHONE FROM STUDENTS WHERE NAME LIKE ?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, name);
			result = statement.executeQuery();
			while (result.next()) {
				Student student = new Student();
				student.setStudentId(result.getLong(1));
				student.setName(result.getString(2));
				student.setPhone(result.getString(3));
				students.add(student);
			}
		} catch (Exception ex) {
			LOG.error("Error ao consultar", ex);
		} finally {
			try {
				if (result != null) {
					result.close();
				}
			} catch (SQLException e) {
				LOG.error("Error desconhecido ao fechar result");
			}
			try {
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				LOG.error("Error desconhecido ao fechar statement");
			}
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				LOG.error("Error desconhecido ao fechar conexao");
			}
		}
		return students;
	}

}
