package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserRepositoryTest {
	public UserRepository userRepository; // временно можно открыть данный класс
	public User userAdmin;
	public User userUser;

	/**
	 * Создаем объект репозитория,
	 * Пользователя удовлетворяющего условиям теста,
	 * Пользователя не удовлетворяющего условиям теста.
	 */
	@BeforeEach
	@DisplayName("Генерация пользователей и репозитория перед каждым тестом")

	public void setUp() {
		userRepository = new UserRepository();
		userAdmin = new User("someName", "somePassword", Role.ADMIN);
		userUser = new User("someName", "somePassword", Role.USER);
	}

	/**
	 * Тестирование добавления пользователя в лист аутентифицированных
	 * пользователей.
	 * Аутентифицируем пользователя,
	 * добавляем пользователя в лист,
	 * проверяем размер листа,
	 * тест удовлетворяет условиям если размер листа равен 1
	 */
	@Test
	@DisplayName("Тест: добавление пользователя в репозиторий")
	void checkAddUserPositive() {
		userAdmin.authenticate("someName", "somePassword");
		userRepository.addUser(userAdmin);
		int expectListSize = 1;
		assertEquals(expectListSize, userRepository.data.size());
	}

	/**
	 * Тестирование получения исключения при попытке добавления
	 * неаутентифицированного пользователя
	 * в лист аутентифицированных пользователей.
	 * Пытаемся аутентифицировать пользователя заведомо ложными данными,
	 * Ловим исключение при попытке добавить в лист,
	 * Проверяем сообщение полученного исключения.
	 */
	@Test
	@DisplayName("Тест: добавление заведомо ложного пользователя в репозиторий")
	void checkExceptionWithAddUser() {
		userUser.authenticate("wrongName", "wrongPassword");
		Exception exception = assertThrows(RuntimeException.class, () -> userRepository.addUser(userAdmin));
		String message = "wrong login or password!";
		assertEquals(message, exception.getMessage());
	}

	/**
	 * Тестирование успешного поиска пользователя в листе аутентифицированных
	 * пользователей по его имени.
	 * Аутентифицируем пользователя, добавляем в лист,
	 * Ожидаем успешное завершение теста при проверке наличия добавленного
	 * пользователя в листе.
	 */
	@Test
	@DisplayName("Тест: добавление пользователя в репозиторий и проверка его наличия там")
	void checkFindByNamePositive() {
		userAdmin.authenticate("someName", "somePassword");
		userRepository.addUser(userAdmin);
		assertTrue(userRepository.findByName("someName"));
	}

	/**
	 * Тестирование неудачного поиска пользователя в листе аутентифицированных
	 * пользователей по его имени.
	 * Аутентифицируем пользователя, добавляем в лист,
	 * Ожидаем успешное завершение теста при проверке наличия заведомо
	 * несуществующего пользователя в листе.
	 */
	@Test
	@DisplayName("Тест: добавление ложного пользователя в репозиторий и проверка его отсутствия там")
	void checkFindByNameNegative() {
		userAdmin.authenticate("someName", "somePassword");
		userRepository.addUser(userAdmin);
		assertFalse(userRepository.findByName("wrongName"));
	}

	/**
	 * Тестирование удаления пользователей из списка аутентифицированных
	 * пользователей при отсутствии прав администратора.
	 * Аутентифицируем пользователей:
	 * userAdmin — имеет права администратора;
	 * userUser — обычный пользователь, без прав администратора;
	 * Удаляем пользователей без прав администратора из списка.
	 * Тест успешен если размер листа равен 1 (Должен остаться только один!).
	 */
	@Test
	@DisplayName("Тест: добавление пользователя в репозиторий")
	void checkLogOutExceptAdministrator() {
		userAdmin.authenticate("someName", "somePassword");
		userUser.authenticate("someName", "somePassword");
		userRepository.addUser(userAdmin);
		userRepository.addUser(userUser);
		userRepository.logOutExceptAdministrator();
		int expectListSize = 1;
		assertEquals(expectListSize, userRepository.data.size());
	}

}