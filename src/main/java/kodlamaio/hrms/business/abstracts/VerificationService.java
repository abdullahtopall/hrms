package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.result.Result;

public interface VerificationService {
	Result sendMail(String email, String code);
}
