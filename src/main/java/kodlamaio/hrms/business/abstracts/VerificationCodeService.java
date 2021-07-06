package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.result.Result;

public interface VerificationCodeService {
	String createCode();
	Result verifyEmail(String code, int userId);
}
