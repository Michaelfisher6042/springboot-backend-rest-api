package net.employee_managment.springboot.service;

import net.employee_managment.springboot.model.Child;

import java.util.List;

public interface ChildService {
    Child saveChild(Child child);
    List<Child> saveChildren(List<Child> children);
    List<Child> getAllChild();
    Child getChildById(long id);
    //Spouse addSpouse(Spouse s);
    Child updateChild(Child s, long id);
    void deleteChild(long id);
}