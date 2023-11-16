package com.example.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hrms.entities.concretes.EmployeeConfirm;

public interface EmployeeConfirmDao extends JpaRepository<EmployeeConfirm, Integer> {

}
