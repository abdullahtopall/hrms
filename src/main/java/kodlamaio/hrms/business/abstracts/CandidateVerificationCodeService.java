package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.Candidate;

public interface CandidateVerificationCodeService extends VerificationCodeService {
	Result add(Candidate candidate);
}
