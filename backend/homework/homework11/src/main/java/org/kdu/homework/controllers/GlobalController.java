package org.kdu.homework.controllers;


import org.kdu.homework.dto.request.RequestGlobalDTO;
import org.kdu.homework.services.GlobalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/allEntities")
public class GlobalController {

    GlobalService globalService;

    @Autowired
    public GlobalController(GlobalService globalService){
        this.globalService = globalService;
    }
    @PostMapping("")
    public ResponseEntity<String> postAllEntities(@RequestBody RequestGlobalDTO globalDTO){
        globalService.addAllEntities(globalDTO);
        return new ResponseEntity<>("Added successfully", HttpStatus.OK);
    }
}
