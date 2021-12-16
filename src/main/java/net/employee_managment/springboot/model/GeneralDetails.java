package net.employee_managment.springboot.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "general_details")
public class GeneralDetails{


    @Id
    @Column(name = "general_details_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long general_details_id;

    @Column(name = "full_name", nullable = true)
    private String fullName;

    @Column(name = "employee_level", nullable = true)
    private String employeeLevel;

    @Column(name = "email", nullable = true)
    private String email;

    public GeneralDetails() {
        System.out.println("GDC1");
    }

    public GeneralDetails(long general_details_id){
        super();
        System.out.println("GDC2");
        this.general_details_id = general_details_id;
    }

    public GeneralDetails(long general_details_id, String fullName, String employeeLevel, String email) {
        super();
        System.out.println("GDC3");
        this.general_details_id = general_details_id;
        this.fullName = fullName;
        this.employeeLevel = employeeLevel;
        this.email = email;
    }

    public long getGeneral_details_id() {
        return general_details_id;
    }
    public String getFullName() {
        return fullName;
    }
    public String getEmployeeLevel() {
        return employeeLevel;
    }
    public String getEmail() {
        return email;
    }

    public void setGeneral_details_id(long general_details_id) {
        this.general_details_id = general_details_id;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public void setEmployeeLevel(String employeeLevel) {
        this.employeeLevel = employeeLevel;
    }
    public void setEmail(String email) {
        this.email = email;
    }



    @Override
    public String toString() {
        return "GeneralDetails{" +
                "fullName='" + fullName + '\'' +
                ", employeeLevel='" + employeeLevel + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
