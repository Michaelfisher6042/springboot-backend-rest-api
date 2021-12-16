
package net.employee_managment.springboot.model;



import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "employee")
@Inheritance(strategy = InheritanceType.JOINED)
public class Employee {

	@Id
	@Column(name="Id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long empId;


	@NotNull
	@ManyToOne
	//@Transient
	@JoinColumn(name="general_details_id")
	private GeneralDetails generalDetails;


	@NotNull
	@ManyToOne
	//@Transient
	@JoinColumn(name="spouse_id")
	private Spouse spouse;

	@NotNull
	@OneToMany( cascade = CascadeType.ALL)
	//define FK column in Address table
	@JoinColumn(name = "Id",
			foreignKey = @ForeignKey(name = "EMPLOYEE_Address_FK"), nullable = true)
	private List<Address> addresses;

	//@NotNull
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "Id",
			foreignKey = @ForeignKey(name = "EMPLOYEE_Child_FK"), nullable = true)
	private List<Child> children;

	public Employee(){
		System.out.println("ec1");
	}
	public Employee(long empId){
		super();
		this.empId = empId;
		System.out.println("ec2");
		System.out.println("id");
		System.out.println(empId);
	}

	public Employee(GeneralDetails generalDetails, Spouse spouse, List<Address> addresses, List<Child> children) {
		super();
		System.out.println("ec3");
		this.generalDetails = generalDetails;
		this.spouse = spouse;
		this.addresses = addresses;
		this.children = children;
	}

	public long getId() {
		return empId;
	}

	public void setId(long empId) {
		this.empId = empId;
	}
	public GeneralDetails getGeneralDetails() {
		return generalDetails;
	}
	public Spouse getSpouse() {
		return spouse;
	}
	public List<Address> getAddress() {
		return addresses;
	}
	public List<Child> getChild() {
		return children;
	}

	public void setGeneralDetails(GeneralDetails generalDetails) {
		this.generalDetails = generalDetails;
	}
	public void setSpouse(Spouse spouse) {
		this.spouse = spouse;
	}
	public void setAddress(List<Address> addresses) {
		this.addresses = addresses;
	}
	public void setChildren(List<Child> children) {
		this.children = children;
	}


	@Override
	public String toString() {
		return "Employee{" +
				"employee_id=" + empId +
				//", generalDetails=" + getGeneralDetails().getGeneral_details_id() +
				//", spouse=" + getSpouse().getSpouse_id()+
				//", addresses=" + Arrays.toString(addresses.toArray()) +
				//", children=" + Arrays.toString(children.toArray()) +
				'}';
	}



}