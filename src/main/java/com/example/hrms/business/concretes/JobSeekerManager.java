package com.example.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hrms.business.abstracts.JobSeekerService;
import com.example.hrms.core.utilities.adapters.mernis.MernisService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.ErrorResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessDataResult;
import com.example.hrms.core.utilities.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.JobSeekerDao;
import com.example.hrms.entities.concretes.JobSeeker;

@Service
public class JobSeekerManager implements JobSeekerService {
	
	private JobSeekerDao jobSeekerDao;
	private MernisService mernisService;
	
	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao, MernisService mernisService) {
		super();
		this.jobSeekerDao = jobSeekerDao;
		this.mernisService = mernisService;
	}
	
	@Override
	public DataResult<List<JobSeeker>> getAll() {
		return new SuccessDataResult<List<JobSeeker>>(this.jobSeekerDao.findAll(),"İş arayanlar listelendi");
	}
	
	@Override
	public Result add(JobSeeker jobSeeker) {
		if (mernisService.isRealPerson(jobSeeker.getFirstName(), jobSeeker.getLastName(), 
				jobSeeker.getIdentificationNumber(), jobSeeker.getBirthYear())) {
			this.jobSeekerDao.save(jobSeeker);
			return new SuccessResult("İş arayan sisteme eklendi");
		} else {
			return new ErrorResult("İş arayanın bilgileri doğrulanamadı");
		}
	}
	
	

}
