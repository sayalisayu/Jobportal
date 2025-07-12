package com.example.jobportal.company;

import com.example.jobportal.job.jobs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImplComapnyService implements companyservice{
    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public List<company> getcompanyAll() {
        return companyRepository.findAll();
    }

    @Override
    public void createcomapny(company Company) {
        companyRepository.save(Company);

    }

    @Override
    public boolean updatecompany(Long id, company company) {

        Optional<company> Company1 =companyRepository.findById(id);
        if(Company1.isPresent()) {
            company Company12 = Company1.get();
            Company12.setName(company.getName());
            Company12.setDescription(company.getDescription());
            Company12.setJob(company.getJob());
            companyRepository.save(Company12);

            return true;
        }
        return false;
    }

    @Override
    public void deleteCompany(Long id) {
        if(companyRepository.existsById(id)) {
            companyRepository.deleteById(id);
        }
        else{
            System.out.println("Company Not Found");
        }

}
    }
