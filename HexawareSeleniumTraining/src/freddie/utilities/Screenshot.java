package freddie.utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {
	
	// This method will take a screenshot of the browser
	public static void snap(WebDriver driver, String filename) {
		File ScreenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(ScreenshotFile, new File(GlobalSettings.screenshotDirectory + filename + ".jpg"));
		} catch (IOException e) {
			System.out.println("Error capturing screenshot");
			e.printStackTrace();
		}
	}

}
