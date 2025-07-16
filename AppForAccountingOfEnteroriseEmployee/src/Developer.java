import java.util.Random;

public class Developer extends Employee{
    private static final double DEFAULT_BUGS_RATE = 0.4;

    int fixedBugs;


    Developer(int id, String name, int age, double salary, String gender, int fixedBugs) {
        super(id, name,  age, salary, gender);
        this.fixedBugs = fixedBugs;
    }

    @Override
    public double getTotalSalary() {
        Random random = new Random();
        boolean randomBoolean = random.nextBoolean();
        double totalSalary = (salary + fixedBugs*DEFAULT_BUGS_RATE)*(randomBoolean ? 2 : 0);
        return totalSalary;
    }

    @Override
    public String toString() {
        return "Developer {" +
                super.toString() +
                ", fixedBugs = " + fixedBugs +
                ", totalSalary = " + getTotalSalary() +
                "}";
    }
}
