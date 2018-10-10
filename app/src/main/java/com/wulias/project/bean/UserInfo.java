package com.wulias.project.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class UserInfo implements Serializable{

	@SerializedName("userName")
	private String userName;
	@SerializedName("password")
	private String password;
	@SerializedName("nickname")
	private String nickname;
	@SerializedName("cover")
	private String cover;
	@SerializedName("age")
	private Integer age;
	
	public UserInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public UserInfo(String userName, String password, String nickname,
			String cover, int age) {
		super();
		this.userName = userName;
		this.password = password;
		this.nickname = nickname;
		this.cover = cover;
		this.age = age;
	}


	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getCover() {
		return cover;
	}
	public void setCover(String cover) {
		this.cover = cover;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "UserInfo [userName=" + userName + ", password=" + password
				+ ", nickname=" + nickname + ", cover=" + cover + ", age="
				+ age + "]";
	}
	
	
}
