package net.employee_managment.springboot.controller;

import net.employee_managment.springboot.model.GeneralDetails;
import net.employee_managment.springboot.service.GeneralDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/api")
public class GeneralDetailsController {

    @Autowired
    private GeneralDetailsService generalDetailsService;

//    public GeneralDetailsController(GeneralDetailsService generalDetailsService) {
//        super();
//        this.generalDetailsService = generalDetailsService;
//    }

    // displaying list of all general_details
        @GetMapping("/general_details")
        public List<GeneralDetails> getAllGeneralDetails(){
            return generalDetailsService.getAllGeneralDetails();
        }


        // displaying general_details by id
        @GetMapping("/general_details/{id}")
        public GeneralDetails getGeneralDetails(@PathVariable int id){
            return generalDetailsService.getGeneralDetailsById(id);
        }

        @PostMapping("/general_details")
        public ResponseEntity<GeneralDetails> saveGeneralDetails(@RequestBody GeneralDetails generalDetails){
            System.out.println(generalDetails);
            return new ResponseEntity<GeneralDetails>(generalDetailsService.saveGeneralDetails(generalDetails), HttpStatus.CREATED);
        }

        //updating general_details by id
        @PutMapping("/general_details/{id}")
        public void updateGeneralDetails(@RequestBody GeneralDetails d, @PathVariable int id){
            generalDetailsService.updateGeneralDetails(d, id);
        }


        // deleting general_details by id
        @DeleteMapping("/general_details/{id}")
        public void deleteGeneralDetails(Long Id){
            generalDetailsService.deleteGeneralDetails(Id);
        }

    //    // updating/ patching general_details by id
//        @PatchMapping("general_details/{id}")
//        public void patchDepartmentByID(@RequestBody GeneralDetails gd, @PathVariable int id) {
//            generalDetailsService(gd, id);
//        }
}