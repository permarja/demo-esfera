package cat.gencat.oqual.esfera.Test;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

//import com.pasa.java.PasarelaAlm;

//import atu.alm.wrapper.exceptions.ALMServiceException;
import cat.gencat.ctti.common.Utils.ConfigPropertiesDetails;
import cat.gencat.ctti.common.Utils.CustomDetectorLinia;
import cat.gencat.ctti.common.Utils.CustomLog;
import cat.gencat.ctti.common.Utils.CustomLog.Tipus;
import cat.gencat.oqual.esfera.PageObjects.CentrePageObject;
import cat.gencat.oqual.esfera.PageObjects.DesconnexioPageObject;
import cat.gencat.oqual.esfera.PageObjects.EscollirCentrePageObject;
import cat.gencat.oqual.esfera.PageObjects.GrupsAsignatsPageObject;
import cat.gencat.oqual.esfera.PageObjects.IdentificacioPageObject;

//import com.EsferaPageObjects.java.EsferaPaginaAvisLegal;


public class SondaEsferaGrupsTest {

	//Constant per detectar el fil d'execuci�
	private static final String NOM_ARXIU = "SondaEsferaGrupsTest.java";

	// Fem refer�ncia a objectes per� no sense crear instancia.
	private CustomLog 					log;
	private RemoteWebDriver 			driver;
//	private PasarelaAlm 				pasarela;
	private ConfigPropertiesDetails 	conf;
	private CustomDetectorLinia			linia;

	private IdentificacioPageObject 	Esf;
	private EscollirCentrePageObject 	Esf3;
	private CentrePageObject 			Esf4;
	private GrupsAsignatsPageObject 	Esf5;
	private DesconnexioPageObject 		Esf6;


	/*private String[] objectesGrupsAsignats = { EsferaPaginaGrupsAsignats.TextResultats,
			EsferaPaginaGrupsAsignats.BotoDesconnexio };*/

	@Parameters("environment")
	@BeforeMethod (groups = {"UNIT","ACCEPTANCE"})
	public void beforeMethod(String environment) throws NoSuchFieldError, //ALMServiceException,
	InterruptedException, Exception {
		
	
		// Instanciem l'objecte de clase "CustomLog" i anomenem l'arxiu de sortida.
		log = new CustomLog("LogSondaEsferaGrupsTest.log");
		// Instanciem l'onjecte de clase "CustomDetectorLinia"
		linia = new  CustomDetectorLinia();
		// Instanciem l'objecte de clase "ConfigPropertiesDetails"
		conf = new ConfigPropertiesDetails(environment);
		// Recuperem el navegador Web
		driver = conf.GetDriver();

		log.CapsaleraLog();
		log.ImprimeixSenseData("", Tipus.INFORMACIO);
		log.ImprimeixAmbData(linia.DiguemQuinaLinia(NOM_ARXIU), " BEFORE METHOD ", Tipus.INFORMACIO);
		// Instanciem l'objecte Esf de clase "IdentificacioEsfera"
		Esf = new IdentificacioPageObject(driver);
		log.ImprimeixAmbData(linia.DiguemQuinaLinia(NOM_ARXIU),	" S'ha instanciat la p�gina login d'Esfera", Tipus.INFORMACIO);

		// Instanciem l'objecte Esf de clase "EscolliuCentreEsfera"
		// Esf2 = new EsferaPaginaAvisLegal(driver);

		// Instanciem l'objecte Esf de clase "PissarraEsfera"
		Esf3 = new EscollirCentrePageObject(driver);
		log.ImprimeixAmbData(linia.DiguemQuinaLinia(NOM_ARXIU),	" S'ha instanciat la p�gina escollir centre d'Esfera", Tipus.INFORMACIO);

		// Instanciem l'objecte Esf de clase "PissarraEsfera"
		Esf4 = new CentrePageObject(driver);
		log.ImprimeixAmbData(linia.DiguemQuinaLinia(NOM_ARXIU),	" S'ha instanciat la p�gina centre d'Esfera", Tipus.INFORMACIO);

		// Instanciem l'objecte Esf de clase "PaginaGestioEconomicaEsfera"
		Esf5 = new GrupsAsignatsPageObject(driver);
		log.ImprimeixAmbData(linia.DiguemQuinaLinia(NOM_ARXIU),	" S'ha instanciat la p�gina gesti� econ�mica d'Esfera", Tipus.INFORMACIO);

		// Instanciem l'objecte Esf de clase "DesconnexioEsfera"
		Esf6 = new DesconnexioPageObject(driver);
		log.ImprimeixAmbData(linia.DiguemQuinaLinia(NOM_ARXIU),	" S'ha instanciat la p�gina logout d'Esfera", Tipus.INFORMACIO);

		// Instanciem L'objecte de clase "CustomAssert" i li afegim l'bjecte de classe
		// PasarelaAlm.
		// Assert = new CustomAssert(Pasarela,log);
		// Obrim la direcci� web d'Esfera a testejar
		Esf.AbrirPagina(ConfigPropertiesDetails.getTestUrl());
		log.ImprimeixAmbData(linia.DiguemQuinaLinia(NOM_ARXIU), " S'ha obert el navegador",	Tipus.INFORMACIO);
		// Esf.
		// Esf.window().maximize();

		Esf.Espera(1);
	}

	@Test (groups = {"UNIT","ACCEPTANCE"})
	public void CarregaPagina() //throws ALMServiceException
	{

		
		//Variable per comprobar resultats
		String resultat;
		
		//###################################################################
		//							P�GINA DE LOGIN
		//###################################################################
		
		log.ImprimeixAmbData(linia.DiguemQuinaLinia(NOM_ARXIU), "CARREGAR P�GINA", Tipus.INFORMACIO);
		log.ImprimeixSenseData("", Tipus.INFORMACIO);
		
		// Comprovem que els elements imprescindibles s'han carregat. Farem 5 iteraci�ns
		// amb 1s entre iteraci�.
		// Si hi ha algun error la prova terminar�
		log.ImprimeixAmbData(linia.DiguemQuinaLinia(NOM_ARXIU),	" Carregant objectes de la p�gina de login", Tipus.INFORMACIO);
		resultat =  Esf.ElementoCargado(5, 1000, Esf.OBJECTES_INDISPENSABLES);
		if (! resultat.equals("OK") ) {
			log.ImprimeixAmbData(linia.DiguemQuinaLinia(NOM_ARXIU), resultat, Tipus.ERROR_FATAL); //KO
			Assert.fail(resultat);
		}
		log.ImprimeixAmbData(linia.DiguemQuinaLinia(NOM_ARXIU), resultat, Tipus.INFORMACIO); //OK
		Esf.Espera(1);
		
			//INTRODUIR USUARI
			
			log.ImprimeixAmbData(linia.DiguemQuinaLinia(NOM_ARXIU), "Introdu�nt usuari", Tipus.INFORMACIO);
			resultat = Esf.IntroduirUsuari(ConfigPropertiesDetails.getEsferaUser());
			if (! resultat.equals("OK") ) {
				log.ImprimeixAmbData(linia.DiguemQuinaLinia(NOM_ARXIU), resultat, Tipus.ERROR_FATAL); //KO
				Assert.fail(resultat);
			}
			log.ImprimeixAmbData(linia.DiguemQuinaLinia(NOM_ARXIU), resultat, Tipus.INFORMACIO); //OK
			Esf.Espera(1);
		
			//INTRODUIR CONTRASENYA
			log.ImprimeixAmbData(linia.DiguemQuinaLinia(NOM_ARXIU), "Introdu�nt contrasenya", Tipus.INFORMACIO);
			resultat = Esf.IntroduirContrasenya(ConfigPropertiesDetails.getEsferaPass());
			if (! resultat.equals("OK") ) {
				log.ImprimeixAmbData(linia.DiguemQuinaLinia(NOM_ARXIU), resultat, Tipus.ERROR_FATAL);
				Assert.fail(resultat);
			}
			log.ImprimeixAmbData(linia.DiguemQuinaLinia(NOM_ARXIU), resultat, Tipus.INFORMACIO);
			Esf.Espera(1);
			
			//PREMER BOT� ACCEPTAR
			log.ImprimeixAmbData(linia.DiguemQuinaLinia(NOM_ARXIU), "Prement bot� aceptar", Tipus.INFORMACIO);
			resultat = Esf.ClickBotoAcceptar();
			if (! resultat.equals("OK") ) {
				log.ImprimeixAmbData(linia.DiguemQuinaLinia(NOM_ARXIU), resultat, Tipus.ERROR_FATAL);
				Assert.fail(resultat);
			}
			log.ImprimeixAmbData(linia.DiguemQuinaLinia(NOM_ARXIU), resultat, Tipus.INFORMACIO);
			Esf.Espera(10);

		//###################################################################
		//						P�GINA DE BUSCAR CENTRE
		//###################################################################
		
		log.ImprimeixAmbData(linia.DiguemQuinaLinia(NOM_ARXIU), " Carregant objectes de la p�gina escollir centre.", Tipus.INFORMACIO);
		resultat = Esf3.ElementoCargado(5, 1000, Esf3.OBJECTES_INDISPENSABLES);
		if (! resultat.equals("OK") ) {
			log.ImprimeixAmbData(linia.DiguemQuinaLinia(NOM_ARXIU), resultat, Tipus.ERROR_FATAL);
			Assert.fail(resultat);
		}
		log.ImprimeixAmbData(linia.DiguemQuinaLinia(NOM_ARXIU), resultat, Tipus.INFORMACIO); 
		Esf3.Espera(1);

			//INTRODUIR CENTRE 
			log.ImprimeixAmbData(linia.DiguemQuinaLinia(NOM_ARXIU), "Introdu�nt codi centre", Tipus.INFORMACIO);
			resultat = Esf3.EscriureCodi("08016380");
			if (! resultat.equals("OK") ) {
				log.ImprimeixAmbData(linia.DiguemQuinaLinia(NOM_ARXIU), resultat, Tipus.ERROR_FATAL);
				Assert.fail(resultat);
			}
			log.ImprimeixAmbData(linia.DiguemQuinaLinia(NOM_ARXIU), resultat, Tipus.INFORMACIO);
			Esf3.Espera(1);
			
			//BUSCAR RESULTATS
			log.ImprimeixAmbData(linia.DiguemQuinaLinia(NOM_ARXIU),"Buscant resultats" ,Tipus.INFORMACIO);
			Esf3.Espera(1);
			resultat = Esf3.ElementoCargado(5, 1000, Esf3.OBJECTES_RESULTAT_ESCOLLIR_CENTRE);
			if (! resultat.equals("OK") ) {
				log.ImprimeixAmbData(linia.DiguemQuinaLinia(NOM_ARXIU), resultat, Tipus.ERROR_FATAL);
				Assert.fail(resultat);
			}
			log.ImprimeixAmbData(linia.DiguemQuinaLinia(NOM_ARXIU), resultat, Tipus.INFORMACIO);
			Esf3.Espera(1);
			
			//PREMER RESULTATS
			log.ImprimeixAmbData(linia.DiguemQuinaLinia(NOM_ARXIU),"Premem el bot� del resultat" ,Tipus.INFORMACIO);
			Esf3.Espera(1);
			resultat = Esf3.ClickBotoLiniaUnicResultat();
			if (! resultat.equals("OK") ) {
				log.ImprimeixAmbData(linia.DiguemQuinaLinia(NOM_ARXIU), resultat, Tipus.ERROR_FATAL);
				Assert.fail(resultat);
			}
			log.ImprimeixAmbData(linia.DiguemQuinaLinia(NOM_ARXIU), resultat, Tipus.INFORMACIO);
			Esf3.Espera(10);
		
			//P�GINA CENTRE
			log.ImprimeixAmbData(linia.DiguemQuinaLinia(NOM_ARXIU), " Carregant objectes del Dashboard del centre.", Tipus.INFORMACIO);
			resultat = Esf4.ElementoCargado(5, 1000, Esf4.OBJECTES_INDISPENSABLES);
			if (! resultat.equals("OK") ) {
				log.ImprimeixAmbData(linia.DiguemQuinaLinia(NOM_ARXIU), resultat, Tipus.ERROR_FATAL);
				Assert.fail(resultat);
			}
			log.ImprimeixAmbData(linia.DiguemQuinaLinia(NOM_ARXIU), resultat, Tipus.INFORMACIO);
			Esf4.Espera(1);

			//BOTO GRUPS
			log.ImprimeixAmbData(linia.DiguemQuinaLinia(NOM_ARXIU), " Prement bot� \"Grups\".", Tipus.INFORMACIO);
			resultat = Esf4.ClickBotoGrups();
			if (! resultat.equals("OK") ) {
				log.ImprimeixAmbData(linia.DiguemQuinaLinia(NOM_ARXIU), resultat, Tipus.ERROR_FATAL);
				Assert.fail(resultat);
			}
			log.ImprimeixAmbData(linia.DiguemQuinaLinia(NOM_ARXIU), resultat, Tipus.INFORMACIO);
			Esf4.Espera(1);
			
			//BOTO GRUPS - Sub GRUPS ASIGNATS
			log.ImprimeixAmbData(linia.DiguemQuinaLinia(NOM_ARXIU), " Prement bot� \"Grups Asignats\".", Tipus.INFORMACIO);
			resultat = Esf4.ClickBotoGrupsSubGrupsAssignats();
			if (! resultat.equals("OK") ) {
				log.ImprimeixAmbData(linia.DiguemQuinaLinia(NOM_ARXIU), resultat, Tipus.ERROR_FATAL);
				Assert.fail(resultat);
			}
			log.ImprimeixAmbData(linia.DiguemQuinaLinia(NOM_ARXIU), resultat, Tipus.INFORMACIO);
			Esf4.Espera(10);
			
		
		
		//###################################################################
		//						P�GINA GRUPS ASSIGNATS
		//###################################################################
		
		log.ImprimeixAmbData(linia.DiguemQuinaLinia(NOM_ARXIU),	" Carregant objectes de \"Grups asignats\".", Tipus.INFORMACIO);
		resultat =  Esf5.ElementoCargado(5, 1000, Esf5.OBJECTES_INDISPENSABLES);
		if (! resultat.equals("OK") ) {
			log.ImprimeixAmbData(linia.DiguemQuinaLinia(NOM_ARXIU), resultat, Tipus.ERROR_FATAL);
			Assert.fail(resultat);
		}
		log.ImprimeixAmbData(linia.DiguemQuinaLinia(NOM_ARXIU), resultat, Tipus.INFORMACIO);
		Esf5.Espera(1);
		
			//COMPROVAR RESULTATS
			log.ImprimeixAmbData(linia.DiguemQuinaLinia(NOM_ARXIU), " Comprovant que hi diu a \"resultats\"", Tipus.INFORMACIO);
			resultat = Esf5.QuehiDiuEnResultats();
			if (! resultat.equals("9 resultat(s)")) {
				log.ImprimeixAmbData(linia.DiguemQuinaLinia(NOM_ARXIU), resultat, Tipus.ERROR_FATAL);
				Assert.fail(resultat);
			}
			log.ImprimeixAmbData(linia.DiguemQuinaLinia(NOM_ARXIU), resultat, Tipus.INFORMACIO);
			Esf5.Espera(1);

			//PREMER DESCONNEXIO
			log.ImprimeixAmbData(linia.DiguemQuinaLinia(NOM_ARXIU), " Desconnectant d'Esfera", Tipus.INFORMACIO);
			resultat = Esf5.ClickBotoDesconnexio();
			if (! resultat.equals("OK") ) {
				log.ImprimeixAmbData(linia.DiguemQuinaLinia(NOM_ARXIU), resultat, Tipus.ERROR_FATAL);
				Assert.fail(resultat);
			}
			log.ImprimeixAmbData(linia.DiguemQuinaLinia(NOM_ARXIU), resultat, Tipus.INFORMACIO);
			Esf5.Espera(15);
		
			//PAGINA DESCONNEXIO ESFERA
			log.ImprimeixAmbData(linia.DiguemQuinaLinia(NOM_ARXIU)," Carregant objectes del la p�gina de desconexi�.", Tipus.INFORMACIO);
			resultat = Esf6.ElementoCargado(5, 1000, Esf6.OBJECTES_INDISPENSABLES);
			if (! resultat.equals("OK") ) {
				log.ImprimeixAmbData(linia.DiguemQuinaLinia(NOM_ARXIU), resultat, Tipus.ERROR_FATAL);
				Assert.fail(resultat);
			}
			log.ImprimeixAmbData(linia.DiguemQuinaLinia(NOM_ARXIU), resultat, Tipus.INFORMACIO);
			Esf6.Espera(1);

			//COMPROVAR RESULTATS DE LA DESCONNEXIO
			resultat = Esf6.QuehiDiuEnDesconnexio();
			if (! resultat.equals("Desconnexi� realitzada amb �xit") ) {
				log.ImprimeixAmbData(linia.DiguemQuinaLinia(NOM_ARXIU), resultat, Tipus.ERROR_FATAL);
				Assert.fail(resultat);
			}
			log.ImprimeixAmbData(linia.DiguemQuinaLinia(NOM_ARXIU), resultat, Tipus.INFORMACIO);
			

			log.ImprimeixSenseData("", Tipus.INFORMACIO);
			log.ImprimeixAmbData(linia.DiguemQuinaLinia(NOM_ARXIU), " Fi de la prova",	Tipus.INFORMACIO);


	}

	@AfterMethod (groups = {"UNIT","ACCEPTANCE"})
	public void afterMethod(ITestResult result) throws Exception {
		
		//Variable per comprobar resultats
		//String resultat;

		log.ImprimeixAmbData(linia.DiguemQuinaLinia(NOM_ARXIU), " AFTER METHOD", Tipus.INFORMACIO);
		log.ImprimeixSenseData("", Tipus.INFORMACIO);
		
		log.ImprimeixAmbData(linia.DiguemQuinaLinia(NOM_ARXIU), " Iniciant pasarel�la",	Tipus.INFORMACIO);

	/*	pasarela = new PasarelaAlm();
		pasarela.setUrlAlm(ConfigPropertiesDetails.getUrlAlm());
		pasarela.setUserAlm(ConfigPropertiesDetails.getUserAlm());
		pasarela.setPassAlm(ConfigPropertiesDetails.getPassAlm());
		pasarela.setDomainAlm(ConfigPropertiesDetails.getDomainAlm());
		pasarela.setProjectAlm(ConfigPropertiesDetails.getProjectAlm());

		pasarela.setTestCasePath(ConfigPropertiesDetails.getBuild()); // Build
		pasarela.setTestCaseName(ConfigPropertiesDetails.getSuit()); // Suite
		pasarela.setTestCaseID(ConfigPropertiesDetails.getSuitId()); // ID de la Suite

		pasarela.setTestName("SondaEsfera-Grups"); */

	//	log.ImprimeixAmbData(linia.DiguemQuinaLinia(NOM_ARXIU), pasarela.ConnectToProject(), Tipus.INFORMACIO);
		log.ImprimeixSenseData("", Tipus.INFORMACIO);

		switch (result.getStatus()) {
		case 1: // SUCCESS
	//		resultat = pasarela.ReportOK();
		//	if (! resultat.equals("") ) {
		//		log.ImprimeixAmbData(linia.DiguemQuinaLinia(NOM_ARXIU), resultat, Tipus.ADVERTENCIA);
		//	}
			log.ImprimeixAmbData(linia.DiguemQuinaLinia(NOM_ARXIU), "OK", Tipus.INFORMACIO);
			break;

		case 2: // FAILURE
		//	resultat = pasarela.ReportKO();
		//	if (! resultat.equals("") ) {
		//		log.ImprimeixAmbData(linia.DiguemQuinaLinia(NOM_ARXIU), resultat, Tipus.ADVERTENCIA);
		//	}
		//	log.ImprimeixAmbData(linia.DiguemQuinaLinia(NOM_ARXIU), resultat, Tipus.ERROR_FATAL);
			break;

		case 3: // SKIP
		//	resultat = pasarela.ReportNoApply();
		//	if (! resultat.equals("") ) {
		//		log.ImprimeixAmbData(linia.DiguemQuinaLinia(NOM_ARXIU), resultat, Tipus.ADVERTENCIA);
		//	}
		//	log.ImprimeixAmbData(linia.DiguemQuinaLinia(NOM_ARXIU), resultat, Tipus.ADVERTENCIA);
			break;
		}
		
		log.ImprimeixSenseData("", Tipus.INFORMACIO);
		log.ImprimeixSenseData("", Tipus.INFORMACIO);
		log.ImprimeixAmbData(linia.DiguemQuinaLinia(NOM_ARXIU), " Netejant objectes", Tipus.INFORMACIO);
		Esf 	= null;
		Esf3 	= null;
		Esf4 	= null;
		Esf5 	= null;
		log.ImprimeixAmbData(linia.DiguemQuinaLinia(NOM_ARXIU),	" Tancant connexi� amb el navegador", Tipus.INFORMACIO);
		Esf6.CerrarSeguro();
		log.ImprimeixAmbData(linia.DiguemQuinaLinia(NOM_ARXIU), " Tancament correcte", Tipus.INFORMACIO);
		log.ImprimeixAmbData(linia.DiguemQuinaLinia(NOM_ARXIU), " Fi del reporting", Tipus.INFORMACIO);

	}

}
