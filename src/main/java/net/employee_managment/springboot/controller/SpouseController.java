

package net.employee_managment.springboot.controller;

import java.util.List;

import net.employee_managment.springboot.model.Spouse;
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

import net.employee_managment.springboot.service.SpouseService;


@RestController
public class SpouseController {

    @Autowired
    private SpouseService spouseService;
    public SpouseController(SpouseService spouseService) {
        super();
        this.spouseService = spouseService;
    }

    // displaying list of all Spouses
    @GetMapping("/api/spouse")
    public List<Spouse> getAllSpouse(){
        return spouseService.getAllSpouse();
    }


    // displaying Spouse by id
    @GetMapping("/api/spouse/{id}")
    public Spouse getSpouse(@PathVariable int id){
        return spouseService.getSpouseById(id);
    }

    // inserting Spouse
    @PostMapping("/api/spouse")
    public ResponseEntity<Spouse> saveSpouse(@RequestBody Spouse spouse){
        System.out.println(spouse);
        return new ResponseEntity<Spouse>(spouseService.saveSpouse(spouse), HttpStatus.CREATED);
    }

    //updating Spouse by id
    @PutMapping("/api/spouse/{id}")
    public void updateSpouse(@RequestBody Spouse s, @PathVariable int id){
        spouseService.updateSpouse(s, id);
    }

    // deleting Spouse by id
    @DeleteMapping("/api/spouse/{id}")
    public void deleteSpouse(Long Id){
        spouseService.deleteSpouse(Id);
    }

}