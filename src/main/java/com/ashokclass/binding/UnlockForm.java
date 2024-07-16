package com.ashokclass.binding;

import lombok.Data;

@Data
public class UnlockForm {
	
	private String tempPassword;
	private String userEmail;
	private String newPassword;
	private String confirmPassword;

}
