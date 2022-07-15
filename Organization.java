package humanResourses;

public class Organization {
    String name_organization;
    Department[] mas_department;

    public Organization(String name_organization) {
        this.name_organization = name_organization;
    }

    public Organization(String name_organization, Department[] mas_department) {
        this.name_organization = name_organization;
        this.mas_department = mas_department;
    }

    public void addDepartment(Department department){
        for (int i = 0; i < mas_department.length; i++) {
            if (mas_department[i].equals("")) {
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
        return mas_department[0]; // пока хз как красиво выйти, если имя не будет совпадать
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

    public Employee richMan() {
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

    public Department employeeDepartment(String name, String surname) {
        Employee[] find_employee;
        for (int i = 0; i < mas_department.length; i++) {
            find_employee = mas_department[i].getMas_employee();
            for (int j = 0; j < find_employee.length ; j++) {
                if (find_employee[j].getName().equals(name) && find_employee[j].getSurname().equals(surname)) {
                    return mas_department[i];
                }
            }
        }
        return mas_department[0]; // также пока хз как норм выйти если проверка не прошла
    }
}
