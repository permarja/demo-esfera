package cat.gencat.oqual.esfera.PageObjects; 

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.RemoteWebDriver;

public class GestioEconomicaPageObject extends WebAbstractaPageObject {

	public GestioEconomicaPageObject(RemoteWebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public final String TEXT_RESULTATS 		= "//*[@id=\"mainView\"]/div[2]/div/div/fieldset/div/table/caption/span[2]";
	public final String BOTO_DESCONNEXIO 	= "//*[@id=\"logoutIcon\"]/i";
	
	public final String[] OBJECTES_INDISPENSABLES 	= { TEXT_RESULTATS,
														BOTO_DESCONNEXIO };

	public String QuehiDiuEnResultats() {
	try {
		return driver.findElement(By.xpath(TEXT_RESULTATS)).getText();
	} catch (Exception e) {
		return e.getMessage();
	}
	
	}


	public String ClickBotoDesconnexio() {
	try {
		driver.findElement(By.xpath(BOTO_DESCONNEXIO)).click();
	} catch (Exception e) {
		return e.getMessage();
	}
	return "OK";
}


	public String IntroBotoDesconnexio() {
	try {
		driver.findElement(By.xpath(BOTO_DESCONNEXIO)).sendKeys(Keys.ENTER);
	} catch (Exception e) {
		return e.getMessage();
	}
	return "OK";
}


}
