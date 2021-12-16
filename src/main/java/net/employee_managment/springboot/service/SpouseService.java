package net.employee_managment.springboot.service;

import net.employee_managment.springboot.model.Spouse;

import java.util.List;

public interface SpouseService {
    Spouse saveSpouse(Spouse spouse);
    List<Spouse> getAllSpouse();
    Spouse getSpouseById(long id);
    //Spouse addSpouse(Spouse s);
    Spouse updateSpouse(Spouse s, long id);
    void deleteSpouse(long id);

}
