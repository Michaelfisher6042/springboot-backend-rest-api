package net.employee_managment.springboot.service;

import java.util.List;

import net.employee_managment.springboot.model.GeneralDetails;


public interface GeneralDetailsService {
    GeneralDetails saveGeneralDetails(GeneralDetails generalDetails);
    List<GeneralDetails> getAllGeneralDetails();
    GeneralDetails getGeneralDetailsById(long id);
    // addGeneralDetails(GeneralDetails generalDetails);
    GeneralDetails updateGeneralDetails(GeneralDetails generalDetails, long id);
    void deleteGeneralDetails(long id);

}
