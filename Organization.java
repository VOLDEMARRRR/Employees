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
    }

}
