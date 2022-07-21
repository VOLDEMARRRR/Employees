package humanResourses;

public class Organization {
    String name_organization;
    Department[] mas_department;

    public Organization(String name_organization) {
        this(name_organization, new Department[1]);
    } // норм

    public Organization(String name_organization, Department[] mas_department) {
        this.name_organization = name_organization;
        this.mas_department = mas_department;
    }  // норм

    public void addDepartment(Department department){
        if (department == null) return;
        for (int i = 0; i < mas_department.length; i++) {
            if (mas_department[i] == null) {
                mas_department[i] = department;
                return;
            }
        }
        Department[] mas_department_2 = new Department[mas_department.length * 2];
        System.arraycopy(mas_department, 0, mas_department_2, 0, mas_department.length);
        mas_department_2[mas_department.length] = department;
        mas_department = mas_department_2;
    } // не понятно че с нулем делать

    public boolean deleteDepartment(String name){
        for (int i = 0; i < mas_department.length; i++) {
            if (mas_department[i] == null) return false;
            if (mas_department[i].getName_department().equals(name)) {
                System.arraycopy(mas_department, i + 1, mas_department, i, mas_department.length - i - 1);
                mas_department[mas_department.length - 1] = null; // строка для уаления если 2 обьекта
                return true;
            }
        }
        return false;
    } // норм и на удивление работает с 1 элементом

    public Department choiceDepartment(String name) {
        for (Department department : mas_department) {
            if (department.getName_department().equals(name)) {
                return department;
            }
        }
        return null;
    } // норм

    public Department[] getMas_department() {
        return mas_department;
    } // норм

    public int countDepartment() {
        int count = 0;
        for (Department department : mas_department) {
            if (department == null) return count;
            count++;
        }
        return count;
    } // норм

    public int countEmployee() {
        int count = 0;
        for (Department department : mas_department) {
            if (department == null) return count;
            count += department.getNum();
        }
        return count;
    } // норм

    public int countEmployeePost(String post) {
        int count = 0;
        for (Department department : mas_department) {
            if (department == null) return count;
            count += department.getMasPost(post).length;
        }
        return count;
    } // норм

    public Employee richMan() {
        int count = 0;
        Employee rich = null;
        for (Department department : mas_department) {
            if (department == null) return rich;
            if (department.getMasSortSalary()[0].getSalary() > count) {
                count = department.getMasSortSalary()[0].getSalary();
                rich = department.getMasSortSalary()[0];
            }
        }
        return rich;
    } // норм

    public Department employeeDepartment(String name, String surname) {
        Employee[] find_employee;
        for (Department department : mas_department) {
            if (department == null) return null;
            find_employee = department.getMass();
            for (Employee employee : find_employee) {
                if (employee.getName().equals(name) && employee.getSurname().equals(surname)) {
                    return department;
                }
            }
        }
        return null;
    } // норм
}
