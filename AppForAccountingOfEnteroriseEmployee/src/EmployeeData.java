public class EmployeeData {

    Employee[] getDefaultEmployees() {

        Developer petyaDeveloper = new Developer(1, "Petya", 42, 2505.28, "Male", 113);
        Developer tanyaDeveloper = new Developer(2, "Tanya", 31, 2505.28, "Female", 98);
        Developer denisDeveloper = new Developer(3, "Denis", 21, 1831.42, "Male", 38);

        Designer henkDesigner = new Designer(4, "Henk", 24, 2000.25, "Male", 25, 22);
        Designer anyaDesigner = new Designer(5, "Anya", 32, 2200.14, "Female", 37, 22);
        Designer davidDesigner = new Designer(6, "David", 28, 2000.25, "Male", 25, 20);

        Manager richardManager = new Manager(7, "Richard", 38, 2587.13, "Male");
        Manager marydManager = new Manager(8, "Mary", 27, 2587.13, "Female");
        Manager susandManager = new Manager(9, "Susan", 26, 2327.14, "Female");


        Employee[] employees = {petyaDeveloper, tanyaDeveloper, denisDeveloper, henkDesigner,
                anyaDesigner, davidDesigner, richardManager, marydManager, susandManager};

        return employees;
    }

}
