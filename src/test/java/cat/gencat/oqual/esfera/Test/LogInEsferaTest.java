package cat.gencat.oqual.esfera.Test; 


import org.testng.annotations.Test;

//import com.pasa.java.PasarelaAlm;



import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

//import atu.alm.wrapper.exceptions.ALMServiceException;
import cat.gencat.ctti.common.Utils.ConfigPropertiesDetails;
import cat.gencat.ctti.common.Utils.CustomDetectorLinia;
import cat.gencat.ctti.common.Utils.CustomLog;
import cat.gencat.ctti.common.Utils.CustomLog.Tipus;
import cat.gencat.oqual.esfera.PageObjects.*;


public class LogInEsferaTest {
	
	//Constant per detectar el fil d'execucio
	private static final String NOM_ARXIU = "LogInEsferaTest.java";

	// Fem referencia a objectes pero no sense crear instancia.
	private CustomLog 					log;
	private RemoteWebDriver 			driver;
	//private PasarelaAlm 				pasarela;
	private ConfigPropertiesDetails 	conf;
	private CustomDetectorLinia			linia;

	private IdentificacioPageObject 	Esf;
	private EscollirCentrePageObject 	Esf3;
	
	
	public static final String RemoteWebdriver = "EXISTING_REMOTE_WEBDRIVER";


	@Parameters("environment")
	@BeforeMethod (groups = {"SMOKE", "LOGIN"})
	public void beforeMethod(String environment) throws NoSuchFieldError, //ALMServiceException, 
	InterruptedException, Exception {
		
	
		// Instanciem l'objecte de clase "CustomLog" i anomenem l'arxiu de sortida.
		log = new CustomLog("LogLogInTest.log");
		// Instanciem l'onjecte de clase "CustomDetectorLinia"
		linia = new  CustomDetectorLinia();
		// Instanciem l'objecte de clase "ConfigPropertiesDetails"
		conf = new ConfigPropertiesDetails(environment);
		// Recuperem el navegador Web
		driver = conf.getDriver();
		//driver = new 
		log.CapsaleraLog();
		log.ImprimeixSenseData("", Tipus.INFORMACIO);
		log.ImprimeixAmbData(linia.DiguemQuinaLinia(NOM_ARXIU), " BEFORE METHOD ", Tipus.INFORMACIO);
		// Instanciem l'objecte Esf de clase "IdentificacioEsfera"
		Esf = new IdentificacioPageObject(driver);
		log.ImprimeixAmbData(linia.DiguemQuinaLinia(NOM_ARXIU),	" S'ha instanciat la p\u00e0gina login d'Esfera", Tipus.INFORMACIO);

		// Instanciem l'objecte Esf de clase "EscolliuCentreEsfera"
		// Esf2 = new EsferaPaginaAvisLegal(driver);

		// Instanciem l'objecte Esf de clase "PissarraEsfera"
		Esf3 = new EscollirCentrePageObject(driver);
		log.ImprimeixAmbData(linia.DiguemQuinaLinia(NOM_ARXIU),	" S'ha instanciat la p\u00e0gina escollir centre d'Esfera", Tipus.INFORMACIO);

		// Obrim la direccio web d'Esfera a testejar
		
		Esf.AbrirPagina(ConfigPropertiesDetails.getTestUrl());
		log.ImprimeixAmbData(linia.DiguemQuinaLinia(NOM_ARXIU), " S'ha obert el navegador",	Tipus.INFORMACIO);
		Esf.Espera(1);
		
	}
	
	
	
	@Test (groups = {"SMOKE", "LOGIN"})
	public void LogIn() throws Exception {
		
	
		//Variable per comprobar resultats
		String resultat;
		
		//###################################################################
		//							P�GINA DE LOGIN
		//###################################################################
		
		log.ImprimeixAmbData(linia.DiguemQuinaLinia(NOM_ARXIU), "LogIn", Tipus.INFORMACIO);
		log.ImprimeixSenseData("", Tipus.INFORMACIO);
		
		// Comprovem que els elements imprescindibles s'han carregat. Farem 5 iteracions
		// amb 1s entre iteracio.
		// Si hi ha algun error la prova terminara
		log.ImprimeixAmbData(linia.DiguemQuinaLinia(NOM_ARXIU),	" Carregant objectes de la p\u00e0gina de login", Tipus.INFORMACIO);
		resultat =  Esf.ElementoCargado(5, 1000, Esf.OBJECTES_INDISPENSABLES);
		if (! resultat.equals("OK") ) {
			log.ImprimeixAmbData(linia.DiguemQuinaLinia(NOM_ARXIU), resultat, Tipus.ERROR_FATAL); //KO
			Assert.fail(resultat);
		}
		log.ImprimeixAmbData(linia.DiguemQuinaLinia(NOM_ARXIU), resultat, Tipus.INFORMACIO); //OK
		Esf.Espera(1);
		
			//INTRODUIR USUARI
			
			log.ImprimeixAmbData(linia.DiguemQuinaLinia(NOM_ARXIU), " Introduint usuari", Tipus.INFORMACIO);
			resultat = Esf.IntroduirUsuari(ConfigPropertiesDetails.getEsferaUser());
			if (! resultat.equals("OK") ) {
				log.ImprimeixAmbData(linia.DiguemQuinaLinia(NOM_ARXIU), resultat, Tipus.ERROR_FATAL); //KO
				Assert.fail(resultat);
			}
			log.ImprimeixAmbData(linia.DiguemQuinaLinia(NOM_ARXIU), resultat, Tipus.INFORMACIO); //OK
			Esf.Espera(1);
		
			//INTRODUIR CONTRASENYA
			
			log.ImprimeixAmbData(linia.DiguemQuinaLinia(NOM_ARXIU), " Introduint contrasenya", Tipus.INFORMACIO);
			resultat = Esf.IntroduirContrasenya(ConfigPropertiesDetails.getEsferaPass());
			if (! resultat.equals("OK") ) {
				log.ImprimeixAmbData(linia.DiguemQuinaLinia(NOM_ARXIU), resultat, Tipus.ERROR_FATAL);
				Assert.fail(resultat);
			}
			log.ImprimeixAmbData(linia.DiguemQuinaLinia(NOM_ARXIU), resultat, Tipus.INFORMACIO);
			Esf.Espera(1);
			
			//PREMER BOTO ACCEPTAR
			
			log.ImprimeixAmbData(linia.DiguemQuinaLinia(NOM_ARXIU), " Prement boto aceptar", Tipus.INFORMACIO);
			resultat = Esf.ClickBotoAcceptar();
			if (! resultat.equals("OK") ) {
				log.ImprimeixAmbData(linia.DiguemQuinaLinia(NOM_ARXIU), resultat, Tipus.ERROR_FATAL);
				Assert.fail(resultat);
			}
			log.ImprimeixAmbData(linia.DiguemQuinaLinia(NOM_ARXIU), resultat, Tipus.INFORMACIO);
			Esf.Espera(15);

		//###################################################################
		//						P�GINA DE BUSCAR CENTRE
		//###################################################################
		
		log.ImprimeixAmbData(linia.DiguemQuinaLinia(NOM_ARXIU), " Carregant objectes de la p\u00e0gina escollir centre.", Tipus.INFORMACIO);
		resultat = Esf3.ElementoCargado(5, 1000, Esf3.OBJECTES_INDISPENSABLES);
		if (! resultat.equals("OK") ) {
			log.ImprimeixAmbData(linia.DiguemQuinaLinia(NOM_ARXIU), resultat, Tipus.ERROR_FATAL);
			Assert.fail(resultat);
		}
		log.ImprimeixAmbData(linia.DiguemQuinaLinia(NOM_ARXIU), resultat, Tipus.INFORMACIO); 
		
	}

	@AfterMethod (groups = {"SMOKE", "LOGIN"})
	public void afterMethod(ITestResult result) throws Exception {

		log.ImprimeixAmbData(linia.DiguemQuinaLinia(NOM_ARXIU), " AFTER METHOD", Tipus.INFORMACIO);
		log.ImprimeixSenseData("", Tipus.INFORMACIO);
		
		log.ImprimeixAmbData(linia.DiguemQuinaLinia(NOM_ARXIU), " Iniciant pasarella",	Tipus.INFORMACIO);

	/*	pasarela = new PasarelaAlm();
		pasarela.setUrlAlm(ConfigPropertiesDetails.getUrlAlm());
		pasarela.setUserAlm(ConfigPropertiesDetails.getUserAlm());
		pasarela.setPassAlm(ConfigPropertiesDetails.getPassAlm());
		pasarela.setDomainAlm(ConfigPropertiesDetails.getDomainAlm());
		pasarela.setProjectAlm(ConfigPropertiesDetails.getProjectAlm());

		pasarela.setTestCasePath(ConfigPropertiesDetails.getBuild()); // Build
		pasarela.setTestCaseName(ConfigPropertiesDetails.getSuit()); // Suite
		pasarela.setTestCaseID(ConfigPropertiesDetails.getSuitId()); // ID de la Suite

		pasarela.setTestName("Esfera-Log-In");
*/
	//	log.ImprimeixAmbData(linia.DiguemQuinaLinia(NOM_ARXIU), pasarela.ConnectToProject(), Tipus.INFORMACIO);
		log.ImprimeixSenseData("", Tipus.INFORMACIO);

		switch (result.getStatus()) {
		case 1: // SUCCESS
		//	log.ImprimeixAmbData(linia.DiguemQuinaLinia(NOM_ARXIU), pasarela.ReportOK(), Tipus.INFORMACIO);
			break;

		case 2: // FAILURE
		//	log.ImprimeixAmbData(linia.DiguemQuinaLinia(NOM_ARXIU), pasarela.ReportKO(), Tipus.ERROR_FATAL);
			break;

		case 3: // SKIP
		//	log.ImprimeixAmbData(linia.DiguemQuinaLinia(NOM_ARXIU), pasarela.ReportNoApply(), Tipus.ADVERTENCIA);
			break;
		}
		
		log.ImprimeixSenseData("", Tipus.INFORMACIO);
		log.ImprimeixSenseData("", Tipus.INFORMACIO);
		log.ImprimeixAmbData(linia.DiguemQuinaLinia(NOM_ARXIU), " Netejant objectes", Tipus.INFORMACIO);
		Esf 	= null;
		Esf3 	= null;
		log.ImprimeixAmbData(linia.DiguemQuinaLinia(NOM_ARXIU), " Fi del reporting", Tipus.INFORMACIO);
	}
	
	
	@AfterClass(alwaysRun = true)
    public void GuardarIdRemoteWebdriver(ITestContext ctx) {	
        ctx.setAttribute(RemoteWebdriver, driver);        
    }
	


}
