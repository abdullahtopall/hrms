package com.example.hrms.core.utilities.adapters.mernis;

import org.springframework.stereotype.Service;

@Service
public class FakeMernisService implements MernisService {

	@Override
	public boolean isRealPerson(String firstName, String lastName, String identificationNumber,
			String birthYear) {
		return true;
	}

}
