# Unit-тесты. Семинар 03

## Качество тестов

__Задание 1.__

Напишите тесты, покрывающие на 100% метод evenOddNumber, который проверяет, является ли переданное число четным или нечетным. 
```java
public boolean evenOddNumber(int n) {
	if (n % 2 == 0) {
		return true;
	} else {
		return false;
	}
}
```

__Задание 2.__

Разработайте и протестируйте метод numberInInterval, который проверяет, попадает ли переданное число в интервал (25;100). 
```java
public boolean numberInInterval(int n) { … }
```

__Задание 3.__  (необязательное)

Добавьте функцию в класс UserRepository, которая разлогинивает всех пользователей, кроме администраторов. Для этого, вам потребуется расширить класс User новым свойством, указывающим, обладает ли пользователь админскими правами. Протестируйте данную функцию.

## Скриншоты

Общее покрытие
![jacoco report 1](/img/page01.png "jacoco report 1")

Покрытие User. 75% ветвей кода
![jacoco report 2](/img/page02.png "jacoco report 2")

Покрытие User. Метод без покрытия
![jacoco report 3](/img/page03.png "jacoco report 3")

Прогон тестов в IDE VS Code
![VS Code. Пройденные тесты](/img/page04.png "VS Code. Пройденные тесты")

## Примечания
Для генерации отчета — команда `mvn package`.

В конкретном случае в терминале из папки `demo`:

`mvn clean jacoco:prepare-agent install jacoco:report`

Иначе — не генерируется обновленный отчет.