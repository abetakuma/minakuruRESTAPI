//package com.example.security.dto;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//
//import org.springframework.security.core.GrantedAuthority;
//
//import com.example.security.entity.UserLoginInfo;
//
//import lombok.Data;
//
///**
// * 認証ユーザ作成クラス
// *
// */
//@Data
//public class LoginUserDetails extends org.springframework.security.core.userdetails.User{
//	private static final long serialVersionUID = 1L;
//
//	/** 認証ユーザ名*/
//	private String name;
//	/** パスワード*/
//	private String password;
//	/** 権限リスト*/
//	private List<String> permissions;
//	/** ロールリスト*/
//	private Collection<GrantedAuthority> authorities;
//
//	/**
//	 * コンストラクタ
//	 * @param user
//	 */
//	public LoginUserDetails(UserLoginInfo userLoginInfo){
//		//Userエンティティから、認証ユーザのユーザ名、パスワード、権限リスト、ロールリストを設定
//		super(userLoginInfo.getEmail(), userLoginInfo.getPassword(), new ArrayList<GrantedAuthority>());
//		name = userLoginInfo.getEmail();
//		password = userLoginInfo.getPassword();
//		//User -> list<Role> -> list<Permission> -> list<String>
////		permissions = userLoginInfo.getRoles()
////						  .stream()
////						  .flatMap(role -> role.getPermissions().stream()
////																.map(permission -> permission.getName()))
////						  .collect(Collectors.toList());
//		//User -> list<Role> -> list<GrantedAuthority>
////		authorities = userLoginInfo.getRoles()
////						.stream()
////						.map(role -> new SimpleGrantedAuthority(role.getName()))
////						.collect(Collectors.toList());
//	}
//}
