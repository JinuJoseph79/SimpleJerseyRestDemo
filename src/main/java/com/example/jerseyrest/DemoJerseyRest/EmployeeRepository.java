package com.example.jerseyrest.DemoJerseyRest;

import java.util.ArrayList;
import java.util.List;

import java.sql.*;

public class EmployeeRepository {

	List<Employee> empList;
	Connection con = null;
	
	public EmployeeRepository() {
		
		String url = "jdbc:sqlserver://SUJI;database=restApiDB";
		String user = "root";
		String password = "root123";
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Employee> getEmployees() {
		
		List<Employee> employee = new ArrayList<> ();
		
		String sql = "select * from Employees";
		
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while ( rs.next()) {
				Employee emp = new Employee();
				emp.setId(rs.getInt(1));
				emp.setName(rs.getString(2));
				emp.setSalary(rs.getInt(3));
				
				employee.add(emp);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return employee;
	}
	
	public Employee getEmployee(int id) {
		
		
		String sql = "select * from Employees where id =" + id;
		Employee emp = new Employee();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while ( rs.next()) {
				
				emp.setId(rs.getInt(1));
				emp.setName(rs.getString(2));
				emp.setSalary(rs.getInt(3));
				
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return emp;
	}
	
	public void addEmployee(Employee emp) {
		String sql = "insert into Employees values(?,?,?)";
			        
		PreparedStatement st;
		try {
			st = con.prepareStatement(sql);
			
			st.setInt(1,  emp.getId());
			
			st.setString(2,  emp.getName());
			st.setInt(3, emp.getSalary());
			st.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void updateEmployee(Employee emp) {
		String sql = "update Employees set name=?, salary=? where id=?";
        
		PreparedStatement st;
		try {
			st = con.prepareStatement(sql);
			
			st.setInt(1,  emp.getId());
			st.setString(2,  emp.getName());
			st.setInt(3, emp.getSalary());
			st.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void deleteEmployee(int id) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM Employees WHERE employeeID =" + id;
        
		PreparedStatement st;
		try {
			st = con.prepareStatement(sql);
			st.setInt(1, id);
			st.executeUpdate();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		
		
	}
}

	

