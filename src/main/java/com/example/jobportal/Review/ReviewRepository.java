package com.example.jobportal.Review;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Reviews,Long>
{


    List<Reviews> findByCompany_Companyid(Long companyid);
    //List<Reviews> findByCompanyid(Long companyid);
}
