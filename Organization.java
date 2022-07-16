package humanResourses;

public class Organization {
    String name_organization;
    Department[] mas_department;

    public Organization(String name_organization) {
        this(name_organization, new Department[0]);
    }

    public Organization(String name_organization, Department[] mas_department) {
        this.name_organization = name_organization;
        this.mas_department = mas_department;
    }

    public void addDepartment(Department department){
        for (int i = 0; i < mas_department.length; i++) {
            if (mas_department[i] == null) {
                mas_department[i] = department;
                return;
            }
        }
        Department[] mas_department_2 = new Department[mas_department.length * 2];
        for (int i = 0; i < mas_department.length; i++) {
            mas_department_2[i] = mas_department[i];
        }
        mas_department_2[mas_department.length] = department;
        mas_department = mas_department_2;
    }

    public boolean deleteDepartment(String name){
        int count = -1;
        for (int i = 0; i < mas_department.length; i++) {
            if (mas_department[i].getName_department().equals(name)) {
                count = i;
                break;
            }
        }
        if (count == -1) return false;
        else {
            for (int i = count; i < mas_department.length - 1; i++) {
                mas_department[i] = mas_department[i + 1];
            }
            mas_department[mas_department.length - 1] = null;
        }
        return true;
    }

    public Department choiceDepartment(String name) {
        for (int i = 0; i < mas_department.length; i++) {
            if (mas_department[i].getName_department().equals(name)) {
                return mas_department[i];
            }
        }
        return null; // пока хз как красиво выйти, если имя не будет совпадать
    }

    public Department[] getMas_department() {
        return mas_department;
    }

    public int countDepartment() {
        return mas_department.length;
    }

    public int countEmployee() {
        int count = 0;
        for (int i = 0; i < mas_department.length; i++) {
            count += mas_department[i].getNum_employee();
        }
        return count;
    }

    public int countEmployeePost(String post) {
        int count = 0;
        for (int i = 0; i < mas_department.length; i++) {
            count += mas_department[i].getMasPost(post).length;
        }
        return count;
    }

    public Employee richMan() { // проверка null
        int count = 0;
        Employee rich = null;
        for (int i = 0; i < mas_department.length; i++) {
            if (mas_department[i].getMasSortSalary()[0].getSalary() > count) {
                count = mas_department[i].getMasSortSalary()[0].getSalary();
                rich = mas_department[i].getMasSortSalary()[0];
            }
        }
        return rich;
    }

    public Department employeeDepartment(String name, String surname) { // проверка null
        Employee[] find_employee;
        for (int i = 0; i < mas_department.length; i++) {
            find_employee = mas_department[i].getMas_employee();
            for (Employee employee : find_employee) { // for each
                if (employee.getName().equals(name) && employee.getSurname().equals(surname)) {
                    return mas_department[i];
                }
            }
        }
        return null; // также пока хз как норм выйти если проверка не прошла
    }
}
