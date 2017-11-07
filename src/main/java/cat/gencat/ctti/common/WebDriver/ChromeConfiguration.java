package cat.gencat.ctti.common.WebDriver;

import java.io.IOException;
import java.net.URL;
import java.util.Hashtable;
import java.util.Map;

import org.apache.commons.configuration2.ex.ConfigurationException;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import cat.gencat.ctti.common.WebDriver.IBrowserObject;


public class ChromeConfiguration implements IBrowserObject {
	// private ReadProperties properties;
	

	RemoteWebDriver remoteWebDriver;
	private static DesiredCapabilities capabilities;

	public  ChromeConfiguration() throws IOException, ConfigurationException {
	
		capabilities = DesiredCapabilities.chrome();
		// ... but only if it supports javascript
		capabilities.setJavascriptEnabled(true);
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-popup-blocking");
		options.addArguments("--start-maximized");
		Map<String, Object> preferences = new Hashtable<>();
		options.setExperimentalOption("prefs", preferences);
		preferences.put("plugins.plugins_disabled", new String[] { "Chrome PDF Viewer" });
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		
		
	}

	@Override
	public RemoteWebDriver CreateWebDriverAndStartBrowser(String seleniumServer) throws IOException, Exception {
		remoteWebDriver = new RemoteWebDriver(new URL(seleniumServer), capabilities);
		return remoteWebDriver;
	}



}
