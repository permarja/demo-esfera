package cat.gencat.ctti.common.Utils;


import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.openqa.selenium.remote.RemoteWebDriver;
import cat.gencat.ctti.common.WebDriver.WebDriverCreation;

public class ConfigPropertiesDetails {

	// CONSTANTS
	private static final String LOG_PATH 		= "SortidaLog";
	private static final String BROWSER 		= "Navegador";
	private static final String URL_ALM 		= "URL_ALM";
	private static final String USER_ALM 		= "UsuariALM";
	private static final String PASS_ALM 		= "ClauALM";
	private static final String DOMAIN_ALM 		= "DominiALM";
	private static final String PROJECT_ALM 	= "ProjecteALM";
	private static final String LIBRARY_JACOB 	= "LlibreriaJacob";
	private static final String SELENIUM_URL	= "ServidorSelenium";

	// TEST SETTINGS
	private static final String BUILD 			= "Build";
	private static final String SUIT 			= "Suit";
	private static final String SUIT_ID 		= "SuitID";

	private static String ENVIRONMENT;

	private static final String ESFERA_USER 	= "UsuariEsfera";
	private static final String ESFERA_PASS 	= "ContrasenyaEsfera";

	//
	private static String CONFIG_CONF_PATH;
	private static CompositeConfiguration config;
	
	protected static RemoteWebDriver driver;

	// GETTERS

	public static String getBrowser() {
		return config.getProperty(BROWSER).toString();
	}

	public static String getLogPath() {
		return config.getProperty(LOG_PATH).toString();
	}

	public static String getUrlAlm() {
		return config.getProperty(URL_ALM).toString();
	}

	public static String getUserAlm() {
		return config.getProperty(USER_ALM).toString();
	}

	public static String getPassAlm() {
		return config.getProperty(PASS_ALM).toString();
	}

	public static String getDomainAlm() {
		return config.getProperty(DOMAIN_ALM).toString();
	}

	public static String getProjectAlm() {
		return config.getProperty(PROJECT_ALM).toString();
	}

	public static String getLibraryJacob() {
		return config.getProperty(LIBRARY_JACOB).toString();
	}

	public static String getCONFIG_CONF_PATH() {
		return CONFIG_CONF_PATH;
	}

	public static String getBuild() {
		return config.getProperty(BUILD).toString();
	}

	public static String getSuit() {
		return config.getProperty(SUIT).toString();
	}

	public static Integer getSuitId() {
		Integer ID = Integer.parseInt(config.getProperty(SUIT_ID).toString());
		return ID;
	}

	/*public static String getArch() {
		return config.getProperty(ARCH).toString();
	}*/
	
	

	public static  String getEnvironment() {
		//return config.getProperty(ENVIRONMENT).toString();
		return ENVIRONMENT;
	}

	public  static String getTestUrl() {
		return (String) config.getProperty("Esfera-" + getEnvironment());
	}

	public static String getEsferaUser() {
		return config.getProperty(ESFERA_USER).toString();
	}

	public static String getEsferaPass() {
		return config.getProperty(ESFERA_PASS).toString();
	}

	public  String getSeleniumServer() {
		return config.getProperty(SELENIUM_URL).toString();
	}
	
	// SETTERS

	private static void setCONFIG_CONF_PATH(String cONFIG_CONF_PATH) {
		CONFIG_CONF_PATH = cONFIG_CONF_PATH;
	}


	public void setENVIRONMENT(String eNVIRONMENT) {
		ENVIRONMENT = eNVIRONMENT;
	}

	public ConfigPropertiesDetails(String env) throws Exception {
		
		String OS = System.getProperty("os.name").toLowerCase();
        
        if(OS.indexOf("win") >= 0) {
               setCONFIG_CONF_PATH(".\\src\\test\\resources\\config.properties");
        }
        else if (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0) {
               setCONFIG_CONF_PATH("./src/test/resources/config.properties");
        }

		config = new CompositeConfiguration();
		Logger.getRootLogger().setLevel(Level.OFF);
		config.addConfiguration(new PropertiesConfiguration(getCONFIG_CONF_PATH()));
		setENVIRONMENT(env);
		WebDriverCreation wd = new WebDriverCreation();
		driver = wd.createWebDriver(getBrowser(), this.getSeleniumServer());		
	}

	public CompositeConfiguration GetCompositeConfiguration() {
		return config;
	}

	public RemoteWebDriver getDriver() {
		return driver;
	}

}
