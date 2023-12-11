package com.sistema.api.Models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "LoginDTO", description = "Esta clase maneja LoginDTO")
public class LoginDTO {
	@ApiModelProperty(value = "usernameOrEmail", required = true, dataType = "String", example = "000", position = 1)
	private String usernameOrEmail;
	@ApiModelProperty(value = "password", required = true, dataType = "String", example = "000", position = 2)
	private String password;

	public String getUsernameOrEmail() {
		return usernameOrEmail;
	}

	public void setUsernameOrEmail(String usernameOrEmail) {
		this.usernameOrEmail = usernameOrEmail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
