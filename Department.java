package humanResourses;

public class Department {
    String name_department;
    Employee[] mas_employee;
    int num_employee;

    public Department(String name_department){
        this.name_department = name_department;
        mas_employee = new Employee[8];
    }

    public Department(String name_department, int number){
        this.name_department = name_department;
        mas_employee = new Employee[number];
    }

    public Department(String name_department, Employee[] mas_employee){
        this.name_department = name_department;
        this.mas_employee = mas_employee;
    }

    public void add_employee(Employee employee){
        for (int i = 0; i < mas_employee.length; i++) {
            if (mas_employee[i].equals("")) {
                mas_employee[i] = employee;
                return;
            }
        }

    }
}
