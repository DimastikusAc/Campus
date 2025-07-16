public class EmployeeService {
    Employee[] employees;

    EmployeeService(Employee[] employees) {
        this.employees = employees;
    }

    void printEmployees() {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    double calculateSalaryAndBonus() {
        double calculateSalary = 0;
        for (int i = 0; i < employees.length; i++) {
            calculateSalary += employees[i].getTotalSalary();
        }
        return calculateSalary;
    }

    Employee getById(long id) {
        for (Employee employee : employees) {
            if (employee.id == id) {
                return employee;
            }
        }
        return null;
    }

    Employee getByName(String name) {
        for (Employee employee : employees) {
            if (employee.name.equals(name)) {
                return employee;
            }
        }
        return null;
    }

    Employee[] sortByName() {
        for (int i = 0; i < employees.length - 1; i++) {
            for (int j = 0; j < employees.length - 1; j++) {
                if (employees[j].name.compareTo(employees[j + 1].name) >= 0) {
                    Employee tmp = employees[j];
                    employees[j] = employees[j + 1];
                    employees[j + 1] = tmp;
                }
            }
        }
        return employees;
    }

    Employee[] sortByNameAndSalary() {
        for (int i = 0; i < employees.length - 1; i++) {
            for (int j = 0; j < employees.length - 1; j++) {
                if (employees[j].name.compareTo(employees[j + 1].name) > 0) {
                    Employee tmp = employees[j];
                    employees[j] = employees[j + 1];
                    employees[j + 1] = tmp;
                }
                if ((employees[j].name.compareTo(employees[j + 1].name)) == 0 &&
                        (employees[j].getTotalSalary() > employees[j + 1].getTotalSalary())) {
                    Employee tmp = employees[j];
                    employees[j] = employees[j + 1];
                    employees[j + 1] = tmp;
                }
            }
        }
        return employees;
    }

    Employee edit(Employee newEmployee) {
        Employee existingEmployee = null;
        int index;
        for (index = 0; index <employees.length; index++) {
            if (employees[index].id == newEmployee.id) {
                existingEmployee = employees[index];
                break;
            }
        }
        if (existingEmployee == null) {
            System.out.println("Employee not found");
            return null;
        }
        employees[index] = newEmployee;
        return existingEmployee;
    }

    Employee remove(long id) {
        Employee[] newEmployees = new Employee[employees.length - 1];
        int index = 0;
        Employee reference = getById(id);
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].id != id) {
                newEmployees[index++] = employees[i];
            }
        }
        employees = newEmployees;
        return reference;
    }

    void add(Employee newEmployee) {
        if(newEmployee.id <= 0) {
            throw new RuntimeException("id cannot be negative or zero");
        }
        for (Employee employee : employees){
            if(employee.id == newEmployee.id){
                throw new RuntimeException("such an id exists");
            }
        }
        Employee[] employeesWithNew = new Employee[employees.length + 1];
        int index = 0;
        for (int i = 0; i < employees.length; i++) {
            employeesWithNew[index++] = employees[i];
        }
        employeesWithNew[index] = newEmployee;
        employees = employeesWithNew;
    }
}
