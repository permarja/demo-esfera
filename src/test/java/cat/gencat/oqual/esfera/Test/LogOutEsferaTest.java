package cat.gencat.oqual.esfera.Test; 

//import com.EsferaPageObjects.java.EsferaPaginaAvisLegal;

import org.testng.annotations.Test;

//import com.pasa.java.PasarelaAlm;



import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

//import atu.alm.wrapper.exceptions.ALMServiceException;
//import cat.gencat.ctti.common.Utils.ConfigPropertiesDetails;
import cat.gencat.ctti.common.Utils.CustomDetectorLinia;
import cat.gencat.ctti.common.Utils.CustomLog;
import cat.gencat.ctti.common.Utils.CustomLog.Tipus;
import cat.gencat.oqual.esfera.PageObjects.*;



public class LogOutEsferaTest {
	
	//Constant per detectar el fil d'execuci�
	private static final String NOM_ARXIU = "LogOutEsferaTest.java";

	// Fem refer�ncia a objectes per� no sense crear instancia.
	private CustomLog 					log;
	private RemoteWebDriver 			driver;
//	private PasarelaAlm 				pasarela;
	//private ConfigPropertiesDetails 	conf;
	private CustomDetectorLinia			linia;

	private EscollirCentrePageObject 	Esf3;
	private DesconnexioPageObject 		Esf6;
	

    @BeforeClass(alwaysRun=true, groups = {"SMOKE", "LOGOUT"}, dependsOnGroups = {"LOGIN"})
    public void fetchData(ITestContext ctx) {
    	driver =   (RemoteWebDriver) ctx.getAttribute(LogInEsferaTest.RemoteWebdriver);
    }

	
	@Parameters("environment")
	@BeforeMethod (groups = {"SMOKE", "LOGOUT"}, dependsOnGroups = {"LOGIN"})
	public void beforeMethod(String environment) throws NoSuchFieldError, //ALMServiceException,
	InterruptedException, Exception {
		
			
		// Instanciem l'objecte de clase "CustomLog" i anomenem l'arxiu de sortida.
		log = new CustomLog("LogLogOutTest.log");
		// Instanciem l'onjecte de clase "CustomDetectorLinia"
		linia = new  CustomDetectorLinia();
		
		log.CapsaleraLog();
		log.ImprimeixSenseData("", Tipus.INFORMACIO);
		log.ImprimeixAmbData(linia.DiguemQuinaLinia(NOM_ARXIU), " BEFORE METHOD ", Tipus.INFORMACIO);
		// Instanciem l'objecte Esf de clase "IdentificacioEsfera"

		// Instanciem l'objecte Esf de clase "PissarraEsfera"
		Esf3 = new EscollirCentrePageObject(driver);
		log.ImprimeixAmbData(linia.DiguemQuinaLinia(NOM_ARXIU),	" S'ha instanciat la p\u00e0gina escollir centre d'Esfera", Tipus.INFORMACIO);


		// Instanciem l'objecte Esf de clase "DesconnexioEsfera"
		Esf6 = new DesconnexioPageObject(driver);
		log.ImprimeixAmbData(linia.DiguemQuinaLinia(NOM_ARXIU),	" S'ha instanciat la p\u00e0gina logout d'Esfera", Tipus.INFORMACIO);

		// Instanciem L'objecte de clase "CustomAssert" i li afegim l'bjecte de classe
		// PasarelaAlm.
		// Assert = new CustomAssert(Pasarela,log);
		// Obrim la direcci� web d'Esfera a testejar
		
	/*	Esf3.AbrirPagina(ConfigPropertiesDetails.getTestUrl());
		log.ImprimeixAmbData(linia.DiguemQuinaLinia(NOM_ARXIU), " S'ha obert el navegador",	Tipus.INFORMACIO);*/
		Esf3.Espera(1);

	}

	@Test (groups = {"SMOKE", "LOGOUT"}, dependsOnGroups = {"LOGIN"})
	public void CarregaPagina() throws Exception {
		
		//Variable per comprobar resultats
		String resultat;
		

		//###################################################################
		//						P�GINA DE BUSCAR CENTRE
		//###################################################################
		
		log.ImprimeixAmbData(linia.DiguemQuinaLinia(NOM_ARXIU), " Comprovant objectes carregats de la p\u00e0gina escollir centre.", Tipus.INFORMACIO);
		resultat = Esf3.ElementoCargado(5, 1000, Esf3.OBJECTES_INDISPENSABLES);
		if (! resultat.equals("OK") ) {
			log.ImprimeixAmbData(linia.DiguemQuinaLinia(NOM_ARXIU), resultat, Tipus.ERROR_FATAL);
			Assert.fail(resultat);
		}
		log.ImprimeixAmbData(linia.DiguemQuinaLinia(NOM_ARXIU), resultat, Tipus.INFORMACIO); 
		

			//PREMER TANCAR
			log.ImprimeixAmbData(linia.DiguemQuinaLinia(NOM_ARXIU), " Tancant finestra de buscar centre", Tipus.INFORMACIO);
			resultat = Esf3.ClickBotoTancar();
			if (! resultat.equals("OK") ) {
				log.ImprimeixAmbData(linia.DiguemQuinaLinia(NOM_ARXIU), resultat, Tipus.ERROR_FATAL);
				Assert.fail(resultat);
			}
			log.ImprimeixAmbData(linia.DiguemQuinaLinia(NOM_ARXIU), resultat, Tipus.INFORMACIO);
			
			Esf3.Espera(10);
			
			//PREMER DESCONNEXIO
			log.ImprimeixAmbData(linia.DiguemQuinaLinia(NOM_ARXIU), " Desconnectant d'Esfera", Tipus.INFORMACIO);
			resultat = Esf3.ClickBotoDesconnexio();
			if (! resultat.equals("OK") ) {
				log.ImprimeixAmbData(linia.DiguemQuinaLinia(NOM_ARXIU), resultat, Tipus.ERROR_FATAL);
				Assert.fail(resultat);
			}
			log.ImprimeixAmbData(linia.DiguemQuinaLinia(NOM_ARXIU), resultat, Tipus.INFORMACIO);
			Esf3.Espera(15);

		//###################################################################
		//						P�GINA DESCONNEXIO
		//###################################################################
		
			//PAGINA DESCONNEXIO ESFERA
			log.ImprimeixAmbData(linia.DiguemQuinaLinia(NOM_ARXIU)," Carregant objectes del la p\u00e0gina de desconexi\u00f3.", Tipus.INFORMACIO);
			resultat = Esf6.ElementoCargado(5, 1000, Esf6.OBJECTES_INDISPENSABLES);
			if (! resultat.equals("OK") ) {
				log.ImprimeixAmbData(linia.DiguemQuinaLinia(NOM_ARXIU), resultat, Tipus.ERROR_FATAL);
				Assert.fail(resultat);
			}
			log.ImprimeixAmbData(linia.DiguemQuinaLinia(NOM_ARXIU), resultat, Tipus.INFORMACIO);
			Esf6.Espera(1);
			
			//COMPROVAR RESULTATS DE LA DESCONNEXIO
			resultat = Esf6.QuehiDiuEnDesconnexio();
			if (! resultat.equals("Desconnexió realitzada amb \u00e8xit") ) {
				log.ImprimeixAmbData(linia.DiguemQuinaLinia(NOM_ARXIU), resultat, Tipus.ERROR_FATAL);
				Assert.fail(resultat);
			}
			log.ImprimeixAmbData(linia.DiguemQuinaLinia(NOM_ARXIU), resultat, Tipus.INFORMACIO);
			

			log.ImprimeixSenseData("", Tipus.INFORMACIO);
			log.ImprimeixAmbData(linia.DiguemQuinaLinia(NOM_ARXIU), " Fi de la prova",	Tipus.INFORMACIO);

	}

	@AfterMethod (groups = {"SMOKE", "LOGOUT"}, dependsOnGroups = {"LOGIN"})
	public void afterMethod(ITestResult result) throws Exception {

		log.ImprimeixAmbData(linia.DiguemQuinaLinia(NOM_ARXIU), " AFTER METHOD", Tipus.INFORMACIO);
		log.ImprimeixSenseData("", Tipus.INFORMACIO);
		
		log.ImprimeixAmbData(linia.DiguemQuinaLinia(NOM_ARXIU), " Iniciant pasarela",	Tipus.INFORMACIO);

	/*	pasarela = new PasarelaAlm();
		pasarela.setUrlAlm(ConfigPropertiesDetails.getUrlAlm());
		pasarela.setUserAlm(ConfigPropertiesDetails.getUserAlm());
		pasarela.setPassAlm(ConfigPropertiesDetails.getPassAlm());
		pasarela.setDomainAlm(ConfigPropertiesDetails.getDomainAlm());
		pasarela.setProjectAlm(ConfigPropertiesDetails.getProjectAlm());

		pasarela.setTestCasePath(ConfigPropertiesDetails.getBuild()); // Build
		pasarela.setTestCaseName(ConfigPropertiesDetails.getSuit()); // Suite
		pasarela.setTestCaseID(ConfigPropertiesDetails.getSuitId()); // ID de la Suite

		pasarela.setTestName("Esfera-Log-Out");*/

	//	log.ImprimeixAmbData(linia.DiguemQuinaLinia(NOM_ARXIU), pasarela.ConnectToProject(), Tipus.INFORMACIO);
		log.ImprimeixSenseData("", Tipus.INFORMACIO);

		switch (result.getStatus()) {
		case 1: // SUCCESS
	//		log.ImprimeixAmbData(linia.DiguemQuinaLinia(NOM_ARXIU), pasarela.ReportOK(), Tipus.INFORMACIO);
			break;

		case 2: // FAILURE
	//		log.ImprimeixAmbData(linia.DiguemQuinaLinia(NOM_ARXIU), pasarela.ReportKO(), Tipus.ERROR_FATAL);
			break;

		case 3: // SKIP
	//		log.ImprimeixAmbData(linia.DiguemQuinaLinia(NOM_ARXIU), pasarela.ReportNoApply(), Tipus.ADVERTENCIA);
			break;
		}
		
		log.ImprimeixSenseData("", Tipus.INFORMACIO);
		log.ImprimeixSenseData("", Tipus.INFORMACIO);
		log.ImprimeixAmbData(linia.DiguemQuinaLinia(NOM_ARXIU), " Netejant objectes", Tipus.INFORMACIO);
		Esf3 	= null;
		log.ImprimeixAmbData(linia.DiguemQuinaLinia(NOM_ARXIU),	" Tancant connexi\u00f3 amb el navegador", Tipus.INFORMACIO);
		Esf6.CerrarSeguro();
		log.ImprimeixAmbData(linia.DiguemQuinaLinia(NOM_ARXIU), " Tancament correcte", Tipus.INFORMACIO);
		log.ImprimeixAmbData(linia.DiguemQuinaLinia(NOM_ARXIU), " Fi del reporting", Tipus.INFORMACIO);
	
	}

}
