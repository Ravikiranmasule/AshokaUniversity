package com.ashokclass.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ashokclass.binding.LoginForm;
import com.ashokclass.binding.SignUpForm;
import com.ashokclass.binding.UnlockForm;
import com.ashokclass.service.UserService;

@Controller
public class UserController {
	@Autowired
	UserService userService;

	@GetMapping("/signUp")
	public String signUpPage(Model model) {
		model.addAttribute("user", new SignUpForm());
		return "signUp";
	}

	@PostMapping("/signUp")
	public String handleSignUp(SignUpForm form, Model model) {
		boolean status = userService.signUp(form);
		if (status) {
			model.addAttribute("succMsg", "Account created !  Check your email");
		} else {
			model.addAttribute("errorMsg", "choose unique email");
		}
		model.addAttribute("user", new SignUpForm());
		return "signUp";
	}

	@GetMapping("/unlock")
	public String unlockPage(@RequestParam String email, Model model) {
		UnlockForm form = new UnlockForm();
		form.setUserEmail(email);
		model.addAttribute("unlock", form);

		return "unlock";
	}

	@PostMapping("/unlock")
	public String unlockUserAccount(@ModelAttribute("unlock") UnlockForm form, Model model) {

		if (form.getNewPassword().equals(form.getConfirmPassword())) {
			boolean isUnlock = userService.unlockAccount(form);

			if (isUnlock) {
				model.addAttribute("succMsg", "Your account unlocked successfully ! ");
			} else {
				model.addAttribute("errMsg", "Given temporory password is incorrect");
			}
		} else {
			model.addAttribute("errMsg", "Confirm password should be same of new password");

		}

		return "unlock";
	}

	@GetMapping("/login")
	public String loginPage(Model model) {
		model.addAttribute("loginForm", new LoginForm());
		return "login";
	}

	@PostMapping("/login")
	public String login(@ModelAttribute("loginForm") LoginForm loginForm, Model model) {
		String msg = userService.login(loginForm);
		if (msg.equals("success")) {
			 return "redirect:/dashboard";
		}
          model.addAttribute("errorMsg",msg);
		
		return "login";
	}

	@GetMapping("/forgotPwd")
	public String forgotPwdPage() {
		return "forgotPwd";
	}
	
	@PostMapping("/forgotPwd")
	public String forgotPwd(@RequestParam String email,Model model) {
		boolean msg = userService.forgetPwd(email);
		if(msg) {
			model.addAttribute("succMsg","Check your mail");
		}
		else {
			model.addAttribute("errorMsg","Invalid email");
		}
		return "forgotPwd";
	}

}
