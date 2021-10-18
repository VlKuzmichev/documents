package com.test.documents.web;

import com.test.documents.dao.EmployeeRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmployeeController {

    public EmployeeRepo employeeRepo;

    public EmployeeController(EmployeeRepo employeeRepo){
        this.employeeRepo = employeeRepo;
    }

    @GetMapping(value = "/employees")
    public String showEmployeesList(Model model) {
        model.addAttribute("employees", employeeRepo.getAll());
        return "employees";
    }

//    @RequestMapping(value = "/document")
//    public String helloWorldController(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
//        model.addAttribute("name", name);
//        return "document";
//    }
}
