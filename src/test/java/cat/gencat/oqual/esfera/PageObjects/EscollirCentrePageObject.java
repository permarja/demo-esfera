package cat.gencat.oqual.esfera.PageObjects;
 
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.RemoteWebDriver;

public class EscollirCentrePageObject extends WebAbstractaPageObject {

	public  final String CAPÇALERA_ESCOLLIU_CENTRE 		= "//*[@id=\"modalCentres\"]/div[2]/div/div[1]";
	public  final String CONTENIDOR_ESCOLLIU_CENTRE		= "//*[@id=\"modalCentres\"]/div[2]/div/div[2]";
	public  final String BLOC_ESCOLLIU_CENTRE 			= "//*[@id=\"modalCentres\"]/div[2]/div/div[2]/div/fieldset/div";
	public  final String TEXT_ESCOLLIU_CENTRE 			= "//*[@id=\"modalCentres\"]/div[2]/div/div[1]/h4";
	public  final String TEXT_RESULTATS					= "//*[@id=\"modalCentres\"]/div[2]/div/div[2]/div/fieldset/div/p";
	public  final String CAPÇALERA_COXINET 				= "//*[@id=\"modalCentres\"]/div[2]/div/div[2]/div/fieldset/div/table/thead/tr[1]/th[1]";
	public  final String CAPÇALERA_CODI					= "//*[@id=\"modalCentres\"]/div[2]/div/div[2]/div/fieldset/div/table/thead/tr[1]/th[2]";
	public  final String CAPÇALERA_NOM 					= "//*[@id=\"modalCentres\"]/div[2]/div/div[2]/div/fieldset/div/table/thead/tr[1]/th[3]";
	public  final String BLOC_PETIT						= "//*[@id=\"modalCentres\"]/div[2]/div/div[2]/div/fieldset/div/table/thead/tr[2]/th[1]";
	public  final String BLOC_CODI 						= "//*[@id=\"modalCentres\"]/div[2]/div/div[2]/div/fieldset/div/table/thead/tr[2]/th[2]";
	public  final String BLOC_NOM 						= "//*[@id=\"modalCentres\"]/div[2]/div/div[2]/div/fieldset/div/table/thead/tr[2]/th[3]";
	public  final String BLOC_PETIT_FINAL 				= "//*[@id=\"modalCentres\"]/div[2]/div/div[2]/div/fieldset/div/table/thead/tr[2]/th[4]";
	public  final String CAIXA_TEXT_CODI 				= "//*[@id=\"modalCentres\"]/div[2]/div/div[2]/div/fieldset/div/table/thead/tr[2]/th[2]/input";
	public  final String CAIXA_TEXT_NOM					= "//*[@id=\"modalCentres\"]/div[2]/div/div[2]/div/fieldset/div/table/thead/tr[2]/th[3]/input";

	public  final String BOTO_LINIA1 					= "//*[@id=\"modalCentres\"]/div[2]/div/div[2]/div/fieldset/div/table/tbody/tr[1]/td[4]/a";
	public  final String BOTO_LINIA2 					= "//*[@id=\"modalCentres\"]/div[2]/div/div[2]/div/fieldset/div/table/tbody/tr[2]/td[4]/a";
	public  final String BOTO_LINIA3 					= "//*[@id=\"modalCentres\"]/div[2]/div/div[2]/div/fieldset/div/table/tbody/tr[3]/td[4]/a";
	public  final String BOTO_LINIA4 					= "//*[@id=\"modalCentres\"]/div[2]/div/div[2]/div/fieldset/div/table/tbody/tr[4]/td[4]/a";
	public  final String BOTO_LINIA5 					= "//*[@id=\"modalCentres\"]/div[2]/div/div[2]/div/fieldset/div/table/tbody/tr[5]/td[4]/a";
	public  final String BOTO_LINIA6 					= "//*[@id=\"modalCentres\"]/div[2]/div/div[2]/div/fieldset/div/table/tbody/tr[6]/td[4]/a";
	public  final String BOTO_LINIA7 					= "//*[@id=\"modalCentres\"]/div[2]/div/div[2]/div/fieldset/div/table/tbody/tr[7]/td[4]/a";
	public  final String BOTO_LINIA8 					= "//*[@id=\"modalCentres\"]/div[2]/div/div[2]/div/fieldset/div/table/tbody/tr[8]/td[4]/a";
	public  final String BOTO_LINIA9 					= "//*[@id=\"modalCentres\"]/div[2]/div/div[2]/div/fieldset/div/table/tbody/tr[9]/td[4]/a";
	public  final String BOTO_LINIA10 					= "//*[@id=\"modalCentres\"]/div[2]/div/div[2]/div/fieldset/div/table/tbody/tr[10]/td[4]/a";
	public  final String ID_RESULTAT1 					= "//*[@id=\"modalCentres\"]/div[2]/div/div[2]/div/fieldset/div/table/tbody/tr[1]/td[1]";
	public  final String ID_RESULTAT2 					= "//*[@id=\"modalCentres\"]/div[2]/div/div[2]/div/fieldset/div/table/tbody/tr[2]/td[1]";
	public  final String ID_RESULTAT3 					= "//*[@id=\"modalCentres\"]/div[2]/div/div[2]/div/fieldset/div/table/tbody/tr[3]/td[1]";
	public  final String ID_RESULTAT4 					= "//*[@id=\"modalCentres\"]/div[2]/div/div[2]/div/fieldset/div/table/tbody/tr[4]/td[1]";
	public  final String ID_RESULTAT5 					= "//*[@id=\"modalCentres\"]/div[2]/div/div[2]/div/fieldset/div/table/tbody/tr[5]/td[1]";
	public  final String ID_RESULTAT6 					= "//*[@id=\"modalCentres\"]/div[2]/div/div[2]/div/fieldset/div/table/tbody/tr[6]/td[1]";
	public  final String ID_RESULTAT7 					= "//*[@id=\"modalCentres\"]/div[2]/div/div[2]/div/fieldset/div/table/tbody/tr[7]/td[1]";
	public  final String ID_RESULTAT8 					= "//*[@id=\"modalCentres\"]/div[2]/div/div[2]/div/fieldset/div/table/tbody/tr[8]/td[1]";
	public  final String ID_RESULTAT9 					= "//*[@id=\"modalCentres\"]/div[2]/div/div[2]/div/fieldset/div/table/tbody/tr[9]/td[1]";
	public  final String ID_RESULTAT10 					= "//*[@id=\"modalCentres\"]/div[2]/div/div[2]/div/fieldset/div/table/tbody/tr[10]/td[1]";
	public  final String CODI_RESULTAT1					= "//*[@id=\"modalCentres\"]/div[2]/div/div[2]/div/fieldset/div/table/tbody/tr[1]/td[2]";
	public  final String CODI_RESULTAT2 				= "//*[@id=\"modalCentres\"]/div[2]/div/div[2]/div/fieldset/div/table/tbody/tr[2]/td[2]";
	public  final String CODI_RESULTAT3 				= "//*[@id=\"modalCentres\"]/div[2]/div/div[2]/div/fieldset/div/table/tbody/tr[3]/td[2]";
	public  final String CODI_RESULTAT4 				= "//*[@id=\"modalCentres\"]/div[2]/div/div[2]/div/fieldset/div/table/tbody/tr[4]/td[2]";
	public  final String CODI_RESULTAT5 				= "//*[@id=\"modalCentres\"]/div[2]/div/div[2]/div/fieldset/div/table/tbody/tr[5]/td[2]";
	public  final String CODI_RESULTAT6 				= "//*[@id=\"modalCentres\"]/div[2]/div/div[2]/div/fieldset/div/table/tbody/tr[6]/td[2]";
	public  final String CODI_RESULTAT7 				= "//*[@id=\"modalCentres\"]/div[2]/div/div[2]/div/fieldset/div/table/tbody/tr[7]/td[2]";
	public  final String CODI_RESULTAT8 				= "//*[@id=\"modalCentres\"]/div[2]/div/div[2]/div/fieldset/div/table/tbody/tr[8]/td[2]";
	public  final String CODI_RESULTAT9 				= "//*[@id=\"modalCentres\"]/div[2]/div/div[2]/div/fieldset/div/table/tbody/tr[9]/td[2]";
	public  final String CODI_RESULTAT10 				= "//*[@id=\"modalCentres\"]/div[2]/div/div[2]/div/fieldset/div/table/tbody/tr[10]/td[2]";
	public  final String NOM_RESULTAT1 					= "//*[@id=\"modalCentres\"]/div[2]/div/div[2]/div/fieldset/div/table/tbody/tr[1]/td[3]";
	public  final String NOM_RESULTAT2 					= "//*[@id=\"modalCentres\"]/div[2]/div/div[2]/div/fieldset/div/table/tbody/tr[2]/td[3]";
	public  final String NOM_RESULTAT3 					= "//*[@id=\"modalCentres\"]/div[2]/div/div[2]/div/fieldset/div/table/tbody/tr[3]/td[3]";
	public  final String NOM_RESULTAT4 					= "//*[@id=\"modalCentres\"]/div[2]/div/div[2]/div/fieldset/div/table/tbody/tr[4]/td[3]";
	public  final String NOM_RESULTAT5 					= "//*[@id=\"modalCentres\"]/div[2]/div/div[2]/div/fieldset/div/table/tbody/tr[5]/td[3]";
	public  final String NOM_RESULTAT6 					= "//*[@id=\"modalCentres\"]/div[2]/div/div[2]/div/fieldset/div/table/tbody/tr[6]/td[3]";
	public  final String NOM_RESULTAT7 					= "//*[@id=\"modalCentres\"]/div[2]/div/div[2]/div/fieldset/div/table/tbody/tr[7]/td[3]";
	public  final String NOM_RESULTAT8 					= "//*[@id=\"modalCentres\"]/div[2]/div/div[2]/div/fieldset/div/table/tbody/tr[8]/td[3]";
	public  final String NOM_RESULTAT9 					= "//*[@id=\"modalCentres\"]/div[2]/div/div[2]/div/fieldset/div/table/tbody/tr[9]/td[3]";
	public  final String NOM_RESULTAT10 				= "//*[@id=\"modalCentres\"]/div[2]/div/div[2]/div/fieldset/div/table/tbody/tr[10]/td[3]";

	public  final String BOTO_LINIA_UNIC_RESULTAT		= "//*[@id=\"modalCentres\"]/div[2]/div/div[2]/div/fieldset/div/table/tbody/tr/td[4]/a";
	public  final String ID_UNIC_RESULTAT 				= "//*[@id=\"modalCentres\"]/div[2]/div/div[2]/div/fieldset/div/table/tbody/tr/td[1]";
	public  final String CODI_UNIC_RESULTAT				= "//*[@id=\"modalCentres\"]/div[2]/div/div[2]/div/fieldset/div/table/tbody/tr/td[2]";
	public  final String NOM_UNIC_RESULTAT 				= "//*[@id=\"modalCentres\"]/div[2]/div/div[2]/div/fieldset/div/table/tbody/tr/td[3]";

	public  final String BOTO_PRIMERA_PAGINA			= "//*[@id=\"modalCentres\"]/div[2]/div/div[2]/div/fieldset/div/table/tfoot/tr/td/div/nav/ul/li[1]/a";
	public  final String BOTO_PAGINA_ANTERIOR 			= "//*[@id=\"modalCentres\"]/div[2]/div/div[2]/div/fieldset/div/table/tfoot/tr/td/div/nav/ul/li[2]/a/i";
	public  final String BOTO_LLISTA_PAGINES			= "//*[@id=\"modalCentres\"]/div[2]/div/div[2]/div/fieldset/div/table/tfoot/tr/td/div/nav/ul/li[3]/select";
	public  final String BOTO_PAGINA_SEGUENT			= "//*[@id=\"modalCentres\"]/div[2]/div/div[2]/div/fieldset/div/table/tfoot/tr/td/div/nav/ul/li[4]/a/i";
	public  final String BOTO_ULTIMA_PAGINA				= "//*[@id=\"modalCentres\"]/div[2]/div/div[2]/div/fieldset/div/table/tfoot/tr/td/div/nav/ul/li[5]/a/i";

	public  final String BOTO_TANCAR 					= "//*[@id=\"modalCentres\"]/div[2]/div/div[1]/button";
	
	public final String BOTO_DESCONEXIO 				= "//*[@id=\"logoutIcon\"]/i";
	
	
	public final String[] OBJECTES_INDISPENSABLES 				= {	CAPÇALERA_ESCOLLIU_CENTRE,
																	CONTENIDOR_ESCOLLIU_CENTRE,
																	BLOC_ESCOLLIU_CENTRE,
																	TEXT_ESCOLLIU_CENTRE,
																	TEXT_RESULTATS,
																	CAPÇALERA_COXINET,
																	CAPÇALERA_CODI,
																	CAPÇALERA_NOM,
																	BLOC_PETIT,
																	BLOC_CODI,
																	BLOC_NOM,
																	BLOC_PETIT_FINAL,
																	CAIXA_TEXT_CODI,
																	CAIXA_TEXT_NOM
																	};

	
	public final String[] OBJECTES_RESULTAT_ESCOLLIR_CENTRE	= { BOTO_LINIA_UNIC_RESULTAT,
																ID_UNIC_RESULTAT, 
																CODI_UNIC_RESULTAT,
																NOM_UNIC_RESULTAT };
	
	public EscollirCentrePageObject(RemoteWebDriver driver) {
		super(driver);
	}

	public String ClickBotoTancar() {
		try {
		driver.findElement(By.xpath(BOTO_TANCAR)).click();
		} catch (Exception e) {
			return e.getMessage();
		}
		return "OK";
	}
	

	public String IntroBotoTancar() {
		try {
		driver.findElement(By.xpath(BOTO_TANCAR)).sendKeys(Keys.ENTER);
		} catch (Exception e) {
			return e.getMessage();
		}
		return "OK";
	}
	

	public String ClickBotoPrimeraPagina() {
		try {
		driver.findElement(By.xpath(BOTO_PRIMERA_PAGINA)).click();
		} catch (Exception e) {
			return e.getMessage();
		}
		return "OK";
	}
	

	public String IntroBotoPrimeraPagina() {
		try {
		driver.findElement(By.xpath(BOTO_PRIMERA_PAGINA)).sendKeys(Keys.ENTER);
		} catch (Exception e) {
			return e.getMessage();
		}
		return "OK";
	}
	

	public String ClickBotoPaginaAnterior() {
		try {
		driver.findElement(By.xpath(BOTO_PAGINA_ANTERIOR)).click();
		} catch (Exception e) {
			return e.getMessage();
		}
		return "OK";
	}
	

	public String IntroBotoPaginaAnterior() {
		try {
		driver.findElement(By.xpath(BOTO_PAGINA_ANTERIOR)).sendKeys(Keys.ENTER);
		} catch (Exception e) {
			return e.getMessage();
		}
		return "OK";
	}
	

	public String ClickBotoLlistaPagines() {
		try {
		driver.findElement(By.xpath(BOTO_LLISTA_PAGINES)).click();
		} catch (Exception e) {
			return e.getMessage();
		}
		return "OK";
	}
	

	public String IntroBotoLlistaPagines() {
		try {
		driver.findElement(By.xpath(BOTO_LLISTA_PAGINES)).sendKeys(Keys.ENTER);
		} catch (Exception e) {
			return e.getMessage();
		}
		return "OK";
	}
	

	public String ClickBotoPaginaSeguent() {
		try {
		driver.findElement(By.xpath(BOTO_PAGINA_SEGUENT)).click();
		} catch (Exception e) {
			return e.getMessage();
		}
		return "OK";
	}
	

	public String IntroBotoPaginaSeguent() {
		try {
		driver.findElement(By.xpath(BOTO_PAGINA_SEGUENT)).sendKeys(Keys.ENTER);
		} catch (Exception e) {
			return e.getMessage();
		}
		return "OK";
	}
	

	public String ClickBotoUltimaPagina() {
		try {
		driver.findElement(By.xpath(BOTO_ULTIMA_PAGINA)).click();
		} catch (Exception e) {
			return e.getMessage();
		}
		return "OK";
	}
	

	public String IntroBotoUltimaPagina() {
		try {
		driver.findElement(By.xpath(BOTO_ULTIMA_PAGINA)).sendKeys(Keys.ENTER);
		} catch (Exception e) {
			return e.getMessage();
		}
		return "OK";
	}
	

	// BOTONS RESULTATS
	public String ClickBotoLinia1() {
		try {
		driver.findElement(By.xpath(BOTO_LINIA1)).click();
		} catch (Exception e) {
			return e.getMessage();
		}
		return "OK";
	}
	

	public String IntroBotoLinia1() {
		try {
		driver.findElement(By.xpath(BOTO_LINIA1)).sendKeys(Keys.ENTER);
		} catch (Exception e) {
			return e.getMessage();
		}
		return "OK";
	}
	

	public String ClickBotoLinia2() {
		try {
		driver.findElement(By.xpath(BOTO_LINIA2)).click();
		} catch (Exception e) {
			return e.getMessage();
		}
		return "OK";
	}
	

	public String IntroBotoLinia2() {
		try {
		driver.findElement(By.xpath(BOTO_LINIA2)).sendKeys(Keys.ENTER);
		} catch (Exception e) {
			return e.getMessage();
		}
		return "OK";
	}
	
	
	public String ClickBotoLinia3() {
		try {
		driver.findElement(By.xpath(BOTO_LINIA3)).click();
		} catch (Exception e) {
			return e.getMessage();
		}
		return "OK";
	}
	

	public String IntroBotoLinia3() {
		try {
		driver.findElement(By.xpath(BOTO_LINIA3)).sendKeys(Keys.ENTER);
		} catch (Exception e) {
			return e.getMessage();
		}
		return "OK";
	}
	

	public String ClickBotoLinia4() {
		try {
		driver.findElement(By.xpath(BOTO_LINIA4)).click();
		} catch (Exception e) {
			return e.getMessage();
		}
		return "OK";
	}
	

	public String IntroBotoLinia4() {
		try {
		driver.findElement(By.xpath(BOTO_LINIA4)).sendKeys(Keys.ENTER);
		} catch (Exception e) {
			return e.getMessage();
		}
		return "OK";
	}
	

	public String ClickBotoLinia5() {
		try {
		driver.findElement(By.xpath(BOTO_LINIA5)).click();
		} catch (Exception e) {
			return e.getMessage();
		}
		return "OK";
	}
	

	public String IntroBotoLinia5() {
		try {
		driver.findElement(By.xpath(BOTO_LINIA5)).sendKeys(Keys.ENTER);
		} catch (Exception e) {
			return e.getMessage();
		}
		return "OK";
	}
	

	public String ClickBotoLinia6() {
		try {
		driver.findElement(By.xpath(BOTO_LINIA6)).click();
		} catch (Exception e) {
			return e.getMessage();
		}
		return "OK";
	}
	

	public String IntroBotoLinia6() {
		try {
		driver.findElement(By.xpath(BOTO_LINIA6)).sendKeys(Keys.ENTER);
		} catch (Exception e) {
			return e.getMessage();
		}
		return "OK";
	}
	

	public String ClickBotoLinia7() {
		try {
		driver.findElement(By.xpath(BOTO_LINIA7)).click();
		} catch (Exception e) {
			return e.getMessage();
		}
		return "OK";
	}
	

	public String IntroBotoLinia7() {
		try {
		driver.findElement(By.xpath(BOTO_LINIA7)).sendKeys(Keys.ENTER);
		} catch (Exception e) {
			return e.getMessage();
		}
		return "OK";
	}
	

	public String ClickBotoLinia8() {
		try {
		driver.findElement(By.xpath(BOTO_LINIA8)).click();
		} catch (Exception e) {
			return e.getMessage();
		}
		return "OK";
	}
	

	public String IntroBotoLinia8() {
		try {
		driver.findElement(By.xpath(BOTO_LINIA8)).sendKeys(Keys.ENTER);
		} catch (Exception e) {
			return e.getMessage();
		}
		return "OK";
	}
	

	public String ClickBotoLinia9() {
		try {
		driver.findElement(By.xpath(BOTO_LINIA9)).click();
		} catch (Exception e) {
			return e.getMessage();
		}
		return "OK";
	}
	

	public String IntroBotoLinia9() {
		try {
		driver.findElement(By.xpath(BOTO_LINIA9)).sendKeys(Keys.ENTER);
		} catch (Exception e) {
			return e.getMessage();
		}
		return "OK";
	}
	

	public String ClickBotoLinia10() {
		try {
		driver.findElement(By.xpath(BOTO_LINIA10)).click();
		} catch (Exception e) {
			return e.getMessage();
		}
		return "OK";
	}
	

	public String IntroBotoLinia10() {
		try {
		driver.findElement(By.xpath(BOTO_LINIA10)).sendKeys(Keys.ENTER);
		} catch (Exception e) {
			return e.getMessage();
		}
		return "OK";
	}
	

	//

	public String ClickBotoLiniaUnicResultat() {
		try {
		driver.findElement(By.xpath(BOTO_LINIA_UNIC_RESULTAT)).click();
		} catch (Exception e) {
			return e.getMessage();
		}
		return "OK";
	}
	

	public String IntroBotoLiniaUnicResultat() {
		try {
		driver.findElement(By.xpath(BOTO_LINIA_UNIC_RESULTAT)).sendKeys(Keys.ENTER);
		} catch (Exception e) {
			return e.getMessage();
		}
		return "OK";
	}
	

	// CUADRES DE TEXTE

	public String EscriureCodi(String str) {
		try {
		driver.findElement(By.xpath(CAIXA_TEXT_CODI)).sendKeys(str);
		} catch (Exception e) {
			return e.getMessage();
		}
		return "OK";
	}
	

	public String EnviarCodi() {
		try {
		driver.findElement(By.xpath(CAIXA_TEXT_CODI)).sendKeys(Keys.ENTER);
		} catch (Exception e) {
			return e.getMessage();
		}
		return "OK";
	}
	

	public String EscriureNom(String str) {
		try {
		driver.findElement(By.xpath(CAIXA_TEXT_NOM)).sendKeys(str);
		} catch (Exception e) {
			return e.getMessage();
		}
		return "OK";
	}
	

	public String EnviarNom() {
		try {
			driver.findElement(By.xpath(CAIXA_TEXT_NOM)).sendKeys(Keys.ENTER);
		} catch (Exception e) {
			return e.getMessage();
		}
		return "OK";
	}
	
	public String ClickBotoDesconnexio() {
		try {
		driver.findElement(By.xpath(BOTO_DESCONEXIO)).click();
		} catch (Exception e) {
			return e.getMessage();
		}
		return "OK";
	}

	public String IntroBotoDesconnexio() {
		try {
		driver.findElement(By.xpath(BOTO_DESCONEXIO)).sendKeys(Keys.ENTER);
		} catch (Exception e) {
			return e.getMessage();
		}
		return "OK";
	}
	

}
