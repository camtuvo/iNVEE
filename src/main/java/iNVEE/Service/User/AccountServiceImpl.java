package iNVEE.Service.User;

import java.text.ParseException;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iNVEE.Dao.UserDao;
import iNVEE.Entity.Users;

@Service
public class AccountServiceImpl implements IAccountService {
	@Autowired
	private UserDao userDao = new UserDao();

	public int AddAccount(Users user)  {
		user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(12)));
		return userDao.AddAccount(user);

	}

	public Users CheckAccount(Users user) {
		String pass = user.getPassword();
		user = userDao.GetAccount(user);
		if(user != null ) {
			if(BCrypt.checkpw(pass, user.getPassword())) {
				return user;
			}
			else {
				return null;
			}	
		}
		return null;
	}

}
