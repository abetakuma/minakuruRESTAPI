package com.example.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.security.dto.LoginUserDetails;
import com.example.security.entity.UserLoginInfo;
import com.example.security.repository.UserLoginInfoRepository;

/**
 * 認証ユーザ取得サービスクラス
 *
 */
@Service
public class LoginUserDetailsService implements UserDetailsService{
	@Autowired
	UserLoginInfoRepository repository;

	@Override
	public UserDetails loadUserByUsername(String mailaddress) throws UsernameNotFoundException{
		//DBに登録されているメールアドレスから認証対象ユーザを取得
		UserLoginInfo userLoginInfo = repository.findById(mailaddress).get();
		if(userLoginInfo == null){
			//TODO:このexceptionをそのままcatchしたい
			throw new UsernameNotFoundException("対象データがありません");
		}
		//取得したUserエンティティをもとにLoginUserDetailsを作成する
		return new LoginUserDetails(userLoginInfo);
	}
}