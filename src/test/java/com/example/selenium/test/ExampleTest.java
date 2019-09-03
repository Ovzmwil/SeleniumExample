package com.example.selenium.test;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.example.selenium.page.HomePage;
import com.example.selenium.report.GenerateReport;
import com.example.selenium.util.SeleniumHelper;

public class ExampleTest extends GenerateReport {

	WebDriver driver;
	HomePage home;
	File folder;

	@BeforeClass
	public static void set() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

	}
	
//	private void finish(File folder) {
//		File[] listOfFiles = folder.listFiles();
//
//		Arrays.sort(listOfFiles, new Comparator<File>() {
//			public int compare(File f1, File f2) {
//				return Long.valueOf(f1.lastModified()).compareTo(f2.lastModified());
//			}
//		});
//		
//		File dest = new File("C:/Users/GrupoHDI/Desktop/" + listOfFiles[listOfFiles.length - 1].getName());
//		try {
//			FileUtils.copyFile(listOfFiles[listOfFiles.length-1].getAbsoluteFile(), dest);
//		}catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
//	private void saveFile() {
//		try {
//			Thread.sleep(10000);
//			File downloadFolder = new File(System.getProperty("user.home") + "/Downloads");
//			File[] listOfFiles = downloadFolder.listFiles();
////			ConfigFileReader reader = new ConfigFileReader("configs/config.properties");    	
//			String defaultDir = System.getProperty("user.home") + "/Desktop";
//			
//			Arrays.sort(listOfFiles, new Comparator<File>() {
//				public int compare(File f1, File f2) {
//					return Long.valueOf(f1.lastModified()).compareTo(f2.lastModified());
//				}
//			});
//
//			Integer index = listOfFiles.length - 1;
//			
//			File dest = new File(defaultDir + "/" + listOfFiles[index].getName());
//			
//			FileUtils.copyFile(listOfFiles[index], dest);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	@Before
	public void init() {
		driver = new ChromeDriver();
		home = new HomePage(driver);
		home.start("https://google.com");
	}
	
	@After
	public void end() {
		driver.quit();
	}

	@Ignore
	@Test
	public void clicaEmDowload() {
		home.downloadPDF();
		home.downloads();
		driver.quit();
	}
	
	@Test
	public void screenShot() {
		SeleniumHelper seleniumHelper = new SeleniumHelper(driver);
		seleniumHelper.screenShotRobot(System.getProperty("user.home") + "/Downloads/test.png");
	}

}
