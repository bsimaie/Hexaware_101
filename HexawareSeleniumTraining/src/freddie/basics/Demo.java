package freddie.basics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import freddie.utilities.DriverFactory;

public class Demo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = DriverFactory.start();
		driver.get("https://www.expedia.com/");
		
		//driver.findElement(By.id("package-departing-hp-package")).sendKeys("12/20/2017");
		//Thread.sleep(2000);
		
		driver.findElement(By.id("package-departing-hp-package")).click();
		Thread.sleep(1000);
		
		String startMonth = driver.findElement(By.xpath("//*[@id=\"package-departing-wrapper-hp-package\"]/div/div/div[2]/table/caption")).getText();
		System.out.println(startMonth);
		if (startMonth.equals("Nov 2017")) {
			driver.findElement(By.xpath("//*[@id=\"package-departing-wrapper-hp-package\"]/div/div/button[2]")).click();
		}
		
		driver.findElement(By.xpath("//*[@id=\"package-departing-wrapper-hp-package\"]/div/div/div[2]/table/tbody")).getText();
		List<WebElement> dates = driver.findElements(By.className("datepicker-cal-date"));
		for (WebElement date : dates) {
			System.out.println(date.getText());
			if (date.getText().toString().equals("10")) {
				date.click();
				break;
			}
		}

	}

}