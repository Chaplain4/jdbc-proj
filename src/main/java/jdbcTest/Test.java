package jdbcTest;

import dao.impl.EmployeeDAOImpl;
import dao.impl.OfficeDAOImpl;
import dao.impl.PassportDAOImpl;
import model.Employee;
import model.Office;

import java.util.HashSet;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        //System.out.println(new EmployeeDAOImpl().all().size());
        Office office = new Office();
        office.setAddress("address");
        office.setPhone1("123");
        office.setPhone2("321");
        office.setPostalCode(222222);
        office.setTitle("Title");
        boolean isCreated = new OfficeDAOImpl().createOffice(office);
        System.out.println("new office created?" + isCreated);
    }
}
