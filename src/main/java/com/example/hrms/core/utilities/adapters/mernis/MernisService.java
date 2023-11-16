package com.example.hrms.core.utilities.adapters.mernis;


public interface MernisService {
	boolean isRealPerson(String firstName, String lastName, String identificationNumber,
			String birthYear);
}
