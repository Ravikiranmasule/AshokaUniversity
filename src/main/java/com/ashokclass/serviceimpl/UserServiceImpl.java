package com.ashokclass.serviceimpl;

import org.hibernate.sql.Template;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashokclass.binding.LoginForm;
import com.ashokclass.binding.SignUpForm;
import com.ashokclass.binding.UnlockForm;
import com.ashokclass.entity.UserDetailsEntity;
import com.ashokclass.repository.UserDetailsRepository;
import com.ashokclass.service.UserService;
import com.ashokclass.util.EmailUtils;
import com.ashokclass.util.PasswordUtils;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserDetailsRepository userDetailsRepository;
	@Autowired
	EmailUtils mailUtil;

	@Override
	public String login(LoginForm form) {
		UserDetailsEntity entity = userDetailsRepository.findByUserEmailAndUserPassword(form.getUserEmail(), form.getUserPassword());
		if(entity==null) {
			return "Wrong Credentials !";
		}
		if(entity.getAccountStatus().equals("LOCKED")) {
			return " Your account is locked";
		}
		
		return "success";
	}

	@Override
	public boolean signUp(SignUpForm form) {
		UserDetailsEntity byUserEmail = userDetailsRepository.findByUserEmail(form.getUserEmail());
		if(byUserEmail!=null) {
			return false;
		}

		UserDetailsEntity entity = new UserDetailsEntity();
		BeanUtils.copyProperties(form, entity);

		String tempPwd = PasswordUtils.generateRandomPassword();
		entity.setUserPassword(tempPwd);
		entity.setAccountStatus("LOCKED");
		userDetailsRepository.save(entity);
		String to = form.getUserEmail();
		String sub = "Unlock your account  | Ashoka University";
		StringBuffer body = new StringBuffer(" ");
		body.append("<h2>Unlock your account using below temporary password</h2>");
		body.append("Temporary password is: " + tempPwd);
		body.append("<br/>");
		body.append("<a href=\"http://localhost:9090/unlock?email=" + to + "\">click here to unlock your account</a>");
//body.append("<a href=\"unlock?email="+to+"\">Click here to unlock your account<a>");

		mailUtil.sendMail(to, sub, body.toString());

		return true;
	}

	@Override
	public boolean unlockAccount(UnlockForm form) {
		UserDetailsEntity entity = userDetailsRepository.findByUserEmail(form.getUserEmail());
		if(form.getTempPassword().equals(entity.getUserPassword())) {
			entity.setUserPassword(form.getConfirmPassword());
			entity.setAccountStatus("UNLOCKED");
			userDetailsRepository.save(entity);
			return true;
		}
		else {
		return false;}
	}

	@Override
	public boolean forgetPwd(String email) {
		UserDetailsEntity entity = userDetailsRepository.findByUserEmail(email);
		if(entity==null) 
		{
			return false;
		}
		String sub="Recover your password ";
		String body="Your password is : "+entity.getUserPassword();
		mailUtil.sendMail(email, sub, body);
		return true;
	}

}
