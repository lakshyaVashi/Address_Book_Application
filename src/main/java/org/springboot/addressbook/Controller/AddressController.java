package org.springboot.addressbook.Controller;

import org.springboot.addressbook.dto.EmployeeDTO;
import org.springboot.addressbook.dto.ResponseDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/address")
public class AddressController {
    @GetMapping("/get/{id}")
    public ResponseDTO getAddressById(@PathVariable Long id){
        return new ResponseDTO("Success API Triggered Get Address {id}", "Success");

    }
    @PostMapping("/create")
    public ResponseDTO createAddress(@RequestBody EmployeeDTO employeeDTO){
        return new ResponseDTO("Success API Triggered Create {id}", "Success");
    }
    @GetMapping("/displayall")
    public ResponseDTO displayAllAddress(){
        return new ResponseDTO("Success API Triggered Display All Address", "Success");
    }
    @PutMapping("/update/{id}")
    public ResponseDTO updateAddress(@RequestBody EmployeeDTO employeeDTO, @PathVariable Long id){
        return new ResponseDTO("Success API Triggered Update {id}", "Success");
    }
    @GetMapping("/delete/{id}")
    public ResponseDTO deleteAddress(@PathVariable Long id){
        return new ResponseDTO("Success API Triggered Delete {id}", "Success");
    }

}
