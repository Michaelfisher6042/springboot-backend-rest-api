package net.employee_managment.springboot.service.impl;

import net.employee_managment.springboot.exception.ResourceNotFoundException;
import net.employee_managment.springboot.model.*;
import net.employee_managment.springboot.repository.*;
import net.employee_managment.springboot.service.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService, SpouseService, AddressService, ChildService , GeneralDetailsService{


	private EmployeeRepository employeeRepository;
	private GeneralDetailsRepository generalDetailsRepository;
	private SpouseRepository spouseRepository;
	private AddressRepository addressRepository;
	private ChildRepository childRepository;


	public EmployeeServiceImpl(EmployeeRepository employeeRepository, GeneralDetailsRepository generalDetailsRepository,SpouseRepository spouseRepository,
							   AddressRepository addressRepository, ChildRepository childRepository) {
		super();
		this.employeeRepository = employeeRepository;
		this.generalDetailsRepository = generalDetailsRepository;
		this.spouseRepository = spouseRepository;
		this.addressRepository = addressRepository;
		this.childRepository = childRepository;
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		System.out.println(employee);
		System.out.println("employeeservice");
		return employeeRepository.save(employee);
	}

	@Override
	public void addEmployees(Employee e){
		employeeRepository.save(e);
	}
	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(long id) {

		return employeeRepository.findById(id).orElseThrow(() ->
						new ResourceNotFoundException("employee", "id", id));

	}

	@Override
	public Employee updateEmployee(Employee employee, long id) {
		
		// we need to check whether employee with given id is exist in DB or not
		Employee existingEmployee = employeeRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("employee", "id", id));
		if (employee.getAddress() != null)
			for (Address A: employee.getAddress()) {
				updateAddress(A,A.getAddress_ID());
			}

		if (employee.getChildren() != null)
			for (Child C: employee.getChildren()) {
				updateChild(C, C.getChild_ID());
			}

		existingEmployee.setGeneralDetails(employee.getGeneralDetails());
		existingEmployee.setSpouse(employee.getSpouse());

		employeeRepository.save(existingEmployee);
		System.out.println("existingEmployee");
		System.out.println(existingEmployee);


		return existingEmployee;
	}

	@Override
	public void deleteEmployee(long id) {
		
		// check whether a employee exist in a DB or not
		Employee existingEmployee = employeeRepository.findById(id).orElseThrow(() ->
								new ResourceNotFoundException("employee", "id", id));
		//existingEmployee.getChild().remove(getAllChild());
		for (Address A: existingEmployee.getAddress()) {
			deleteAddress(A.getAddress_ID());
		}

		for (Child C: existingEmployee.getChildren()) {
			deleteChild(C.getChild_ID());
		}


		long gdId = existingEmployee.getGeneralDetails().getGeneral_details_id();
		long sId = existingEmployee.getSpouse().getSpouse_id();
		employeeRepository.deleteById(id);
		generalDetailsRepository.deleteById(gdId);
		spouseRepository.deleteById(sId);

		//addressRepository.delete(existingEmployee.getAddress());


	}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	@Override
	public GeneralDetails saveGeneralDetails(GeneralDetails generalDetails) {
//		System.out.println("saveGeneralDetails");
//		System.out.println(generalDetails);
		return generalDetailsRepository.save(generalDetails);
	}

	@Override
	public List<GeneralDetails> getAllGeneralDetails() {
		return generalDetailsRepository.findAll();
	}

	@Override
	public GeneralDetails getGeneralDetailsById(long id) {
		return generalDetailsRepository.findById(id).orElseThrow(() ->
				new ResourceNotFoundException("GeneralDetails", "general_details_id", id));
	}


	@Override
	public GeneralDetails updateGeneralDetails(GeneralDetails generalDetails,  long id) {
		GeneralDetails existingGeneralDetails = generalDetailsRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("GeneralDetails", "general_details_id", id));
		System.out.println(generalDetails);
		existingGeneralDetails.setGeneral_details_id(generalDetails.getGeneral_details_id());
		existingGeneralDetails.setFullName(generalDetails.getFullName());
		existingGeneralDetails.setEmployeeLevel(generalDetails.getEmployeeLevel());
		existingGeneralDetails.setEmail(generalDetails.getEmail());
		generalDetailsRepository.save(existingGeneralDetails);
		return existingGeneralDetails;
	}

	@Override
	public void deleteGeneralDetails(long id) {
		generalDetailsRepository.findById(id).orElseThrow(() ->
				new ResourceNotFoundException("GeneralDetails", "general_details_id", id));
		generalDetailsRepository.deleteById(id);
	}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public Spouse saveSpouse(Spouse spouse) {
//		System.out.println(spouse);
		return spouseRepository.save(spouse);
	}

	@Override
	public List<Spouse> getAllSpouse() {
		return spouseRepository.findAll();
	}

	@Override
	public Spouse getSpouseById(long id) {
		return spouseRepository.findById(id).orElseThrow(() ->
				new ResourceNotFoundException("spouse", "spouse_id", id));
	}

	@Override
	public Spouse updateSpouse(Spouse s, long id) {
		Spouse existingSpouse = spouseRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("spouse", "spouse_id", id));

		existingSpouse.setSpouse_id(s.getSpouse_id());
		existingSpouse.setSpouseFullName(s.getSpouseFullName());
		existingSpouse.setGender(s.getGender());
		spouseRepository.save(existingSpouse);
		return existingSpouse;
	}

	@Override
	public void deleteSpouse(long id) {
		spouseRepository.findById(id).orElseThrow(() ->
				new ResourceNotFoundException("spouse", "spouse_id", id));
		spouseRepository.deleteById(id);
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	@Override
	public Address saveAddress(Address address) {
		//System.out.println(address);
		return addressRepository.save(address);
	}
	@Override
	public List<Address> saveAddresses(List<Address> addresses){
		return addressRepository.saveAll(addresses);
	}

	@Override
	public List<Address> getAllAddress() {
		return  addressRepository.findAll();
	}

	@Override
	public Address getAddressById(long id) {
		return addressRepository.findById(id).orElseThrow(() ->
				new ResourceNotFoundException("addresses", "address_id", id));
	}

	@Override
	public Address updateAddress(Address s, long id) {
		Address existingAddress = addressRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("addresses", "address_id", id));
		existingAddress.setAddress_ID(s.getAddress_ID());
		existingAddress.setFullAddress(s.getFullAddress());
		addressRepository.save(existingAddress);
		return existingAddress;
	}

	@Override
	public void deleteAddress(long id) {
		addressRepository.findById(id).orElseThrow(() ->
				new ResourceNotFoundException("addresses", "address_id", id));
		addressRepository.deleteById(id);
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	@Override
	public Child saveChild(Child child) {
		System.out.println(child);
		return childRepository.save(child);
	}

	@Override
	public List<Child> saveChildren(List<Child> children){
		return childRepository.saveAll(children);
	}

	@Override
	public List<Child> getAllChild() {
		return childRepository.findAll();
	}

	@Override
	public Child getChildById(long id) {
		return childRepository.findById(id).orElseThrow(() ->
				new ResourceNotFoundException("child", "child_id", id));
	}


	@Override
	public Child updateChild(Child c, long id) {
		Child existingChild = childRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("child", "child_id", id));
		existingChild.setChild_ID(c.getChild_ID());
		existingChild.setChildFullName(c.getChildFullName());
		existingChild.setAge(c.getAge());
		childRepository.save(existingChild);
		return existingChild;
	}

	@Override
	public void deleteChild(long id) {
		childRepository.findById(id).orElseThrow(() ->
				new ResourceNotFoundException("child", "child_id", id));
		childRepository.deleteById(id);
	}
}
