package org.springboot.addressbook.Interfaces;

import org.springboot.addressbook.dto.EmployeeDTO;
import org.springboot.addressbook.dto.ResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IEmployeeInterface {
    public EmployeeDTO getEmployeeById(Long id);
    public EmployeeDTO createaddressBook(EmployeeDTO employeeDTO,Long id);
    public List<EmployeeDTO> displayAllEmployee();
    public ResponseDTO ressponseDTO(String message, String status);
    public EmployeeDTO updateAddress(EmployeeDTO employeeDTO, Long id);
    public String deleteAddress(Long id);
    public String cleatAllEmployee();

}
