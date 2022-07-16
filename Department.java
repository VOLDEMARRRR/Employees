package humanResourses;

public class Department {
    String name_department;
    Employee[] mas_employee;
    int num_employee;

    public Department(String name_department){
        this(name_department,8);
    }

    public Department(String name_department, int number){
        this(name_department, new Employee[number]);
    }

    public Department(String name_department, Employee[] mas_employee){
        this.name_department = name_department;
        this.mas_employee = mas_employee;
        this.num_employee = mas_employee.length;
    }

    public void addEmployee(Employee employee){ // проверка employee на null
        for (int i = 0; i < mas_employee.length; i++) {
            if (mas_employee[i] == null) {
                mas_employee[i] = employee;
                return;
            }
        }
        Employee[] mas_employee_2 = new Employee[mas_employee.length * 2];
        for (int i = 0; i < mas_employee.length; i++) { // передалать array copy
            mas_employee_2[i] = mas_employee[i];
        }
        mas_employee_2[mas_employee.length] = employee;
        mas_employee = mas_employee_2;
    }

    public boolean kickEmployee(String name, String surname){
        int count = -1;
        for (int i = 0; i < mas_employee.length; i++) {
            if (mas_employee[i].getName().equals(name) && mas_employee[i].getSurname().equals(surname)) {
                count = i; // array copy
                break;
            }
        }
        if (count == -1) return false;
        else {
            for (int i = count; i < mas_employee.length - 1; i++) {
                mas_employee[i] = mas_employee[i + 1];
            }
            mas_employee[mas_employee.length - 1] = null;
        }
        return true;
    }

    public int getNum() {
        return num_employee;
    }

    public Employee[] getMass() {
        return mas_employee;
    }

    public Employee[] getMasPost(String post){
        int count = 0;
        for (int i = 0; i < mas_employee.length; i++) {
           if (mas_employee[i].getPost().equals(post)) {
               count++;
           }
        }
        Employee[] mas_post = new Employee[count];
        for (int i = 0; i < mas_employee.length; i++) {
            if (mas_employee[i].getPost().equals(post)) {
                mas_post[i] = mas_employee[i];
            }
        }
        return mas_post;
    }

    public Employee[] getMasSortSalary() { // проверка на null
        for (int i = 0; i < mas_employee.length; i++) {
            Employee buffer;
            for (int j = 0; j < mas_employee.length - i - 1; j++) {
                if (mas_employee[i].getSalary() < mas_employee[i + 1].getSalary()){
                    buffer = mas_employee[i];
                    mas_employee[i] = mas_employee[i + 1];
                    mas_employee[i + 1] = buffer;
                }

            }
        }
        return mas_employee;
    }

    public String getName_department() {
        return name_department;
    }
    public void setName_department(String name_department) {
        this.name_department = name_department;
    }

    public Employee[] getMas_employee() {
        return mas_employee;
    }
    public void setMas_employee(Employee[] mas_employee) {
        this.mas_employee = mas_employee;
    }

    public int getNum_employee() {
        return num_employee;
    }
    public void setNum_employee(int num_employee) {
        this.num_employee = num_employee;
    }
}
