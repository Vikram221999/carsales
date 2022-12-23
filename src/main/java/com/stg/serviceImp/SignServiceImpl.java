package com.stg.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.stg.entity.Admin;
import com.stg.entity.User;
import com.stg.exception.UserException;
import com.stg.repository.AdminRepo;
import com.stg.repository.UserRepo;
import com.stg.service.SignServiceInterface;

@Service
public class SignServiceImpl implements SignServiceInterface {

	@Autowired
	private UserRepo repo;

	@Autowired
	private AdminRepo adminRepo;

	@Override
	public String createUserSign(User user) throws UserException {

		if (user != null) {
			User user2 = repo.findByEmail(user.getEmail());
			if (user2 != null) {
				throw new UserException("User Aleady Exist");
			} else {
				if (!user.getUserPassword().matches("[a-zA-Z0-9]{8,20}")) {
					throw new UserException("Invalid Password Pattern");
				}
				if (repo.existsByMobileNumber(user.getMobileNumber())) {
					throw new UserException("Mobile Number Already Exist");
				}
				
				repo.save(user);
			}
		}
		return "\"User Created\"";
	}

	@Override
	public List<User> showUser() {
		List<User> list = repo.findAll();

		return list;
	}

	@Override
	public String createAdmin(Admin admin) throws UserException {

		if (admin != null) {
			if (adminRepo.existsByAdminEmail(admin.getAdminEmail())) {
				throw new UserException("Admin Aleady Exist");
			} else {
				if (!admin.getAdminPassword().matches("[a-zA-Z0-9]{8,20}")) {
					throw new UserException("Invalid Password Pattern");
				}
				adminRepo.save(admin);
			}
		}
		return "Admin Created";

	}

}
