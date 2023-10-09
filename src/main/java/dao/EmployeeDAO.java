package dao;

import model.Employee;

import java.util.Set;

public interface EmployeeDAO {
    boolean createEmployee(Employee employee);
    Employee findById(int id);
    boolean deleteById(int id);
    boolean updateEmployee(Employee employee);
    Set<Employee> all();
    // и так далее
    Set<Employee> getAllByOfficeID(int officeID);
}
