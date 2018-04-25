import employeeType.employee.Employee;
import employeeType.subTypes.CommissionEmployee;
import employeeType.subTypes.HourlyEmployee;
import employeeType.subTypes.SalaryEmployee;

/*  Name        : Daniel O'Connell
 *  Class       : 1620-001
 *  Program #   : 2
 *  Due Date    : October 1, 2015
 *  
 *  Honor Pledge:  On my honor as a student of the University
 *                of Nebraska at Omaha, I have neither given nor received
 *                unauthorized help on this homework assignment.
 *
 * NAME     : Daniel O'Connell
 * NUID     : 12992765
 * EMAIL    : danwoc@gmail.com  
 * Partners : Tutors - Chris -- Compile issue
 *
 * Description:
 * This program creates a simple class hierarchy using abstract methods and inheritance
 * building upon the Employee program from assignment 1. This program simulates an 
 * employee management system that might be used by restaurants or similarly structured 
 * organizations.
 */

public class EmployeeManager {
    private Employee[] employees;
    private final int employeeMax = 100;
    private int currentEmployees;
    
    /*  Method Name   : <<EmployeeManager>>
     *  Parameters    : None.
     *  Return Values : None.
     *  Partners      : None.
     *  Description   : Constructor method for the EmployeeManager class.
     *                  Creates a new array of employees using the maximum
     *                  size of employeeMax. Sets currentEmployees to 0.
     */
    public EmployeeManager(){
        employees = new Employee[employeeMax];
        currentEmployees = 0;
    }
    
    /*  Method Name   : addEmployee
     *  Parameters    : Integer for type of employee to be created
     *                  Strings for first name and last name
     *                  Characters for gender and middle initial
     *                  Integer for employee number
     *                  Boolean for full time or part time
     *                  Double for rate
     *  Return Values : None.
     *  Partners      : None.
     *  Description   : Creates a new employee object of the given type at the next available
     *                  opening in the array.
     */
    public void addEmployee(int type, String fn, String ln, char m, char g, int en, boolean ft, double amount){
        boolean exists;
        if (currentEmployees != employeeMax){
            switch(type){
                case 1:  //This is an hourly employee
                    exists = false;
                    if(currentEmployees != 0){
                        for(int i = 0; i < currentEmployees; i++){
                            if(employees[i].getEmployeeNumber() == en){
                                exists = true;
                            }
                        }
                    }
                    
                    if(exists == true){
                        System.out.println("\nDuplicate Not Added\n");
                    }
                    else{
                        employees[currentEmployees] = new HourlyEmployee(fn, ln, m, g, en, ft, amount);
                        currentEmployees++;    
                    }
                    break; //end case 1
                    
                case 2:  //This is a salary employee
                    exists = false;
                    if(currentEmployees != 0){
                        for(int i = 0; i < currentEmployees; i++){
                            if(employees[i].getEmployeeNumber() == en){
                                exists = true;
                            }
                        }
                    }
                    
                    if(exists == true){
                        System.out.println("\nDuplicate Not Added\n");
                    }
                    else{
                        employees[currentEmployees] = new SalaryEmployee(fn, ln, m, g, en, ft, amount);
                        currentEmployees++;    
                    }
                    break; //end case 2
                    
                case 3:  //This is a commission employee
                    exists = false;
                    if(currentEmployees != 0){
                        for(int i = 0; i < currentEmployees; i++){
                            if(employees[i].getEmployeeNumber() == en){
                                exists = true;
                            }
                        }
                    }
                    
                    if(exists == true){
                        System.out.println("\nDuplicate Not Added\n");
                    }
                    else{
                        employees[currentEmployees] = new CommissionEmployee(fn, ln, m, g, en, ft, amount);
                        currentEmployees++;    
                    }
                    break; //end case 3
                    
                default: //This will happen if the employee type is invalid
                    System.out.println("\nInvalid Employee Type, None Added!\n");
                    break; //end default case
            }//end switch
        }//end if
    }//end method addEmployee
    
    /*  Method Name   : removeEmployee
     *  Parameters    : integer for index of employee to remove
     *  Return Values : None.
     *  Partners      : None.
     *  Description   : Finds and removes an employee at the given index.
     */
    public void removeEmployee(int index){
        if(index != -1){
            employees[index] = employees[currentEmployees - 1];
            --currentEmployees;
        }
        else{
            System.out.println("Employee not found!");
        }
    }
    
    /*  Method Name   : listAll
     *  Parameters    : None.
     *  Return Values : None.
     *  Partners      : None.
     *  Description   : Prints a formatted string for all employees.
     */
    public void listAll(){
        boolean exists = false;
        for(int i = 0; i < currentEmployees; i++){
            if(employees[i] != null){
                exists = true; 
                System.out.println(employees[i].toString());
            }
        }
        if(exists == false){
            System.out.println("No Employees.\n");
        }
    }
    
    /*  Method Name   : listHourly
     *  Parameters    : None.
     *  Return Values : None.
     *  Partners      : None.
     *  Description   : Prints a formatted string for each 
     *                  hourly employee.
     */
    public void listHourly(){
        for(int i = 0; i < currentEmployees; i++){
            if(employees[i] != null && employees[i] instanceof HourlyEmployee){
                System.out.println(employees[i].toString());
            }
        }
    }
    
    /*  Method Name   : listSalary
     *  Parameters    : None.
     *  Return Values : None.
     *  Partners      : None.
     *  Description   : Prints a formatted string for each 
     *                  salary employee.
     */
    public void listSalary(){
        for(int i = 0; i < currentEmployees; i++){
            if(employees[i] != null && employees[i] instanceof SalaryEmployee){
                System.out.println(employees[i].toString());
            }
        }
    }
    
    /*  Method Name   : listCommission
     *  Parameters    : None.
     *  Return Values : None.
     *  Partners      : None.
     *  Description   : Prints a formatted string for each 
     *                  commission employee.
     */
    public void listCommission(){
        for(int i = 0; i < currentEmployees; i++){
            if(employees[i] != null && employees[i] instanceof CommissionEmployee){
                System.out.println(employees[i].toString());
            }
        }
    }
    
    /*  Method Name   : resetWeek
     *  Parameters    : None.
     *  Return Values : None.
     *  Partners      : None.
     *  Description   : Resets the week for all employees. 
     */
    public void resetWeek(){
        for(int i = 0; i < currentEmployees; i++){
            if(employees[i] != null){
                employees[i].resetWeek();
            }
        }
    }
    
    /*  Method Name   : calculatePayout
     *  Parameters    : None.
     *  Return Values : double for total payout
     *  Partners      : None.
     *  Description   : Calculates total weekly pay 
     *                  of all employees 
     */
    public double calculatePayout(){
        double payout = 0;
        for(int i = 0; i < currentEmployees; i++){
            if(employees[i] != null){
                payout += employees[i].calculateWeeklyPay();
            }
        }
        return payout;
    }
    
    /*  Method Name   : getIndex
     *  Parameters    : integer for employee number
     *  Return Values : integer for matching array index
     *  Partners      : None.
     *  Description   : Finds and returns the index of an 
     *                  employee with the given employee number
     */
    public int getIndex(int empNum){
        int match = -1;
        for(int i = 0; i < currentEmployees; i++){
            if(employees[i] != null){
                if(employees[i].getEmployeeNumber() == empNum){
                    match = i;   
                }
            }
        }
        return match;
    }
    
    /*  Method Name   : annualRaises
     *  Parameters    : None.
     *  Return Values : None.
     *  Partners      : None.
     *  Description   : Applies an annual raise to each
     *                  employee. 
     */
    public void annualRaises(){
        for(int i = 0; i < currentEmployees; i++){
            employees[i].annualRaise();
        }
    }
    
    /*  Method Name   : holidayBonuses
     *  Parameters    : None
     *  Return Values : Double for total holiday bonuses.
     *  Partners      : None.
     *  Description   : calculates holiday bonus for all employees
     */
    public double holidayBonuses(){
        double totalBonus = 0;
        for(int i = 0; i < currentEmployees; i++){
            if(employees[i] != null){
                totalBonus += employees[i].holidayBonus();
            }
        }
        return totalBonus;
    }
    
    /*  Method Name   : increaseHours
     *  Parameters    : Double for amount to increase hours, 
     *                  index of employee
     *  Return Values : None.
     *  Partners      : None.
     *  Description   : Applies an increase to the number of hours for an 
     *                  employee at given index. 
     */
    public void increaseHours(int index, double amount){
        if(employees[index] instanceof HourlyEmployee){
            ((HourlyEmployee)employees[index]).increaseHours(amount);
        }
    }
    
    /*  Method Name   : increaseSales
     *  Parameters    : Double for amount to increase sales, 
     *                  index of employee
     *  Return Values : None.
     *  Partners      : None.
     *  Description   : Applies an increase to the number of sales for an 
     *                  employee at given index. 
     */
    public void increaseSales(int index, double amount){
        if(employees[index] instanceof CommissionEmployee){
            ((CommissionEmployee)employees[index]).increaseSales(amount);
        }
    }
}