package org.kdu.homework.controllers.saveEntities;


import org.kdu.homework.entities.Tenant;
import org.kdu.homework.services.TenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping()
    public ResponseEntity<String> addTenant(@RequestBody Tenant tenant) {
        tenantService.addTenant(tenant);
        return new ResponseEntity<>("Tenant added successfully", HttpStatus.CREATED);
    }




}
