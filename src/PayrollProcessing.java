package src;
import java.util.Scanner;

/**
 * PayrollProcessing class,the entry of processing payroll
 *
 * @author Yuan zhao,Alexander Galvan
 */
public class PayrollProcessing {
    String[] USER_CMD = {"AP", "AF", "AM", "R", "C", "S", "PA", "PH", "PD", "Q"};

    /**
     * check if cmd is valid
     *
     * @param cmd
     * @return true if valid
     */
    public boolean parseCmd(String cmd) {
        for (int i = 0; i < USER_CMD.length; i++)
            if (cmd.equals(USER_CMD[i]))
                return true;
        return false;
    }

    /**
     * create a fulltime employee
     *
     * @param profile profile of fulltime employee
     * @param s       string of salary
     * @return fulltime employee
     */
    private Employee createFulltime(Profile profile, String s) {
        int salary = Integer.parseInt(s);
        if (salary < 0) {
            System.out.println("Salary cannot be negative.");
            return null;
        }
        return new Fulltime(profile, salary);
    }

    /**
     * create a management employee
     *
     * @param profile profile of the management
     * @param s       string of salary
     * @param code    manage code
     * @return management
     */
    private Employee createManagement(Profile profile, String s, String code) {
        int salary = Integer.parseInt(s);
        int managementCode = Integer.parseInt(code);
        if (salary < 0) {
            System.out.println("Salary cannot be negative.");
            return null;
        } else if (managementCode < 1 || managementCode > 3) {
            System.out.println("Invalid management code.");
            return null;
        }
        return new Management(profile, salary, managementCode);
    }

    /**
     * create a parttime employee
     *
     * @param profile profile of the parttime employee
     * @param s       string of salary
     * @return parttime employee
     */
    private Employee createParttime(Profile profile, String s) {
        double hourlyRate = Double.parseDouble(s);
        if (hourlyRate < 0) {
            System.out.println("Pay rate cannot be negative.");
            return null;
        }
        return new Parttime(profile, hourlyRate);
    }

    /**
     * Add one employee
     *
     * @param company company of the employee
     * @param type    type of employee
     * @param args    infomation of employee
     */
    private void AddEmployee(Company company, String type, String[] args) {
        Employee employee = null;
        Profile profile = createProfile(args[1], args[2], args[3]);
        if (profile == null) {
            return;
        }
        switch (type) {
            case "AP":
                employee = createParttime(profile, args[4]);
                break;
            case "AF":
                employee = createFulltime(profile, args[4]);
                break;
            case "AM":
                employee = createManagement(profile, args[4], args[5]);
                break;
            default:
                break;
        }
        if (employee == null) {
            return;
        }
        if (!company.add(employee)) {
            System.out.println("Employee is already in the list.");
        } else {
            System.out.println("Employee added.");
        }
    }


    /**
     * set worked hours of the part time employee
     *
     * @param company company of the employee
     * @param args    infomation of employee
     */
    private void setHoursParttime(Company company, String[] args) {
        Profile profile = createProfile(args[1], args[2], args[3]);
        if (profile == null) {
            return;
        }
        Parttime employee = new Parttime(profile);
        int hoursToSet = Integer.parseInt(args[4]);
        employee.setHoursWorked(hoursToSet);
        if (hoursToSet > 100) {
            System.out.println("Invalid Hours: over 100.");
        } else if (hoursToSet < 0) {
            System.out.println("Working hours cannot be negative.");
        } else if (!company.setHours(employee)) {
            System.out.println("Employee does not exist.");
        } else {
            System.out.println("Working hours set.");
        }
    }

    /**
     * Entry of processing payroll
     */
    public void run() {
        System.out.println("Payroll Processing starts.");
        Scanner scanner = new Scanner(System.in);
        Company company = new Company();
        boolean running = true;
        while (running) {
            try {
                String inputLine = scanner.nextLine();
                String[] args = inputLine.split(" ");
                String command = args[0];
                //parse the command
                if (!parseCmd(command)) {
                    System.out.println("Command '" + command + "' not supported!");
                    continue;
                }
                //add a employee
                if (command.charAt(0) == 'A') {
                    AddEmployee(company, command, args);
                    continue;
                }
                //company is empty, continue
                if (company.isEmpty()) {
                    System.out.println("Employee database is empty.");
                    continue;
                }
                //Execute command
                switch (command) {
                    // print earning statements for all employees
                    case "PA":
                        System.out.println("--Printing earning statements for all employees--");
                        company.print();
                        break;
                    // print earning statements for all employees by date hired
                    case "PH":
                        System.out.println("--Printing earning statements by date hired--");
                        company.printByDate();
                        break;
                    // print earning statements for all employees by department
                    case "PD":
                        System.out.println("--Printing earning statements by department--");
                        company.printByDepartment();
                        break;
                    // calculate payments
                    case "C":
                        company.processPayments();
                        System.out.println("Calculation of employee payments is done.");
                        break;
                    // remove employee
                    case "R": {
                        Profile profile = createProfile(args[1], args[2], args[3]);
                        if (profile != null) {
                            if (!company.remove(new Employee(profile))) {
                                System.out.println("Employee doesn't exist.");
                            } else {
                                System.out.println("Employee removed.");
                            }
                        }
                        break;
                    }
                    // set hours of part time employee
                    case "S": {
                        setHoursParttime(company, args);
                        break;
                    }
                    case "Q":
                        System.out.println("Payroll Processing completed.");
                        running = false;
                        break;
                }
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
    }

    /**
     * create a profile for one employee
     *
     * @param name       of the employee
     * @param department of the employee
     * @param strDate    dateHired of the employee
     * @return profile
     */
    private Profile createProfile(String name, String department, String strDate) {
        //department checking
        if (!(department.equals("ECE") || department.equals("IT") || department.equals("CS"))) {
            System.out.println("'" + department + "' is not a valid department code");
            return null;
        }
        //checking hired date
        Date date = new Date(strDate);
        if (!date.isValid()) {
            System.out.println(strDate + " is not a valid date!");
            return null;
        }
        return new Profile(name, department, date);
    }
}
