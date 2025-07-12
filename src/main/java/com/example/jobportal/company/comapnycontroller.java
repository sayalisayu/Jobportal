package com.example.jobportal.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class comapnycontroller {
    @Autowired
    private companyservice companyservice;
    @Autowired
    public void setcompanyservice(companyservice companyservice) {}
    @GetMapping("GetComapines")
    private ResponseEntity<List<company>> getcompany()
    {
        return new ResponseEntity<>(companyservice.getcompanyAll(), HttpStatus.OK);
    }
    @PostMapping("/CreateCompany")
    private ResponseEntity<String> createcompany(@RequestBody company Company)

    {
        companyservice.createcomapny(Company);
        return new ResponseEntity<>("Company created",HttpStatus.OK);
    }
    @PutMapping("/UpdateCompany/{id}")
    private ResponseEntity<String> updatecompany(@PathVariable Long id , @RequestBody company Company)
    {
        boolean Company1= companyservice.updatecompany(id,Company);
        if(Company1)
        return new ResponseEntity<>("Comapny details is updated",HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("DeleteCompany/{id}")
    private ResponseEntity<String> deletecompany(@PathVariable Long id)
    {
        companyservice.deleteCompany(id);
        return new ResponseEntity<>("Company deleted",HttpStatus.OK);
    }
}
