package humanResourses;

public class Department {
    String name_department;
    Employee[] mas_employee;
    int num_employee;

    public Department(String name_department){
        this(name_department,8);
    } // норм

    public Department(String name_department, int number){
        this(name_department, new Employee[number]);
    } // норм

    public Department(String name_department, Employee[] mas_employee){
        this.name_department = name_department;
        this.mas_employee = mas_employee;
        this.num_employee = mas_employee.length;
    } // норм

    public void addEmployee(Employee employee){
        if (employee == null) return;
        for (int i = 0; i < mas_employee.length; i++) {
            if (mas_employee[i] == null) {
                mas_employee[i] = employee;
                return;
            }
        }
        Employee[] mas_employee_2 = new Employee[mas_employee.length * 2];
        System.arraycopy(mas_employee, 0, mas_employee_2, 0, mas_employee.length);
        mas_employee_2[mas_employee.length] = employee;
        mas_employee = mas_employee_2;
    } // норм

    public boolean kickEmployee(String name, String surname){
        for (int i = 0; i < mas_employee.length; i++) {
            if (mas_employee[i] == null) return false;
            if (mas_employee[i].getName().equals(name) && mas_employee[i].getSurname().equals(surname)) {
                System.arraycopy(mas_employee, i + 1, mas_employee, i, mas_employee.length - i - 1);
                mas_employee[mas_employee.length - 1] = null; // строка для уаления если 2 обьекта
                return true;
            }
        }
        return false;
    } // норм

    public int getNum() {
        int count = 0;
        for (Employee employee : mas_employee) {
            if (employee == null) return count;
            count++;
        }
        return count;
    } // норм

    public Employee[] getMass() {
        int count = mas_employee.length;
        for (int i = 0; i < mas_employee.length; i++) {
            if (mas_employee[i] == null) {
                count = i;
                break;
            }
        }
        Employee[] mass = new Employee[count];
        System.arraycopy(mas_employee, 0, mass, 0, count);
        return mass;
    } // норм

    public Employee[] getMasPost(String post){
        Employee[] mass = getMas_employee();
        int count = 0;
        for (Employee employee : mass) {
            if (employee == null) break;
            if (employee.getPost().equals(post)) {
                count++;
            }
        }
        Employee[] mas_post = new Employee[count];
        int count1 = 0;
        for (Employee employee : mass) {
            if (employee == null) break;
            if (employee.getPost().equals(post)) {
                mas_post[count1] = employee;
                count1++;
            }
        }
        return mas_post;
    } // норм

    public Employee[] getMasSortSalary() {
        Employee[] mass = getMas_employee();
        if (mass == null) return null;
        for (int i = 0; i < mass.length; i++) {
            Employee buffer;
            for (int j = 0; j < mass.length - i - 1; j++) {
                if (mass[j + 1] == null) break;
                if (mass[j].getSalary() < mass[j + 1].getSalary()){
                    buffer = mass[j];
                    mass[j] = mass[j + 1];
                    mass[j + 1] = buffer;
                }
            }
        }
        return mass;
    } // норм

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

    @Override
    public String toString() {
        return "Department{" +
                "name_department='" + name_department + '\'' +
                '}';
    }
}