package org.springboot.addressbook.Repositories;

import org.springboot.addressbook.Entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepositories extends JpaRepository<EmployeeEntity,Long> {
    public EmployeeEntity findByEmail(String email);
}
