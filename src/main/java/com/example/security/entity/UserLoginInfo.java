package com.example.security.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="user_login_info")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserLoginInfo implements Serializable{
	private static final long serialVersionUID = 1L;

	/** メールアドレス（認証時使用）*/
	@Id
	@Column(nullable=false,columnDefinition="VARCHAR(255)")
	private String email;

	@Column(nullable=false)
	private String name;

	/** パスワード（認証時使用。DBにはハッシュ化して格納）*/
	@JsonIgnore
	@Column(nullable=false,columnDefinition="VARCHAR(255)")
	private String password;

	/** クライアント表示ユーザ名*/
//	@Column(nullable=false,columnDefinition="VARCHAR(50)")
//	private String name;

	/** 保有するロールリスト*/
//	@ManyToMany(fetch=FetchType.LAZY)
//	@JoinTable(
//			name="user_has_role",
//			joinColumns=@JoinColumn(name="user_name",referencedColumnName="name"),
//			inverseJoinColumns=@JoinColumn(name="role_id",referencedColumnName="id")
//			)
//	private List<Role> roles;

	  public static UserLoginInfo of(String name, String password, String email) {
		    return UserLoginInfo.builder().name(name).password(password).email(email).build();
	  }

}