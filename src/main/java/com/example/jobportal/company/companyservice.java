package com.example.jobportal.company;

import java.util.List;

public interface companyservice{
    List<company> getcompanyAll();
    void createcomapny(company company);

    boolean updatecompany(Long id, company company);

    void deleteCompany(Long id);
}
