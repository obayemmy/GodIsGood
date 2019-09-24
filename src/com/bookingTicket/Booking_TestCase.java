package com.bookingTicket;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Booking_TestCase {
	String driverLocation="C:\\Loopmi_Web\\drive\\chromedriver.exe";
	WebDriver driver;
	@BeforeTest
	public void openBrowser() {
		//To launch browser
		System.setProperty("webdriver.chrome.driver",driverLocation);
		driver = new ChromeDriver();
		driver.get("https://www.gigm.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		}
	
	@Test(priority=1)
	public void selectTrip() throws InterruptedException {
		//driver.findElement(By.xpath("(//span[@id='mClose'])[2]")).click();
		Thread.sleep(2000);
		//To click and select departures state
		WebElement departureField = driver.findElement(By.xpath("//div[@id='bookBusWidget']/div[2]/div/div/div/span/span/span/span[2]/b"));
		departureField.click();
		WebElement departState = driver.findElement(By.xpath("//option[contains(text(),'Lagos => Ajah')]"));
		departState.click();
		Thread.sleep(5000);
		//To click and select arrival state
		WebElement arrivalState =driver.findElement(By.xpath("//select[@id='ContentPlaceHolder2_ddlto']"));
		arrivalState.click();
		WebElement selectedState = driver.findElement(By.xpath("//option[contains(text(),'Akwa Ibom-Uyo')]"));
		selectedState.click();
		Thread.sleep(2000);
		//To click and select date
		WebElement date = driver.findElement(By.xpath("//input[@id='ContentPlaceHolder2_txtdepart']"));
		date.click();
		WebElement day = driver.findElement(By.xpath("//td[@class='day'][contains(text(),'26')]"));
		day.click();
		Thread.sleep(3000);
		//To select number tickets
		WebElement noOfTicket = driver.findElement(By.xpath("//select[@id='ContentPlaceHolder2_ddltickets']"));
		noOfTicket.click();
		WebElement noSeat = driver.findElement(By.xpath("//div[contains(@class,'form-group col-md-1 col-sm-1 col-xs-12 small-inputs')]//option[1]"));
		noSeat.click();
		//To click the bookNow button
		WebElement bookBtn =driver.findElement(By.xpath("//input[@id='ContentPlaceHolder2_Button1']"));
		bookBtn.click();
		Thread.sleep(12000);
	}
	@Test(priority=2)
	public void selectSeat() throws InterruptedException {
		//To verify Bus Availability is displayed on this page
		String pageText="Bus Availability";
		if(driver.getPageSource().contains(pageText)) {
			System.out.println("the page text is" + pageText);
		}else {
			System.out.println("the page text is not visible");
		}
		//To view available sits
		WebElement viewSeat = driver.findElement(By.xpath("//div[@class='row ng-scope']//div[1]//div[1]//div[1]//div[5]//button[1]"));
		viewSeat.click();
		Thread.sleep(2000);
		//To select preferred seat no
		WebElement seatNo = driver.findElement(By.xpath("//div[@class='a12 add-pad-left bus-back ng-scope']//span[@class='seatsselect ng-binding bus-available'][contains(text(),'5')]"));
		seatNo.click();
		//To click continue button
		WebElement continueBtn = driver.findElement(By.xpath("//a[@id='ContentPlaceHolder2_lvbus_lnkbook_0']"));
		continueBtn.click();
		Thread.sleep(4000);
		//To click continue without sign in link
		WebElement cWt =driver.findElement(By.linkText("Continue without Login"));
		cWt.click();
		Thread.sleep(3000);
	}
		
	@Test(priority=3)
	public void passengerDetails() throws InterruptedException {
		//To select no pickup check box
		WebElement pickUp = driver.findElement(By.xpath("//input[@id='pickupNo']"));
		pickUp.click();
		Thread.sleep(2000);
		//To enter full name
		WebElement nameField = driver.findElement(By.xpath("//input[@id='ContentPlaceHolder2_txtFullname1']"));
		nameField.sendKeys("Oje Olugbenga");
		Thread.sleep(2000);
		//To select gender=male
		Select gender = new Select(driver.findElement(By.id("ContentPlaceHolder2_ddlgender1")));
		gender.selectByVisibleText("Male");
		//To enter email address
		WebElement emailField=driver.findElement(By.id("ContentPlaceHolder2_txtemail1"));
		emailField.sendKeys("obayemmy92@gmail.com");
		//To enter phone Number
	    WebElement phoneField=driver.findElement(By.id("ContentPlaceHolder2_txtphone1"));
	    phoneField.sendKeys("07085120885");
	    //To enter next of kin name
	    WebElement kinField=driver.findElement(By.id("ContentPlaceHolder2_txtnextofkin1"));
	    kinField.sendKeys("bukunmi opeyemi");
	    //To enter next of kin phone number
	    WebElement kinFieldPhone=driver.findElement(By.id("ContentPlaceHolder2_txtnextofkinphone1"));
	    kinFieldPhone.sendKeys("09067568764");
	    Thread.sleep(10000);
	}
	
	 @Test(priority=4)
	 public void payment() {
		 //To click on  first bank USSD 
	    WebElement firstBankUssd = driver.findElement(By.id("lnkbtnFbnUssd2"));
	    Actions actions = new Actions(driver);
	    actions.moveToElement(firstBankUssd).click().perform();
	    
	}
		
	@AfterTest
	//To close browser
	public void closeBrowser() {
		driver.close();
		
	}
}




