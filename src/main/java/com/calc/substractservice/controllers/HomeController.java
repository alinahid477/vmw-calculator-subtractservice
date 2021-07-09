package com.calc.substractservice.controllers;


import com.calc.substractservice.responseObjects.GenericResponseObject;
import com.calc.substractservice.services.SubstractService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RestController(value = "/")
public class HomeController {

    @Autowired
    private SubstractService subtractService;

    @RequestMapping(value="", method=RequestMethod.GET)
    public ResponseEntity<GenericResponseObject> index() {
        
        return new ResponseEntity<>(new GenericResponseObject(){ { setSuccess(true); setMessage("Hello from subtract service. Thanks"); } }, 
            HttpStatus.OK);     
    }


    @RequestMapping(value="healthcheck", method=RequestMethod.GET)
    public ResponseEntity<GenericResponseObject> healthCheck() {
        
        return new ResponseEntity<>(new GenericResponseObject(){ { setSuccess(true); setMessage("substract running. Thanks"); } }, 
            HttpStatus.OK);     
    }


    @RequestMapping(value="subtract", method=RequestMethod.POST)
    public ResponseEntity<GenericResponseObject> subtract(@RequestParam String a, @RequestParam String b) throws NumberFormatException, InterruptedException {
        final String sum;
        double x = this.subtractService.subtract(Double.parseDouble(a), Double.parseDouble(b));
        if(x % 1 == 0) {
            sum = "" + (int)x;
        } else {
            sum = "" + x;
        }
        Thread.sleep(5000);
        return new ResponseEntity<>(new GenericResponseObject(){ { setSuccess(true); setMessage(sum); } }, 
            HttpStatus.OK);     
    }
    


}
