package com.example;

public class User {

	String name;
	String password;

	// Добавляем поле типизации пользователя
	Role userRole;

	boolean isAuthenticate = false;

	public User(String name, String password, Role userRole) {
		this.name = name;
		this.password = password;
		this.userRole = userRole;

	}

	/**
	 * Авторизация пользователя
	 *
	 * @param name     имя пользователя
	 * @param password пароль пользователя
	 * @return Если имя и пароль существуют — true, иначе false
	 */
	public boolean authenticate(String name, String password) {
		this.isAuthenticate = (this.name.equals(name) && this.password.equals(password));
		return this.isAuthenticate;
	}

	/**
	 * Проверка типа пользователя
	 *
	 * @return Если администратор — true, иначе false
	 */
	public boolean isRoleAdmin() {
		return this.userRole.equals(Role.ADMIN);
	}

}
