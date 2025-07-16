import java.util.Random;

public class EmployeeFactory {
    private static final int MIN_RANDOM_AGE = 19;
    private static final int MAX_RANDOM_AGE = 50;
    private static final double MIN_RANDOM_SALARY = 1500.26;
    private static final double MAX_RANDOM_SALARY = 2739.52;
    private static final int MAX_FIXED_BUGS = 120;
    private static final int MIN_RATE = 15;
    private static final int MAX_RATE = 40;
    private static final int MAX_WORKER_DAY = 23;

    Employee[] generateEmployee(int size) {
        Employee[] generateEmployees = new Employee[size];

        String[] maleNames = {
                "James", "John", "Robert", "Michael", "William",
                "David", "Richard", "Joseph", "Thomas", "Charles"
        };
        String[] femaleNames = {
                "Mary", "Patricia", "Jennifer", "Linda", "Elizabeth",
                "Barbara", "Susan", "Jessica", "Sarah", "Karen"
        };
        String[] positions = {"Developer", "Designer", "Manager"};

        String[][] arrayOfNames = {maleNames, femaleNames};
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            //Generate id
            int randomId = i + 1;

            // Generate randomPositions
            int indexPosition = random.nextInt(positions.length);
            String randomPosition = positions[indexPosition];


            //Generate randomGender
            String randomGender;
            int genderIndex = random.nextInt(arrayOfNames.length);
            if (genderIndex == 0) {
                randomGender = "Male";
            } else {
                randomGender = "Female";
            }

            //Generate name
            String[] selectRandomName = arrayOfNames[genderIndex];
            int indexName = random.nextInt(selectRandomName.length);
            String randomName = selectRandomName[indexName];

            //Generate randomAge
            int randomAge = random.nextInt(MAX_RANDOM_AGE - MIN_RANDOM_AGE) + MIN_RANDOM_AGE;

            //Generate randomSalary
            double randomSalary = random.nextDouble(MAX_RANDOM_SALARY - MIN_RANDOM_SALARY) + MIN_RANDOM_SALARY;

            //Generate fields based on job position
            if (randomPosition.equals("Developer")) {
                int randomFixedBugs = random.nextInt(MAX_FIXED_BUGS);
                Developer developer = new Developer(
                        randomId,
                        randomName,
                        randomAge,
                        randomSalary,
                        randomGender,
                        randomFixedBugs
                );
                generateEmployees[i] = developer;
            } else if (randomPosition.equals("Designer")) {
                int rate = random.nextInt(MAX_RATE - MIN_RATE) + MIN_RATE;
                int workerDay = random.nextInt(MAX_WORKER_DAY);
                Designer designer = new Designer(
                        randomId,
                        randomName,
                        randomAge,
                        randomSalary,
                        randomGender,
                        rate,
                        workerDay
                );
                generateEmployees[i] = designer;
            } else if (randomPosition.equals("Manager")) {
                Manager manager = new Manager(
                        randomId,
                        randomName,
                        randomAge,
                        randomSalary,
                        randomGender
                );
                generateEmployees[i] = manager;
            } else {
                System.out.println("This position does not exist in the company’s staff list");
            }
        }
        return generateEmployees;
    }
}
