package com.ashokclass.service;

import com.ashokclass.binding.LoginForm;
import com.ashokclass.binding.SignUpForm;
import com.ashokclass.binding.UnlockForm;

public interface UserService {
	public String login(LoginForm form);
	public boolean signUp(SignUpForm form);
	public boolean unlockAccount(UnlockForm form);
	public boolean forgetPwd(String email);

}
