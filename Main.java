package humanResourses;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Employee Lana = new Employee("Lana", "Fay", "Singer", 50);
        Employee Obi = new Employee("Obi-Wan","Kenobi", "Master-jedi", 1000 );
        Employee Thor = new Employee("Thor", "Odinson");
        Employee Klod = new Employee("klod", "Monet", "painter", 359);
        Employee Ivan = new Employee("Ivan", "Ivanov", "economist", 3213);
        Employee Victor = new Employee("Victor", "Sobolev", "economist", 50000000);
        System.out.println(Lana.getName());
        System.out.println(Obi.getPost());
        System.out.println(Thor.getPost());
        Thor.setPost("God of thunder");
        Thor.setSalary(1000000);
        System.out.println(Thor.getPost());
        System.out.println(Thor.getSalary());
        System.out.println();

        Department sport = new Department("sport", 1);
        Department economic = new Department("economic");
        Department quality = new Department("quality");
        sport.addEmployee(Lana);
        sport.addEmployee(Obi);
        sport.addEmployee(Thor);
        economic.addEmployee(Klod);
        economic.addEmployee(Ivan);
        economic.addEmployee(Victor);
        Employee[] sports = sport.getMas_employee();
        Employee[] economics = economic.getMas_employee();

        System.out.println(sport.getNum());
        System.out.println(economic.getNum());
        System.out.println(Arrays.toString(sports));
        System.out.println(Arrays.toString(economics));
        System.out.println(Arrays.toString(sport.getMass()));
        System.out.println(Arrays.toString(economic.getMass()));
        System.out.println(Arrays.toString(sport.getMasPost("Master-jedi")));
        System.out.println(Arrays.toString(economic.getMasPost("economist")));
        System.out.println(Arrays.toString(sport.getMasSortSalary()));
        System.out.println(Arrays.toString(economic.getMasSortSalary()));
        System.out.println((sport.kickEmployee("Lana", "Fay")));
        System.out.println((sport.kickEmployee("Lana", "Fay")));
        System.out.println(Arrays.toString(sports));
        System.out.println(Arrays.toString(sport.getMass()));
        System.out.println(Arrays.toString(economic.getMass()));

        Organization apple = new Organization("Apple");
        apple.addDepartment(sport);
        apple.addDepartment(economic);
        apple.addDepartment(quality);
        Department[] departs = apple.getMas_department();
        System.out.println(Arrays.toString(departs));
        System.out.println(apple.deleteDepartment(quality.getName_department()));
        System.out.println(Arrays.toString(departs));
        System.out.println(apple.choiceDepartment("economic"));
        System.out.println(Arrays.toString(apple.getMas_department()));
        System.out.println(apple.countDepartment());
        System.out.println(apple.countEmployee());
        System.out.println(apple.countEmployeePost("economist"));
        System.out.println(apple.richMan());
        System.out.println(apple.employeeDepartment("klod", "Monet"));

    }
}