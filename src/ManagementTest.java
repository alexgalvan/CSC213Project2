import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Testing class for Management
 *
 * @author Yuan zhao,Alexander Galvan
 */
public class ManagementTest {
    Profile profile1;
    Profile profile2;
    Profile profile3;

    @Before
    public void setUp() {
        profile1 = new Profile("Yuan zhao1", "CS", new Date());
        profile2 = new Profile("Yuan zhao2", "ECE", new Date());
        profile3 = new Profile("Alexander Galvan3", "IT", new Date());
    }

    @Test
    public void calculatePayment() {
        Company company = new Company();
        Management management1, management2, management3;
        management1 = new Management(profile1, 20000, 1);
        management2 = new Management(profile2, 20000, 2);
        management3 = new Management(profile3, 20000, 3);
        company.add(management1);
        company.add(management2);
        company.add(management3);

        management1.updatePayment();
        management2.updatePayment();
        management3.updatePayment();

        assertEquals("961.54", String.format("%,.2f", management1.getPayment()));
        assertEquals("1,134.62", String.format("%,.2f", management2.getPayment()));
        assertEquals("1,230.77", String.format("%,.2f", management3.getPayment()));
    }
}