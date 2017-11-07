package cat.gencat.oqual.esfera.PageObjects; 

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DesconnexioPageObject extends WebAbstractaPageObject {

	public static final String CAPÇALERA 					= "//*[@id=\"wrap\"]/div/header";
	public static final String LOGO_GENERALITAT				= "//*[@id=\"wrap\"]/div/header/div/nav/div[1]/div/a";
	public static final String TEXT_AUTENTICACIO_USUARIS	= "//*[@id=\"nomPortal\"]/span";
	public static final String CONTENIDOR_TEXTE				= "//*[@id=\"wrap\"]/div/section/article/div/div/div[2]";
	public static final String TEXT_DESCONNEXIO 			= "//*[@id=\"wrap\"]/div/section/article/div/div/div[2]/h2";
	public static final String LINIA_TEXT1 					= "//*[@id=\"wrap\"]/div/section/article/div/div/div[2]/p[1]";
	public static final String LINEA_TEXT2 					= "//*[@id=\"wrap\"]/div/section/article/div/div/div[2]/p[2]";
	public static final String PAGINA 						= "//*[@id=\"wrap\"]";
	public static final String PEU_PAGINA 					= "//*[@id=\"footer\"]";
	public static final String LOGO_GENERALITAT_PEU_PAGINA 	= "//*[@id=\"footer\"]/footer/div[2]/div/div";
	
	
	public final String[] OBJECTES_INDISPENSABLES			= { 	CAPÇALERA,
																	LOGO_GENERALITAT,
																	TEXT_AUTENTICACIO_USUARIS, 
																	CONTENIDOR_TEXTE,
																	TEXT_DESCONNEXIO, 
																	LINIA_TEXT1,
																	LINEA_TEXT2, 
																	PAGINA, 
																	PEU_PAGINA,
																	LOGO_GENERALITAT_PEU_PAGINA };

	public DesconnexioPageObject(RemoteWebDriver driver) {
		super(driver);
	}

	public String QuehiDiuEnDesconnexio() {
		return driver.findElement(By.xpath(TEXT_DESCONNEXIO)).getText();
	}

}
