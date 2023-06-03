package Datas;

import java.util.Objects;

public class TestTableData {
    public String firstName;
    public String lastName;
    public String email;
    public String age;
    public String salary;
    public String department;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getAge() {
        return age;
    }

    public String getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestTableData tableData = (TestTableData) o;
        return firstName.equals(tableData.firstName) && lastName.equals(tableData.lastName) && email.equals(tableData.email) && age.equals(tableData.age) && salary.equals(tableData.salary) && department.equals(tableData.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, email, age, salary, department);
    }
}