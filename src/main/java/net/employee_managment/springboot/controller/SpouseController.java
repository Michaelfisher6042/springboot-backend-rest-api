

package net.employee_managment.springboot.controller;

import java.util.List;

import net.employee_managment.springboot.model.Spouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import net.employee_managment.springboot.service.SpouseService;


@RestController
@RequestMapping("/api")
public class SpouseController {

    @Autowired
    private SpouseService spouseService;
    public SpouseController(SpouseService spouseService) {
        super();
        this.spouseService = spouseService;
    }

    // displaying list of all Spouses
    @GetMapping("/spouse")
    public List<Spouse> getAllSpouse(){
        return spouseService.getAllSpouse();
    }


    // displaying Spouse by id
    @GetMapping("/spouse/{id}")
    public Spouse getSpouse(@PathVariable int id){
        return spouseService.getSpouseById(id);
    }

    // inserting Spouse
    @PostMapping("/spouse")
    public ResponseEntity<Spouse> saveSpouse(@RequestBody Spouse spouse){
        System.out.println(spouse);
        return new ResponseEntity<Spouse>(spouseService.saveSpouse(spouse), HttpStatus.CREATED);
    }

    //updating Spouse by id
    @PutMapping("/spouse/{id}")
    public void updateSpouse(@RequestBody Spouse s, @PathVariable int id){
        spouseService.updateSpouse(s, id);
    }

    // deleting Spouse by id
    @DeleteMapping("/spouse/{id}")
    public void deleteSpouse(Long Id){
        spouseService.deleteSpouse(Id);
    }

}