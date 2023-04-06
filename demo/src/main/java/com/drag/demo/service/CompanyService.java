package com.drag.demo.service;

import com.drag.demo.model.Company;
import com.drag.demo.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyService {
    private final CompanyRepository companyRepository;
    public List<Company> readCompanies() {
        return companyRepository.findAll();
    }
}
