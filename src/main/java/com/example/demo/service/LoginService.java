package com.example.demo.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.UserInfo;
import com.example.demo.repository.UserInfoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoginService {
	
	/** ユーザー情報テーブル DAO */
	private final UserInfoRepository repository;
	
	/**
	 * ユーザー情報テーブルキー検索
	 * @param loginId ログインID
	 * @return　ユーザー情報テーブルキーを検索した検索結果(1件)
	 */
	public Optional<UserInfo> searchUserById(String loginId){
		return repository.findById(loginId);
	}

}



