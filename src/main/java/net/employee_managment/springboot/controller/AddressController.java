

package net.employee_managment.springboot.controller;

import java.util.ArrayList;
import java.util.List;

import net.employee_managment.springboot.model.Address;
import net.employee_managment.springboot.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AddressController {

    @Autowired
    private AddressService addressService;
    public AddressController(AddressService addressService) {
        super();
        this.addressService = addressService;
    }

    // displaying list of all addresses
    @GetMapping("/api/addresses")
    public List<Address> getAllAddress(){
        return addressService.getAllAddress();
    }


    // displaying addresses by id
    @GetMapping("/api/addresses/{id}")
    public Address getAddress(@PathVariable int id){
        return addressService.getAddressById(id);
    }

    // inserting addresses
    @PostMapping("/api/addresses")
    public ResponseEntity<List<Address>> saveAddress(@RequestBody List<Address> addresses){
        System.out.println("postaddress");
        System.out.println(addresses);
//        List<Address> list = new ArrayList<Address>();
//        for (  Address l: addresses) {
//            list.add( (Address) addressService.saveAddress(l));
//        }
        return new ResponseEntity<List<Address>>(addressService.saveAddresses(addresses), HttpStatus.CREATED);
    }

    //updating addresses by id
    @PutMapping("/api/addresses/{id}")
    public void updateAddress(@RequestBody Address address, @PathVariable int id){
        System.out.println(address);
        addressService.updateAddress(address, id);
    }

    // deleting addresses by id
    @DeleteMapping("/api/addresses/{id}")
    public void deleteAddress(Long Id){
        addressService.deleteAddress(Id);
    }

}