package dao.impl;

import dao.EmployeeDAO;
import dao.OfficeDAO;
import dao.PassportDAO;
import model.Employee;
import model.Office;
import model.Passport;
import util.DBUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

public class EmployeeDAOImpl implements EmployeeDAO {
    private OfficeDAO officeDAO = new OfficeDAOImpl();
    private PassportDAO passportDAO = new PassportDAOImpl();

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
                return createEmployee(rs);
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
        Set<Employee> employees = new HashSet<>();
        Connection connection = DBUtils.getConnection();
        Statement statement = null;
        ResultSet rs = null;
        try {
            statement = connection.createStatement();
            rs = statement.executeQuery("SELECT * FROM employees");
            while (rs.next()) {
                employees.add(createEmployee(rs));
            }
            return employees;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtils.release(connection, statement, rs);
        }
    }

    @Override
    public Set<Employee> getAllByOfficeID(Office office) {
        return null;
    }

    private Employee createEmployee(ResultSet rs) throws SQLException {
        Employee employee = new Employee();
        employee.setId(rs.getInt("id"));
        employee.setName(rs.getString("name"));
        employee.setLastName(rs.getString("last_name"));
        employee.setAge(rs.getInt("age"));
        employee.setOffice(officeDAO.findById(rs.getInt("office_id")));
        employee.setPassport(passportDAO.findById(rs.getInt("passport_id")));
        employee.setCreatedTs(rs.getTimestamp("created_ts"));
        employee.setUpdatedTs(rs.getTimestamp("updated_ts"));
        return employee;
    }
}
