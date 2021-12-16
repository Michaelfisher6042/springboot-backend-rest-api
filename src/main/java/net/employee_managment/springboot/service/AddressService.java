package net.employee_managment.springboot.service;

import net.employee_managment.springboot.model.Address;

import java.util.List;

public interface AddressService {
    Address saveAddress(Address spouse);
    List<Address> saveAddresses(List<Address> addresses);
    List<Address> getAllAddress();
    Address getAddressById(long id);
    //Spouse addSpouse(Spouse s);
    Address updateAddress(Address s, long id);
    void deleteAddress(long id);
}
