package com.example.selenium.util;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class SeleniumHelper {
	
	WebDriver driver;
	Robot robot;

	public SeleniumHelper(WebDriver driver) {
		this.driver = driver;
	}

	public void screenShot() {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File("target/report/screenshots"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void screenShot(String path) {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File("target/" + path +"/screenshots"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void screenShotRobot(String path) {
		try {
			robot = new Robot();
			BufferedImage image = robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
			ImageIO.write(image, "png", new File(path));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
