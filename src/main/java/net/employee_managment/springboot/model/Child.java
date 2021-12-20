package net.employee_managment.springboot.model;

import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "Child")
public class Child {

    @Id
    @Column(name = "child_ID", nullable = false)
    private Long child_ID;

    @Column(name = "child_full_name", nullable = true)
    private String childFullName;

    @Column(name = "age", nullable = true)
    private String age;

    public Child() {
        System.out.println("cc1");
    }

    public Child(String childFullName, String age) {
        System.out.println("cc2");
        this.childFullName =childFullName;
        this.age=age;
    }

    public Child(Long child_ID, String childFullName, String age, Employee employee) {
        super();
        System.out.println("cc3");
        Employee e = null;
        this.child_ID = child_ID;
        this.childFullName = childFullName;
        this.age=age;
        e = employee;
    }

    @Override
    public String toString() {
        return "Child{" +
//                "fullName='" + childFullName + '\'' +
//                ", age='" + age + '\'' +
                '}';
    }
}
