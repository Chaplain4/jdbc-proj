package jdbcTest;

import dao.impl.EmployeeDAOImpl;
import dao.impl.OfficeDAOImpl;
import dao.impl.PassportDAOImpl;
import model.Employee;
import model.Office;
import model.Passport;

import java.util.HashSet;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
//        System.out.println(new EmployeeDAOImpl().all());
//        Office office = new Office();
//        office.setAddress("address");
//        office.setPhone1("123");
//        office.setPhone2("321");
//        office.setPostalCode(222222);
//        office.setTitle("Title");
//        boolean isCreated = new OfficeDAOImpl().createOffice(office);
//        System.out.println("new office created?" + isCreated);
//        System.out.println("office deleted?" + new OfficeDAOImpl().deleteById(6));
//        Office office = new Office();
//        office.setId(2);
//        System.out.println(new EmployeeDAOImpl().getAllByOfficeID(office));
        PassportDAOImpl pdi = new PassportDAOImpl();
        Passport passport1 = pdi.findById(1);
        passport1.setPersonalID("MP9832025");
        System.out.println("passport updated? " + pdi.updatePassport(passport1));
    }
}
