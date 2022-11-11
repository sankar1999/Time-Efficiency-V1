package com.time.efficiency.controller;

import com.time.efficiency.entity.Company;
import com.time.efficiency.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping("/beginBulkTest")
    public void beginBulkTest() {
        companyService.beginBulkTest();
    }
}
