public class Employee {
    int id;
    String name;
    int age;
    double salary;
    String gender;

    Employee(int id, String name, int age, double salary, String gender) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.gender = gender;
    }
    public double getTotalSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return  "id = " + id +
                ", name is " + name +
                ", age = " + age +
                ", salary = " + String.format("%.2f", salary)+
                ", gender = " + gender;
    }
}
