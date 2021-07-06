package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.VerificationService;
import kodlamaio.hrms.core.utilities.result.ErrorResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.core.utilities.senders.email.EmailSender;

@Service
public class VerificationCodeManager implements VerificationService {
		
	EmailSender emailSender = new EmailSender();
	
	@Autowired
	public VerificationCodeManager() {
		
	}
	
	@Override
	public Result sendMail(String email, String code) {
		boolean sendEmail = emailSender.sendVerificationCode(email, code);
		if(sendEmail == false) {
			return new ErrorResult();
		} else 
			return new SuccessResult();
	}

}
