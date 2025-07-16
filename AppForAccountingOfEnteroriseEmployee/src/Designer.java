public class Designer extends Employee{
    int rate;
    int workerDay;

    Designer(int id, String name, int age, double salary, String gender, int rate, int workerDay) {
        super(id, name,  age, salary, gender);
        this.rate = rate;
        this.workerDay = workerDay;


    }
    @Override
    public double getTotalSalary() {
        double totalSalary = salary + rate * workerDay;
        return totalSalary;
    }

    @Override
    public String toString() {
        return "Designer {" +
                super.toString() +
                ", rate = " + rate +
                ", workerDay" + workerDay +
                ", totalSalary = " + getTotalSalary() +
                "}";
    }
}
