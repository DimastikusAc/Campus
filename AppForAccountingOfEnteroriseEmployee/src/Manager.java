public class Manager extends Employee {


    Manager(int id, String name, int age, double salary, String gender){
        super(id, name,  age, salary, gender);


    }
    @Override
    public double getTotalSalary() {
        double totalSalary = salary;
        return totalSalary;
    }

    @Override
    public String toString() {
        return "Manager {" +
                super.toString() +
                ", totalSalary = " + getTotalSalary() +
                "}";
    }
}
