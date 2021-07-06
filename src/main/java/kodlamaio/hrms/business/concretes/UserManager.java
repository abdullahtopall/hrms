package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.utilities.result.ErrorResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.User;

@Service
public class UserManager implements UserService {
	
	private UserDao userDao;
	public UserManager(UserDao userDao) {
		this.userDao=userDao;
	}

	@Override
	public Result emailControl(User user) {
		List<User> users = this.userDao.findByEmail(user.getEmail());
		if(!(users.isEmpty())) {
			return new ErrorResult("Bu e-posta adresi daha önce kaydedilmiş.");
		}
		else {
			return new SuccessResult();
		}
	}

	
	
}
