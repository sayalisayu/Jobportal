package com.example.jobportal.company;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository  extends JpaRepository<company,Long>
{

}
