package dao.impl;

import dao.EmployeeDAO;
import model.Employee;
import util.DBUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Set;

public class EmployeeDAOImpl implements EmployeeDAO {
    @Override
    public boolean createEmployee(Employee employee) {
        return false;
    }

    @Override
    public Employee findById(int id) {
        Connection connection = DBUtils.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM employees where id =" + id);
            if (rs.next()) {
                Employee employee = new Employee();
                employee.setId(id);
                employee.setName(rs.getString("name"));
                employee.setLastName(rs.getString("last_name"));
                employee.setAge(rs.getInt("age"));
                return employee;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }

    @Override
    public boolean updateEmployee(Employee employee) {
        return false;
    }

    @Override
    public Set<Employee> all() {
        return null;
    }

    @Override
    public Set<Employee> getAllByOfficeID(int officeID) {
        return null;
    }
}
