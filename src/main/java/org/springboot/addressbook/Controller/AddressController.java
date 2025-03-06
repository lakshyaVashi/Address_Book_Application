package org.springboot.addressbook.Controller;

import org.springboot.addressbook.Interfaces.IEmployeeInterface;
import org.springboot.addressbook.dto.EmployeeDTO;
import org.springboot.addressbook.dto.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Qualifier("employeeService")
    @Autowired
    IEmployeeInterface employeeInterface;
    // UC1  --> REST API Using ResponseDTO
    @GetMapping("/get/{id}")
    public ResponseDTO getAddressById1(@PathVariable Long id){
        return new ResponseDTO("Success API Triggered Get Address {id}", "Success");

    }
    @PostMapping("/create")
    public ResponseDTO createAddress1(@RequestBody EmployeeDTO employeeDTO){
        return new ResponseDTO("Success API Triggered Create {id}", "Success");
    }
    @GetMapping("/displayall")
    public ResponseDTO displayAllAddress1(){
        return new ResponseDTO("Success API Triggered Display All Address", "Success");
    }
    @PutMapping("/update/{id}")
    public ResponseDTO updateAddress1(@RequestBody EmployeeDTO employeeDTO, @PathVariable Long id){
        return new ResponseDTO("Success API Triggered Update {id}", "Success");
    }
    @GetMapping("/delete/{id}")
    public ResponseDTO deleteAddress1(@PathVariable Long id){
        return new ResponseDTO("Success API Triggered Delete {id}", "Success");
    }



    // UC 2--- Using Interface CRUD Operation Without Using DataBases
    @GetMapping("api1/get/{id}")
    public ResponseDTO getAddressById(@PathVariable Long id){
        return employeeInterface.ressponseDTO("Success API Triggered Get Address {id}", "Success");
    }

    @PostMapping("api1/create")
    public ResponseDTO createAddress(@RequestBody EmployeeDTO employeeDTO){
        return employeeInterface.ressponseDTO("Success API Triggered Create {id}", "Success");
    }
    @GetMapping("api1/displayall")
    public ResponseDTO displayAllAddress(){
        return employeeInterface.ressponseDTO("Success API Triggered Display All Address", "Success");
    }
    @PutMapping("api1/update/{id}")
    public ResponseDTO updateAddress(@RequestBody EmployeeDTO employeeDTO, @PathVariable Long id){
        return employeeInterface.ressponseDTO("Success API Triggered Update {id}", "Success");
    }
    @GetMapping("api1/delete/{id}")
    public ResponseDTO deleteAddress(@PathVariable Long id){
        return employeeInterface.ressponseDTO("Success API Triggered Delete {id}", "Success");
    }



}
