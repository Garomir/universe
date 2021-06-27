package com.garomir.universe;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

@SpringBootApplication
public class UniverseApplication {

	public static void main(String[] args) {
		SpringApplication.run(UniverseApplication.class, args);
		//Указали путь в системе, где лежит наш selenium WebDriver
		System.setProperty("webdriver.chrome.driver", "C:\\Proj\\chromedriver_win32\\chromedriver.exe");
		//Создаем экземпляр WebDriver
		WebDriver driver = new ChromeDriver();
		//открываем в браузере первую страницу нашего проекта
		driver.get("http://localhost:8090/index");
		//ожидаем 3 секунды
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(9));
		//получаем нашу первую кнопку "Повелители" по cssSelector
		WebElement btnLords = driver.findElement(By.cssSelector("form[action='/lords'] button"));
		//нажимаем кнопку
		btnLords.click();
		//ожидаем 3 секунды
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		//создаем 15 повелителей
		for (int i = 1; i < 16; i++) {
			WebElement inputLordName = driver.findElement(By.cssSelector("input[name='name']"));
			WebElement inputLordAge = driver.findElement(By.cssSelector("input[name='Age']"));
			WebElement btnAddLord = driver.findElement(By.cssSelector("form[action='/addlord'] button"));
			inputLordName.sendKeys("Lord " + i);
			inputLordAge.sendKeys("" + i*100);
			btnAddLord.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebElement btnGetFreeLords = driver.findElement(By.cssSelector("form[action='/getfreelords'] button"));
		btnGetFreeLords.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebElement btnGetTop10Lords = driver.findElement(By.cssSelector("form[action='/gettop10lords'] button"));
		btnGetTop10Lords.click();
	}
}
