package cat.gencat.oqual.esfera.PageObjects; 

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.RemoteWebDriver;

public class CentrePageObject extends WebAbstractaPageObject {

	public final String BARRA_SUPERIOR 				= "//*[@id=\"wrap\"]/div[1]/div[1]/nav";
	public final String BOTO_CASA 					= "//*[@id=\"menuitem-0\"]/span/i";
	public final String BOTO_GRUPS 					= "//*[@id=\"menuitem-1\"]";
	public final String BOTO_MATRICULA 				= "//*[@id=\"menuitem-2\"]/span";
	public final String BOTO_ADMINISTRACIO 			= "//*[@id=\"menuitem-3\"]/span";
	public final String BOTO_CONFIGURACIONS			= "//*[@id=\"menuitem-9\"]/span";
	public final String BOTO_CURRICULUMS 			= "//*[@id=\"menuitem-11\"]/span";
	public final String BOTO_AVALUACIONS 			= "//*[@id=\"menuitem-15\"]/span";
	public final String BOTO_GESTIO_ECONOMICA 		= "//*[@id=\"menuitem-27\"]/span";
	public final String BOTO_PUBLICACIONS 			= "//*[@id=\"menuitem-28\"]/span";
	public final String BOTO_GESTIO_ADMINISTRATIVA 	= "//*[@id=\"menuitem-43\"]/span";
	public final String BOTO_PERSONAL 				= "//*[@id=\"menuitem-59\"]/span";
	public final String BOTO_INFO 					= "//*[@id=\"logoutIcon\"]/i";
	
	public final String BOTO_GRUPS_SUBGRUPS_GRUPS_ASSIGNATS = "//*[@id=\"submenuitem-0\"]";
	
	public String[] OBJECTES_INDISPENSABLES			= { BARRA_SUPERIOR,
														BOTO_CASA,
														BOTO_GRUPS, 
														BOTO_MATRICULA, 
														BOTO_ADMINISTRACIO,
														BOTO_CONFIGURACIONS, 
														BOTO_CURRICULUMS, 
														BOTO_AVALUACIONS,
														BOTO_GESTIO_ECONOMICA, 
														BOTO_PUBLICACIONS,
														BOTO_GESTIO_ADMINISTRATIVA, 
														BOTO_PERSONAL, 
														BOTO_INFO};



	public CentrePageObject(RemoteWebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	// BOTONS
	public String ClickBotoCasa() {
	try {
		driver.findElement(By.xpath(BOTO_CASA)).click();
	} catch (Exception e) {
		return e.getMessage();
	}
	return "OK";
}

	public String IntroBotoCasa() {
	try {
		driver.findElement(By.xpath(BOTO_CASA)).sendKeys(Keys.ENTER);
	} catch (Exception e) {
		return e.getMessage();
	}
	return "OK";
}

	public String ClickBotoGrups() {
	try {
		driver.findElement(By.xpath(BOTO_GRUPS)).click();
	} catch (Exception e) {
		return e.getMessage();
	}
	return "OK";
}

	public String IntroBotoGrups() {
	try {	
		driver.findElement(By.xpath(BOTO_GRUPS)).sendKeys(Keys.ENTER);
	} catch (Exception e) {
		return e.getMessage();
	}
	return "OK";
}

	public String ClickBotoMatricula() {
	try {
		driver.findElement(By.xpath(BOTO_MATRICULA)).click();
	} catch (Exception e) {
		return e.getMessage();
	}
	return "OK";
}

	public String IntroBotoMatricula() {
	try {
		driver.findElement(By.xpath(BOTO_MATRICULA)).sendKeys(Keys.ENTER);
	} catch (Exception e) {
		return e.getMessage();
	}
	return "OK";
}

	public String ClickBotoAdministracio() {
	try {
		driver.findElement(By.xpath(BOTO_ADMINISTRACIO)).click();
	} catch (Exception e) {
		return e.getMessage();
	}
	return "OK";
}

	public String IntroBotoAdministracio() {
	try {
		driver.findElement(By.xpath(BOTO_ADMINISTRACIO)).sendKeys(Keys.ENTER);
	} catch (Exception e) {
		return e.getMessage();
	}
	return "OK";
}

	public String ClickBotoConfiguracions() {
	try {
		driver.findElement(By.xpath(BOTO_CONFIGURACIONS)).click();
	} catch (Exception e) {
		return e.getMessage();
	}
	return "OK";
}

	public String IntroBotoConfiguracions() {
	try {
		driver.findElement(By.xpath(BOTO_CONFIGURACIONS)).sendKeys(Keys.ENTER);
	} catch (Exception e) {
		return e.getMessage();
	}
	return "OK";
}

	public String ClickBotoCurriculums() {
	try {
		driver.findElement(By.xpath(BOTO_CURRICULUMS)).click();
	} catch (Exception e) {
		return e.getMessage();
	}
	return "OK";
}

	public String IntroBotoCurriculums() {
	try {
		driver.findElement(By.xpath(BOTO_CURRICULUMS)).sendKeys(Keys.ENTER);
	} catch (Exception e) {
		return e.getMessage();
	}
	return "OK";
}

	public String ClickBotoAvaluacions() {
	try {
		driver.findElement(By.xpath(BOTO_AVALUACIONS)).click();
	} catch (Exception e) {
		return e.getMessage();
	}
	return "OK";
}

	public String IntroBotoAvaluacions() {
	try {
		driver.findElement(By.xpath(BOTO_AVALUACIONS)).sendKeys(Keys.ENTER);
	} catch (Exception e) {
		return e.getMessage();
	}
	return "OK";
}

	public String ClickBotoGestioEconomica() {
	try {
		driver.findElement(By.xpath(BOTO_GESTIO_ECONOMICA)).click();
	} catch (Exception e) {
		return e.getMessage();
	}
	return "OK";
}

	public String IntroBotoGestioEconomica() {
	try {
		driver.findElement(By.xpath(BOTO_GESTIO_ECONOMICA)).sendKeys(Keys.ENTER);
	} catch (Exception e) {
		return e.getMessage();
	}
	return "OK";
}

	public String ClickBotoPublicacions() {
	try {
		driver.findElement(By.xpath(BOTO_PUBLICACIONS)).click();
	} catch (Exception e) {
		return e.getMessage();
	}
	return "OK";
}

	public String IntroBotoPublicacions() {
	try {
		driver.findElement(By.xpath(BOTO_PUBLICACIONS)).sendKeys(Keys.ENTER);
	} catch (Exception e) {
		return e.getMessage();
	}
	return "OK";
}

	public String ClickBotoGestioAdministrativa() {
	try {
		driver.findElement(By.xpath(BOTO_GESTIO_ADMINISTRATIVA)).click();
	} catch (Exception e) {
		return e.getMessage();
	}
	return "OK";
}

	public String IntroBotoGestioAdministrativa() {
	try {
		driver.findElement(By.xpath(BOTO_GESTIO_ADMINISTRATIVA)).sendKeys(Keys.ENTER);
	} catch (Exception e) {
		return e.getMessage();
	}
	return "OK";
}

	public String ClickBotoPersonal() {
	try {
		driver.findElement(By.xpath(BOTO_PERSONAL)).click();
	} catch (Exception e) {
		return e.getMessage();
	}
	return "OK";
}

	public String IntroBotoPersonal() {
	try {
		driver.findElement(By.xpath(BOTO_PERSONAL)).sendKeys(Keys.ENTER);
	} catch (Exception e) {
		return e.getMessage();
	}
	return "OK";
}

	public String ClickBotoInfo() {
	try {
		driver.findElement(By.xpath(BOTO_INFO)).click();
	} catch (Exception e) {
		return e.getMessage();
	}
	return "OK";
}

	public String IntroBotoInfo() {
	try {
		driver.findElement(By.xpath(BOTO_INFO)).sendKeys(Keys.ENTER);
	} catch (Exception e) {
		return e.getMessage();
	}
	return "OK";
}

	// SUB MENU
	public String ClickBotoGrupsSubGrupsAssignats() {
	try {
		driver.findElement(By.xpath(BOTO_GRUPS_SUBGRUPS_GRUPS_ASSIGNATS)).click();
	} catch (Exception e) {
		return e.getMessage();
	}
	return "OK";
}

	public String IntroBotoGrupsSubGrupsAssignats() {
	try {
		driver.findElement(By.xpath(BOTO_GRUPS_SUBGRUPS_GRUPS_ASSIGNATS)).sendKeys(Keys.ENTER);
	} catch (Exception e) {
		return e.getMessage();
	}
	return "OK";
}

}
