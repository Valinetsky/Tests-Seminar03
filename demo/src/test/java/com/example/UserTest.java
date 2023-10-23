package com.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
	public static User userAdmin;
	public static User userUser;

	/**
	 * Создаем двух пользователей:
	 * userAdmin — имеющий права администратора
	 * userUser — обычный пользователь, без прав администратора
	 */
	@BeforeAll
	@DisplayName("Генерация пользователей перед каждым тестом")
	public static void createUsers() {
		userAdmin = new User("someName", "somePassword", Role.ADMIN);
		userUser = new User("someName", "somePassword", Role.USER);
	}

	/**
	 * Тестирование успешной аутентификации пользователя
	 * ожидаем получить от метода authenticate
	 * и изменение поля isAuthenticate — true
	 */
	@Test
	@DisplayName("Тест: положительная аутентификация")
	void checkAuthenticatePositive() {
		userAdmin.authenticate("someName", "somePassword");
		assertTrue(userAdmin.isAuthenticate);
	}

	/**
	 * Тестирование отрицательной аутентификации пользователя
	 * ожидаем получить от метода authenticate — false
	 * поле isAuthenticate не подвергается изменению
	 */
	@Test
	@DisplayName("Тест: отрицательная аутентификация")
	void checkAuthenticateNegative() {
		userUser.authenticate("wrongName", "wrongPassword");
		assertFalse(userUser.isAuthenticate);
	}

	/**
	 * Тестирование подтверждения роли администратора
	 * для пользователя удовлетворяющего условиям теста
	 * ожидаем получить от метода isRoleAdmin() — true
	 */
	@Test
	@DisplayName("Тест: положительная проверка — пользователь с правами администратора")
	void checkIsRoleAdminPositive() {
		assertTrue(userAdmin.isRoleAdmin());
	}

	/**
	 * Тестирование отсутствия роли администратора
	 * для пользователя НЕ удовлетворяющего условиям теста
	 * ожидаем получить от метода isRoleAdmin() — false
	 */
	@Test
	@DisplayName("Тест: отрицательная проверка — пользователь без прав администратора")
	void checkIsRoleAdminNegative() {
		assertFalse(userUser.isRoleAdmin());
	}
}