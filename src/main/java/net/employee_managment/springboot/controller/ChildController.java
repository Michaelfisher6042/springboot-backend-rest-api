

package net.employee_managment.springboot.controller;

import java.util.ArrayList;
import java.util.List;

import net.employee_managment.springboot.model.Address;
import net.employee_managment.springboot.model.Child;
import net.employee_managment.springboot.service.ChildService;
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
public class ChildController {

    @Autowired
    private ChildService childService;
    public ChildController(ChildService childService) {
        super();
        this.childService = childService;
    }

    // displaying list of all addresses
    @GetMapping("/api/children")
    public List<Child> getAllChildren(){
        return childService.getAllChild();
    }


    // displaying addresses by id
    @GetMapping("/api/children/{id}")
    public Child getChild(@PathVariable int id){
        return childService.getChildById(id);
    }

    // inserting addresses
    @PostMapping("/api/children")
    public ResponseEntity<List<Child>> saveChild(@RequestBody List<Child> children){
        System.out.println(children);
        List<Child> list = new ArrayList<Child>();
        for (  Child l: children) {
            list.add( (Child) childService.saveChild(l));
        }
        return new ResponseEntity<List<Child>>(childService.saveChildren(children), HttpStatus.CREATED);
    }

    //updating addresses by id
    @PutMapping("/api/children/{id}")
    public void updateChild(@RequestBody Child children, @PathVariable int id){
        childService.updateChild(children, id);
    }

    // deleting addresses by id
    @DeleteMapping("/api/children/{id}")
    public void deleteChild(Long Id){
        childService.deleteChild(Id);
    }

}