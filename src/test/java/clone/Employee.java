package clone;

import java.util.Date;
import java.util.GregorianCalendar;

public class Employee implements Cloneable {//Cloneable - it is markable interface, clone() is inherited from Object
    private String name;
    private double salary;
    private Date hireDay;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
        hireDay = new Date();
    }

    //need to override with public access modifier
    public Employee clone() throws CloneNotSupportedException {
        Employee cloned = (Employee) super.clone(); //protected native Object clone()
        cloned.hireDay = (Date) hireDay.clone();
        return cloned;
    }

    public void setHireDay(int year, int month, int day) {
        Date newHireDay = new GregorianCalendar(year, month - 1, day).getTime();
        hireDay.setTime(newHireDay.getTime());
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent /100;
        salary+=raise;
    }

    public String toString() {
        return "Employee[name=" + name + ", salary=" + salary + ",hireDay=" + hireDay + "]";
    }

    public static class CloneTest {

        public static void main(String[] args) throws CloneNotSupportedException {
            var original = new Employee("John", 5000);
            Employee copy = original.clone();
        }
    }
}
