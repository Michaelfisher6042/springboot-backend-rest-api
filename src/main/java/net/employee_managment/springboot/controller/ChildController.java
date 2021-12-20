

package net.employee_managment.springboot.controller;

import net.employee_managment.springboot.model.Child;
import net.employee_managment.springboot.service.ChildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class ChildController {

    @Autowired
    private ChildService childService;
    public ChildController(ChildService childService) {
        super();
        this.childService = childService;
    }

    // displaying list of all addresses
    @GetMapping("/children")
    public List<Child> getAllChildren(){
        return childService.getAllChild();
    }


    // displaying addresses by id
    @GetMapping("/children/{id}")
    public Child getChild(@PathVariable int id){
        return childService.getChildById(id);
    }

    // inserting addresses
    @PostMapping("/children")
    public ResponseEntity<List<Child>> saveChild(@RequestBody List<Child> children){
        System.out.println(children);
//        List<Child> list = new ArrayList<Child>();
//        for (  Child l: children) {
//            list.add( (Child) childService.saveChild(l));
//        }
        return new ResponseEntity<List<Child>>(childService.saveChildren(children), HttpStatus.CREATED);
    }

    //updating addresses by id
    @PutMapping("/children/{id}")
    public void updateChild(@RequestBody Child child, @PathVariable int id){
        childService.updateChild(child, id);
    }

    // deleting addresses by id
    @DeleteMapping("/children/{id}")
    public void deleteChild(Long Id){
        childService.deleteChild(Id);
    }

}