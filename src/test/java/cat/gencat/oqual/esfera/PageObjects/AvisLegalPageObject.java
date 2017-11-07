package cat.gencat.oqual.esfera.PageObjects; 

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AvisLegalPageObject extends WebAbstractaPageObject {

	public AvisLegalPageObject(RemoteWebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public static final String BOTO_CANCELAR 	= "//*[@id=\"enrere\"]/a[1]";
	public static final String BOTO_ACEPTAR 	= "//*[@id=\"enrere\"]/a[2]";
	public static final String FONS_TEXT_LEGAL 	= "//*[@id=\"mainView\"]/div/div[2]/div";
	public static final String TEXT_LEGAL 		= "//*[@id=\"mainView\"]/div/div[2]/div/b";

	public void ClickBotoCancelar() {
		driver.findElement(By.xpath(BOTO_CANCELAR)).click();
	}

	public void IntroBotoCancelar() {
		driver.findElement(By.xpath(BOTO_CANCELAR)).sendKeys(Keys.ENTER);
	}

	public void ClickBotoAceptar() {
		driver.findElement(By.xpath(BOTO_ACEPTAR)).click();
	}

	public void IntroBotoAceptar() {
		driver.findElement(By.xpath(BOTO_ACEPTAR)).sendKeys(Keys.ENTER);
	}
}
