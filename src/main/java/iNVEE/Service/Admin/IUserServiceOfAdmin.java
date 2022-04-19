package iNVEE.Service.Admin;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iNVEE.Entity.Products;
import iNVEE.Entity.Users;

@Service
public interface IUserServiceOfAdmin {
	@Autowired
	public List<Users> GetDataCustomer();
	public List<Users> GetDataEmployee();
	public Users CheckAccount(Users user);
	public Users CheckAccountAdmin(Users user);
	public int AddAccountAdmin(Users user);
	public Users FindEmployeeByID(String id);
	public int ActiveEmployee(String id, HttpSession session);
	public Users FindCustomerByID(String id);
	public int UpdateProfileEmployee(Users user, HttpSession session);
	public int UpdateUser(Users user,String id, HttpSession session);
	public int DeleteUser(String id);
}
