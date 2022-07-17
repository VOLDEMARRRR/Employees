package humanResourses;

import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {
        Employee Lana = new Employee("lana", "Fay", "Singer", 50);
        Employee Obi = new Employee("Obi-Wan","Kenobi", "Master-jedi", 1000 );
        Employee Thor = new Employee("Thor", "Odinson");
        System.out.println(Lana.getName());
        System.out.println(Obi.getPost());
        System.out.println(Thor.getPost());
        Thor.setPost("God of thunder");
        Thor.setSalary(1000000);
        System.out.println(Thor.getPost());
        System.out.println(Thor.getSalary());
        System.out.println();

        Department sport = new Department("sport");
        System.out.println(sport.getMas_employee());
        sport.addEmployee(Lana);
        sport.addEmployee(Obi);
        sport.addEmployee(Thor);
        System.out.println(sport.getNum());
        System.out.println(sport.getMass());
        System.out.println(sport.getMasSortSalary());
    }
}
