package com.synclab.regenerate.controller;

import com.synclab.regenerate.model.Department;
import com.synclab.regenerate.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    //Methods

    //Method that returns ALL departments
    @GetMapping("/all")
    public ResponseEntity<List<Department>> getAlDepartment(){
        List<Department> departmentList = departmentService.findAllDepartment();
        return new ResponseEntity<>(departmentList, HttpStatus.OK);
    }

    //Method that returns the department NAME associated with the given ID
    @GetMapping("/{id}")
    public ResponseEntity<String> getDepartmentName (@PathVariable("id") Long id) {
        String departmentName = departmentService.findDepartmentById(id);
        return new ResponseEntity<>(departmentName, HttpStatus.OK);
    }

}
