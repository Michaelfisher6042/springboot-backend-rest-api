package net.employee_managment.springboot.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "Address")
public class Address{

    @Id
    @Column(name = "address_id", nullable = false)
    private Long address_ID;

    @Column(name = "full_address", nullable = true)
    private String fullAddress;

//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "employee_id", nullable = false)
//    private Employee employee;

//    @Column(name = "id", nullable = true)
//    private int _id;
//    @Column//(name = "employee_id", nullable = false)
//    private int employee_id;


//    @NotNull
//    @ManyToOne
//    @JoinColumn(name = "Employee")
    public Address() {
        System.out.println("ac1");
    //        System.out.println("c3");
    //        System.out.println(address_ID);
    //        System.out.println(fullAddress);

    }

    public Address(String fullAddress) {
        System.out.println("ac2");
        //this.address_ID = address_ID;
        this.fullAddress = fullAddress;
    }

    public Address(Long address_ID, String fullAddress, Employee employee) {
        super();
        Employee e = null;
          System.out.println("ac3");
//        System.out.println(address_ID);
//        System.out.println(fullAddress);
        //System.out.println(employee_id);
        this.address_ID = address_ID;
        this.fullAddress = fullAddress;
        e = employee;
    }


    @Override
    public String toString() {
        return "Address{" +
                "address_ID=" + address_ID +
                ", fullAddress='" + fullAddress + '\'' +
//                ", _id='" + _id + '\'' +
                '}';
    }
}

