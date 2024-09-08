package com.example.demo.form;

import lombok.Data;

// gettser setter を用意してくれる

/**
 * ログイン画面
 *  
 * @author ys-fj
 *
 */
@Data
public class LoginForm {
	/** ログインID */
	private String loginId;
	/** パスワード */
	private String password;

}
