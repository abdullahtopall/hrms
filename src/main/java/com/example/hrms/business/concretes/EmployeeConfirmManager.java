package com.example.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.hrms.business.abstracts.EmployeeConfirmService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessDataResult;
import com.example.hrms.core.utilities.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.EmployeeConfirmDao;
import com.example.hrms.entities.concretes.EmployeeConfirm;

@Service
public class EmployeeConfirmManager implements EmployeeConfirmService {
	
	private EmployeeConfirmDao employeeConfirmDao;
	
	public EmployeeConfirmManager(EmployeeConfirmDao employeeConfirmDao) {
		super();
		this.employeeConfirmDao = employeeConfirmDao;
	}

	@Override
	public DataResult<List<EmployeeConfirm>> getAll() {
		return new SuccessDataResult<List<EmployeeConfirm>>(this.employeeConfirmDao.findAll(),
				"listelendi");
	}

	@Override
	public Result add(EmployeeConfirm employeeConfirm) {
		this.employeeConfirmDao.save(employeeConfirm);
		return new SuccessResult();
	}

}
