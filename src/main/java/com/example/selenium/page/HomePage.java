package com.example.selenium.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	/*
	 * Variável que define o parâmetro de espera do driver ao interagir com o
	 * elemento
	 */
	private WebDriverWait wait;

	private WebDriver driver;

	/*
	 * Procura o elemento na página de acordo com o parâmetro (id, xpath,
	 * cssSelector, class, etc) e o guarda em WebElement
	 */
	@FindBy(name = "q")
	WebElement searchBox;

	public HomePage(WebDriver driver) {
		/* O initElements cria todos os WebElements */
		PageFactory.initElements(driver, this);

		this.driver = driver;

		/* Por quanto tempo o driver deve esperar até a condição ser aceita */
		wait = new WebDriverWait(driver, 10);
	}

	public void start(String url) {
		driver.get(url);
	}

	public void search(String text) {
		wait.until(ExpectedConditions.elementToBeClickable(searchBox));
		searchBox.sendKeys(text);
		searchBox.submit();
		waitTime(2000);
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public String getUrl() {
		return driver.getCurrentUrl();
	}
	
	public void downloads() {
		driver.navigate().to("chrome://downloads");
		waitTime(10000);
	}
	
	public void downloadPDF() {
		driver.navigate().to("http://www.susep.gov.br/download/menumercado/teste.txt/view");
		waitTime(3000);
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/p[2]/span/a")).click();
	}
	
	public void clickOnDownload() {
		WebElement shadow = getShadowDom();
		shadow.findElement(By.cssSelector("#file-link"));
	}
	
	private WebElement getShadowDom() {
		waitTime(10000);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return (WebElement) js.executeScript("return arguments[0].shadowRoot", driver.findElement(By.cssSelector("#downloadsList > downloads-item:nth-child(2)")));
	}

	private void waitTime(Integer milliseconds) {
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
