package net.employee_managment.springboot.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
//@Data
@Table(name = "spouse")

public class Spouse<gender> {

	@Id
	@Column(name = "spouse_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long spouse_id;


	@Column(name = "spouse_full_name", nullable = true)
	private String spouseFullName;


	public enum Gender {
		@JsonProperty("Male")
		MALE,
		@JsonProperty("Female")
		FEMALE
	}

	@Column(name = "gender", nullable = true)
	private Gender eGender;


	public Spouse() {

	}
	public Spouse(long spouse_id) {
		super();
		this.spouse_id = spouse_id;

	}
	public Spouse(long spouse_id, String spouseFullName, String gender) {
		super();
		this.spouse_id = spouse_id;
		this.spouseFullName = spouseFullName;
		this.eGender = eGender;
	}


	public long getSpouse_id() {
		return spouse_id;
	}
	public String getSpouseFullName() {
		return spouseFullName;
	}
	public Gender getGender() {
		return eGender;
	}

	public void setSpouse_id(long spouse_id) {
		this.spouse_id = spouse_id;
	}
	public void setSpouseFullName(String spouseFullName) {
		this.spouseFullName = spouseFullName;
	}
	public void setGender(Gender gender) {
		this.eGender = gender;
	}

	@Override
	public String toString() {
		return "Spouse{" +
				"fullName='" + spouseFullName + '\'' +
				", gender='" + eGender + '\'' +
				'}';
	}
}
