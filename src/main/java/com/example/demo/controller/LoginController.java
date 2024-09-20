package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.form.LoginForm;
import com.example.demo.service.LoginService;

import lombok.RequiredArgsConstructor;

/**
 * ログイン画面 Controller
 * 
 * @author miyakesaki
 *
 */

@Controller
@RequiredArgsConstructor
public class LoginController {
	/**ログイン画面 Service */
	private final LoginService service;
	/**
	 * 初期表示
	 * @param model モデル
	 * @param form 入力情報
	 * @return 表示画面
	 */
	@GetMapping("/login")
	public String view(Model model, LoginForm form) {
		
		return "login"; //login.htmlをする
	}
	
	/**
	 * 初期表示
	 * 
	 * @param model モデル
	 * @param form 入力情報(ログインIDとパスワード)
	 * @return 表示画面
	 */
	
	// HTTPのPOSTリクエストを受け取るためのアノテーション
	@PostMapping("/login")
	public String login(Model model, LoginForm form) {
		// ログインIDに基づいてユーザー情報をデータベースから取得するメソッド
		// LoginService クラスの searchUserById メソッドを呼び出して、Optional<UserInfo> を返します
		var userInfo = service.searchUserById(form.getLoginId());
		// userInfo.isPresent() は、Optional に値が存在するかどうかを確認
		var isCorrectUserAuth = userInfo.isPresent() 
				// フォームで入力されたパスワードと、データベースに保存されているパスワードが
				 //   一致するかを確認。
				&& form.getPassword().equals(userInfo.get().getPassword());
		if(isCorrectUserAuth) {
			return "redirect:/menu";
		}else {
			model.addAttribute("errorMsg","IDとPASSの組み合わせが間違っています。");
			return "login";
		}
	}
}


