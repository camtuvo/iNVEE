package iNVEE.Service.Admin;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iNVEE.Dao.UserDao;
import iNVEE.Entity.Slides;
import iNVEE.Entity.Users;
@Service
public class UserServiceOfAdminImpl implements IUserServiceOfAdmin {
	@Autowired
	private UserDao userDao;
	
	public List<Users> GetDataCustomer() {
		return userDao.GetDataCustomer();
	}
	public List<Users> GetDataEmployee() {
		return userDao.GetDataEmployee();
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
	public Users CheckAccountAdmin(Users user) {
		String pass = user.getPassword();
		user = userDao.GetAccountAdmin(user);
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
	public int AddAccountAdmin(Users user) {
		return userDao.AddAccountAdmin(user);
	}
	public Users FindEmployeeByID(String id) {
		return userDao.FindEmployeeByID(id);
	}
	public int ActiveEmployee(String id, HttpSession session) {
		return userDao.ActiveEmployee(id, session);
		
	}
	public Users FindCustomerByID(String id) {
		return userDao.FindCustomerByID(id);
	}
	public int UpdateProfileEmployee(Users user, HttpSession session) {
		return userDao.UpdateProfileEmployee(user, session);
	}
	public int UpdateUser(Users user,String id, HttpSession session) {
		return userDao.UpdateUser(user, id, session);
	}
	public int DeleteUser(String id) {
		return userDao.DeleteUser(id);
	}
	

}
