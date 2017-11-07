package cat.gencat.ctti.common.WebDriver;

//import java.io.File;
import java.io.IOException;
//import java.net.URL;
import java.net.URL;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.openqa.selenium.remote.RemoteWebDriver;

//import com.MdP.Utils.ReadProperties;
//import com.MdP.WebDriver.IBrowserObject;

//import io.github.bonigarcia.wdm.FirefoxDriverManager;

public class FirefoxConfiguration implements IBrowserObject {

	RemoteWebDriver remoteWebDriver;
	//FirefoxProfile firefoxProfile;
	DesiredCapabilities capabilities;
	//Proxy proxy;

	public FirefoxConfiguration() throws IOException {
		
		FirefoxOptions options = new FirefoxOptions();
		//options.addArguments("disable-popup-blocking");
		options.addArguments("--start-maximized");

		/*this.proxy = this.CreateProxy();
		this.firefoxProfile = this.CreateFirefoxProfile();
		this.desiredCapabilities = this.CreateDesiredCapabilities(this.proxy);*/
		capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options);
		//capabilities.setCapability(CapabilityType.PROXY, proxy);
		
	}

	public DesiredCapabilities CreateDesiredCapabilities(Proxy proxy) {
		DesiredCapabilities cap = DesiredCapabilities.firefox();
		cap.setCapability(CapabilityType.PROXY, proxy);
		return cap;
	}

	@Override
	public RemoteWebDriver CreateWebDriverAndStartBrowser(String seleniumServer) throws IOException, Exception {
		remoteWebDriver = new RemoteWebDriver(new URL(seleniumServer), capabilities);
		return remoteWebDriver;
	}
	
	/*public Proxy CreateProxy() {
	Proxy proxy = new Proxy();
	proxy.setProxyType(ProxyType.SYSTEM);
	return proxy;
}*/
}
