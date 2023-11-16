package com.example.hrms.business.abstracts;

import java.util.List;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.EmployeeConfirm;

public interface EmployeeConfirmService {
	DataResult<List<EmployeeConfirm>> getAll();
	Result add(EmployeeConfirm employeeConfirm);
}
