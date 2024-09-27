package org.kdu.homework.controllers;


import org.kdu.homework.entities.Tenant;
import org.kdu.homework.services.TenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tenant")
public class TenantController {

    private final TenantService tenantService;

    @Autowired
    public TenantController(TenantService tenantService) {
        this.tenantService = tenantService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<String> getAllTenants(){
        return new ResponseEntity<>(tenantService.getAllTenants().toString(), HttpStatus.OK);
    }




}
