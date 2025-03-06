package org.springboot.addressbook.Services;

import org.springboot.addressbook.Entities.EmployeeEntity;
import org.springboot.addressbook.Interfaces.IEmployeeInterface;
import org.springboot.addressbook.Repositories.EmployeeRepositories;
import org.springboot.addressbook.dto.EmployeeDTO;
import org.springboot.addressbook.dto.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeInterface {

    @Autowired
    EmployeeRepositories employeeRepositories;

    public ResponseDTO ressponseDTO(String message, String status){
        return new ResponseDTO(message,status);
    }

    @Override
    public EmployeeDTO updateAddress(EmployeeDTO employeeDTO, Long id) {
        EmployeeEntity foundEmp = employeeRepositories.findById(id).orElseThrow(() -> new RuntimeException("Employee Not Found"));
        foundEmp.setName(employeeDTO.getName());
        foundEmp.setEmail(employeeDTO.getEmail());
        EmployeeEntity updatedEmp = employeeRepositories.save(foundEmp);
        EmployeeDTO resultDTO = new EmployeeDTO(updatedEmp.getName(), updatedEmp.getEmail(), updatedEmp.getId());
        return resultDTO;
    }

    @Override
    public String deleteAddress(Long id) {
        EmployeeEntity foundEmp = employeeRepositories.findById(id).orElseThrow(() -> new RuntimeException("Employee Not Found"));
        employeeRepositories.delete(foundEmp);
        return "Employee Deleted";
    }

    @Override
    public String cleatAllEmployee() {
        employeeRepositories.deleteAll();
        return "All Employee Cleated";
    }

    public EmployeeDTO getEmployeeById(Long id) {
        EmployeeEntity foundEmp = employeeRepositories.findById(id).orElseThrow(() -> new RuntimeException("Employee Not Found"));
        EmployeeDTO resultDTO = new EmployeeDTO(foundEmp.getName(), foundEmp.getEmail(), foundEmp.getId());
        return resultDTO;
    }
    public EmployeeDTO createaddressBook(EmployeeDTO employeeDTO,Long id) {
        EmployeeEntity employeeEntity = new EmployeeEntity(employeeDTO.getName(), employeeDTO.getEmail(), id);
        EmployeeEntity savedEmployee = employeeRepositories.save(employeeEntity);
        EmployeeDTO resultDTO = new EmployeeDTO(savedEmployee.getName(), savedEmployee.getEmail(), savedEmployee.getId());
                return resultDTO;
    }

    @Override
    public List<EmployeeDTO> displayAllEmployee() {
       return employeeRepositories.findAll().stream().map(employeeEntity -> new EmployeeDTO(employeeEntity.getName(), employeeEntity.getEmail(), employeeEntity.getId())).toList();
    }
}

