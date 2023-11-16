package com.example.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hrms.business.abstracts.JobSeekerService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.JobSeeker;

@RestController
@RequestMapping("api/jobseekers")
public class JobSeekersControllers {
	
	private JobSeekerService jobSeekerService;

	public JobSeekersControllers(JobSeekerService jobSeekerService) {
		super();
		this.jobSeekerService = jobSeekerService;
	}
	
	@GetMapping("/all")
	public DataResult<List<JobSeeker>> getAll() {
		return jobSeekerService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(JobSeeker jobSeeker) {
		return jobSeekerService.add(jobSeeker);
	}
	
}
