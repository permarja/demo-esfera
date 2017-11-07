package cat.gencat.oqual.esfera.PageObjects; 

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.RemoteWebDriver;

public class IdentificacioPageObject extends WebAbstractaPageObject {

	// DEFINICIO OBJECTES DE LA PANTALLA DE LOGIN

	public final String FONS_CAPÇALERA 											= "//*[@id=\"banner\"]";
	public final String FONS_CAPÇALERA_PETIT 									= "//*[@id=\"navlist\"]";
	public final String LOGOTIP_GENERALITAT 									= "//*[@id=\"active\"]/img";
	public final String IMATGE_ENLLAÇ_ENSENYAMENT 								= "//*[@id=\"navlist\"]/li[2]/a/img";
	public final String TITOL_IDENTIFICACIO_ENTORN 								= "//*[@id=\"content\"]/p[1]/font/strong";
	public final String TITOL_ACCES_USUARI 										= "//*[@id=\"content\"]/p[2]";
	public final String CONTENIDOR_IDENTIFICACIO 								= "//*[@id=\"container\"]";
	public final String TITOL_ACCES_USUARI_CORPORATIU 							= "//*[@id=\"cap\"]";
	public final String TITOL_ACCES_CERTIFICAT_DIGITAL 							= "//*[@id=\"cap\"]";
	public final String CONTENIDOR_ACCES_USUARI_CORPORATIU 						= "//*[@id=\"centre\"]/form/fieldset";
	public final String CONTENIDOR_ACCES_CENTRIFICAT_DIGITAL 					= "//*[@id=\"centre\"]";
	public final String ETIQUETA_IDENTIFICADOR 									= "//*[@id=\"centre\"]/form/fieldset/p[1]/label";
	public final String ETIQUETA_CONTRASENYA 									= "//*[@id=\"centre\"]/form/fieldset/p[2]/label";
	public final String CAIXA_IDENTIFICADOR 									= "//*[@id=\"centre\"]/form/fieldset/p[1]/input";
	public final String CAIXA_IDENTIFICADOR_CONTRASENYA 						= "//*[@id=\"centre\"]/form/fieldset/p[2]/input";
	public final String BOTO_ACEPTA 											= "//*[@id=\"submit\"]/input";
	public final String TEXT_CANVIAR_CONTRASENYA 								= "//*[@id=\"enllac\"]";
	public final String PEU_ACCES_USUARI_CORPORATIU 							= "//*[@id=\"peu\"]";
	public final String PEU_ACCESS_CERTIFICACIO_DIGITAL 						= "//*[@id=\"peu\"]";
	public final String CONTENIDOR_MISSATGE_ACCESS_CERTIFICACIO_DIGITAL 		= "//*[@id=\"centre\"]/p[1]";
	public final String TEXT_CERTIFICACIO_DIGITAL 								= "//*[@id=\"centre\"]/p[1]/a";
	public final String BOTO_ACCEDEIX 											= "//*[@id=\"submit\"]/a";
	public final String CONTENIDOR_INFO_ACCES_USUARI_CORPORATIU 				= "//*[@id=\"capsa1\"]";
	public final String CONTENIDOR_INFO_ACCES_CERTIFICAT_DIGITAL 				= "//*[@id=\"capsa1\"]";
	public final String TEXT_ENLLAÇ_ENSENYAMENT 								= "//*[@id=\"capsa1\"]/a";
	public final String FONS_PEU 												= "//*[@id=\"footer\"]/ul";
	public final String CERTIFICACIO_GENERALITAT 								= "//*[@id=\"footer\"]/ul/li";
	
	
	public final String[] OBJECTES_INDISPENSABLES				 				= { BOTO_ACEPTA,
																					BOTO_ACCEDEIX,
																					CAIXA_IDENTIFICADOR,
																					ETIQUETA_CONTRASENYA,
																					ETIQUETA_IDENTIFICADOR,
																					CAIXA_IDENTIFICADOR_CONTRASENYA };

	public IdentificacioPageObject(RemoteWebDriver driver) {
		super(driver);
	}

	public String IntroduirUsuari(String str) {
		try {
			driver.findElement(By.xpath(CAIXA_IDENTIFICADOR)).sendKeys(str);
		} catch (Exception e) {
			return e.getMessage();
		}
		return "OK";
	}

	public String IntroduirContrasenya(String str) {
		try {
		driver.findElement(By.xpath(CAIXA_IDENTIFICADOR_CONTRASENYA)).sendKeys(str);
		} catch (Exception e) {
			return e.getMessage();
		}
		return "OK";
	}

	public String ClickBotoAcceptar() {
		try {
		driver.findElement(By.xpath(BOTO_ACEPTA)).click();
		} catch (Exception e) {
			return e.getMessage();
		}
		return "OK";
	}

	public String IntroBotoAcceptar() {
		try {
		driver.findElement(By.xpath(BOTO_ACEPTA)).sendKeys(Keys.ENTER);
		} catch (Exception e) {
			return e.getMessage();
		}
		return "OK";
	}

	public String ClickBOTO_ACCEDEIX() {
		try {
		driver.findElement(By.xpath(BOTO_ACEPTA)).click();
		} catch (Exception e) {
			return e.getMessage();
		}
		return "OK";
	}

	public String IntroBOTO_ACCEDEIX() {
		try {
		driver.findElement(By.xpath(BOTO_ACEPTA)).sendKeys(Keys.ENTER);
		} catch (Exception e) {
			return e.getMessage();
		}
		return "OK";
	}

	public String ClickTextCanviarContrasenya() {
		try {
		driver.findElement(By.xpath(TEXT_CANVIAR_CONTRASENYA)).click();
		} catch (Exception e) {
			return e.getMessage();
		}
		return "OK";
	}

	public String IntroTextCanviarContrasenya() {
		try {
		driver.findElement(By.xpath(TEXT_CANVIAR_CONTRASENYA)).sendKeys(Keys.ENTER);
		} catch (Exception e) {
			return e.getMessage();
		}
		return "OK";
	}

	public String ClickTEXT_CERTIFICACIO_DIGITAL() {
		try {
		driver.findElement(By.xpath(TEXT_CERTIFICACIO_DIGITAL)).click();
		} catch (Exception e) {
			return e.getMessage();
		}
		return "OK";
	}

	public String IntroTEXT_CERTIFICACIO_DIGITAL() {
		try {
		driver.findElement(By.xpath(TEXT_CERTIFICACIO_DIGITAL)).sendKeys(Keys.ENTER);
		} catch (Exception e) {
			return e.getMessage();
		}
		return "OK";
	}

	public String ClickTextEllaçSau() {
		try {
		driver.findElement(By.xpath(TEXT_ENLLAÇ_ENSENYAMENT)).click();
		} catch (Exception e) {
			return e.getMessage();
		}
		return "OK";
	}

	public String IntroTextEllaçSau() {
		try {
		driver.findElement(By.xpath(TEXT_ENLLAÇ_ENSENYAMENT)).sendKeys(Keys.ENTER);
		} catch (Exception e) {
			return e.getMessage();
		}
		return "OK";
	}

	public String ClickCapçaleraGeneralitat() {
		try {
		driver.findElement(By.xpath(TEXT_ENLLAÇ_ENSENYAMENT)).click();
		} catch (Exception e) {
			return e.getMessage();
		}
		return "OK";
	}

	public String IntroClickCapçaleraGeneralitat() {
		try {
		driver.findElement(By.xpath(TEXT_ENLLAÇ_ENSENYAMENT)).sendKeys(Keys.ENTER);
		} catch (Exception e) {
			return e.getMessage();
		}
		return "OK";
	}

}
