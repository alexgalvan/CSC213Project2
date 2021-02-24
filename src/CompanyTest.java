package src;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Test class for Company
 *
 * @author Yuan zhao,Alexander Galvan
 */
public class CompanyTest {
    Profile profile1 = new Profile("Unkonw,Unkonw", "CS", new Date());
    Profile profile2 = new Profile("Doe,Jane", "ECE", new Date());
    Profile profile3 = new Profile("Brown,Charlie", "IT", new Date());
    Company company = new Company();
    Employee employee;
    Parttime partTime;
    Fulltime fullTime;
    Management management;

    /**
     * Testing add method
     */
    @Test
    public void add() {
        employee = new Employee(profile1);
        assertTrue(company.add(employee));
        assertFalse(company.add(employee));
    }

    /**
     * Testing remove method
     */
    @Test
    public void remove() {
        employee = new Employee(profile1);
        company.add(employee);
        assertTrue(company.remove(employee));
        assertFalse(company.remove(employee));
    }

    /**
     * Testing setHours method
     */
    @Test
    public void setHours() {
        partTime = new Parttime(profile1, 10);
        fullTime = new Fulltime(profile2, 1233);
        management = new Management(profile3, 32232, 1);
        company.add(partTime);
        company.add(fullTime);
        company.add(management);
        assertTrue(company.setHours(new Parttime(partTime.getProfile(), 0)));
        assertFalse(company.setHours(new Parttime(fullTime.getProfile(), 0)));
        assertFalse(company.setHours(new Parttime(management.getProfile(), 0)));
    }

}