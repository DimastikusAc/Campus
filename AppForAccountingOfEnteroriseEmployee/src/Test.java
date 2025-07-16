public class Test {
    public static void main(String[] args) {
        //создал объект по шаблону EmployeeData, в переменной employeeData сохранил ссылку на него.
        EmployeeData employeeData = new EmployeeData();

        // Вызвал метод getDefaultEmployees из EmployeeData который возвращает массив объектов типа Employee.
        // Создал переменную/ссылку employees на этот массив.
        Employee[] employees = employeeData.getDefaultEmployees();

        // Создал объект класса EmployeeServise, в конструктор передал массив employees.
        //Теперь объект EmployeeServise может использовать этот массив внутри себя.
        EmployeeService employeeService = new EmployeeService(employees);
        employeeService.printEmployees();

        //Calculation of total salary for 1 month of all employees
        double calculateTotalSalary = employeeService.calculateSalaryAndBonus();
        System.out.println("Total amount of payments = " + calculateTotalSalary);

        // Search employee by id
        Employee searchById = employeeService.getById(4);
        System.out.println(searchById);

        //Search employee by name
        String name = "Anton";
        Employee searchByName = employeeService.getByName(name);
        if(searchByName != null){
            System.out.println(searchByName);
        } else {
            System.out.println("Such employee " + name + " does not exist!");

        }

        System.out.println("===== Sort by name =====");
        employeeService.sortByName();
        employeeService.printEmployees();

        System.out.println("===== Sort by name and totalSalary =====");
        employeeService.sortByNameAndSalary();
        employeeService.printEmployees();

        System.out.println("===== Edit Employee =====");
        Employee newEmployee = new Designer(5, "Joseph", 29, 2408.84, "Male", 25, 22);
        Employee oldEmployee = employeeService.edit(newEmployee);
        if (oldEmployee != null) {
            System.out.println(oldEmployee);
        }

        System.out.println("===== Remove employee and return link to a remove object =====");
        long id = 2;
        Employee removeEmployee = employeeService.remove(id);
        System.out.println("Link to remove employee with id = " + id +": " + removeEmployee);

        System.out.println("===== Add employee to employees =====");
        Employee addNewEmployee = new Designer(10, "Karen", 23, 2200.14, "Female", 20, 22);
        employeeService.add(addNewEmployee);
        employeeService.printEmployees();

        System.out.println("===== Generate random employee by size =====");
        int size = 5;
        EmployeeFactory employeeFactory = new EmployeeFactory();
        Employee[] generateEmployees = employeeFactory.generateEmployee(size);
        for (Employee employee : generateEmployees) {
            System.out.println(employee);
        }

    }
}

