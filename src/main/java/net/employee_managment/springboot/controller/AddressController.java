

package net.employee_managment.springboot.controller;

import net.employee_managment.springboot.model.Address;
import net.employee_managment.springboot.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class AddressController {

    @Autowired
    private AddressService addressService;
    public AddressController(AddressService addressService) {
        super();
        this.addressService = addressService;
    }

    // displaying list of all addresses
    @GetMapping("/addresses")
    public List<Address> getAllAddress(){
        return addressService.getAllAddress();
    }


    // displaying addresses by id
    @GetMapping("/addresses/{id}")
    public Address getAddress(@PathVariable int id){
        return addressService.getAddressById(id);
    }

    // inserting addresses
    @PostMapping("/addresses")
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
    @PutMapping("/addresses/{id}")
    public void updateAddress(@RequestBody Address address, @PathVariable int id){
        System.out.println(address);
        addressService.updateAddress(address, id);
    }

    // deleting addresses by id
    @DeleteMapping("/addresses/{id}")
    public void deleteAddress(Long Id){
        addressService.deleteAddress(Id);
    }

}