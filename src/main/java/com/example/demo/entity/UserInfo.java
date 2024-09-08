package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * ユーザー情報テーブル Entity
 * 
 * @auther ys-fj
 */
@Entity
// @Table : どのテーブルとリンクしているか。
@Table(name = "user_info")
@Data
public class UserInfo {
	/**ログインID */
	@Id
	@Column(name = "login_id") // TBLとのフィールドの紐付け
	private String loginId;
	
	/**パスワード */
	private String password;
	
}
