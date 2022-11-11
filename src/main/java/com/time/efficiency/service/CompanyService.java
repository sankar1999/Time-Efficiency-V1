package com.time.efficiency.service;

import com.time.efficiency.entity.Company;
import com.time.efficiency.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository repository;

    List<Company> companies = new ArrayList<>();

    public void beginBulkTest() {

        int beginTimeWithoutItr;
        int endTimeWithoutItr;

        int beginTimeWithItr;
        int endTimeWithItr;

        // Bulk insert at a time
        // **** Begin Time
        beginTimeWithoutItr = (int) System.currentTimeMillis();

       for (int i =1; i<=500; i++) {
           Company company = new Company();
           company.setId(""+i);
           company.setName("Tesla"+i);
           company.setCountry("USA"+i);
           companies.add(company);
       }
        // Test Actions for Bulk insert at a time
        repository.saveAll(companies);
        endTimeWithoutItr = (int) System.currentTimeMillis() - beginTimeWithoutItr;
        // *** End Time
        // End Test Actions for Bulk insert at a time

       // Bulk insert with iteration
        // *** Begin Time
        beginTimeWithItr = (int) System.currentTimeMillis();
        // ****
        for (int i=501; i<=1000; i++) {
            Company company = new Company();
            company.setId(""+i);
            company.setName("Tesla"+i);
            company.setCountry("USA"+i);
            repository.save(company);
        }

        // ****
        endTimeWithItr = (int) System.currentTimeMillis() - beginTimeWithItr;

        System.out.print("Bulk insert without Iteration Time taken : ");
        System.out.println(endTimeWithoutItr);

        System.out.print("Bulk insert with Iteration Time taken :  ");
        System.out.println(endTimeWithItr);

    }
}
