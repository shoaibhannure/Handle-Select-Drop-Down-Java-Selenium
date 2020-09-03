package com.shoaib.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

//@Author:- SHOAIB HANNURE
public class HandleSelectDropDown {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(); // launch chrome
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://scgi.half.ebay.com/ws/eBayISAPI.dll?RegisterEnterInfo&usage=2943&ru="); // launch URL
		
		
		List<WebElement> stateList =driver.findElements(By.xpath("//select[@name='state']/option"));//xpath of option list
		System.out.println("Total No of State in the List are  "+stateList.size());// print total no of Values in drop down
		
		for(int i=1; i<stateList.size(); i++){
			System.out.println(stateList.get(i).getText()); //print all states present in the drop down list
		}
		
		
		WebElement selectState=driver.findElement(By.xpath("//select[@name='state']"));
		Select stateDropdown = new Select(selectState);
		//stateDropdown.selectByValue("DC"); //Select By Value
		
		stateDropdown.selectByVisibleText("North Carolina"); //Select By Visible Text displayed in UI
		
		System.out.println("State is selected from the drop down list");
		
	/*	Notes:
			•	isDisplayed() is the method used to verify presence of a web element within the webpage.
			 The method returns a “true” value if the specified web element is present on the web page and a “false” value if the web element is not present on the web page.
			•	isDisplayed() is capable to check for the presence of all kinds of web elements available.*/
		
		boolean flag = driver.findElement(By.id("state")).isDisplayed();
		System.out.println(flag); //it will return true if state is selected and displayed in the state field

	}

}
